package objects;

import java.util.ArrayList;

import interactableObjects.SpawnedObject;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();
	
	
	public String name;
	public Player p;
	public ArrayList<GameObject> objects = new ArrayList<>();
	
	public void render(Graphics g) {
		for (GameObject o : objects) {
			
		}
	}
	
	public Level (ArrayList<SpawnedObject> objects, String name){
		this.objects = objects;
		this.name = name;
	}
}
