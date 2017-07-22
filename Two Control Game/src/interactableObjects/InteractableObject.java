package interactableObjects;

import objects.GameObject;
import systemObjects.PointD;

import java.awt.*;

public abstract class InteractableObject extends GameObject {
    Integer beatsBeforeSpawn;
    public InteractableObject(Integer beatsBefore) {
        super(new PointD(beatsBefore * 10, 0));
    }

    public abstract Point getSize();
}
