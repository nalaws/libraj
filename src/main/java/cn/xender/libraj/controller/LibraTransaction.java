package cn.xender.libraj.controller;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.libra.types.Transaction;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.ByteString;

import cn.xender.libraj.common.Hex;
import cn.xender.libraj.common.Unitl;
import cn.xender.libraj.crypto.LibraHash;
import cn.xender.libraj.crypto.Sha3Util;
import cn.xender.libraj.wallet.ExtendedPrivKey;

public class LibraTransaction {
	public String from;
	public long sequence;
	public LibraProgram program;
	public long maxGasAmount;
	public long  gasUnitPrice;
	public long  expiration;
	public byte[] fromPublicKey;
	public byte[] signature;
	
	public LibraTransaction() {
		
	}
	
	public LibraTransaction(String from, long sequence, LibraProgram program, long maxGasAmount, long gasUnitPrice, long expiration, byte[] fromPublicKey, byte[] signature) {
		this.from = from;
		this.sequence = sequence;
		this.program = program;
		this.maxGasAmount = maxGasAmount;
		this.gasUnitPrice = gasUnitPrice;
		this.expiration = expiration;
		this.fromPublicKey = fromPublicKey;
		this.signature = signature;
	}
	
	public String toJson() {
		JSONObject jobj = new JSONObject();
		jobj.put("from", from);
		jobj.put("sequence", sequence);
		jobj.put("program", program);	
		jobj.put("max_gas_amount", maxGasAmount);
		jobj.put("gas_unit_price", gasUnitPrice);
		jobj.put("expiration", expiration);
		jobj.put("public_key", Hex.Bytes2Hex(fromPublicKey));
		jobj.put("signature", Hex.Bytes2Hex(signature));
		return jobj.toJSONString();
	}

	public byte[] generateUnsignTransferRawTransaction(String sender, long sequence, long maxGasAmount, long gasUnitPrice, long expirationTime, String recver, long amount) {		
		String code = "4c49425241564d0a010007014a00000004000000034e000000060000000c54000000050000000d5900000004000000055d0000002900000004860000002000000007a60000000d00000000000001000200010300020002040203020402063c53454c463e0c4c696272614163636f756e74046d61696e0f7061795f66726f6d5f73656e64657200000000000000000000000000000000000000000000000000000000000000000001020004000c000c01110102";			
		Transaction.TransactionArgument arg0 = Transaction.TransactionArgument.newBuilder()
				.setType(Transaction.TransactionArgument.ArgType.ADDRESS)
				.setData(ByteString.copyFrom(Hex.Hex2Bytes(recver)))
				.build();
		Transaction.TransactionArgument arg1 = Transaction.TransactionArgument.newBuilder()
				.setType(Transaction.TransactionArgument.ArgType.U64)
				.setData(ByteString.copyFrom(Unitl.reverseBytes(Unitl.long2Bytes(amount))))
				.build();
		Transaction.Program program = Transaction.Program.newBuilder()
				.setCode(ByteString.copyFrom(Hex.Hex2Bytes(code)))
				.addArguments(arg0)
				.addArguments(arg1)
				.build();		
		Transaction.RawTransaction rawTx =  Transaction.RawTransaction.newBuilder()
				.setSenderAccount(ByteString.copyFrom(Hex.Hex2Bytes(sender)))
				.setSequenceNumber(sequence)
				.setProgram(program)
				.setMaxGasAmount(maxGasAmount)
				.setGasUnitPrice(gasUnitPrice)
				.setExpirationTime(expirationTime)
				.build();
		return rawTx.toByteArray();
	}
	
	public byte[] signRawTransaction(ExtendedPrivKey privateKey, byte[] rawTransaction) {
		byte[] hash = Sha3Util.sha3256(LibraHash.rawTransactionExpr(), rawTransaction);
		byte[] sign = null;
		try {
			sign = privateKey.sign(hash);
		} catch (DataLengthException | CryptoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    return sign;
	}
}
