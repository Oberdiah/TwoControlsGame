package graphics;

import functions.LevelF;

import java.awt.*;

public class GGame {
    public static void gogo(Graphics2D g) {
        LevelF.currentLevel.render(g);
    }
}
