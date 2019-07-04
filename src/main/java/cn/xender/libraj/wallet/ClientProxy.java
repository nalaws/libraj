package cn.xender.libraj.wallet;

import java.util.List;

import org.libra.types.GetWithProof;
import org.libra.types.Transaction;
import org.libra.types.AccessPathProtos;
import org.libra.types.AccountStateBlobOuterClass.AccountStateBlob;
import org.libra.types.Events;

import com.google.protobuf.ByteString;
import cn.xender.libraj.common.Hex;
import cn.xender.libraj.network.grpc.GrpcClient;

public class ClientProxy {
	public GrpcClient client;
	public AccountData[] accounts;
	public AccountData faucetAccount; // option
	public ClientProxy() {
		this.client = GrpcClient.getInstance();
	}
	
	public boolean submitTransaction(Transaction.SignedTransaction signedTransaction) {
		return GrpcClient.getInstance().submitTransaction(signedTransaction);
	}
	
	public AccountResource getAccountResource(String hexAddress) {
		GetWithProof.GetAccountStateRequest accountRequest = GetWithProof.GetAccountStateRequest.newBuilder()
				.setAddress(ByteString.copyFrom(Hex.Hex2Bytes(hexAddress)))
				.build();
		
		GetWithProof.RequestItem item = GetWithProof.RequestItem.newBuilder()
				.setGetAccountStateRequest(accountRequest)
				.build();
		
		GetWithProof.ResponseItem response = GrpcClient.getInstance().call(item);
		GetWithProof.GetAccountStateResponse accountState = response.getGetAccountStateResponse();
		AccountStateBlob blob = accountState.getAccountStateWithProof().getBlob();
		AccountConfig account = new AccountConfig();
		return account.getAccountResourceOrDefault(blob);
	}
	
	public Transaction.SignedTransaction getTransactionByAccountSequence(String hexAddress, long sequenceNumber, boolean fetchEvents) {
		GetWithProof.GetAccountTransactionBySequenceNumberRequest request = GetWithProof.GetAccountTransactionBySequenceNumberRequest.newBuilder()
				.setAccount(ByteString.copyFrom(Hex.Hex2Bytes(hexAddress)))
				.setSequenceNumber(sequenceNumber)
				.setFetchEvents(fetchEvents)
				.build();
		
		GetWithProof.RequestItem item = GetWithProof.RequestItem.newBuilder()
				.setGetAccountTransactionBySequenceNumberRequest(request)
				.build();
		GetWithProof.ResponseItem response = GrpcClient.getInstance().call(item);
		
		GetWithProof.GetAccountTransactionBySequenceNumberResponse accountTransaction = response.getGetAccountTransactionBySequenceNumberResponse();
		return accountTransaction.getSignedTransactionWithProof().getSignedTransaction();
	}
	
	public List<Events.EventWithProof> getEventsByEventAccessPath(String hexAddress, byte[] path, long startSeqNum, boolean ascend, long limit) {
		AccessPathProtos.AccessPath accessPath = AccessPathProtos.AccessPath.newBuilder()
				.setAddress(ByteString.copyFrom(Hex.Hex2Bytes(hexAddress)))
				.setPath(ByteString.copyFrom(path))
				.build();
		GetWithProof.GetEventsByEventAccessPathRequest request = GetWithProof.GetEventsByEventAccessPathRequest.newBuilder()
				.setAccessPath(accessPath)
				.setStartEventSeqNum(startSeqNum)
				.setAscending(ascend)
				.setLimit(limit)
				.build();
		
		GetWithProof.RequestItem item = GetWithProof.RequestItem.newBuilder()
				.setGetEventsByEventAccessPathRequest(request)
				.build();
		GetWithProof.ResponseItem response = GrpcClient.getInstance().call(item);
		
		GetWithProof.GetEventsByEventAccessPathResponse events = response.getGetEventsByEventAccessPathResponse();
		return events.getEventsWithProofList();
	}
}
