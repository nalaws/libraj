package cn.xender.libraj.network.grpc;


import org.libra.admission_control.AdmissionControlGrpc;
import org.libra.admission_control.AdmissionControlOuterClass;
import org.libra.types.GetWithProof;
import org.libra.types.Transaction;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	private ManagedChannel channel;
	
	private static class LazyHolderGrpcClient {
        private static final GrpcClient INSTANCE = new GrpcClient();
    }

    private GrpcClient() {
    	channel = ManagedChannelBuilder.forAddress("ac.testnet.libra.org", 8000)
				.usePlaintext()
				.build();
    }

    public static final GrpcClient getInstance() {
        return LazyHolderGrpcClient.INSTANCE;
    }
    
	public GetWithProof.ResponseItem call(GetWithProof.RequestItem item) {
		GetWithProof.UpdateToLatestLedgerRequest request = GetWithProof.UpdateToLatestLedgerRequest.newBuilder()
				.addRequestedItems(item)
				.build();
		AdmissionControlGrpc.AdmissionControlBlockingStub stub = AdmissionControlGrpc.newBlockingStub(channel);
		GetWithProof.UpdateToLatestLedgerResponse response = stub.updateToLatestLedger(request);
		return response.getResponseItems(0);
	}
	
	public boolean submitTransaction(Transaction.SignedTransaction signedTransaction) {	
		AdmissionControlOuterClass.SubmitTransactionRequest request = AdmissionControlOuterClass.SubmitTransactionRequest.newBuilder()
				.setSignedTxn(signedTransaction)
				.build();
		AdmissionControlGrpc.AdmissionControlBlockingStub stub = AdmissionControlGrpc.newBlockingStub(channel);
		AdmissionControlOuterClass.SubmitTransactionResponse response = stub.submitTransaction(request);
		
		if(response.getStatusCase() == AdmissionControlOuterClass.SubmitTransactionResponse.StatusCase.AC_STATUS) {
			return (response.getAcStatus() != AdmissionControlOuterClass.AdmissionControlStatus.Rejected);
		} 
		
		return true;
	}
}
