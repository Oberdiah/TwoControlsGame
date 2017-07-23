package objects;

import functions.LevelF;
import graphics.Cloud;
import graphics.GGeneral;
import interactableObjects.InteractableObject;
import interactableObjects.froggos.FrogType;
import interactableObjects.jumps.Jumps;
import interactableObjects.kills.Kills;
import kuusisto.tinysound.Music;
import mainstuff.InitLevels;
import mainstuff.Main;
import particles.Particle;
import printer.P;
import systemObjects.PointD;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();

    private Double ticks = 0.0;
    private Double animTicks = 0.0;
    public Integer animationState = 0;

    public Boolean unlocked = false;
    public String song;
    public int bpm = 128;
	public String name;
	public Player player;
	public ArrayList<GameObject> objects = new ArrayList<>();
    public ArrayList<Particle> particles = new ArrayList<>();
    public int length = 0;
    public Music music;

    public boolean started = false;

    public static double PSFT = 5.0/16.0;

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
        Point point = LevelF.convertToScreen(new PointD(-30, 0));
        BufferedImage dirt = Main.allImages.get("Dirt");
        int movement = (int)(PSFT*192*LevelF.scale);
        g.drawImage(dirt,  point.x%movement+movement, point.y, (int) (PSFT*dirt.getWidth()*LevelF.scale), (int) (PSFT*dirt.getHeight()*LevelF.scale), null);
        g.drawImage(dirt, point.x%movement, point.y, (int) (PSFT*dirt.getWidth()*LevelF.scale), (int) (PSFT*dirt.getHeight()*LevelF.scale), null);

        LevelF.heightOfGround = Main.game.getHeight()/3;
		for (GameObject o : objects) {
            Point screenCoords = LevelF.convertToScreen(o);
			o.render(screenCoords.x, screenCoords.y, g);
		}
        for(Particle p: this.particles){
		    Point partP = LevelF.convertToScreen(p.loc);

            g.setColor(p.c);
            g.fillRect(partP.x,partP.y,10,10);
        }
	}

    public void update(double delta) {
        if (!started) return;

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
        Boolean passed = true;
        for(InteractableObject io: this.allIOs()){
            /*P.p(io);
            P.p(io.getClass().getSimpleName());
            P.p(io.loc);
            P.p(io.loc.x);
            P.p(this);
            P.p(this.player);
            P.p(this.player.loc);
            P.p(this.player.loc.x);*/
            if(io.loc.x > this.player.loc.x){
                passed = false;
            }
        }
        if(passed){
            // Play sound etc
            Integer index = Level.allLevels.indexOf(this);
            if(index + 2 > Level.allLevels.size()){
                // Nothing
            } else {
                InitLevels.unlocked = Math.max(index + 1, InitLevels.unlocked);
            }

            LevelF.finishGame();
        }

        for(GameObject go: this.objects){
            go.tick(delta);
        }
        for(Particle p: this.particles){
            p.tick(delta);
        }
    }

    private void onBeat(){
        P.p("Beat");
    }
    public void addObjectMarkers(){
        this.player.jumpAtPos.clear();
        this.player.jumpAtType.clear();
        for(InteractableObject io: this.allIOs()){
            player.jumpAtPos.add(io.loc.x);
            if(io instanceof Jumps){
                player.jumpAtType.add(1);
            }else if(io instanceof Kills){
                player.jumpAtType.add(2);
            }else if(io instanceof FrogType){
                player.jumpAtType.add(3);
            }else{
                try {
                    throw new Exception("Type of object which isn't Jumps or Kills");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void start() {
        player = new Player(new PointD(-5,0));
        started = true;
        addObjectMarkers();
        objects.add(player);
        bpm = LevelF.getBPM(song);
        Main.allSongs.get(song).play(true);


        ticks = 0.0;
        animTicks = 0.0;

        GGeneral.clouds.clear();
        for (int i = 0; i < 30; i++) {
            GGeneral.clouds.add(new Cloud());
        }
    }

	public Level (ArrayList<GameObject> objects, String name, String song, int length){
        this.objects = objects;
        this.name = name;
        this.song = song;
	}
}

































