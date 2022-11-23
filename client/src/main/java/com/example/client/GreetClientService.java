package com.example.client;

import com.example.shared.GreetGrpc.GreetStub;
import com.example.shared.GreetRequest;
import com.example.shared.GreetResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class GreetClientService {

  @GrpcClient("greet-server")
  private GreetStub clientGreetStub;

  public String receiveGreeting(String name) {
    GreetRequest greetRequest = GreetRequest.newBuilder().setName(name).build();
    CountDownLatch finishLatch = new CountDownLatch(1);
    List<GreetResponse> results = new ArrayList<>();

    StreamObserver<GreetRequest> streamObserver = clientGreetStub.greeting(new StreamObserver<GreetResponse>() {
      @Override
      public void onNext(GreetResponse value) {
        results.add(value);
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        finishLatch.countDown();
      }
    });

    streamObserver.onNext(greetRequest);
    streamObserver.onNext(greetRequest);
    streamObserver.onNext(greetRequest);

    streamObserver.onCompleted();

    try {
      finishLatch.await(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return results.toString();
  }
}
