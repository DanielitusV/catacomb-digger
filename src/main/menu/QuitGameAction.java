package main.menu;

import main.interfaces.MenuInterface;

public class QuitGameAction implements MenuInterface {
    @Override
    public void execute() {
        System.exit(0);
    }
}
