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
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class FileService {

  @GrpcClient("server")
  private FileServiceGrpc.FileServiceStub fileServiceStub;

  private static final int BUFFER_SIZE = 4096;

  @PostConstruct
  public void init() {
    downloadFile();
  }

  public void downloadFile() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
      }

      @Override
      public void onCompleted() {
        System.out.println("download completed!");
        try {
          ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
          AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

          AudioFormat format = audioStream.getFormat();
          DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
          SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
          sourceDataLine.open(format);
          sourceDataLine.start();

          System.out.println("Playback Start!");

          byte[] bufferBytes = new byte[BUFFER_SIZE];
          int readBytes = -1;
          while ((readBytes = audioStream.read(bufferBytes)) != -1) {
            if (readBytes > 0) {
              sourceDataLine.write(bufferBytes, 0, readBytes);
            }
          }
          sourceDataLine.drain();
          sourceDataLine.close();
          audioStream.close();

          System.out.println("Playback Finished!");

        } catch (Exception e) {
          e.printStackTrace();
        }
      };
    };

    fileServiceStub.downloadFile(Empty.newBuilder().build(), streamObserver);
  }
}
