package scenery;

import objects.GameObject;
import systemObjects.PointD;

import java.awt.*;

public class Scenery extends GameObject {
    public Point getSize() {return new Point(0,0);}
    public Scenery(PointD loc) {
        super(loc);
    }
}
