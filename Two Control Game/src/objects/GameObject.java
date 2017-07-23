package objects;

import functions.LevelF;
import mainstuff.Main;
import printer.P;
import systemObjects.PointD;

import java.awt.*;
import java.awt.image.BufferedImage;

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
    public void tick(Double delta){

    }

	// This is in Screen Coordinates
	// This function never uses PointD p
	public void render(int x, int y, Graphics g) {
        if (Main.allAnimations.containsKey(texture)) {
            BufferedImage[] frames = Main.allAnimations.get(texture);
            if (frames.length == 2) {
                g.drawImage(frames[LevelF.currentLevel.animationState/3], x, y, getSize().x*LevelF.scale, getSize().y*LevelF.scale, null);
            } else if (frames.length == 6) {
                g.drawImage(frames[LevelF.currentLevel.animationState], x, y, getSize().x*LevelF.scale, getSize().y*LevelF.scale, null);
            } else {
                P.p("Wrong Frame Size!");
                assert false;
            }
        } else {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(x, y, getSize().x*LevelF.scale, getSize().y*LevelF.scale);
        }
	}
}
