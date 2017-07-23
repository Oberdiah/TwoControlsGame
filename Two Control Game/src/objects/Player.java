package objects;

import functions.LevelF;
import interactableObjects.InteractableObject;
import interactableObjects.jumps.Rock;
import mainstuff.Main;
import systemObjects.PointD;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    public Integer shouldActionWhen;
    public Boolean actionIsOne;
    public Integer lives = 20;
    private Point size = new Point(5, 5);

    public Point getSize() {
        return size;
    }

    public static final Integer actionLeeway = 5;
    public static final Double distanceBack = 1.5;
    public static final Integer jumpLength = 30;
    public static final Integer jumpHeight = 4;

    public ArrayList<Double> jumpAtPos = new ArrayList<>();
    public ArrayList<Integer> jumpAtType = new ArrayList<>();

    public Integer jumpTime = 0;

    public Player(PointD loc) {
        super(loc, "Walking Man");
    }

    public static Integer ticks = 0;

    @Override
    public void tick(Double delta){
        this.loc.x += delta/10*((double) (LevelF.currentLevel.bpm)/60);

        if (this.jumpTime > 0) {
            this.jumpTime--;
            if (this.jumpTime == 0) {
                this.loc.y -= jumpHeight;
            }
        }

        for (InteractableObject interactableObject : LevelF.currentLevel.allIOs()) {
            if (interactableObject.loc.x < loc.x && !interactableObject.tomWantedToDelete) {
                interactableObject.tomWantedToDelete = true;
                looseLife();
            }
        }
    }

    public void action(Boolean typeOne) {

        Integer attackType = 0;
        if (typeOne) {
            attackType = 1;
        } else {
            attackType = 2;
        }
        if (!typeOne && this.jumpTime > 0) {
            attackType = 3;
        }
        Boolean isAcceptable = false;

        Integer indexOfLoc = null;
        for (Double locs : this.jumpAtPos) {
            if (this.loc.x + distanceBack < locs && this.loc.x + distanceBack > locs - actionLeeway) {
                isAcceptable = true;
                indexOfLoc = this.jumpAtPos.indexOf(locs);
            }
        }
        Boolean shouldKill = true;
        if (isAcceptable) {
            if (this.jumpAtType.get(indexOfLoc) != attackType) {
                isAcceptable = false;
            }
        }
        if (typeOne && this.jumpTime > 0) {
            isAcceptable = false;
        }
        if (attackType  == 1 && indexOfLoc != null && this.jumpAtType .get(indexOfLoc)== 3) {
            isAcceptable = true;
            shouldKill = false;
        }// Index of loc is null
        if(indexOfLoc != null){
            if(attackType == 2 && this.jumpAtType.get(indexOfLoc) == 3){
                isAcceptable = false;
            }
            if (isAcceptable) {
                // This is the problem

                //this.jumpAtType.remove(new Integer(indexOfLoc));
                //this.jumpAtPos.remove(new Integer(indexOfLoc));

                if(shouldKill){
                    for(InteractableObject io: LevelF.currentLevel.allIOs()){
                        if(new Double(io.loc.x).equals(this.jumpAtPos.get(indexOfLoc))){
                            if (io instanceof Rock) {
                                io.tomWantedToDelete = true;
                            } else {
                                LevelF.currentLevel.objects.remove(io);
                            }
                        }
                    }
                }


                LevelF.currentLevel.addObjectMarkers();



                if (typeOne) {
                    // Jumping
                    this.jumpTime = jumpLength;
                    this.loc.y += jumpHeight;

                } else {
                    // Chopping
                /*for (InteractableObject io : new ArrayList<>(LevelF.currentLevel.allIOs())) {
                    if (io.loc.x - 10 < this.loc.x) {
                        LevelF.currentLevel.objects.remove(io);
                    }
                }*/
                }
                Main.allSounds.get("Tada").play(0.5);
            } else {
                looseLife();
                // Play sound and other stuff here
            }
        }else{
            this.looseLife();
        }


    }
    public void looseLife(){
        lives--;
        Main.allSounds.get("Hurt 2").play();
        if (lives <= 0) {
            LevelF.finishGame();
        }
    }
}







