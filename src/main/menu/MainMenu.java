package main.menu;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.GridBagLayout;

import main.interfaces.MenuInterface;

public class MainMenu {
    
    private JFrame mainFrame;
    private Map<String, MenuInterface> actions = new LinkedHashMap<>();

    public MainMenu() {
        mainFrame = new JFrame("Catacomb Digger - Main Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
    
        actions.put("New Game", new NewGameAction());
        actions.put("Load Game", new LoadGameAction());
        actions.put("Quit", new QuitGameAction());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        
        for (Map.Entry<String, MenuInterface> entry : actions.entrySet()) {
            JButton button = new JButton(entry.getKey());
            button.addActionListener(e -> entry.getValue().execute());
            mainPanel.add(button);
        }

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
