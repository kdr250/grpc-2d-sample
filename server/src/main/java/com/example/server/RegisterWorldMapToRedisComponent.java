package com.example.server;

import com.example.shared.GrpcTile;
import com.example.shared.GrpcWorldMap;
import org.apache.commons.io.FileUtils;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import reactor.util.function.Tuple3;
import reactor.util.function.Tuples;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RegisterWorldMapToRedisComponent {

  private final StringRedisTemplate redisTemplate;

  public RegisterWorldMapToRedisComponent(final StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @PostConstruct
  public void init() {
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
    List<Pair<String, String>> worldMapList = new ArrayList<>();

    try {
      File worldMapFolder = ResourceUtils.getFile("classpath:worldmap/");
      File[] worldMapFiles = worldMapFolder.listFiles();
      if (worldMapFiles != null) {
        worldMapList = Arrays.stream(worldMapFiles).map(this::readWorldMapCsv)
          .peek(tuple3 -> valueOperations.set(tuple3.getT1(), tuple3.getT2()))
          .map(tuple3 -> Pair.of(tuple3.getT1(), tuple3.getT3()))
          .collect(Collectors.toList());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    for (Pair<String, String> worldMap : worldMapList) {
      try {
        for (String imageName : worldMap.getSecond().split("")) {
          File imageFile = ResourceUtils.getFile("classpath:image/" + worldMap.getFirst() + "/" + imageName + ".png");
          byte[] fileContent = FileUtils.readFileToByteArray(imageFile);
          String encodedString = Base64.getEncoder().encodeToString(fileContent);
          valueOperations.set(imageName, encodedString);
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    for (PlayerImageType playerImageType : PlayerImageType.values()) {
      for (PlayerImageType.PlayerAnimationType animationType : PlayerImageType.PlayerAnimationType.values()) {
        String filename = playerImageType.fileName(animationType, "png");
        try {
          File imageFile = ResourceUtils.getFile("classpath:image/player/" + playerImageType.partOfFileName() + "/" + filename);
          byte[] fileContent = FileUtils.readFileToByteArray(imageFile);
          String encodedString = Base64.getEncoder().encodeToString(fileContent);
          hashOperations.put(playerImageType.name(), animationType.name(), encodedString);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public GrpcWorldMap grpcWorldMap(String worldId) {
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    String tilePlacementWithLine = valueOperations.get(worldId);
    assert tilePlacementWithLine != null;
    String[] tilePlacementArray = tilePlacementWithLine.split("\r\n|[\n\r]");
    int width = tilePlacementArray[0].split(",").length;
    int height = tilePlacementArray.length;
    String tilePlacement = tilePlacementWithLine.replaceAll("[0-9,\n\r]", "");
    String[] tilePlacementOnlyCharacter = tilePlacementWithLine.replaceAll("[\n\r]", "").split(",");
    Set<Pair<Character, Integer>> characterAndCollision = Arrays.stream(tilePlacementOnlyCharacter)
      .map(t -> Pair.of(t.charAt(0), Character.getNumericValue(t.charAt(1))))
      .collect(Collectors.toSet());
    List<GrpcTile> tiles = characterAndCollision.stream().map(pair -> {
      String tileImageBase64 = valueOperations.get(pair.getFirst().toString());
      boolean collision = !pair.getSecond().equals(0);
      return GrpcTile.newBuilder()
        .setName(pair.getFirst().toString())
        .setBase64Image(tileImageBase64)
        .setCollision(collision).build();
    }).collect(Collectors.toList());

    return GrpcWorldMap.newBuilder().setId(worldId).setWidth(width).setHeight(height).setTilePlacement(tilePlacement)
      .addAllTiles(tiles).build();
  }

  private Tuple3<String, String, String> readWorldMapCsv(File file) {
    String fullFileName = file.getName();
    String fileName = fullFileName.contains(".") ?
      fullFileName.substring(0, fullFileName.lastIndexOf(".")) : fullFileName;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      int num;
      StringBuilder stringBuilder = new StringBuilder();
      Set<Character> characterSet = new HashSet<>();
      while ((num = br.read()) >= 0) {
        stringBuilder.append((char) num);
        if ((char)num == '0' || (char)num == '1') continue;
        switch ((char)num) {
          case ',':
          case '\n':
          case '\r':
            break;
          default:
             characterSet.add((char)num) ;
        }
      }
      String characterVariation = characterSet.stream().map(Object::toString).collect(Collectors.joining());
      return Tuples.of(fileName, stringBuilder.toString(), characterVariation);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
