package menuObjects;

public abstract class MenuOption {

    public abstract void onSelect();
    public String text = "Nothing";
    public MenuOption(String text){
        this.text = text;
    }
}
