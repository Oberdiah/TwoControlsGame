package inputs;

import enums.GameState;
import functions.LevelF;
import graphics.GMenu;
import graphics.GSelection;
import mainstuff.Main;
import objects.Level;

public class InputProcessing {

    public static void input(Boolean typeOne){
        if(Main.state == GameState.INGAME){
            LevelF.currentLevel.player.action(typeOne);

        }else if(Main.state == GameState.INMENU){
            if(typeOne){
                GMenu.selected ++;
                if(GMenu.selected >= GMenu.buttons.size()){
                    GMenu.selected = 0;
                }
            }else{
                GMenu.buttons.get(GMenu.selected).onSelect();
            }
        }else if(Main.state == GameState.INLEVELSELECT){
            if(typeOne){
                GSelection.selected ++;
                if(GSelection.selected >= Level.allLevels.size()){
                    GSelection.selected = 0;
                }
            }else{
                LevelF.loadLevel(GSelection.selected);
                Main.state = GameState.INGAME;
            }
        }
    }
}
