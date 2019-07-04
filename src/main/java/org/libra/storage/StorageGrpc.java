package org.libra.storage;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * -----------------------------------------------------------------------------
 * ---------------- Service definition for storage
 * -----------------------------------------------------------------------------
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0-SNAPSHOT)",
    comments = "Source: storage.proto")
public final class StorageGrpc {

  private StorageGrpc() {}

  public static final String SERVICE_NAME = "storage.Storage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.SaveTransactionsRequest,
      org.libra.storage.StorageOuterClass.SaveTransactionsResponse> getSaveTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveTransactions",
      requestType = org.libra.storage.StorageOuterClass.SaveTransactionsRequest.class,
      responseType = org.libra.storage.StorageOuterClass.SaveTransactionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.SaveTransactionsRequest,
      org.libra.storage.StorageOuterClass.SaveTransactionsResponse> getSaveTransactionsMethod() {
    io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.SaveTransactionsRequest, org.libra.storage.StorageOuterClass.SaveTransactionsResponse> getSaveTransactionsMethod;
    if ((getSaveTransactionsMethod = StorageGrpc.getSaveTransactionsMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getSaveTransactionsMethod = StorageGrpc.getSaveTransactionsMethod) == null) {
          StorageGrpc.getSaveTransactionsMethod = getSaveTransactionsMethod = 
              io.grpc.MethodDescriptor.<org.libra.storage.StorageOuterClass.SaveTransactionsRequest, org.libra.storage.StorageOuterClass.SaveTransactionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage.Storage", "SaveTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.SaveTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.SaveTransactionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("SaveTransactions"))
                  .build();
          }
        }
     }
     return getSaveTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.libra.types.GetWithProof.UpdateToLatestLedgerRequest,
      org.libra.types.GetWithProof.UpdateToLatestLedgerResponse> getUpdateToLatestLedgerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateToLatestLedger",
      requestType = org.libra.types.GetWithProof.UpdateToLatestLedgerRequest.class,
      responseType = org.libra.types.GetWithProof.UpdateToLatestLedgerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.libra.types.GetWithProof.UpdateToLatestLedgerRequest,
      org.libra.types.GetWithProof.UpdateToLatestLedgerResponse> getUpdateToLatestLedgerMethod() {
    io.grpc.MethodDescriptor<org.libra.types.GetWithProof.UpdateToLatestLedgerRequest, org.libra.types.GetWithProof.UpdateToLatestLedgerResponse> getUpdateToLatestLedgerMethod;
    if ((getUpdateToLatestLedgerMethod = StorageGrpc.getUpdateToLatestLedgerMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getUpdateToLatestLedgerMethod = StorageGrpc.getUpdateToLatestLedgerMethod) == null) {
          StorageGrpc.getUpdateToLatestLedgerMethod = getUpdateToLatestLedgerMethod = 
              io.grpc.MethodDescriptor.<org.libra.types.GetWithProof.UpdateToLatestLedgerRequest, org.libra.types.GetWithProof.UpdateToLatestLedgerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage.Storage", "UpdateToLatestLedger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.types.GetWithProof.UpdateToLatestLedgerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.types.GetWithProof.UpdateToLatestLedgerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("UpdateToLatestLedger"))
                  .build();
          }
        }
     }
     return getUpdateToLatestLedgerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetTransactionsRequest,
      org.libra.storage.StorageOuterClass.GetTransactionsResponse> getGetTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransactions",
      requestType = org.libra.storage.StorageOuterClass.GetTransactionsRequest.class,
      responseType = org.libra.storage.StorageOuterClass.GetTransactionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetTransactionsRequest,
      org.libra.storage.StorageOuterClass.GetTransactionsResponse> getGetTransactionsMethod() {
    io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetTransactionsRequest, org.libra.storage.StorageOuterClass.GetTransactionsResponse> getGetTransactionsMethod;
    if ((getGetTransactionsMethod = StorageGrpc.getGetTransactionsMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getGetTransactionsMethod = StorageGrpc.getGetTransactionsMethod) == null) {
          StorageGrpc.getGetTransactionsMethod = getGetTransactionsMethod = 
              io.grpc.MethodDescriptor.<org.libra.storage.StorageOuterClass.GetTransactionsRequest, org.libra.storage.StorageOuterClass.GetTransactionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage.Storage", "GetTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.GetTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.GetTransactionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("GetTransactions"))
                  .build();
          }
        }
     }
     return getGetTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest,
      org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse> getGetAccountStateWithProofByStateRootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountStateWithProofByStateRoot",
      requestType = org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest.class,
      responseType = org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest,
      org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse> getGetAccountStateWithProofByStateRootMethod() {
    io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest, org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse> getGetAccountStateWithProofByStateRootMethod;
    if ((getGetAccountStateWithProofByStateRootMethod = StorageGrpc.getGetAccountStateWithProofByStateRootMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getGetAccountStateWithProofByStateRootMethod = StorageGrpc.getGetAccountStateWithProofByStateRootMethod) == null) {
          StorageGrpc.getGetAccountStateWithProofByStateRootMethod = getGetAccountStateWithProofByStateRootMethod = 
              io.grpc.MethodDescriptor.<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest, org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage.Storage", "GetAccountStateWithProofByStateRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("GetAccountStateWithProofByStateRoot"))
                  .build();
          }
        }
     }
     return getGetAccountStateWithProofByStateRootMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest,
      org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse> getGetExecutorStartupInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExecutorStartupInfo",
      requestType = org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest.class,
      responseType = org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest,
      org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse> getGetExecutorStartupInfoMethod() {
    io.grpc.MethodDescriptor<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest, org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse> getGetExecutorStartupInfoMethod;
    if ((getGetExecutorStartupInfoMethod = StorageGrpc.getGetExecutorStartupInfoMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getGetExecutorStartupInfoMethod = StorageGrpc.getGetExecutorStartupInfoMethod) == null) {
          StorageGrpc.getGetExecutorStartupInfoMethod = getGetExecutorStartupInfoMethod = 
              io.grpc.MethodDescriptor.<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest, org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage.Storage", "GetExecutorStartupInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("GetExecutorStartupInfo"))
                  .build();
          }
        }
     }
     return getGetExecutorStartupInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StorageStub newStub(io.grpc.Channel channel) {
    return new StorageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StorageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StorageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StorageFutureStub(channel);
  }

  /**
   * <pre>
   * -----------------------------------------------------------------------------
   * ---------------- Service definition for storage
   * -----------------------------------------------------------------------------
   * </pre>
   */
  public static abstract class StorageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Persist transactions. Called by Execution when either syncing nodes or
     * committing blocks during normal operation.
     * </pre>
     */
    public void saveTransactions(org.libra.storage.StorageOuterClass.SaveTransactionsRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.SaveTransactionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Used to get a piece of data and return the proof of it. If the client
     * knows and trusts a ledger info at version v, it should pass v in as the
     * client_known_version and we will return the latest ledger info together
     * with the proof that it derives from v.
     * </pre>
     */
    public void updateToLatestLedger(org.libra.types.GetWithProof.UpdateToLatestLedgerRequest request,
        io.grpc.stub.StreamObserver<org.libra.types.GetWithProof.UpdateToLatestLedgerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateToLatestLedgerMethod(), responseObserver);
    }

    /**
     * <pre>
     * When we receive a request from a peer validator asking a list of
     * transactions for state synchronization, this API can be used to serve the
     * request. Note that the peer should specify a ledger version and all proofs
     * in the response will be relative to this given ledger version.
     * </pre>
     */
    public void getTransactions(org.libra.storage.StorageOuterClass.GetTransactionsRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetTransactionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionsMethod(), responseObserver);
    }

    /**
     */
    public void getAccountStateWithProofByStateRoot(org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountStateWithProofByStateRootMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information needed for Executor to start up.
     * </pre>
     */
    public void getExecutorStartupInfo(org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExecutorStartupInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.libra.storage.StorageOuterClass.SaveTransactionsRequest,
                org.libra.storage.StorageOuterClass.SaveTransactionsResponse>(
                  this, METHODID_SAVE_TRANSACTIONS)))
          .addMethod(
            getUpdateToLatestLedgerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.libra.types.GetWithProof.UpdateToLatestLedgerRequest,
                org.libra.types.GetWithProof.UpdateToLatestLedgerResponse>(
                  this, METHODID_UPDATE_TO_LATEST_LEDGER)))
          .addMethod(
            getGetTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.libra.storage.StorageOuterClass.GetTransactionsRequest,
                org.libra.storage.StorageOuterClass.GetTransactionsResponse>(
                  this, METHODID_GET_TRANSACTIONS)))
          .addMethod(
            getGetAccountStateWithProofByStateRootMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest,
                org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse>(
                  this, METHODID_GET_ACCOUNT_STATE_WITH_PROOF_BY_STATE_ROOT)))
          .addMethod(
            getGetExecutorStartupInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest,
                org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse>(
                  this, METHODID_GET_EXECUTOR_STARTUP_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * -----------------------------------------------------------------------------
   * ---------------- Service definition for storage
   * -----------------------------------------------------------------------------
   * </pre>
   */
  public static final class StorageStub extends io.grpc.stub.AbstractStub<StorageStub> {
    private StorageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageStub(channel, callOptions);
    }

    /**
     * <pre>
     * Persist transactions. Called by Execution when either syncing nodes or
     * committing blocks during normal operation.
     * </pre>
     */
    public void saveTransactions(org.libra.storage.StorageOuterClass.SaveTransactionsRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.SaveTransactionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Used to get a piece of data and return the proof of it. If the client
     * knows and trusts a ledger info at version v, it should pass v in as the
     * client_known_version and we will return the latest ledger info together
     * with the proof that it derives from v.
     * </pre>
     */
    public void updateToLatestLedger(org.libra.types.GetWithProof.UpdateToLatestLedgerRequest request,
        io.grpc.stub.StreamObserver<org.libra.types.GetWithProof.UpdateToLatestLedgerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateToLatestLedgerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * When we receive a request from a peer validator asking a list of
     * transactions for state synchronization, this API can be used to serve the
     * request. Note that the peer should specify a ledger version and all proofs
     * in the response will be relative to this given ledger version.
     * </pre>
     */
    public void getTransactions(org.libra.storage.StorageOuterClass.GetTransactionsRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetTransactionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountStateWithProofByStateRoot(org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountStateWithProofByStateRootMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information needed for Executor to start up.
     * </pre>
     */
    public void getExecutorStartupInfo(org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest request,
        io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetExecutorStartupInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * -----------------------------------------------------------------------------
   * ---------------- Service definition for storage
   * -----------------------------------------------------------------------------
   * </pre>
   */
  public static final class StorageBlockingStub extends io.grpc.stub.AbstractStub<StorageBlockingStub> {
    private StorageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Persist transactions. Called by Execution when either syncing nodes or
     * committing blocks during normal operation.
     * </pre>
     */
    public org.libra.storage.StorageOuterClass.SaveTransactionsResponse saveTransactions(org.libra.storage.StorageOuterClass.SaveTransactionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveTransactionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Used to get a piece of data and return the proof of it. If the client
     * knows and trusts a ledger info at version v, it should pass v in as the
     * client_known_version and we will return the latest ledger info together
     * with the proof that it derives from v.
     * </pre>
     */
    public org.libra.types.GetWithProof.UpdateToLatestLedgerResponse updateToLatestLedger(org.libra.types.GetWithProof.UpdateToLatestLedgerRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateToLatestLedgerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * When we receive a request from a peer validator asking a list of
     * transactions for state synchronization, this API can be used to serve the
     * request. Note that the peer should specify a ledger version and all proofs
     * in the response will be relative to this given ledger version.
     * </pre>
     */
    public org.libra.storage.StorageOuterClass.GetTransactionsResponse getTransactions(org.libra.storage.StorageOuterClass.GetTransactionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse getAccountStateWithProofByStateRoot(org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountStateWithProofByStateRootMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information needed for Executor to start up.
     * </pre>
     */
    public org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse getExecutorStartupInfo(org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetExecutorStartupInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * -----------------------------------------------------------------------------
   * ---------------- Service definition for storage
   * -----------------------------------------------------------------------------
   * </pre>
   */
  public static final class StorageFutureStub extends io.grpc.stub.AbstractStub<StorageFutureStub> {
    private StorageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Persist transactions. Called by Execution when either syncing nodes or
     * committing blocks during normal operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.libra.storage.StorageOuterClass.SaveTransactionsResponse> saveTransactions(
        org.libra.storage.StorageOuterClass.SaveTransactionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveTransactionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Used to get a piece of data and return the proof of it. If the client
     * knows and trusts a ledger info at version v, it should pass v in as the
     * client_known_version and we will return the latest ledger info together
     * with the proof that it derives from v.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.libra.types.GetWithProof.UpdateToLatestLedgerResponse> updateToLatestLedger(
        org.libra.types.GetWithProof.UpdateToLatestLedgerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateToLatestLedgerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * When we receive a request from a peer validator asking a list of
     * transactions for state synchronization, this API can be used to serve the
     * request. Note that the peer should specify a ledger version and all proofs
     * in the response will be relative to this given ledger version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.libra.storage.StorageOuterClass.GetTransactionsResponse> getTransactions(
        org.libra.storage.StorageOuterClass.GetTransactionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse> getAccountStateWithProofByStateRoot(
        org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountStateWithProofByStateRootMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information needed for Executor to start up.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse> getExecutorStartupInfo(
        org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetExecutorStartupInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_TRANSACTIONS = 0;
  private static final int METHODID_UPDATE_TO_LATEST_LEDGER = 1;
  private static final int METHODID_GET_TRANSACTIONS = 2;
  private static final int METHODID_GET_ACCOUNT_STATE_WITH_PROOF_BY_STATE_ROOT = 3;
  private static final int METHODID_GET_EXECUTOR_STARTUP_INFO = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StorageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StorageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_TRANSACTIONS:
          serviceImpl.saveTransactions((org.libra.storage.StorageOuterClass.SaveTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.SaveTransactionsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TO_LATEST_LEDGER:
          serviceImpl.updateToLatestLedger((org.libra.types.GetWithProof.UpdateToLatestLedgerRequest) request,
              (io.grpc.stub.StreamObserver<org.libra.types.GetWithProof.UpdateToLatestLedgerResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSACTIONS:
          serviceImpl.getTransactions((org.libra.storage.StorageOuterClass.GetTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetTransactionsResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_STATE_WITH_PROOF_BY_STATE_ROOT:
          serviceImpl.getAccountStateWithProofByStateRoot((org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootRequest) request,
              (io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetAccountStateWithProofByStateRootResponse>) responseObserver);
          break;
        case METHODID_GET_EXECUTOR_STARTUP_INFO:
          serviceImpl.getExecutorStartupInfo((org.libra.storage.StorageOuterClass.GetExecutorStartupInfoRequest) request,
              (io.grpc.stub.StreamObserver<org.libra.storage.StorageOuterClass.GetExecutorStartupInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.libra.storage.StorageOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Storage");
    }
  }

  private static final class StorageFileDescriptorSupplier
      extends StorageBaseDescriptorSupplier {
    StorageFileDescriptorSupplier() {}
  }

  private static final class StorageMethodDescriptorSupplier
      extends StorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StorageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StorageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StorageFileDescriptorSupplier())
              .addMethod(getSaveTransactionsMethod())
              .addMethod(getUpdateToLatestLedgerMethod())
              .addMethod(getGetTransactionsMethod())
              .addMethod(getGetAccountStateWithProofByStateRootMethod())
              .addMethod(getGetExecutorStartupInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
