package interactableObjects.kills;

import interactableObjects.InteractableObject;

import java.awt.*;

public abstract class Kills extends InteractableObject{
    public Kills(Integer beatsBefore, String texture) {
        super(beatsBefore, texture);
    }


    @Override
    public Point getSize() {
        return new Point(5, 5);
    }
}
