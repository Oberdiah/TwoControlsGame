package graphics;

import functions.LevelF;
import mainstuff.Main;
import objects.Level;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GGeneral {

    public static ArrayList<Cloud> clouds = new ArrayList<>();

    public static void gogo(Graphics2D g) {
        g.drawImage(Main.allImages.get("Sky"), 0, 0, Main.game.getWidth(), Main.game.getHeight(), null);

        for (Cloud cloud : clouds) {
            BufferedImage image = Main.allImages.get("Cloud" + cloud.type);
            g.drawImage(image,
                    (int) (cloud.loc.x),
                    (int) (cloud.loc.y),
                    (int) (Level.PSFT*image.getWidth()*LevelF.scale*cloud.xspeed*cloud.xsize),
                    (int) (Level.PSFT*image.getHeight()*LevelF.scale*cloud.xspeed*cloud.ysize), null);
        }

        switch (Main.state) {
            case INGAME:
                GGame.gogo(g);
                break;
            case INMENU:
                GMenu.gogo(g);
                break;
            case INLEVELSELECT:
                GSelection.gogo(g);
                break;
            default:
                break;

        }

    }
}
