package objects;

import java.awt.Graphics;
import java.awt.Point;

import mainstuff.Main;
import systemObjects.PointD;

public class GameObject {
	public PointD p;
	public String texture;
	
	// This is in Screen Coordinates
	// This function never uses PointD p
	public void render(int x, int y, Graphics g) {
		g.drawImage(Main.allImages.get(texture), x, y, null);
		
	}
}
