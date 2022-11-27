package com.example.server;

import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
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
    ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
    HashOperations<String, String, Object> hashOperations = objectRedisTemplate.opsForHash();

    listOperations.rightPush(worldId + "_player", player.getId());
    stringRedisTemplate.expire(worldId + "_player", 5, TimeUnit.SECONDS);

    hashOperations.put(player.getId(), "name", player.getName());
    hashOperations.put(player.getId(), "locationX", player.getLocation().getX());
    hashOperations.put(player.getId(), "locationY", player.getLocation().getY());
    objectRedisTemplate.expire(worldId + "_player", 5, TimeUnit.SECONDS);
  }

  public List<Supplier<GrpcPlayer>> get(String worldId, String playerId) {
    ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
    HashOperations<String, String, Object> hashOperations = objectRedisTemplate.opsForHash();
    List<String> playerIdList = listOperations.range(worldId + "_player", 0, -1);

    if (playerIdList == null) return new ArrayList<>();

    return playerIdList.stream().filter(id -> !id.equals(playerId)).map(id -> (Supplier<GrpcPlayer>) () -> {
      Map<String, Object> map = hashOperations.entries(id);
      String name = (String)map.get("name");
      Integer locationX = (Integer)map.get("locationX");
      Integer locationY = (Integer)map.get("locationY");
      GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(locationX).setY(locationY).build();
      return GrpcPlayer.newBuilder().setId(id).setName(name).setLocation(grpcLocation).build();
    }).collect(Collectors.toList());
  }
}
