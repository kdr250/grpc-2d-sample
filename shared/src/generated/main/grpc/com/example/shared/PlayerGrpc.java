package com.example.shared;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Player.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PlayerGrpc {

  private PlayerGrpc() {}

  public static final String SERVICE_NAME = "Player";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.shared.PlayerSyncRequest,
      com.example.shared.PlayerSyncResponse> getSyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sync",
      requestType = com.example.shared.PlayerSyncRequest.class,
      responseType = com.example.shared.PlayerSyncResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.shared.PlayerSyncRequest,
      com.example.shared.PlayerSyncResponse> getSyncMethod() {
    io.grpc.MethodDescriptor<com.example.shared.PlayerSyncRequest, com.example.shared.PlayerSyncResponse> getSyncMethod;
    if ((getSyncMethod = PlayerGrpc.getSyncMethod) == null) {
      synchronized (PlayerGrpc.class) {
        if ((getSyncMethod = PlayerGrpc.getSyncMethod) == null) {
          PlayerGrpc.getSyncMethod = getSyncMethod =
              io.grpc.MethodDescriptor.<com.example.shared.PlayerSyncRequest, com.example.shared.PlayerSyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Sync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.PlayerSyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.PlayerSyncResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PlayerMethodDescriptorSupplier("Sync"))
              .build();
        }
      }
    }
    return getSyncMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlayerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlayerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlayerStub>() {
        @java.lang.Override
        public PlayerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlayerStub(channel, callOptions);
        }
      };
    return PlayerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlayerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlayerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlayerBlockingStub>() {
        @java.lang.Override
        public PlayerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlayerBlockingStub(channel, callOptions);
        }
      };
    return PlayerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlayerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlayerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlayerFutureStub>() {
        @java.lang.Override
        public PlayerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlayerFutureStub(channel, callOptions);
        }
      };
    return PlayerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PlayerImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.PlayerSyncRequest> sync(
        io.grpc.stub.StreamObserver<com.example.shared.PlayerSyncResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSyncMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSyncMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.shared.PlayerSyncRequest,
                com.example.shared.PlayerSyncResponse>(
                  this, METHODID_SYNC)))
          .build();
    }
  }

  /**
   */
  public static final class PlayerStub extends io.grpc.stub.AbstractAsyncStub<PlayerStub> {
    private PlayerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlayerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlayerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.PlayerSyncRequest> sync(
        io.grpc.stub.StreamObserver<com.example.shared.PlayerSyncResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSyncMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PlayerBlockingStub extends io.grpc.stub.AbstractBlockingStub<PlayerBlockingStub> {
    private PlayerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlayerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlayerBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class PlayerFutureStub extends io.grpc.stub.AbstractFutureStub<PlayerFutureStub> {
    private PlayerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlayerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlayerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SYNC = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlayerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlayerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SYNC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sync(
              (io.grpc.stub.StreamObserver<com.example.shared.PlayerSyncResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PlayerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlayerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.shared.PlayerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Player");
    }
  }

  private static final class PlayerFileDescriptorSupplier
      extends PlayerBaseDescriptorSupplier {
    PlayerFileDescriptorSupplier() {}
  }

  private static final class PlayerMethodDescriptorSupplier
      extends PlayerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlayerMethodDescriptorSupplier(String methodName) {
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
      synchronized (PlayerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlayerFileDescriptorSupplier())
              .addMethod(getSyncMethod())
              .build();
        }
      }
    }
    return result;
  }
}
