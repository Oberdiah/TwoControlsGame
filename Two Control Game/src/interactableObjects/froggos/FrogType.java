package interactableObjects.froggos;

import interactableObjects.InteractableObject;

import java.awt.*;

public abstract class FrogType extends InteractableObject{
    public FrogType(Integer beatsBefore, String texture) {
        super(beatsBefore, texture);
    }

}
