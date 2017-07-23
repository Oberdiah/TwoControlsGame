package graphics;

import functions.LevelF;
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
            //g.fillRect(toDraw.x,toDraw.y,-5 * LevelF.scale ,10);
        }

        g.setColor(new Color(255, 50, 67));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g.drawString(LevelF.currentLevel.player.lives + "", Main.game.getWidth() - 300, 200);
    }
}
