package inputs;

import enums.GameState;
import mainstuff.Main;

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
		Integer n = ke.getKeyCode();


		if(n==32||n==16||n==155||n==87||n==65){
			// Space is 32

			// Shift is 16

			// Insert is 155
			// W is 87
			// A is 65

			// REMOVED
			// Up is 38
			// Left is 37


			InputProcessing.input(true);
		}
		if(n==10||n==17||n==8||n==192||n==127||n==83||n==68||n==66){
			// Enter is 10
			// Control is 17
			// Backspace is 8
			// Key below esc is 192
			// Delete 127
			// S is 83
			// D is 68
			// B is 66

			// REMOVED
			// Down is 40
			// Right is 39
			InputProcessing.input(false);
		}

		if(n==27){
			// Esc is 27
			if(Main.state == GameState.INLEVELSELECT){
				Main.state = GameState.INMENU;
			}

		}








	}
}
