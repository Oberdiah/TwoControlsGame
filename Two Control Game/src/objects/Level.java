package objects;

import functions.LevelF;
import logic.MainTick;
import mainstuff.Main;
import systemObjects.PointD;

import java.awt.*;
import java.util.ArrayList;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();

    public String song;
    public int bpm = 128;
	public String name;
	public Player player;
	public ArrayList<GameObject> objects = new ArrayList<>();

	public void render(Graphics g) {
        LevelF.heightOfGround = Main.game.getHeight()/3;
		for (GameObject o : objects) {
            Point screenCoords = LevelF.convertToScreen(o);
			o.render(screenCoords.x, screenCoords.y, g);
		}
	}
	
	public Level (ArrayList<GameObject> objects, String name, String song){
		this.objects = objects;
		this.name = name;
        player = new Player(new PointD(0,0));
        objects.add(player);
        bpm = LevelF.getBPM(song);
        Main.allSongs.get(song).play(true);

        MainTick.resetTicks();
	}
}

































