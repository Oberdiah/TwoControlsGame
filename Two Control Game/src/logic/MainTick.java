package logic;

import functions.LevelF;

public class MainTick {

	public static void goUpdates(double delta) {

        if (LevelF.currentLevel != null) {
            LevelF.currentLevel.update(delta);
        }

	}
}
