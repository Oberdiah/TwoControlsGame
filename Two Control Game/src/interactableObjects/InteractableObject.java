package interactableObjects;

import objects.GameObject;
import systemObjects.PointD;

public class InteractableObject extends GameObject {
    Integer beatsBeforeSpawn;
    public InteractableObject(Integer beatsBefore) {
        super(new PointD(beatsBefore * 10, 0));
    }
}
