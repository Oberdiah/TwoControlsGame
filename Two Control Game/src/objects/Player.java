package objects;

import systemObjects.PointD;

import java.awt.*;

public class Player extends GameObject {
    public Point getSize() {return new Point(5, 5); }

    public Player(PointD loc) {
        super(loc, "Walking Man");
    }
}