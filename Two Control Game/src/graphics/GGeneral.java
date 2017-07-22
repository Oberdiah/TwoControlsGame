package graphics;

import java.awt.*;

import mainstuff.Main;

public class GGeneral {
    public static void gogo(Graphics2D g) {
        g.setColor(new Color(255, 83, 207));

        switch (Main.state) {
            case INGAME:
                GGame.gogo(g);
                break;
            case INMENU:
                break;
            default:
                break;

        }

    }
}
