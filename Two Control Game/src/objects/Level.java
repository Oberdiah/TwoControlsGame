package objects;

import functions.LevelF;
import mainstuff.Main;
import systemObjects.PointD;

import java.awt.*;
import java.util.ArrayList;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();

    private Integer ticks = 0;
    public Integer animationState = 0;

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

    public void update(double delta) {
        ticks ++;

        Double BPM = (double) (bpm);
        Double everyThisDouble = delta * (100/(BPM/60));
        Double everyThisAnim = delta * (100/(BPM/10));

        if (animationState >= everyThisAnim.intValue()) {
            animationState++;
            if (animationState == 6) {
                animationState = 0;
            }
        }

        //System.out.println(everyThisDouble.intValue());
        if(ticks >= everyThisDouble.intValue()){
            onBeat();
            ticks = 0;
        }

        // If BP'S' was 1, we want every delta * 1000
        // If BP'S' was 2, we want every delta * (1000/2)
        // If BPM was 2, we want every delta * (1000/(2/60))

        player.loc.x += delta/10*(BPM/60);
    }

    public void resetTicks() {
        ticks = 0;
    }

    private void onBeat(){

    }

    public void start() {
        player = new Player(new PointD(0,0));
        objects.add(player);
        bpm = LevelF.getBPM(song);
        Main.allSongs.get(song).play(true);

        ticks = 0;
    }

	public Level (ArrayList<GameObject> objects, String name, String song){
        this.objects = objects;
        this.name = name;
        this.song = song;
	}
}

































