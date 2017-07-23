package graphics;

import mainstuff.Main;

import java.awt.*;

public class GGeneral {
    public static void gogo(Graphics2D g) {
        g.setColor(new Color(198, 197, 255));
        g.fillRect(0, 0, Main.frame.getWidth(), Main.frame.getHeight());

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
