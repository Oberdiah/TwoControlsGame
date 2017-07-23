package objects;

import functions.LevelF;
import logic.MainTick;
import mainstuff.Main;
import systemObjects.PointD;

import java.awt.*;

public abstract class GameObject {
	public PointD loc;
	public String texture;
    public Color color;

    public abstract Point getSize();

	public GameObject(PointD loc, String texture){
		this.loc = loc;
        this.texture = texture;
	}

    public GameObject(PointD loc, Color color){
        this.loc = loc;
        this.color = color;
    }

	// This is in Screen Coordinates
	// This function never uses PointD p
	public void render(int x, int y, Graphics g) {
        if (Main.allImages.containsKey(texture)) {
            g.drawImage(Main.allImages.get(texture)[MainTick.animationState], x, y, null);
        } else {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(x, y, getSize().x*LevelF.scale, getSize().y*LevelF.scale);
        }
	}
}
