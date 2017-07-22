package interactableObjects.kills;

import java.awt.*;

public class Enemy extends Kills {
    public Point getSize() {return new Point(10, 10); }

    public Enemy(Integer beatsBefore) {
        super(beatsBefore);
    }
}
