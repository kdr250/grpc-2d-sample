// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WorldMap.proto

package com.example.shared;

public final class WorldMapProto {
  private WorldMapProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_InitializeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_InitializeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_InitializeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_InitializeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GrpcWorldMap_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GrpcWorldMap_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GrpcTile_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GrpcTile_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016WorldMap.proto\"!\n\021InitializeRequest\022\014\n" +
      "\004name\030\001 \001(\t\"5\n\022InitializeResponse\022\037\n\010wor" +
      "ldMap\030\001 \001(\0132\r.GrpcWorldMap\"j\n\014GrpcWorldM" +
      "ap\022\n\n\002id\030\001 \001(\t\022\r\n\005width\030\002 \001(\005\022\016\n\006height\030" +
      "\003 \001(\005\022\025\n\rtilePlacement\030\004 \001(\t\022\030\n\005tiles\030\005 " +
      "\003(\0132\t.GrpcTile\"@\n\010GrpcTile\022\014\n\004name\030\001 \001(\t" +
      "\022\023\n\013base64image\030\002 \001(\t\022\021\n\tcollision\030\003 \001(\010" +
      "2A\n\010WorldMap\0225\n\nInitialize\022\022.InitializeR" +
      "equest\032\023.InitializeResponseB%\n\022com.examp" +
      "le.sharedB\rWorldMapProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_InitializeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_InitializeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_InitializeRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_InitializeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_InitializeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_InitializeResponse_descriptor,
        new java.lang.String[] { "WorldMap", });
    internal_static_GrpcWorldMap_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GrpcWorldMap_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GrpcWorldMap_descriptor,
        new java.lang.String[] { "Id", "Width", "Height", "TilePlacement", "Tiles", });
    internal_static_GrpcTile_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_GrpcTile_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GrpcTile_descriptor,
        new java.lang.String[] { "Name", "Base64Image", "Collision", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
