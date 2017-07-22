package inputs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseUpDown extends MouseAdapter {
	public static Boolean down = false;
	
	@Override
	public void mousePressed(MouseEvent e) {
		down = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		down = false;
}
}
