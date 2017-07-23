package menuObjects;

import mainstuff.Main;

public class ExitGame extends MenuOption{

    public ExitGame() {
        super("Exit");
    }
    @Override
    public void onSelect() {
        Main.frame.setVisible(false);
        Main.frame.dispose();

        System.exit(1);
    }
}