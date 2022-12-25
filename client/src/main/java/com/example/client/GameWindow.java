package com.example.client;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Component
public class GameWindow extends JFrame {

  private final TitlePanel titlePanel;

  private final GamePanel gamePanel;

  private final JPanel cardPanel;

  private final CardLayout cardLayout;

  public GameWindow(final TitlePanel titlePanel, final GamePanel gamePanel) {
    this.titlePanel = titlePanel;
    this.gamePanel = gamePanel;
    this.cardPanel = new JPanel();
    this.cardLayout = new CardLayout();

    cardPanel.setLayout(this.cardLayout);
    cardPanel.add(titlePanel, "TitlePanel");
    cardPanel.add(gamePanel, "GamePanel");
    Container contentPane = getContentPane();
    contentPane.add(cardPanel, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("gRPC 2D Sample");

    pack();

    setLocationRelativeTo(null);
    setVisible(true);

    addWindowListener(new WindowListener(gamePanel));
  }

  public void showGamePanel() {
    cardLayout.show(cardPanel, "GamePanel");
  }

  static class WindowListener extends WindowAdapter {

    private final GamePanel gamePanel;

    public WindowListener(final GamePanel gamePanel) {
      this.gamePanel = gamePanel;
    }
    public void windowClosing(WindowEvent e) {
      gamePanel.stopThread();
      System.out.println("windowClosing!");
      System.exit(0);
    }
  }
}
