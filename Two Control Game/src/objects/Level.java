package objects;

import functions.LevelF;
import interactableObjects.InteractableObject;
import interactableObjects.jumps.Jumps;
import interactableObjects.kills.Kills;
import mainstuff.Main;
import printer.P;
import systemObjects.PointD;

import java.awt.*;
import java.util.ArrayList;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();

    private Double ticks = 0.0;
    private Double animTicks = 0.0;
    public Integer animationState = 0;

    public String song;
    public int bpm = 128;
	public String name;
	public Player player;
	public ArrayList<GameObject> objects = new ArrayList<>();
    public int length = 0;



	public ArrayList<InteractableObject> allIOs(){
        ArrayList<InteractableObject> array = new ArrayList<>();
        for(GameObject go: this.objects){
            if(go instanceof InteractableObject){
                array.add((InteractableObject) go);
            }
        }
        return array;
    }

	public void render(Graphics g) {
        g.drawImage(Main.allImages.get("Sky"), 0, 0, Main.game.getWidth(), Main.game.getHeight(), null);

        LevelF.heightOfGround = Main.game.getHeight()/3;
		for (GameObject o : objects) {
            Point screenCoords = LevelF.convertToScreen(o);
			o.render(screenCoords.x, screenCoords.y, g);
		}
	}

    public void update(double delta) {
        ticks += delta;
        animTicks += delta;

        Double BPM = (double) (bpm);
        Double everyThisDouble = (100/(BPM/60));
        Double everyThisAnim = (100/(BPM/10));

        if (animTicks >= everyThisAnim.intValue()) {
            animTicks = 0.0;
            animationState++;
            if (animationState == 6) {
                animationState = 0;
            }
        }

        //System.out.println(everyThisDouble.intValue());
        if(ticks >= everyThisDouble.intValue()){
            onBeat();
            ticks -= everyThisDouble;
            animTicks = 0.0;
        }

        // If BP'S' was 1, we want every delta * 1000
        // If BP'S' was 2, we want every delta * (1000/2)
        // If BPM was 2, we want every delta * (1000/(2/60))



        for(GameObject go: this.objects){
            go.tick(delta);
        }
    }

    private void onBeat(){
        P.p("Beat");
    }

    public void start() {
        player = new Player(new PointD(0,0));
        for(InteractableObject io: this.allIOs()){
            player.jumpAtPos.add(io.loc.x);
            P.p("Added " + io.loc.x);
            if(io instanceof Jumps){
                player.jumpAtTypeOne.add(true);
            }else if(io instanceof Kills){
                player.jumpAtTypeOne.add(false);
            }else{
                try {
                    throw new Exception("Type of object which isn't Jumps or Kills");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        objects.add(player);
        bpm = LevelF.getBPM(song);
        Main.allSongs.get(song).play(true);

        ticks = 0.0;
        animTicks = 0.0;
    }

	public Level (ArrayList<GameObject> objects, String name, String song, int length){
        this.objects = objects;
        this.name = name;
        this.song = song;
	}
}

































