package interactableObjects.jumps;

import java.awt.*;

public class Rock extends Jumps {
    private Point size = new Point(5, 5);
    public Point getSize() {return size; }
    public Rock(Integer beatsBefore) {
        super(beatsBefore, "Rock");
    }
}
