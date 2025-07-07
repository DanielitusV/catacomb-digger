package main.menu;

import javax.swing.JOptionPane;
import main.interfaces.MenuInterface;

public class NewGameAction implements MenuInterface {
    @Override
    public void execute() {
        JOptionPane.showMessageDialog(null, "Nueva partida iniciada.");
    }
}