package graphics;

import mainstuff.Main;
import objects.Level;

import java.awt.*;

public class GSelection {

    public static Integer selected = 0;

    public static void gogo(Graphics2D g) {
        Integer x = 0;
        Integer y = 0;

        Integer fontSize = 20;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));


        for(Level l: Level.allLevels){
            if(Level.allLevels.indexOf(l) == selected){
                g.setColor(new Color(0, 255, 141));
            }else{
                g.setColor(new Color(0, 144, 255));
            }
            g.fillRect(100 + x * 220, 300 + y * 220, 200, 200);

            g.setColor(new Color(0, 84, 255));
            g.drawString((Level.allLevels.indexOf(l) + 1)+" "+l.name, 100 + x * 220, fontSize + 300 + y * 220);

            x ++;
            if(x >= 5) {
                x = 0;
                y++;
            }
        }
    }
}
