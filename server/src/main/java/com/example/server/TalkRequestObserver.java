package com.example.server;

import com.example.shared.TalkRequest;
import com.example.shared.TalkResponse;
import io.grpc.stub.StreamObserver;

public class TalkRequestObserver implements StreamObserver<TalkRequest> {

  private final StreamObserver<TalkResponse> talkResponseStreamObserver;

  public TalkRequestObserver(final StreamObserver<TalkResponse> talkResponseStreamObserver) {
    this.talkResponseStreamObserver = talkResponseStreamObserver;
  }

  @Override
  public void onNext(TalkRequest value) {

  }

  @Override
  public void onError(Throwable t) {

  }

  @Override
  public void onCompleted() {

  }
}
