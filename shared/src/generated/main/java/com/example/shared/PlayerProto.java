// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Player.proto

package com.example.shared;

public final class PlayerProto {
  private PlayerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PlayerSyncRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PlayerSyncRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PlayerSyncResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PlayerSyncResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GrpcPlayer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GrpcPlayer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GrpcLocation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GrpcLocation_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Player.proto\"0\n\021PlayerSyncRequest\022\033\n\006p" +
      "layer\030\001 \001(\0132\013.GrpcPlayer\"6\n\022PlayerSyncRe" +
      "sponse\022 \n\013otherPlayer\030\001 \003(\0132\013.GrpcPlayer" +
      "\"G\n\nGrpcPlayer\022\n\n\002id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t" +
      "\022\037\n\010location\030\003 \001(\0132\r.GrpcLocation\"$\n\014Grp" +
      "cLocation\022\t\n\001x\030\001 \001(\005\022\t\n\001y\030\002 \001(\0052=\n\006Playe" +
      "r\0223\n\004Sync\022\022.PlayerSyncRequest\032\023.PlayerSy" +
      "ncResponse(\0010\001B#\n\022com.example.sharedB\013Pl" +
      "ayerProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PlayerSyncRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PlayerSyncRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PlayerSyncRequest_descriptor,
        new java.lang.String[] { "Player", });
    internal_static_PlayerSyncResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_PlayerSyncResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PlayerSyncResponse_descriptor,
        new java.lang.String[] { "OtherPlayer", });
    internal_static_GrpcPlayer_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GrpcPlayer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GrpcPlayer_descriptor,
        new java.lang.String[] { "Id", "Name", "Location", });
    internal_static_GrpcLocation_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_GrpcLocation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GrpcLocation_descriptor,
        new java.lang.String[] { "X", "Y", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
