package mainstuff;

import interactableObjects.froggos.Froggo;
import interactableObjects.jumps.Rock;
import interactableObjects.kills.Enemy;
import objects.GameObject;
import objects.Level;

import java.util.ArrayList;

public class InitLevels {
    public static int unlocked = 0;

	public static void addLevelsSpam(){
		// Add levels
		Level.allLevels.clear();

		ArrayList<GameObject> items = new ArrayList<GameObject>();
		/*for (int i = 15; i < 100; i++) {
			if (Math.random() > 0.3) {

				if (Math.random() > 0.5) {
					items.add(new Rock(i));
				}else{
					items.add(new Froggo(i));
				}
			} else {
				items.add(new Enemy(i));
			}
		}*/
        items.add(new Rock(1));
        items.add(new Froggo(2));
        items.add(new Enemy(3));


		Level toUnlock = new Level(items, "1. (61 BPM)", "Cut_and_Dry", 100);
		toUnlock.unlocked = true;
		Level.allLevels.add(toUnlock);
		Level.allLevels.add(new Level(items, "2. (74 BPM)", "Airship_Serenity", 100));
		Level.allLevels.add(new Level(items, "3. (85 BPM)", "Doobly_Doo", 100));
		Level.allLevels.add(new Level(items, "4. (128 BPM)", "EDM_Detection_Mode", 100));
		Level.allLevels.add(new Level(items, "5. (160 BPM)", "Furious_Freak", 100));
		Level.allLevels.add(new Level(items, "6. (220 BPM)", "Mega_Hyper_UltraStorm", 100));

        for (int i = 0; i <= unlocked; i++) {
            if (i < Level.allLevels.size()) {
                Level.allLevels.get(i).unlocked = true;
            }
        }
	}
}