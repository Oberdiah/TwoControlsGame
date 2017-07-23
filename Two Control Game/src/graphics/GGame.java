package graphics;

import functions.LevelF;
import interactableObjects.InteractableObject;
import mainstuff.Main;
import systemObjects.PointD;

import java.awt.*;

public class GGame {
    public static void gogo(Graphics2D g) {
        LevelF.currentLevel.render(g);


        for(Double io: LevelF.currentLevel.player.jumpAtPos){
            Integer y = LevelF.heightOfGround + Main.game.getHeight();
            g.setColor(new Color(255, 66, 0));
            Point toDraw = LevelF.convertToScreen(new PointD(io,0));
            Point size = LevelF.convertToScreen(new PointD(10,0));
            g.fillRect(toDraw.x,toDraw.y,-5 * LevelF.scale ,10);
        }
    }
}
