package com.example.shared;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: WorldMap.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorldMapGrpc {

  private WorldMapGrpc() {}

  public static final String SERVICE_NAME = "WorldMap";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.shared.InitializeRequest,
      com.example.shared.InitializeResponse> getInitializeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Initialize",
      requestType = com.example.shared.InitializeRequest.class,
      responseType = com.example.shared.InitializeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.shared.InitializeRequest,
      com.example.shared.InitializeResponse> getInitializeMethod() {
    io.grpc.MethodDescriptor<com.example.shared.InitializeRequest, com.example.shared.InitializeResponse> getInitializeMethod;
    if ((getInitializeMethod = WorldMapGrpc.getInitializeMethod) == null) {
      synchronized (WorldMapGrpc.class) {
        if ((getInitializeMethod = WorldMapGrpc.getInitializeMethod) == null) {
          WorldMapGrpc.getInitializeMethod = getInitializeMethod =
              io.grpc.MethodDescriptor.<com.example.shared.InitializeRequest, com.example.shared.InitializeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Initialize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.InitializeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.InitializeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorldMapMethodDescriptorSupplier("Initialize"))
              .build();
        }
      }
    }
    return getInitializeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorldMapStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorldMapStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorldMapStub>() {
        @java.lang.Override
        public WorldMapStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorldMapStub(channel, callOptions);
        }
      };
    return WorldMapStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorldMapBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorldMapBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorldMapBlockingStub>() {
        @java.lang.Override
        public WorldMapBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorldMapBlockingStub(channel, callOptions);
        }
      };
    return WorldMapBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorldMapFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorldMapFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorldMapFutureStub>() {
        @java.lang.Override
        public WorldMapFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorldMapFutureStub(channel, callOptions);
        }
      };
    return WorldMapFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WorldMapImplBase implements io.grpc.BindableService {

    /**
     */
    public void initialize(com.example.shared.InitializeRequest request,
        io.grpc.stub.StreamObserver<com.example.shared.InitializeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInitializeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.shared.InitializeRequest,
                com.example.shared.InitializeResponse>(
                  this, METHODID_INITIALIZE)))
          .build();
    }
  }

  /**
   */
  public static final class WorldMapStub extends io.grpc.stub.AbstractAsyncStub<WorldMapStub> {
    private WorldMapStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorldMapStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorldMapStub(channel, callOptions);
    }

    /**
     */
    public void initialize(com.example.shared.InitializeRequest request,
        io.grpc.stub.StreamObserver<com.example.shared.InitializeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WorldMapBlockingStub extends io.grpc.stub.AbstractBlockingStub<WorldMapBlockingStub> {
    private WorldMapBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorldMapBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorldMapBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.shared.InitializeResponse initialize(com.example.shared.InitializeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WorldMapFutureStub extends io.grpc.stub.AbstractFutureStub<WorldMapFutureStub> {
    private WorldMapFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorldMapFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorldMapFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.shared.InitializeResponse> initialize(
        com.example.shared.InitializeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INITIALIZE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorldMapImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorldMapImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INITIALIZE:
          serviceImpl.initialize((com.example.shared.InitializeRequest) request,
              (io.grpc.stub.StreamObserver<com.example.shared.InitializeResponse>) responseObserver);
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

  private static abstract class WorldMapBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorldMapBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.shared.WorldMapProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorldMap");
    }
  }

  private static final class WorldMapFileDescriptorSupplier
      extends WorldMapBaseDescriptorSupplier {
    WorldMapFileDescriptorSupplier() {}
  }

  private static final class WorldMapMethodDescriptorSupplier
      extends WorldMapBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorldMapMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorldMapGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorldMapFileDescriptorSupplier())
              .addMethod(getInitializeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
