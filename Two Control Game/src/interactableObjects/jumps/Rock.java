package interactableObjects.jumps;

import java.awt.*;

public class Rock extends Jumps {
    public Point getSize() {return new Point(10, 10); }
    public Rock(Integer beatsBefore) {
        super(beatsBefore);
    }
}
