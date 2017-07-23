package mainstuff;

import functions.LevelF;
import graphics.GMenu;
import menuObjects.ExitGame;
import menuObjects.StartGame;
import objects.Level;

public class Init {
	public static void onGameStart(){
		InitLevels.addLevelsSpam();
		LevelF.loadLevel(0);


		GMenu.buttons.add(new StartGame());
		GMenu.buttons.add(new ExitGame());

	}
}