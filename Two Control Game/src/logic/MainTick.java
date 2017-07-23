package logic;

import functions.LevelF;

public class MainTick {
	private static Integer ticks = 0;
    public static Integer animationState = 0;

	public static void goUpdates(double delta) {

		ticks ++;

		Double BPM = (double) (LevelF.currentLevel.bpm);
		Double everyThisDouble = delta * (100/(BPM/60));
        Double everyThisAnim = delta * (100/(BPM/10));

        if (animationState >= everyThisAnim.intValue()) {
            animationState++;
            if (animationState == 6) {
                animationState = 0;
            }
        }

		//System.out.println(everyThisDouble.intValue());
		if(ticks >= everyThisDouble.intValue()){
			onBeat();
			ticks = 0;
		}



		LevelF.currentLevel.player.loc.x += delta/10*(BPM/60);

		// If BP'S' was 1, we want every delta * 1000
		// If BP'S' was 2, we want every delta * (1000/2)
		// If BPM was 2, we want every delta * (1000/(2/60))

	}

    public static void resetTicks() {
        ticks = 0;
    }

	private static void onBeat(){

	}


}
