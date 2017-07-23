package objects;

import functions.LevelF;
import interactableObjects.InteractableObject;
import org.omg.CosNaming.IstringHelper;
import printer.P;
import systemObjects.PointD;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    public Integer shouldActionWhen;
    public Boolean actionIsOne;
    public Integer lives = 3;
    public Point getSize() {return new Point(5, 5); }

    public static final Integer actionLeeway = 5;

    public ArrayList<Double> jumpAtPos = new ArrayList<>();
    public ArrayList<Boolean> jumpAtTypeOne = new ArrayList<>();

    public Integer jumpTime = 0;

    public Player(PointD loc) {
        super(loc, "walking_man");
    }

    @Override
    public void tick(Double delta){
        this.loc.x += delta/10*((double) (LevelF.currentLevel.bpm)/60);
        if(this.jumpTime > 0){
            this.jumpTime --;
            if(this.jumpTime == 0){
                this.loc.y -= 10;
            }
        }
    }

    public void action(Boolean typeOne){
        Boolean isAcceptable = false;
        Integer indexOfLoc = null;
        for(Double locs: this.jumpAtPos){
            if(this.loc.x < locs && this.loc.x  > locs - actionLeeway){
                isAcceptable = true;
                indexOfLoc = this.jumpAtPos.indexOf(locs);
            }
        }


        if(isAcceptable){
            if(this.jumpAtTypeOne.get(indexOfLoc) != typeOne){
                isAcceptable = false;
            }
        }
        if(typeOne && this.jumpTime > 0){
            isAcceptable = false;
        }
        if(isAcceptable){
            if(typeOne){
                // Jumping
                this.jumpTime = 20;
                this.loc.y += 10;
            }
        }else{
            lives --;
            // Play sound and other stuff here
        }

    }



}