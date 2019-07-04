package cn.xender.libraj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.libra.types.AccessPathProtos;
import org.libra.types.Events;
import org.libra.types.Transaction;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import cn.xender.libraj.common.Hex;
import cn.xender.libraj.common.Unitl;
import cn.xender.libraj.wallet.AccountConfig;
import cn.xender.libraj.wallet.AccountResource;
import cn.xender.libraj.wallet.ClientProxy;
import cn.xender.libraj.wallet.ExtendedPrivKey;
import cn.xender.libraj.wallet.ExtendedPrivKey.KeyPair;
import cn.xender.libraj.wallet.KeyFactory;

public class LibraApi {
	private final long GAS_UNIT_PRICE = 0;
	private final long MAX_GAS_AMOUNT = 10000;
	private final long TX_EXPIRATION = 100;
	
	private ClientProxy proxy;
	
	public LibraApi() {
		proxy = new ClientProxy();
	}

	public byte[] generateMasterKey(String mnemonic) {
		KeyFactory kf = new KeyFactory();
		byte[] seed = kf.newSeed(mnemonic, "LIBRA");
		return kf.newMaster(seed);
	}
	
	public ExtendedPrivKey generatePrivateKey(byte[]master, long childNumber) {
		return KeyFactory.privateChild(master, childNumber);
	}
	
	public String getAddress(ExtendedPrivKey prvkey) {
		return prvkey.getAddress();
	}
	
	public KeyPair generateKeyPair(byte[]master, long childNumber) {
		return ExtendedPrivKey.KeyPair.fromComponents(master, childNumber);
	}
	
	/**
	 * get account balance
	 * @param hexAddress
	 * @return
	 */
	public long getBalance(String hexAddress) {
		AccountResource account = proxy.getAccountResource(hexAddress);
		return account.getBalance();
	}
	
	public boolean transfer(String sender, ExtendedPrivKey.KeyPair keyPair, String recver, long amount) {
		AccountResource resource = proxy.getAccountResource(sender);
		if(resource.getBalance() < amount) {
			return false;
		}
		long expirationTime = Calendar.getInstance().getTimeInMillis() /1000 + TX_EXPIRATION;
		LibraTransaction libraTx = new LibraTransaction();
		byte[] bytesRawTx = libraTx.generateUnsignTransferRawTransaction(sender, resource.getSequenceNumber(), MAX_GAS_AMOUNT, GAS_UNIT_PRICE, expirationTime, recver, amount);
		byte[] sign = libraTx.signRawTransaction(keyPair.privateKey, bytesRawTx);
	    if(sign == null) {
	    	return false;
	    }
	    
	    Transaction.SignedTransaction signedTransaction = Transaction.SignedTransaction.newBuilder()
				.setRawTxnBytes(ByteString.copyFrom(bytesRawTx))
				.setSenderPublicKey(ByteString.copyFrom(keyPair.publicKey))
				.setSenderSignature(ByteString.copyFrom(sign))
				.build();
	    return proxy.submitTransaction(signedTransaction);
	}
	
