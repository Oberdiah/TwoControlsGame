package mainstuff;

import java.util.ArrayList;
import java.util.Arrays;

import interactableObjects.jumps.Rock;
import objects.GameObject;
import objects.Level;

public class InitLevels {
	public static void addLevelsSpam(){
		// Add levels
		ArrayList<GameObject> items = new ArrayList<GameObject>();
		items.add(new Rock(4));
		Level.allLevels.add(new Level(items, "First Level"));

	}
}