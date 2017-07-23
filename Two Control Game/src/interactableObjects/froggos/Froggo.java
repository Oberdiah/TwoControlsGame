package interactableObjects.froggos;

import java.awt.*;

public class Froggo extends FrogType{
    private Point size = new Point(5, 5);
    public Point getSize() {return size; }
    public Froggo(Integer beatsBefore) {
        super(beatsBefore, "Froggo");
    }

}
