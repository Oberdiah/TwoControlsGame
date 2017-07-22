package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMoving extends MouseMotionAdapter {
	
	public static int x = 0;
	public static int y = 0;

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Moved");
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
}
