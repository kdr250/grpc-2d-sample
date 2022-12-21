package com.example.client;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

@Component
public class TitlePanel extends JPanel implements ActionListener {

  private final ApplicationContext applicationContext;

  private final JTextField playerNameField;

  private final ButtonGroup playerCharacterRadioButtonGroup;

  private final JRadioButton[] radios;

  public TitlePanel(final ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    JLabel playerNameLabel = new JLabel();
    playerNameLabel.setText("ニックネーム");
    this.playerNameField = new JTextField(20);
    panel.add(playerNameLabel);
    panel.add(playerNameField);

    JLabel playerCharacterLabel = new JLabel();
    playerNameLabel.setText("プレイヤー選択");
    panel.add(playerCharacterLabel);
    this.radios = new JRadioButton[PlayerCharacterType.length()];
    this.playerCharacterRadioButtonGroup = new ButtonGroup();
    for (PlayerCharacterType characterType : PlayerCharacterType.values()) {
      int ordinal = characterType.ordinal();
      boolean isSelected = ordinal == 0;
      radios[ordinal] = new JRadioButton(characterType.displayName(), isSelected);
      playerCharacterRadioButtonGroup.add(radios[ordinal]);
      panel.add(radios[ordinal]);
    }

    Button playButton = new Button("スタート");
    playButton.addActionListener(this);
    panel.add(playButton);

    add(panel, BorderLayout.CENTER);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String playerName = playerNameField.getText();
    PlayerCharacterType playerCharacterType = Arrays.stream(radios).filter(AbstractButton::isSelected)
      .map(AbstractButton::getText)
      .map(PlayerCharacterType::from)
      .findFirst()
      .orElseThrow(RuntimeException::new);

    GamePanel gamePanel = applicationContext.getBean(GamePanel.class);
    gamePanel.startThread(playerName, playerCharacterType);

    GameWindow gameWindow = applicationContext.getBean(GameWindow.class);
    gameWindow.showGamePanel();
  }
}
