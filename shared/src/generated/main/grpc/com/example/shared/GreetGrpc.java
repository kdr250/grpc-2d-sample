package com.example.shared;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Greet.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GreetGrpc {

  private GreetGrpc() {}

  public static final String SERVICE_NAME = "greet.Greet";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.shared.GreetRequest,
      com.example.shared.GreetResponse> getGreetingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greeting",
      requestType = com.example.shared.GreetRequest.class,
      responseType = com.example.shared.GreetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.shared.GreetRequest,
      com.example.shared.GreetResponse> getGreetingMethod() {
    io.grpc.MethodDescriptor<com.example.shared.GreetRequest, com.example.shared.GreetResponse> getGreetingMethod;
    if ((getGreetingMethod = GreetGrpc.getGreetingMethod) == null) {
      synchronized (GreetGrpc.class) {
        if ((getGreetingMethod = GreetGrpc.getGreetingMethod) == null) {
          GreetGrpc.getGreetingMethod = getGreetingMethod =
              io.grpc.MethodDescriptor.<com.example.shared.GreetRequest, com.example.shared.GreetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "greeting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.GreetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.GreetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetMethodDescriptorSupplier("greeting"))
              .build();
        }
      }
    }
    return getGreetingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetStub>() {
        @java.lang.Override
        public GreetStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetStub(channel, callOptions);
        }
      };
    return GreetStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetBlockingStub>() {
        @java.lang.Override
        public GreetBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetBlockingStub(channel, callOptions);
        }
      };
    return GreetBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetFutureStub>() {
        @java.lang.Override
        public GreetFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetFutureStub(channel, callOptions);
        }
      };
    return GreetFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GreetImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.GreetRequest> greeting(
        io.grpc.stub.StreamObserver<com.example.shared.GreetResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGreetingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGreetingMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.shared.GreetRequest,
                com.example.shared.GreetResponse>(
                  this, METHODID_GREETING)))
          .build();
    }
  }

  /**
   */
  public static final class GreetStub extends io.grpc.stub.AbstractAsyncStub<GreetStub> {
    private GreetStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.GreetRequest> greeting(
        io.grpc.stub.StreamObserver<com.example.shared.GreetResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGreetingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GreetBlockingStub extends io.grpc.stub.AbstractBlockingStub<GreetBlockingStub> {
    private GreetBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class GreetFutureStub extends io.grpc.stub.AbstractFutureStub<GreetFutureStub> {
    private GreetFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GREETING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreetImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreetImplBase serviceImpl, int methodId) {
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
        case METHODID_GREETING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.greeting(
              (io.grpc.stub.StreamObserver<com.example.shared.GreetResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreetBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.shared.Greeter.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greet");
    }
  }

  private static final class GreetFileDescriptorSupplier
      extends GreetBaseDescriptorSupplier {
    GreetFileDescriptorSupplier() {}
  }

  private static final class GreetMethodDescriptorSupplier
      extends GreetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreetMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreetGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreetFileDescriptorSupplier())
              .addMethod(getGreetingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
