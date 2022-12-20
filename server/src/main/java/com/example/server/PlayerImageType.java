package com.example.server;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PlayerImageType {
  BOY("boy"),
  OLD_MAN("oldman"),
  GREEN_SLIME("greenslime"),
  RED_SLIME("redslime");

  private final String partOfFileName;

  PlayerImageType(final String partOfFileName) {
    this.partOfFileName = partOfFileName;
  }

  public String partOfFileName() {
    return partOfFileName;
  }

  public String fileName(PlayerAnimationType playerAnimationType, String fileExtension) {
    return partOfFileName + playerAnimationType.partOfFileName + "." + fileExtension;
  }

  public enum PlayerAnimationType {
    UP_ONE("_up_1"),
    UP_TWO("_up_2"),
    DOWN_ONE("_down_1"),
    DOWN_TWO("_down_2"),
    LEFT_ONE("_left_1"),
    LEFT_TWO("_left_2"),
    RIGHT_ONE("_right_1"),
    RIGHT_TWO("_right_2");

    private final String partOfFileName;

    PlayerAnimationType(final String partOfFileName) {
      this.partOfFileName = partOfFileName;
    }

    public static List<String> partOfFileNameList() {
      return Arrays.stream(values()).map(v -> v.partOfFileName).collect(Collectors.toList());
    }
  }
}
