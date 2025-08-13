package main.menu;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.LinkedHashMap;
import java.util.Map;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import main.interfaces.MenuInterface;

public class MainMenu {
    
    private JFrame mainFrame;
    private Map<String, MenuInterface> actions = new LinkedHashMap<>();

    public MainMenu() {
        mainFrame = new JFrame("Catacomb Digger - Main Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1600, 900);
        mainFrame.setLocationRelativeTo(null);

        actions.put("New Game", new NewGameAction(mainFrame));
        actions.put("Load Game", new LoadGameAction());
        actions.put("Quit", new QuitGameAction());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(15, 0, 15, 0);

        JLabel title = new JLabel("Catacomb Digger");
        title.setFont(new Font("Times New Roman", Font.BOLD, 36));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(title, gbc);

        for (Map.Entry<String, MenuInterface> entry : actions.entrySet()) {
            JButton button = new JButton(entry.getKey());
            button.setFont(new Font("Arial", Font.BOLD, 22));
            button.setPreferredSize(new Dimension(300, 60));
            button.addActionListener(e -> entry.getValue().execute());
            mainPanel.add(button, gbc);
        }

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
