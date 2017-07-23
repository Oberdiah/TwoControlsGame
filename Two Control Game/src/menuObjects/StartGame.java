package menuObjects;

import enums.GameState;
import mainstuff.Main;

public class StartGame extends MenuOption{

    public StartGame() {
        super("Start game");
    }
    @Override
    public void onSelect() {
        Main.state = GameState.INLEVELSELECT;
    }
}
