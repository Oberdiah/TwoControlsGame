package scenery;

import objects.GameObject;
import systemObjects.PointD;

import java.awt.*;

public class Scenery extends GameObject {
    private Point size = new Point(10, 10);
    public Point getSize() {return size;}
    public Scenery(PointD loc) {
        super(loc);
    }
}
