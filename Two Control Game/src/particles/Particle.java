package particles;

import functions.LevelF;
import printer.P;
import systemObjects.PointD;

import java.awt.*;

public class Particle {
    public PointD velocity;
    public PointD loc;
    public Double size = 1.0;
    public Color c;
    private Integer waitTick = 0;
    public Particle(PointD loc, PointD velocity, Color color){
        this.loc = loc;
        this.velocity = velocity;
        this.c = color;
    }
    public static void createExplosion(PointD loc, Integer numOfBits){
        for(int num = 0; num < numOfBits; num ++){
            LevelF.currentLevel.particles.add(new Particle(loc,new PointD(Math.random() * 10 - 5, Math.random() * 10 - 5), new Color(255, 135, 52)));
        }
    }
    public void tick(Double delta){
        waitTick ++;
        if(waitTick % 1000 == 0){
            System.out.println("Loc was " + this.loc.y);
            loc.x += velocity.x * delta;


            loc.y += velocity.y * delta;
            System.out.println("Loc is " + this.loc.y);
            velocity.y --;
        }

    }

}
