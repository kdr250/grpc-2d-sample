package com.example.server;

import com.example.shared.AddEvent;
import com.example.shared.GrpcImageType;
import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.MoveEvent;
import com.example.shared.PlayerSyncResponse;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class RegisterPlayerToRedisComponent {

  private final StringRedisTemplate stringRedisTemplate;
  private final RedisTemplate<String, Object> objectRedisTemplate;

  public RegisterPlayerToRedisComponent(final StringRedisTemplate stringRedisTemplate, final RedisTemplate<String, Object> objectRedisTemplate) {
    this.stringRedisTemplate = stringRedisTemplate;
    this.objectRedisTemplate = objectRedisTemplate;
  }

  public void register(String worldId, GrpcPlayer player) {
    SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
    HashOperations<String, String, Object> hashOperations = objectRedisTemplate.opsForHash();

    setOperations.add(worldId + "_player", player.getId());
    stringRedisTemplate.expire(worldId + "_player", 5, TimeUnit.SECONDS);

    hashOperations.put(player.getId(), "name", player.getName());
    hashOperations.put(player.getId(), "locationX", player.getLocation().getX());
    hashOperations.put(player.getId(), "locationY", player.getLocation().getY());
    objectRedisTemplate.expire(worldId + "_player", 5, TimeUnit.SECONDS);
  }

  public List<PlayerSyncResponse> get(String worldId, String playerId, List<String> otherPlayerIdList) {
    SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
    HashOperations<String, String, Object> hashOperations = objectRedisTemplate.opsForHash();
    Set<String> playerIdList = setOperations.members(worldId + "_player");

    if (playerIdList == null) return new ArrayList<>();

    return playerIdList.stream().filter(id -> !id.equals(playerId)).map(id -> {
      Map<String, Object> map = hashOperations.entries(id);
      String name = (String)map.get("name");
      Integer locationX = (Integer)map.get("locationX");
      Integer locationY = (Integer)map.get("locationY");
      GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(locationX).setY(locationY).build();
      GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(id).setName(name).setLocation(grpcLocation).build();

      return otherPlayerIdList.contains(id) ?
        PlayerSyncResponse.newBuilder().setMoveEvent(moveEvent(grpcPlayer)).build() :
        PlayerSyncResponse.newBuilder().setAddEvent(addEvent(grpcPlayer)).build();

    }).collect(Collectors.toList());
  }

  public AddEvent addEvent(GrpcPlayer grpcPlayer) {
    ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
    HashOperations<String, String, String> stringHashOperations = stringRedisTemplate.opsForHash();
    if (Boolean.FALSE.equals(stringRedisTemplate.hasKey("image_" + grpcPlayer.getId()))) {
      PlayerImageType playerImageType = new Random().nextBoolean() ? PlayerImageType.BOY : PlayerImageType.OLD_MAN;
      valueOperations.set("image_" + grpcPlayer.getId(), playerImageType.name());
    }
    PlayerImageType playerImageType = PlayerImageType.valueOf(valueOperations.get("image_" + grpcPlayer.getId()));
    List<GrpcImageType> imageTypes = new ArrayList<>();
    stringHashOperations.entries(playerImageType.name()).forEach((key, value) -> {
      GrpcImageType grpcImageType = GrpcImageType.newBuilder().setName(key).setBase64Image(value).build();
      imageTypes.add(grpcImageType);
    });
    return AddEvent.newBuilder().setOtherPlayer(grpcPlayer).addAllImageType(imageTypes).build();
  }

  private MoveEvent moveEvent(GrpcPlayer grpcPlayer) {
    return MoveEvent.newBuilder().setOtherPlayer(grpcPlayer).build();
  }
}
