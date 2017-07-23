package mainstuff;

import graphics.GMenu;
import menuObjects.ExitGame;
import menuObjects.StartGame;

public class Init {
	public static void onGameStart(){
		InitLevels.addLevelsSpam();


		GMenu.buttons.add(new StartGame());
		GMenu.buttons.add(new ExitGame());

	}
}