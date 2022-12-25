package com.example.client;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OtherPlayers {
  private Map<String, OtherPlayer> map = new HashMap<>();

  public void moveOrAdd(final OtherPlayer otherPlayer) {
    if (map.containsKey(otherPlayer.id())) {
      OtherPlayer existingPlayer = map.get(otherPlayer.id());
      existingPlayer.move(otherPlayer.location());
      map.put(existingPlayer.id(), existingPlayer);
      return;
    }
    map.put(otherPlayer.id(), otherPlayer);
  }

  public void refresh() {
    map = map.values().stream().filter(OtherPlayer::isAlive).collect(Collectors.toMap(OtherPlayer::id, o -> o));
  }

  public Set<OtherPlayer> values() {
    return new HashSet<>(map.values());
  }

  public List<String> idList() {
    return List.copyOf(map.keySet());
  }
}
