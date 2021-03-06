package functions;

import enums.GameState;
import mainstuff.InitLevels;
import mainstuff.Main;
import objects.GameObject;
import objects.Level;
import systemObjects.PointD;

import java.awt.*;

public final class LevelF {

    private LevelF() {
    }

    public static Level currentLevel;
    public static Integer levelNum = 0;

    public static final int scale = 50;
    public static int heightOfGround = 400;
    public static int distanceFromEdge = 100;

    public static void loadLevel(Integer index){
        levelNum = index + 1;
        currentLevel = Level.allLevels.get(levelNum - 1);
        currentLevel.start();

    }
    public static Point convertToScreen(PointD p) {
        Point po = new Point(0, 0);
        po.y = (int) (-p.y * LevelF.scale) - LevelF.heightOfGround + Main.game.getHeight();
        po.x = (int) (p.x * LevelF.scale - currentLevel.player.loc.x*scale + distanceFromEdge);

        return po;
    }

    public static Point convertToScreen(GameObject o) {
        Point p = convertToScreen(o.loc);
        p.y -= o.getSize().y*scale;
        return p;
    }

    public static int getBPM(String song) {
        switch (song) {
            case "Cut_and_Dry":
                return 61;
            case "Airship_Serenity":
                return 74;
            case "Doobly_Doo":
                return 85;
            case "EDM_Detection_Mode":
                return 128;
            case "Furious_Freak":
                return 160;
            case "Mega_Hyper_UltraStorm":
                return 220;
            default:
                return 1000000;
        }
    }
    public static void finishGame(){
        Main.state = GameState.INLEVELSELECT;

        Main.allSongs.get(LevelF.currentLevel.song).stop();

        InitLevels.addLevelsSpam();
    }
}


































