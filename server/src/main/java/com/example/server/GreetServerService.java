package com.example.server;

import com.example.shared.GreetGrpc;
import com.example.shared.GreetRequest;
import com.example.shared.GreetResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.List;

@GRpcService
public class GreetServerService extends GreetGrpc.GreetImplBase {

  private List<String> greetList = List.of("Good Morning! ", "Hello! ", "Good Night! ", "Nice! ");

  @Override
  public StreamObserver<GreetRequest> greeting(StreamObserver<GreetResponse> responseObserver) {
    return new StreamObserver<GreetRequest>() {
      @Override
      public void onNext(GreetRequest value) {
        for (String greet : greetList) {
          GreetResponse greetResponse = GreetResponse.newBuilder().setMessage(greet + value.getName()).build();
          responseObserver.onNext(greetResponse);
        }
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
  }
}
