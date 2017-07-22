package logic;

import functions.LevelF;
import interactableObjects.InteractableObject;
import mainstuff.Main;
import objects.GameObject;

public class MainTick {
	private static Integer ticks = 0;

	public static void goUpdates(double delta) {

		ticks += 1;

		Double BPM = 120.0;//LevelF.currentLevel.BPM
		Double everyThisDouble = delta * (100/(BPM/60));

		//System.out.println(everyThisDouble.intValue());
		if(ticks >= everyThisDouble.intValue()){
			onBeat();
			ticks = 0;
		}
		LevelF.currentLevel.player.loc.x += delta/10;

		// If BP'S' was 1, we want every delta * 1000
		// If BP'S' was 2, we want every delta * (1000/2)
		// If BPM was 2, we want every delta * (1000/(2/60))


	}

	private static void onBeat(){

	}


}
