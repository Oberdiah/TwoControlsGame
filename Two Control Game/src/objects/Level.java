package objects;

import systemObjects.PointD;

import java.awt.*;
import java.util.ArrayList;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();
	
	public String name;
	public Player player;
	public ArrayList<GameObject> objects = new ArrayList<>();

    public static final int scale = 5;
    public static final int heightOfGround = 200;


	public void render(Graphics g) {
		for (GameObject o : objects) {
            Point screenCoords = convertToScreen(o.loc);
			o.render(screenCoords.x, screenCoords.y, g);
		}
	}
	
	public Level (ArrayList<GameObject> objects, String name){
		this.objects = objects;
		this.name = name;
        player = new Player(new PointD(0,0));
	}

    public Point convertToScreen(PointD p) {
        Point po = new Point(0,0);

        po.y = (int) (p.y*scale) + heightOfGround;
        po.x = (int) (p.x*scale);

        return po;
    }
}

































