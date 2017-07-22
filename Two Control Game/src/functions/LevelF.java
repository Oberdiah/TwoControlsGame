package functions;

import objects.GameObject;
import objects.Level;

public class LevelF {
	
	public static Level currentLevel;
	public static Integer levelNum = 1;
	
	public static void nextLevel(){
		currentLevel = Level.allLevels.get(levelNum - 1);


		
		
	}
}