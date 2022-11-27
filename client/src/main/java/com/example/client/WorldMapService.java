package com.example.client;

import com.example.shared.GrpcTile;
import com.example.shared.GrpcWorldMap;
import com.example.shared.InitializeRequest;
import com.example.shared.InitializeResponse;
import com.example.shared.WorldMapGrpc.WorldMapBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WorldMapService {

  @GrpcClient("server")
  private WorldMapBlockingStub worldMapBlockingStub;

  public WorldMap worldMap() {
    InitializeRequest initializeRequest = InitializeRequest.newBuilder().setName("プレイヤー1").build();

    InitializeResponse initializeResponse = worldMapBlockingStub.initialize(initializeRequest);

    GrpcWorldMap grpcWorldMap = initializeResponse.getWorldMap();

    return convert(grpcWorldMap);
  }

  private WorldMap convert(GrpcWorldMap grpcWorldMap) {
    int width = grpcWorldMap.getWidth();
    int height = grpcWorldMap.getHeight();
    Tile[][] result = new Tile[height][width];
    String[] tilePlacement = grpcWorldMap.getTilePlacement().split("");

    List<GrpcTile> grpcTileList = grpcWorldMap.getTilesList();
    Map<String, BufferedImage> imageMap = grpcTileList.stream()
      .collect(Collectors.toMap(GrpcTile::getName, t -> bufferedImage(t.getBase64Image())));
    Map<String, Boolean> collisionMap =  grpcTileList.stream()
      .collect(Collectors.toMap(GrpcTile::getName, GrpcTile::getCollision));


    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        String character = tilePlacement[i * width + j];
        Location location = new Location(j * Tile.TILE_SIZE, i * Tile.TILE_SIZE);
        BufferedImage image = imageMap.get(character);
        Boolean isCollidable = collisionMap.get(character);
        result[i][j] = new Tile(character, location, image, isCollidable);
      }
    }

    return new WorldMap(result);
  }

  public BufferedImage bufferedImage(String base64String) {
    byte[] decodedBytes = Base64.getDecoder().decode(base64String);
    ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
    try {
      BufferedImage original = ImageIO.read(bis);
      BufferedImage scaledImage = new BufferedImage(Tile.TILE_SIZE, Tile.TILE_SIZE, original.getType());
      Graphics2D g2 = scaledImage.createGraphics();
      g2.drawImage(original, 0, 0, Tile.TILE_SIZE, Tile.TILE_SIZE, null);
      return scaledImage;
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
