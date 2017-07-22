package interactableObjects.jumps;

import objects.GameObject;
import systemObjects.PointD;

public class Rock extends Jumps {
    public Rock(Integer beatsBefore) {
        super(null, beatsBefore);
    }
    public Rock(PointD loc, Integer beatsBefore) {
        super(loc, beatsBefore);
    }
}
