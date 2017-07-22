package interactableObjects;

import objects.GameObject;
import systemObjects.PointD;

import java.awt.*;

public abstract class InteractableObject extends GameObject {
    Integer beatsBeforeSpawn;
    public InteractableObject(PointD loc, Integer beatsBefore) {
        super(loc);
        this.beatsBeforeSpawn = beatsBefore;
    }

    public abstract Point getSize();
}
