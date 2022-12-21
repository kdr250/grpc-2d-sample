package com.example.client;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class TitlePanel extends JPanel implements ActionListener {

  private final JLabel label;
  private final JTextField text;

  private final ApplicationContext applicationContext;

  public TitlePanel(final ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;

    this.label = new JLabel();
    this.label.setText("プレイヤー名");
    this.text = new JTextField(20);

    add(label);
    add(text);

    Button playButton = new Button("スタート");
    playButton.addActionListener(this);
    add(playButton, BorderLayout.LINE_END);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    GameWindow gameWindow = applicationContext.getBean(GameWindow.class);
    gameWindow.showGamePanel();

    GamePanel gamePanel = applicationContext.getBean(GamePanel.class);
    gamePanel.startThread(text.getText());
  }
}
