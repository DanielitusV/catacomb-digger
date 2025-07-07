package main.menu;

import javax.swing.JOptionPane;
import main.interfaces.MenuInterface;

public class LoadGameAction implements MenuInterface {
    @Override
    public void execute() {
        JOptionPane.showMessageDialog(null, "Cargando partida...");
    }
}
