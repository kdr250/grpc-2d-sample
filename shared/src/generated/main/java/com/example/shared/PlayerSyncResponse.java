// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Player.proto

package com.example.shared;

/**
 * Protobuf type {@code PlayerSyncResponse}
 */
public final class PlayerSyncResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PlayerSyncResponse)
    PlayerSyncResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PlayerSyncResponse.newBuilder() to construct.
  private PlayerSyncResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PlayerSyncResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PlayerSyncResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PlayerSyncResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.example.shared.GrpcPlayer.Builder subBuilder = null;
            if (otherPlayer_ != null) {
              subBuilder = otherPlayer_.toBuilder();
            }
            otherPlayer_ = input.readMessage(com.example.shared.GrpcPlayer.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(otherPlayer_);
              otherPlayer_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.shared.PlayerProto.internal_static_PlayerSyncResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.shared.PlayerProto.internal_static_PlayerSyncResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.shared.PlayerSyncResponse.class, com.example.shared.PlayerSyncResponse.Builder.class);
  }

  public static final int OTHERPLAYER_FIELD_NUMBER = 1;
  private com.example.shared.GrpcPlayer otherPlayer_;
  /**
   * <code>.GrpcPlayer otherPlayer = 1;</code>
   * @return Whether the otherPlayer field is set.
   */
  @java.lang.Override
  public boolean hasOtherPlayer() {
    return otherPlayer_ != null;
  }
  /**
   * <code>.GrpcPlayer otherPlayer = 1;</code>
   * @return The otherPlayer.
   */
  @java.lang.Override
  public com.example.shared.GrpcPlayer getOtherPlayer() {
    return otherPlayer_ == null ? com.example.shared.GrpcPlayer.getDefaultInstance() : otherPlayer_;
  }
  /**
   * <code>.GrpcPlayer otherPlayer = 1;</code>
   */
  @java.lang.Override
  public com.example.shared.GrpcPlayerOrBuilder getOtherPlayerOrBuilder() {
    return getOtherPlayer();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (otherPlayer_ != null) {
      output.writeMessage(1, getOtherPlayer());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (otherPlayer_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getOtherPlayer());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.shared.PlayerSyncResponse)) {
      return super.equals(obj);
    }
    com.example.shared.PlayerSyncResponse other = (com.example.shared.PlayerSyncResponse) obj;

    if (hasOtherPlayer() != other.hasOtherPlayer()) return false;
    if (hasOtherPlayer()) {
      if (!getOtherPlayer()
          .equals(other.getOtherPlayer())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasOtherPlayer()) {
      hash = (37 * hash) + OTHERPLAYER_FIELD_NUMBER;
      hash = (53 * hash) + getOtherPlayer().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.shared.PlayerSyncResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.shared.PlayerSyncResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.shared.PlayerSyncResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.shared.PlayerSyncResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.shared.PlayerSyncResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code PlayerSyncResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PlayerSyncResponse)
      com.example.shared.PlayerSyncResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.shared.PlayerProto.internal_static_PlayerSyncResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.shared.PlayerProto.internal_static_PlayerSyncResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.shared.PlayerSyncResponse.class, com.example.shared.PlayerSyncResponse.Builder.class);
    }

    // Construct using com.example.shared.PlayerSyncResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (otherPlayerBuilder_ == null) {
        otherPlayer_ = null;
      } else {
        otherPlayer_ = null;
        otherPlayerBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.shared.PlayerProto.internal_static_PlayerSyncResponse_descriptor;
    }

    @java.lang.Override
    public com.example.shared.PlayerSyncResponse getDefaultInstanceForType() {
      return com.example.shared.PlayerSyncResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.shared.PlayerSyncResponse build() {
      com.example.shared.PlayerSyncResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.shared.PlayerSyncResponse buildPartial() {
      com.example.shared.PlayerSyncResponse result = new com.example.shared.PlayerSyncResponse(this);
      if (otherPlayerBuilder_ == null) {
        result.otherPlayer_ = otherPlayer_;
      } else {
        result.otherPlayer_ = otherPlayerBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.shared.PlayerSyncResponse) {
        return mergeFrom((com.example.shared.PlayerSyncResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.shared.PlayerSyncResponse other) {
      if (other == com.example.shared.PlayerSyncResponse.getDefaultInstance()) return this;
      if (other.hasOtherPlayer()) {
        mergeOtherPlayer(other.getOtherPlayer());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.shared.PlayerSyncResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.shared.PlayerSyncResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.example.shared.GrpcPlayer otherPlayer_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.shared.GrpcPlayer, com.example.shared.GrpcPlayer.Builder, com.example.shared.GrpcPlayerOrBuilder> otherPlayerBuilder_;
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     * @return Whether the otherPlayer field is set.
     */
    public boolean hasOtherPlayer() {
      return otherPlayerBuilder_ != null || otherPlayer_ != null;
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     * @return The otherPlayer.
     */
    public com.example.shared.GrpcPlayer getOtherPlayer() {
      if (otherPlayerBuilder_ == null) {
        return otherPlayer_ == null ? com.example.shared.GrpcPlayer.getDefaultInstance() : otherPlayer_;
      } else {
        return otherPlayerBuilder_.getMessage();
      }
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    public Builder setOtherPlayer(com.example.shared.GrpcPlayer value) {
      if (otherPlayerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        otherPlayer_ = value;
        onChanged();
      } else {
        otherPlayerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    public Builder setOtherPlayer(
        com.example.shared.GrpcPlayer.Builder builderForValue) {
      if (otherPlayerBuilder_ == null) {
        otherPlayer_ = builderForValue.build();
        onChanged();
      } else {
        otherPlayerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    public Builder mergeOtherPlayer(com.example.shared.GrpcPlayer value) {
      if (otherPlayerBuilder_ == null) {
        if (otherPlayer_ != null) {
          otherPlayer_ =
            com.example.shared.GrpcPlayer.newBuilder(otherPlayer_).mergeFrom(value).buildPartial();
        } else {
          otherPlayer_ = value;
        }
        onChanged();
      } else {
        otherPlayerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    public Builder clearOtherPlayer() {
      if (otherPlayerBuilder_ == null) {
        otherPlayer_ = null;
        onChanged();
      } else {
        otherPlayer_ = null;
        otherPlayerBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    public com.example.shared.GrpcPlayer.Builder getOtherPlayerBuilder() {
      
      onChanged();
      return getOtherPlayerFieldBuilder().getBuilder();
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    public com.example.shared.GrpcPlayerOrBuilder getOtherPlayerOrBuilder() {
      if (otherPlayerBuilder_ != null) {
        return otherPlayerBuilder_.getMessageOrBuilder();
      } else {
        return otherPlayer_ == null ?
            com.example.shared.GrpcPlayer.getDefaultInstance() : otherPlayer_;
      }
    }
    /**
     * <code>.GrpcPlayer otherPlayer = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.shared.GrpcPlayer, com.example.shared.GrpcPlayer.Builder, com.example.shared.GrpcPlayerOrBuilder> 
        getOtherPlayerFieldBuilder() {
      if (otherPlayerBuilder_ == null) {
        otherPlayerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.shared.GrpcPlayer, com.example.shared.GrpcPlayer.Builder, com.example.shared.GrpcPlayerOrBuilder>(
                getOtherPlayer(),
                getParentForChildren(),
                isClean());
        otherPlayer_ = null;
      }
      return otherPlayerBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:PlayerSyncResponse)
  }

  // @@protoc_insertion_point(class_scope:PlayerSyncResponse)
  private static final com.example.shared.PlayerSyncResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.shared.PlayerSyncResponse();
  }

  public static com.example.shared.PlayerSyncResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PlayerSyncResponse>
      PARSER = new com.google.protobuf.AbstractParser<PlayerSyncResponse>() {
    @java.lang.Override
    public PlayerSyncResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PlayerSyncResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PlayerSyncResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PlayerSyncResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.shared.PlayerSyncResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
