package com.example.server;

import com.example.shared.DataChunk;
import com.example.shared.FileServiceGrpc;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.apache.commons.io.FileUtils;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.util.ResourceUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;

@GRpcService
public class FileService extends FileServiceGrpc.FileServiceImplBase {

  @Override
  public void downloadFile(Empty request, StreamObserver<DataChunk> responseObserver) {
    try {
      File soundFile = ResourceUtils.getFile("classpath:sound/ohayo.wav");
      byte[] bytes = FileUtils.readFileToByteArray(soundFile);
      BufferedInputStream soundStream = new BufferedInputStream(new ByteArrayInputStream(bytes));
      int bufferSize = 1024 * 100;
      byte[] buffer = new byte[bufferSize];
      int length;
      while ((length = soundStream.read(buffer, 0, bufferSize)) != -1) {
        responseObserver.onNext(DataChunk.newBuilder()
          .setData(ByteString.copyFrom(buffer, 0, length))
          .setSize(bufferSize)
          .build());
      }
      soundStream.close();
      responseObserver.onCompleted();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
