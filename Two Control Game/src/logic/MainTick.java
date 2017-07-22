package logic;

import functions.LevelF;
import interactableObjects.InteractableObject;
import objects.GameObject;

public class MainTick {
	public static void goUpdates(double delta) {
		 for(GameObject io: LevelF.currentLevel.objects){
		 	if(io instanceof InteractableObject){
		 		io.loc.x -= 1;
			}
		 }
	}
}
