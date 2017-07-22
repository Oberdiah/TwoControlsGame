package interactableObjects;

import objects.GameObject;
import systemObjects.PointD;

public class InteractableObject extends GameObject {
    Integer beatsBeforeSpawn;
    public InteractableObject(PointD loc, Integer beatsBefore) {
        super(loc);
        this.beatsBeforeSpawn = beatsBefore;
    }
}
