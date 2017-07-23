package interactableObjects.kills;

import java.awt.*;

public class Enemy extends Kills {
    private Point size = new Point(5, 5);

    public Point getSize() {return size; }

    public Enemy(Integer beatsBefore) {
        super(beatsBefore, "Snail");
    }
}
