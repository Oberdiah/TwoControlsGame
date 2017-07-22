package mainstuff;

import functions.LevelF;
import objects.Level;

public class Init {
	public static void onGameStart(){
		InitLevels.addLevelsSpam();
		LevelF.nextLevel();
		
	}
	
	
}
