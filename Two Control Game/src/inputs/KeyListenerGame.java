package inputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyListenerGame extends KeyAdapter{
	
	public static HashMap<String, Boolean> pressed = new HashMap<String, Boolean>();

	public static Boolean isPressed(String k) {
		if (pressed.get(k) == null) pressed.put(k, false);
		return pressed.get(k);
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		pressed.put(String.valueOf(ke.getKeyChar()), true);
		
		if (KeyListenerGame.isPressed(" ")) {
			
		}
	}
	@Override
	public void keyReleased(KeyEvent ke) {
		pressed.put(String.valueOf(ke.getKeyChar()), false);
	}
}
