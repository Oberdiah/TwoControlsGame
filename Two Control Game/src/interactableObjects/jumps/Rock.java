package interactableObjects.jumps;

import java.awt.*;

public class Rock extends Jumps {
    private Point size = new Point(1, 1);
    public Point getSize() {return size; }
    public Rock(Integer beatsBefore) {
        super(beatsBefore, "Rock");
    }
}
