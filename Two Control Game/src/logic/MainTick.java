package logic;

import enums.GameState;
import functions.LevelF;
import graphics.Cloud;
import graphics.GGeneral;
import mainstuff.Main;

public class MainTick {

	public static void goUpdates(double delta) {
        for (Cloud cloud : GGeneral.clouds) {
            cloud.loc.x -= delta*cloud.xspeed;
            if (cloud.loc.x < -1000) {
                cloud.loc.x = Main.game.getWidth();
            }
        }


        if (LevelF.currentLevel != null && Main.state == GameState.INGAME) {
            LevelF.currentLevel.update(delta);
        }

	}
}
