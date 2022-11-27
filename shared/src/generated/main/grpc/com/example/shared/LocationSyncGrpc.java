package com.example.shared;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: Location.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LocationSyncGrpc {

  private LocationSyncGrpc() {}

  public static final String SERVICE_NAME = "LocationSync";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.shared.LocationRequest,
      com.example.shared.LocationResponse> getSyncLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "syncLocation",
      requestType = com.example.shared.LocationRequest.class,
      responseType = com.example.shared.LocationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.shared.LocationRequest,
      com.example.shared.LocationResponse> getSyncLocationMethod() {
    io.grpc.MethodDescriptor<com.example.shared.LocationRequest, com.example.shared.LocationResponse> getSyncLocationMethod;
    if ((getSyncLocationMethod = LocationSyncGrpc.getSyncLocationMethod) == null) {
      synchronized (LocationSyncGrpc.class) {
        if ((getSyncLocationMethod = LocationSyncGrpc.getSyncLocationMethod) == null) {
          LocationSyncGrpc.getSyncLocationMethod = getSyncLocationMethod =
              io.grpc.MethodDescriptor.<com.example.shared.LocationRequest, com.example.shared.LocationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "syncLocation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.LocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.shared.LocationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LocationSyncMethodDescriptorSupplier("syncLocation"))
              .build();
        }
      }
    }
    return getSyncLocationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LocationSyncStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationSyncStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationSyncStub>() {
        @java.lang.Override
        public LocationSyncStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationSyncStub(channel, callOptions);
        }
      };
    return LocationSyncStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LocationSyncBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationSyncBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationSyncBlockingStub>() {
        @java.lang.Override
        public LocationSyncBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationSyncBlockingStub(channel, callOptions);
        }
      };
    return LocationSyncBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LocationSyncFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationSyncFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationSyncFutureStub>() {
        @java.lang.Override
        public LocationSyncFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationSyncFutureStub(channel, callOptions);
        }
      };
    return LocationSyncFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LocationSyncImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.LocationRequest> syncLocation(
        io.grpc.stub.StreamObserver<com.example.shared.LocationResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSyncLocationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSyncLocationMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.shared.LocationRequest,
                com.example.shared.LocationResponse>(
                  this, METHODID_SYNC_LOCATION)))
          .build();
    }
  }

  /**
   */
  public static final class LocationSyncStub extends io.grpc.stub.AbstractAsyncStub<LocationSyncStub> {
    private LocationSyncStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationSyncStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationSyncStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.shared.LocationRequest> syncLocation(
        io.grpc.stub.StreamObserver<com.example.shared.LocationResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSyncLocationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LocationSyncBlockingStub extends io.grpc.stub.AbstractBlockingStub<LocationSyncBlockingStub> {
    private LocationSyncBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationSyncBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationSyncBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class LocationSyncFutureStub extends io.grpc.stub.AbstractFutureStub<LocationSyncFutureStub> {
    private LocationSyncFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationSyncFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationSyncFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SYNC_LOCATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LocationSyncImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LocationSyncImplBase serviceImpl, int methodId) {
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
        case METHODID_SYNC_LOCATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.syncLocation(
              (io.grpc.stub.StreamObserver<com.example.shared.LocationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LocationSyncBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocationSyncBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.shared.LocationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LocationSync");
    }
  }

  private static final class LocationSyncFileDescriptorSupplier
      extends LocationSyncBaseDescriptorSupplier {
    LocationSyncFileDescriptorSupplier() {}
  }

  private static final class LocationSyncMethodDescriptorSupplier
      extends LocationSyncBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LocationSyncMethodDescriptorSupplier(String methodName) {
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
      synchronized (LocationSyncGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LocationSyncFileDescriptorSupplier())
              .addMethod(getSyncLocationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
