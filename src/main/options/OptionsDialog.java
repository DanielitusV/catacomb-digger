package main.options;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.Dimension;
import java.awt.GridLayout;

public class OptionsDialog extends JDialog {
    private static final Dimension BUTTON_DIMENSION = new Dimension(120, 40);

    public OptionsDialog(JFrame parent, Runnable backMenu) {
        super(parent, "Options", true);
        setSize(300, 180);
        setLocationRelativeTo(parent);

        JButton resumeButton = new JButton("Resume Game");
        JButton backButton = new JButton("Back to Menu");

        resumeButton.setPreferredSize(BUTTON_DIMENSION);
        backButton.setPreferredSize(BUTTON_DIMENSION);

        resumeButton.addActionListener(e -> dispose());
        backButton.addActionListener(e -> {
            dispose();
            backMenu.run();
        });

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panel.add(resumeButton);
        panel.add(backButton);

        add(panel);
    }
}
