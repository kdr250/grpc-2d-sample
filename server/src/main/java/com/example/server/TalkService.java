package com.example.server;

import com.example.shared.TalkGrpc;
import com.example.shared.TalkRequest;
import com.example.shared.TalkResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.HashSet;
import java.util.Set;

@GRpcService
public class TalkService extends TalkGrpc.TalkImplBase {

  Set<StreamObserver<TalkResponse>> responseObserverSet = new HashSet<>();

  @Override
  public StreamObserver<TalkRequest> stream(StreamObserver<TalkResponse> responseObserver) {
    responseObserverSet.add(responseObserver);

    return new StreamObserver<TalkRequest>() {
      @Override
      public void onNext(TalkRequest value) {
        responseObserverSet.stream().filter(o -> o != responseObserver).forEach(o -> {
          TalkResponse talkResponse = TalkResponse.newBuilder()
            .setOtherTalkByteArray(value.getTalkByteArray())
            .setReadBytes(value.getReadBytes())
            .build();
          o.onNext(talkResponse);
        });
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        System.out.println("onCompleted!");
        responseObserver.onCompleted();
        responseObserverSet.remove(responseObserver);
      }
    };
  }
}
