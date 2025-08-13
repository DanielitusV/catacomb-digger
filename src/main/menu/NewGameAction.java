package main.menu;

import javax.swing.JFrame;
import main.interfaces.MenuInterface;
import main.game.GamePanel;

public class NewGameAction implements MenuInterface {
    private JFrame gameFrame;
    
    public NewGameAction(JFrame frame) {
        this.gameFrame = frame;
    }
    
    @Override
    public void execute() {
        Runnable backToMenu = () -> {
            gameFrame.getContentPane().removeAll();
            gameFrame.setTitle("Catacomb Digger - Main Menu");
            new MainMenu();
            gameFrame.revalidate();
            gameFrame.repaint();
        };

        GamePanel gamePanel = new GamePanel(gameFrame, backToMenu);
        gameFrame.getContentPane().removeAll();
        gameFrame.setTitle("Catacomb Digger - Game");
        gameFrame.add(gamePanel);
        gameFrame.revalidate();
        gameFrame.repaint();
        gamePanel.requestFocusInWindow();
    }
}