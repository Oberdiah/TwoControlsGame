package graphics;

import mainstuff.Main;
import systemObjects.PointD;

/**
 * Created by Oberdiah on 23/07/2017.
 */
public class Cloud {
    public PointD loc = new PointD(Math.random()* (Main.game.getWidth()+1000)-1000, Math.random()* Main.game.getHeight());
    int type = (int) (Math.random()*3+1);
    public double xspeed = Math.random()+0.5;
    public double xsize = (Math.random()+1)/2;
    public double ysize = (Math.random()+1)/2;
}
