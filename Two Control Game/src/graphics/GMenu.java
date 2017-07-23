package graphics;

import mainstuff.Main;
import menuObjects.MenuOption;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GMenu {
    public static Integer selected = 0;

    public static ArrayList<MenuOption> buttons = new ArrayList<>();

    public static void gogo(Graphics2D g) {

        Integer along = 0;

        g.setFont(new Font("TimesRoman", Font.PLAIN, 70));

        int gap = 20;
        int heightFromMiddle = 100;
        int multiplier = 10;
        for(MenuOption mo: buttons){
            BufferedImage button;
            if(buttons.indexOf(mo) == selected){
                button = Main.allImages.get("ButtonOn");
            }else{
                button = Main.allImages.get("Button");
            }

            int width = button.getWidth()*multiplier;
            int height = button.getHeight()*multiplier;

            int x = Main.game.getWidth()/2-width/2;
            int y = Main.game.getHeight()/2-heightFromMiddle+(height+gap)*along;

            g.drawImage(button, x, y, width, height, null);

            g.setColor(new Color(255, 255, 255));
            Main.drawCenteredString(g, mo.text, new Rectangle(x, y, width, height), new Font("VCR OSD Mono", Font.BOLD, 50));;

            along ++;
        }

        BufferedImage title = Main.allImages.get("Title");
        int width = title.getWidth()*multiplier;
        int height = title.getHeight()*multiplier;
        int x = Main.game.getWidth()/2-width/2;
        int y = Main.game.getHeight()/2-heightFromMiddle-gap-height;
        g.drawImage(title, x, y, width, height, null);
    }
}

































