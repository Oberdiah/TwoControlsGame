package graphics;

import java.awt.Graphics2D;

import mainstuff.Main;

public class GGeneral {
	public static void gogo(Graphics2D g){
		
		switch(Main.state){
		
		case INGAME: GGame.gogo(g);
			break;
		default:
			break;
			
		}
		
	}
}
