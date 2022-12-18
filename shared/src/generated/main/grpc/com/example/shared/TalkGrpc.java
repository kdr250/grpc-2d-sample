package com.example.shared;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Talk.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TalkGrpc {

  private TalkGrpc() {}

  public static final String SERVICE_NAME = "Talk";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.shared.TalkRequest,
      com.example.shared.TalkResponse> getStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Stream",
      requestType = com.example.shared.TalkRequest.class,
      responseType = com.example.shared.TalkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.shared.TalkRequest,
      com.example.shared.TalkResponse> getStreamMethod() {
    io.grpc.MethodDescriptor<com.example.shared.TalkRequest, com.example.shared.TalkResponse> getStreamMethod;
    if ((getStreamMethod = TalkGrpc.getStreamMethod) == null) {
      synchronized (TalkGrpc.class) {
        if ((getStreamMethod = TalkGrpc.getStreamMethod) == null) {
          TalkGrpc.getStreamMethod = getStreamMethod =
              io.grpc.MethodDescriptor.<com.example.shared.TalkRequest, com.example.shared.TalkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Stream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.TalkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.TalkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TalkMethodDescriptorSupplier("Stream"))
              .build();
        }
      }
    }
    return getStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TalkStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TalkStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TalkStub>() {
        @java.lang.Override
        public TalkStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TalkStub(channel, callOptions);
        }
      };
    return TalkStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TalkBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TalkBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TalkBlockingStub>() {
        @java.lang.Override
        public TalkBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TalkBlockingStub(channel, callOptions);
        }
      };
    return TalkBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TalkFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TalkFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TalkFutureStub>() {
        @java.lang.Override
        public TalkFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TalkFutureStub(channel, callOptions);
        }
      };
    return TalkFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TalkImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.TalkRequest> stream(
        io.grpc.stub.StreamObserver<com.example.shared.TalkResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.shared.TalkRequest,
                com.example.shared.TalkResponse>(
                  this, METHODID_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class TalkStub extends io.grpc.stub.AbstractAsyncStub<TalkStub> {
    private TalkStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TalkStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TalkStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.TalkRequest> stream(
        io.grpc.stub.StreamObserver<com.example.shared.TalkResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TalkBlockingStub extends io.grpc.stub.AbstractBlockingStub<TalkBlockingStub> {
    private TalkBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TalkBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TalkBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class TalkFutureStub extends io.grpc.stub.AbstractFutureStub<TalkFutureStub> {
    private TalkFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TalkFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TalkFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TalkImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TalkImplBase serviceImpl, int methodId) {
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
        case METHODID_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.stream(
              (io.grpc.stub.StreamObserver<com.example.shared.TalkResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TalkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TalkBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.shared.TalkProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Talk");
    }
  }

  private static final class TalkFileDescriptorSupplier
      extends TalkBaseDescriptorSupplier {
    TalkFileDescriptorSupplier() {}
  }

  private static final class TalkMethodDescriptorSupplier
      extends TalkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TalkMethodDescriptorSupplier(String methodName) {
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
      synchronized (TalkGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TalkFileDescriptorSupplier())
              .addMethod(getStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
