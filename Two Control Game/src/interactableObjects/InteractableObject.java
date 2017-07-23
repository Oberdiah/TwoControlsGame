package interactableObjects;

import objects.GameObject;
import systemObjects.PointD;

public abstract class InteractableObject extends GameObject {
    Integer beatsBeforeSpawn;
    public InteractableObject(Integer beatsBefore, String texture) {
        super(new PointD(beatsBefore * 10, 0), texture);
    }

    public boolean counted = false;
    public boolean tomWantedToDelete = false;
}
