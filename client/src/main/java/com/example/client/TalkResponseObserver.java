package com.example.client;

import com.example.shared.TalkRequest;
import com.example.shared.TalkResponse;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import java.io.ByteArrayOutputStream;

public class TalkResponseObserver implements StreamObserver<TalkResponse> {

  private StreamObserver<TalkRequest> talkRequestObserver;

  private TargetDataLine microphone;

  private SourceDataLine speakers;

  private final AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);

  private static final int CHUNK_SIZE = 1024;

  public TalkResponseObserver() {
    try {
      microphone = AudioSystem.getTargetDataLine(format);
      DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
      microphone = (TargetDataLine) AudioSystem.getLine(info);
      microphone.open(format);
      microphone.start();

      DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, format);
      speakers = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
      speakers.open(format);
      speakers.start();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  @Override
  public void onNext(TalkResponse value) {
    speakers.write(value.getOtherTalkByteArray().toByteArray(), 0, value.getReadBytes());
  }

  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
  }

  @Override
  public void onCompleted() {
    speakers.drain();
    speakers.close();
    microphone.close();
  }

  public void setTalkRequestObserver(final StreamObserver<TalkRequest> talkRequestObserver) {
    this.talkRequestObserver = talkRequestObserver;
  }

  public void sendTalk() {
    int numBytesRead;
    byte[] data = new byte[microphone.getBufferSize() / 5];

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int bytesRead = 0;

    while (bytesRead < 100000) {
      numBytesRead = microphone.read(data, 0, CHUNK_SIZE);
      bytesRead += numBytesRead;

      out.write(data, 0, numBytesRead);
    }

    ByteString byteString = ByteString.copyFrom(out.toByteArray());
    TalkRequest talkRequest = TalkRequest.newBuilder().setTalkByteArray(byteString).setReadBytes(bytesRead).build();
    talkRequestObserver.onNext(talkRequest);
  }
}
