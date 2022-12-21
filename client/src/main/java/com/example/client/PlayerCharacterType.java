package com.example.client;

import java.util.Arrays;

public enum PlayerCharacterType {
  BOY("勇者"),
  OLD_MAN("村人"),
  GREEN_SLIME("緑スライム"),
  RED_SLIME("赤スライム"),
  BLUE_SLIME("青スライム");

  private String displayName;

  PlayerCharacterType(final String displayName) {
    this.displayName = displayName;
  }

  public String displayName() {
    return displayName;
  }

  public static int length() {
    return values().length;
  }

  public static PlayerCharacterType from(String displayName) {
    return Arrays.stream(values()).filter(v -> v.displayName.equals(displayName))
      .findFirst().orElseThrow(RuntimeException::new);
  }
}
