package com.example.client;

import com.example.shared.DataChunk;
import com.example.shared.FileServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class FileService implements LineListener {

  @GrpcClient("server")
  private FileServiceGrpc.FileServiceStub fileServiceStub;

  private boolean isPlaybackCompleted;

  @PostConstruct
  public void init() {
    downloadFile();
  }

  public void downloadFile() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    AtomicBoolean completed = new AtomicBoolean(false);

    StreamObserver<DataChunk> streamObserver = new StreamObserver<DataChunk>() {
      @Override
      public void onNext(DataChunk value) {
        try {
          outputStream.write(value.getData().toByteArray());
        } catch (IOException e) {
          onError(e);
        }
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
        countDownLatch.countDown();
      }

      @Override
      public void onCompleted() {
        System.out.println("download completed!");
        completed.compareAndSet(false, true);
        countDownLatch.countDown();
      }
    };

    try {
      fileServiceStub.downloadFile(Empty.newBuilder().build(), streamObserver);

      countDownLatch.await(30, TimeUnit.SECONDS);

      if (!completed.get()) {
        throw new RuntimeException("download not completed!");
      }

      ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
      AudioFormat audioFormat = audioInputStream.getFormat();
      DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
      Clip audioClip = (Clip) AudioSystem.getLine(info);
      audioClip.addLineListener(this);
      audioClip.open(audioInputStream);
      audioClip.start();

      audioClip.close();
      audioInputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(LineEvent event) {
    if (LineEvent.Type.START == event.getType()) {
      System.out.println("Playback started.");
    } else if (LineEvent.Type.STOP == event.getType()) {
      isPlaybackCompleted = true;
      System.out.println("Playback completed.");
    }
  }
}
