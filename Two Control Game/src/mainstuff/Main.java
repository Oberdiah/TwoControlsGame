package mainstuff;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import enums.GameState;
import graphics.GGeneral;

public class Main extends JPanel{

	static JFrame frame = new JFrame("Game ver. 0.0.0.1");
	
	public static GameState state = GameState.INGAME;
	
	@Override
	public void paint(Graphics g) {
		GGeneral.gogo((Graphics2D) g);
		
	}


	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		System.out.println("Marmaladal Projectios");

		Main game = new Main();

		frame.add(game);

		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.repaint();
			Thread.sleep(10);
		}
	}
}