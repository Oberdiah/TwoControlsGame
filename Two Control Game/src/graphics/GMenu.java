package graphics;

import functions.LevelF;
import menuObjects.MenuOption;
import printer.P;

import java.awt.*;
import java.util.ArrayList;

public class GMenu {
    public static Integer selected = 0;

    public static ArrayList<MenuOption> buttons = new ArrayList<>();

    public static void gogo(Graphics2D g) {

        Integer along = 0;

        g.setFont(new Font("TimesRoman", Font.PLAIN, 70));

        for(MenuOption mo: buttons){
            if(buttons.indexOf(mo) == selected){
                g.setColor(new Color(0, 255, 141));
            }else{
                g.setColor(new Color(0, 144, 255));
            }

            g.fillRect(200,along * 100 + 490, 400, 90);

            g.setColor(new Color(0, 84, 255));
            g.drawString(mo.text, 200, along * 100 + 560);

            along ++;
        }
    }
}
