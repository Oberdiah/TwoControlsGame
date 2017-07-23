package graphics;

import functions.LevelF;
import mainstuff.Main;
import objects.Level;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GSelection {

    public static Integer selected = 0;

    public static void gogo(Graphics2D g) {
        Integer x = 0;
        Integer y = 0;

        int size = 250;
        int gap = 20;
        int numInRow = 5;
        int numInCol = Level.allLevels.size()/numInRow;

        int xa = Main.game.getWidth()/2-numInRow*(size + gap)/2;
        int ya = Main.game.getHeight()/2-numInCol*(size + gap);

        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("VCR OSD Mono", Font.BOLD, 40));
        g.drawString("Pick a level", xa, ya - 40);

        for(Level l: new ArrayList<>(Level.allLevels)){
            BufferedImage img;
            if(Level.allLevels.indexOf(l) == selected){
                img = Main.allImages.get("SelectionButtonOn");
            } else if(!l.unlocked){
                img = Main.allImages.get("SelectionButtonLocked");
            } else {
                img = Main.allImages.get("SelectionButton");
            }

            g.drawImage(img, x*(size + gap) + xa, y*(size + gap) + ya, size, size, null);

            g.setColor(new Color(255, 255, 255));

            Main.drawCenteredString(g, l.name, new Rectangle(x * (size + gap) + xa, y * (size + gap) + ya, size, size / 4), new Font("VCR OSD Mono", Font.BOLD, 20));

            if (l.unlocked) {
                Main.drawCenteredString(g, LevelF.getBPM(l.song) + "BPM", new Rectangle(x*(size + gap) + xa, y*(size + gap) + ya+size/4, size, size/4*3), new Font("VCR OSD Mono", Font.BOLD, 50));
            }

            x ++;
            if(x >= numInRow) {
                x = 0;
                y++;
            }
        }
    }
}
