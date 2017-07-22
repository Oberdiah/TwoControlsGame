package objects;

import java.awt.Graphics;
import java.util.ArrayList;

public class Level {
	public Player p;
	public ArrayList<GameObject> objects = new ArrayList<>();
	
	public void render(Graphics g) {
		for (GameObject o : objects) {
			
		}
	}
}
