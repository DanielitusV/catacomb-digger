package main.game;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import main.options.OptionsDialog;

public class GamePanel extends JPanel {
    private final int INIT_X = 375;
    private final int INIT_Y = 275;
    private final int SIZE = 50;
    private final int STEP = 10;

    private int posX = INIT_X;
    private int posY = INIT_Y;

    public GamePanel(JFrame parentFrame, Runnable backToMenu) {
        setPreferredSize(new Dimension(1600, 900));
        setBackground(Color.WHITE);
        setFocusable(true);
        setLayout(null);

        JButton optionsButton = new JButton("⚙️");
        optionsButton.setBounds(700, 20, 60, 40);
        optionsButton.setFont(new Font("Arial", Font.BOLD, 18));
        optionsButton.setFocusPainted(false);

        optionsButton.addActionListener(e -> {
            new OptionsDialog(parentFrame, backToMenu).setVisible(true);
        });

        add(optionsButton);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        posY = Math.max(0, posY - STEP); break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        posY = Math.min(900 - SIZE, posY + STEP); break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        posX = Math.max(0, posX - STEP); break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        posX = Math.min(1600 - SIZE, posX + STEP); break;                   
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, SIZE, SIZE);
    }
}