	public LibraTransaction getTransactionByAccountSequence(String hexAddress, long sequenceNumber, boolean fetchEvents) {
		Transaction.SignedTransaction signedTx = proxy.getTransactionByAccountSequence(hexAddress, sequenceNumber, fetchEvents);
		Transaction.RawTransaction rawTx = null;
		try {
			rawTx = Transaction.RawTransaction.parseFrom(signedTx.getRawTxnBytes());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		LibraProgram libraProgram = null;
		switch (rawTx.getPayloadCase()) {
		case PROGRAM:
			Transaction.Program program = rawTx.getProgram();
			byte[] code = program.getCode().toByteArray();
			String operation = null;
			if(Arrays.equals(code, Hex.Hex2Bytes("4c49425241564d0a010007014a00000004000000034e000000060000000c54000000050000000d5900000004000000055d0000002900000004860000002000000007a60000000d00000000000001000200010300020002040203020402063c53454c463e0c4c696272614163636f756e74046d61696e0f7061795f66726f6d5f73656e64657200000000000000000000000000000000000000000000000000000000000000000001020004000c000c01110102"))) {
				operation = "peer_to_peer_transaction";
			}
			List<Transaction.TransactionArgument> argus = program.getArgumentsList();
			long amount = 0;
			String toAddress = null;
			for(Transaction.TransactionArgument argu : argus) {
				switch(argu.getType()) {
				case U64:
					byte[] amountBytes = argu.getData().toByteArray();
					amount = Unitl.bytes2Long(Unitl.reverseBytes(amountBytes));
					break;
				case ADDRESS:
					toAddress = Hex.Bytes2Hex(argu.getData().toByteArray());
					break;
				default:
					break;
				}
			}
			libraProgram = new LibraProgram(operation, toAddress, amount);
			break;
		default:
			return null;
		}
		
		return new LibraTransaction(Hex.Bytes2Hex(rawTx.getSenderAccount().toByteArray()), 
				rawTx.getSequenceNumber(),
				libraProgram,
				rawTx.getMaxGasAmount(),
				rawTx.getGasUnitPrice(),
				rawTx.getExpirationTime(),
				signedTx.getSenderPublicKey().toByteArray(),
				signedTx.getSenderSignature().toByteArray()
				);
	}
	
	/**
	 * get events
	 * @param hexAddress: 
	 * @param eventType：
	 * @param startSeqNum: start sequence number
	 * @param ascend:
	 * @param limit:
	 */
	public List<LibraEvent> getEventsByEventAccessPath(String hexAddress, EventType eventType, long startSeqNum, boolean ascend, long limit) {
		byte[] path =null;
		AccountConfig config = new AccountConfig();
		if(eventType.equals(EventType.received)) {
			path = config.accountReceivedEventPath();
		} else {
			path = config.accountSentEventPath();
		}
		List<Events.EventWithProof> eventList = proxy.getEventsByEventAccessPath(hexAddress, path, startSeqNum, ascend, limit);
		List<LibraEvent> events = new ArrayList<LibraEvent>();
		int count = eventList.size();
		for(int i = 0; i < count; i++) {
			Events.EventWithProof proof = eventList.get(i);
			long version = proof.getTransactionVersion();
			Events.Event e = proof.getEvent();
			AccessPathProtos.AccessPath access = e.getAccessPath();
			String accessAddress = Hex.Bytes2Hex(access.getAddress().toByteArray());
			byte[] accessPathBytes = access.getPath().toByteArray();
			AccountConfig cfg = new AccountConfig();
			int pathlen = cfg.accountResourcePath().length;
			int suffixlen = accessPathBytes.length - pathlen;
			byte[] suffixBytes = new byte[suffixlen];
			System.arraycopy(accessPathBytes, pathlen, suffixBytes, 0, suffixlen);
			long sequence = e.getSequenceNumber();
			byte[] eventData = e.getEventData().toByteArray();
			byte[] amountBytes = new byte[8];
			int pos = 0;
			System.arraycopy(eventData, pos, amountBytes, 0, 8);
			pos += 8;
			long amount = Unitl.bytes2Long(Unitl.reverseBytes(amountBytes));
			byte[] addressLenBytes = new byte[4];
			System.arraycopy(eventData, pos, addressLenBytes, 0, 4);
			pos += 4;
			int addresslen = Unitl.bytes2Int(Unitl.reverseBytes(addressLenBytes));
			byte[] addressBytes = new byte[addresslen];
			System.arraycopy(eventData, pos, addressBytes, 0, addresslen);
			pos += addresslen;
			String eventAddress = Hex.Bytes2Hex(addressBytes);
			
			String from = accessAddress;
			String to = eventAddress;
			if(Arrays.equals(suffixBytes, "/received_events_count/".getBytes())) {
				from = eventAddress;
				to = accessAddress;
			}
					
			events.add(new LibraEvent(version, from, sequence, to, amount));
		}
		
		return events;
	}
	
	public enum EventType {
		sent,
		received
	}
}
