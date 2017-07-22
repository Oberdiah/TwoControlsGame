package mainstuff;

import java.util.ArrayList;
import java.util.Arrays;

import objects.GameObject;
import objects.Level;

public class InitLevels {
	public static void addLevelsSpam(){
		// Add levels
		
		Level.allLevels.add(new Level(new ArrayList<GameObject>(Arrays.asList()), "First Level"));
		
		
	}
}