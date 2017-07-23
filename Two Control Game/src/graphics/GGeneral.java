package graphics;

import java.awt.*;

import mainstuff.Main;

public class GGeneral {
    public static void gogo(Graphics2D g) {
        g.setColor(new Color(255, 83, 207));
        g.fillRect(0,0,Main.game.getWidth(),Main.game.getHeight());

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
