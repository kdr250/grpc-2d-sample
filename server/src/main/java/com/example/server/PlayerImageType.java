package com.example.server;

import java.util.List;
import java.util.stream.Collectors;

public enum PlayerImageType {
  BOY("boy"),
  OLD_MAN("oldman");

  private final String keyword;

  private static final List<String> variations = List.of("_down_1", "_down_2", "_left_1", "_left_2", "_right_1", "_right_2", "_up_1", "_up_2");

  PlayerImageType(final String keyword) {
    this.keyword = keyword;
  }

  public String keyword() {
    return keyword;
  }

  public List<String> fileNameList(String fileExtension) {
    return variations.stream().map(variation -> keyword + variation + "." + fileExtension).collect(Collectors.toList());
  }
}
