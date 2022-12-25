package com.example.client;

import com.example.shared.TalkGrpc.TalkStub;
import com.example.shared.TalkRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TalkService implements Runnable {

  @GrpcClient("server")
  private TalkStub talkStub;

  private TalkResponseObserver talkResponseObserver;

  private Thread talkThread;

  public void startThread() {
    talkResponseObserver = new TalkResponseObserver();
    StreamObserver<TalkRequest> talkRequestObserver = talkStub.stream(talkResponseObserver);
    talkResponseObserver.setTalkRequestObserver(talkRequestObserver);

    talkThread = new Thread(this);
    talkThread.start();
  }

  public void stopThread() {
    talkThread = null;
    talkResponseObserver.onCompleted();
    System.out.println("Talk onCompleted!");
  }

  @Override
  public void run() {
    while (talkThread != null) {
      talkResponseObserver.sendTalk();
    }
  }
}
