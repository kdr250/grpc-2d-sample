package com.example.client;

import com.example.shared.TalkGrpc.TalkStub;
import com.example.shared.TalkStreamRequest;
import com.example.shared.TalkStreamResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.sound.sampled.AudioSystem;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

@Service
public class TalkService {

  @GrpcClient("server")
  private TalkStub talkStub;

  private byte[] talkByteArray;

  @PostConstruct
  public void init() {
    try {
      File wavFile = ResourceUtils.getFile("classpath:sound/ohayo.wav");
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(wavFile));

      int read;
      byte[] buff = new byte[1024];
      while ((read = bufferedInputStream.read(buff)) > 0) {
        outputStream.write(buff, 0, read);
      }
      outputStream.flush();
      talkByteArray = outputStream.toByteArray();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public void start() {
    StreamObserver<TalkStreamRequest> requestObserver = talkStub.stream(new StreamObserver<TalkStreamResponse>() {
      @Override
      public void onNext(TalkStreamResponse value) {
        
      }

      @Override
      public void onError(Throwable t) {

      }

      @Override
      public void onCompleted() {

      }
    });
  }
}
