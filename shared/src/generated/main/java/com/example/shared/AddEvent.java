// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Player.proto

package com.example.shared;

/**
 * Protobuf type {@code AddEvent}
 */
public final class AddEvent extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:AddEvent)
    AddEventOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AddEvent.newBuilder() to construct.
  private AddEvent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddEvent() {
    imageTypes_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AddEvent();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AddEvent(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              imageTypes_ = new java.util.ArrayList<com.example.shared.GrpcImageTypes>();
              mutable_bitField0_ |= 0x00000001;
            }
            imageTypes_.add(
                input.readMessage(com.example.shared.GrpcImageTypes.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        imageTypes_ = java.util.Collections.unmodifiableList(imageTypes_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.shared.PlayerProto.internal_static_AddEvent_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.shared.PlayerProto.internal_static_AddEvent_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.shared.AddEvent.class, com.example.shared.AddEvent.Builder.class);
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

  public static final int IMAGETYPES_FIELD_NUMBER = 2;
  private java.util.List<com.example.shared.GrpcImageTypes> imageTypes_;
  /**
   * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
   */
  @java.lang.Override
  public java.util.List<com.example.shared.GrpcImageTypes> getImageTypesList() {
    return imageTypes_;
  }
  /**
   * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.example.shared.GrpcImageTypesOrBuilder> 
      getImageTypesOrBuilderList() {
    return imageTypes_;
  }
  /**
   * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
   */
  @java.lang.Override
  public int getImageTypesCount() {
    return imageTypes_.size();
  }
  /**
   * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
   */
  @java.lang.Override
  public com.example.shared.GrpcImageTypes getImageTypes(int index) {
    return imageTypes_.get(index);
  }
  /**
   * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
   */
  @java.lang.Override
  public com.example.shared.GrpcImageTypesOrBuilder getImageTypesOrBuilder(
      int index) {
    return imageTypes_.get(index);
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
    for (int i = 0; i < imageTypes_.size(); i++) {
      output.writeMessage(2, imageTypes_.get(i));
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
    for (int i = 0; i < imageTypes_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, imageTypes_.get(i));
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
    if (!(obj instanceof com.example.shared.AddEvent)) {
      return super.equals(obj);
    }
    com.example.shared.AddEvent other = (com.example.shared.AddEvent) obj;

    if (hasOtherPlayer() != other.hasOtherPlayer()) return false;
    if (hasOtherPlayer()) {
      if (!getOtherPlayer()
          .equals(other.getOtherPlayer())) return false;
    }
    if (!getImageTypesList()
        .equals(other.getImageTypesList())) return false;
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
    if (getImageTypesCount() > 0) {
      hash = (37 * hash) + IMAGETYPES_FIELD_NUMBER;
      hash = (53 * hash) + getImageTypesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.shared.AddEvent parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.shared.AddEvent parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.shared.AddEvent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.shared.AddEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.shared.AddEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.shared.AddEvent parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.shared.AddEvent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.shared.AddEvent parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.shared.AddEvent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.shared.AddEvent parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.shared.AddEvent parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.shared.AddEvent parseFrom(
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
  public static Builder newBuilder(com.example.shared.AddEvent prototype) {
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
   * Protobuf type {@code AddEvent}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:AddEvent)
      com.example.shared.AddEventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.shared.PlayerProto.internal_static_AddEvent_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.shared.PlayerProto.internal_static_AddEvent_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.shared.AddEvent.class, com.example.shared.AddEvent.Builder.class);
    }

    // Construct using com.example.shared.AddEvent.newBuilder()
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
        getImageTypesFieldBuilder();
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
      if (imageTypesBuilder_ == null) {
        imageTypes_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        imageTypesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.shared.PlayerProto.internal_static_AddEvent_descriptor;
    }

    @java.lang.Override
    public com.example.shared.AddEvent getDefaultInstanceForType() {
      return com.example.shared.AddEvent.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.shared.AddEvent build() {
      com.example.shared.AddEvent result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.shared.AddEvent buildPartial() {
      com.example.shared.AddEvent result = new com.example.shared.AddEvent(this);
      int from_bitField0_ = bitField0_;
      if (otherPlayerBuilder_ == null) {
        result.otherPlayer_ = otherPlayer_;
      } else {
        result.otherPlayer_ = otherPlayerBuilder_.build();
      }
      if (imageTypesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          imageTypes_ = java.util.Collections.unmodifiableList(imageTypes_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.imageTypes_ = imageTypes_;
      } else {
        result.imageTypes_ = imageTypesBuilder_.build();
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
      if (other instanceof com.example.shared.AddEvent) {
        return mergeFrom((com.example.shared.AddEvent)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.shared.AddEvent other) {
      if (other == com.example.shared.AddEvent.getDefaultInstance()) return this;
      if (other.hasOtherPlayer()) {
        mergeOtherPlayer(other.getOtherPlayer());
      }
      if (imageTypesBuilder_ == null) {
        if (!other.imageTypes_.isEmpty()) {
          if (imageTypes_.isEmpty()) {
            imageTypes_ = other.imageTypes_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureImageTypesIsMutable();
            imageTypes_.addAll(other.imageTypes_);
          }
          onChanged();
        }
      } else {
        if (!other.imageTypes_.isEmpty()) {
          if (imageTypesBuilder_.isEmpty()) {
            imageTypesBuilder_.dispose();
            imageTypesBuilder_ = null;
            imageTypes_ = other.imageTypes_;
            bitField0_ = (bitField0_ & ~0x00000001);
            imageTypesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getImageTypesFieldBuilder() : null;
          } else {
            imageTypesBuilder_.addAllMessages(other.imageTypes_);
          }
        }
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
      com.example.shared.AddEvent parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.shared.AddEvent) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

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

    private java.util.List<com.example.shared.GrpcImageTypes> imageTypes_ =
      java.util.Collections.emptyList();
    private void ensureImageTypesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        imageTypes_ = new java.util.ArrayList<com.example.shared.GrpcImageTypes>(imageTypes_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.shared.GrpcImageTypes, com.example.shared.GrpcImageTypes.Builder, com.example.shared.GrpcImageTypesOrBuilder> imageTypesBuilder_;

    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public java.util.List<com.example.shared.GrpcImageTypes> getImageTypesList() {
      if (imageTypesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(imageTypes_);
      } else {
        return imageTypesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public int getImageTypesCount() {
      if (imageTypesBuilder_ == null) {
        return imageTypes_.size();
      } else {
        return imageTypesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public com.example.shared.GrpcImageTypes getImageTypes(int index) {
      if (imageTypesBuilder_ == null) {
        return imageTypes_.get(index);
      } else {
        return imageTypesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder setImageTypes(
        int index, com.example.shared.GrpcImageTypes value) {
      if (imageTypesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureImageTypesIsMutable();
        imageTypes_.set(index, value);
        onChanged();
      } else {
        imageTypesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder setImageTypes(
        int index, com.example.shared.GrpcImageTypes.Builder builderForValue) {
      if (imageTypesBuilder_ == null) {
        ensureImageTypesIsMutable();
        imageTypes_.set(index, builderForValue.build());
        onChanged();
      } else {
        imageTypesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder addImageTypes(com.example.shared.GrpcImageTypes value) {
      if (imageTypesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureImageTypesIsMutable();
        imageTypes_.add(value);
        onChanged();
      } else {
        imageTypesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder addImageTypes(
        int index, com.example.shared.GrpcImageTypes value) {
      if (imageTypesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureImageTypesIsMutable();
        imageTypes_.add(index, value);
        onChanged();
      } else {
        imageTypesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder addImageTypes(
        com.example.shared.GrpcImageTypes.Builder builderForValue) {
      if (imageTypesBuilder_ == null) {
        ensureImageTypesIsMutable();
        imageTypes_.add(builderForValue.build());
        onChanged();
      } else {
        imageTypesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder addImageTypes(
        int index, com.example.shared.GrpcImageTypes.Builder builderForValue) {
      if (imageTypesBuilder_ == null) {
        ensureImageTypesIsMutable();
        imageTypes_.add(index, builderForValue.build());
        onChanged();
      } else {
        imageTypesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder addAllImageTypes(
        java.lang.Iterable<? extends com.example.shared.GrpcImageTypes> values) {
      if (imageTypesBuilder_ == null) {
        ensureImageTypesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, imageTypes_);
        onChanged();
      } else {
        imageTypesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder clearImageTypes() {
      if (imageTypesBuilder_ == null) {
        imageTypes_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        imageTypesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public Builder removeImageTypes(int index) {
      if (imageTypesBuilder_ == null) {
        ensureImageTypesIsMutable();
        imageTypes_.remove(index);
        onChanged();
      } else {
        imageTypesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public com.example.shared.GrpcImageTypes.Builder getImageTypesBuilder(
        int index) {
      return getImageTypesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public com.example.shared.GrpcImageTypesOrBuilder getImageTypesOrBuilder(
        int index) {
      if (imageTypesBuilder_ == null) {
        return imageTypes_.get(index);  } else {
        return imageTypesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public java.util.List<? extends com.example.shared.GrpcImageTypesOrBuilder> 
         getImageTypesOrBuilderList() {
      if (imageTypesBuilder_ != null) {
        return imageTypesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(imageTypes_);
      }
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public com.example.shared.GrpcImageTypes.Builder addImageTypesBuilder() {
      return getImageTypesFieldBuilder().addBuilder(
          com.example.shared.GrpcImageTypes.getDefaultInstance());
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public com.example.shared.GrpcImageTypes.Builder addImageTypesBuilder(
        int index) {
      return getImageTypesFieldBuilder().addBuilder(
          index, com.example.shared.GrpcImageTypes.getDefaultInstance());
    }
    /**
     * <code>repeated .GrpcImageTypes imageTypes = 2;</code>
     */
    public java.util.List<com.example.shared.GrpcImageTypes.Builder> 
         getImageTypesBuilderList() {
      return getImageTypesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.shared.GrpcImageTypes, com.example.shared.GrpcImageTypes.Builder, com.example.shared.GrpcImageTypesOrBuilder> 
        getImageTypesFieldBuilder() {
      if (imageTypesBuilder_ == null) {
        imageTypesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.example.shared.GrpcImageTypes, com.example.shared.GrpcImageTypes.Builder, com.example.shared.GrpcImageTypesOrBuilder>(
                imageTypes_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        imageTypes_ = null;
      }
      return imageTypesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:AddEvent)
  }

  // @@protoc_insertion_point(class_scope:AddEvent)
  private static final com.example.shared.AddEvent DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.shared.AddEvent();
  }

  public static com.example.shared.AddEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddEvent>
      PARSER = new com.google.protobuf.AbstractParser<AddEvent>() {
    @java.lang.Override
    public AddEvent parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AddEvent(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddEvent> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddEvent> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.shared.AddEvent getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
