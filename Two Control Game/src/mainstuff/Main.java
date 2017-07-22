package mainstuff;

import enums.GameState;
import graphics.GGeneral;
import inputs.KeyListenerGame;
import inputs.MouseUpDown;
import logic.MainTick;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main extends JPanel{

	public static HashMap<String, BufferedImage> allImages = new HashMap<>();

	public static JFrame frame = new JFrame("Jump the thing");

    public static Main game;
	public static GameState state = GameState.INGAME;

	@Override
	public void paint(Graphics g) {
		GGeneral.gogo((Graphics2D) g);
	}

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		System.out.println("Marmaladal Projectios");

		game = new Main();

		JTextField textField = new JTextField();
		textField.addKeyListener(new KeyListenerGame());
		game.addMouseListener(new MouseUpDown());
		frame.add(textField);
		frame.add(game);

		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Init.onGameStart();
		
		long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 100;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        long lastFpsTime = 0;
        long fps = 0;

        for (File file : new File("Images").listFiles()) {
        	try {
        	    allImages.put(file.getName(), ImageIO.read(file));
        	} catch (IOException e) {
                System.out.println(e);
        	}
        }


        
        while (true) {
           // work out how long its been since the last update, this
           // will be used to calculate how far the entities should
           // move this loop
           long now = System.nanoTime();
           long updateLength = now - lastLoopTime;
           lastLoopTime = now;
           double delta = updateLength / ((double)OPTIMAL_TIME);
           
           // update the frame counter
           lastFpsTime += updateLength;
           fps++;
           
           // update our FPS counter if a second has passed since
           // we last recorded
           if (lastFpsTime >= 1000000000) {
              System.out.println("(FPS: "+fps+")");
              lastFpsTime = 0;
              fps = 0;
           }
           
           // draw everyting
           game.repaint();
           
           // update the game logic
           MainTick.goUpdates(delta);
           
           // we want each frame to take 10 milliseconds, to do this
           // we've recorded when we started the frame. We add 10 milliseconds
           // to this and then factor in the current time to give 
           // us our final value to wait for
           // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
           try{
        	   Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
    	   } catch(Exception e) {
    		   
    	   }
        }
    }
}