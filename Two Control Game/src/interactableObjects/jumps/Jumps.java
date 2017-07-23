package interactableObjects.jumps;

import interactableObjects.InteractableObject;

import java.awt.*;

public abstract class Jumps extends InteractableObject {
    public Jumps(Integer beatsBefore, String texture) {
        super(beatsBefore, texture);
    }

    @Override
    public Point getSize() {
        return new Point(5, 5);
    }
}
