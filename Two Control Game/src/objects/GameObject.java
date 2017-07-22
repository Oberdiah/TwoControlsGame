package objects;

import java.awt.Graphics;
import java.awt.Point;

import mainstuff.Main;
import systemObjects.PointD;

public class GameObject {
	public PointD loc;
	public String texture;

	public GameObject(PointD loc){
		this.loc = loc;
	}
	// This is in Screen Coordinates
	// This function never uses PointD p
	public void render(int x, int y, Graphics g) {
		g.drawImage(Main.allImages.get(texture), x, y, null);
		
	}
}
