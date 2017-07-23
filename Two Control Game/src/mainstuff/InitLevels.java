package mainstuff;

import interactableObjects.jumps.Rock;
import interactableObjects.kills.Enemy;
import objects.GameObject;
import objects.Level;

import java.util.ArrayList;

public class InitLevels {
	public static void addLevelsSpam(){
		// Add levels
		ArrayList<GameObject> items = new ArrayList<GameObject>();
		items.add(new Enemy(4));
		items.add(new Rock(5));
		items.add(new Rock(6));
		items.add(new Rock(7));
        items.add(new Enemy(10));
		Level.allLevels.add(new Level(items, "EDM_Detection_Mode", "EDM_Detection_Mode", 100));
		Level.allLevels.add(new Level(items, "Cut_and_Dry", "Cut_and_Dry", 100));
		Level.allLevels.add(new Level(items, "First Level", "Cut_and_Dry", 100));
		Level.allLevels.add(new Level(items, "First Level", "Cut_and_Dry", 100));
		Level.allLevels.add(new Level(items, "First Level", "Cut_and_Dry", 100));
		Level.allLevels.add(new Level(items, "First Level", "Cut_and_Dry", 100));
	}
}