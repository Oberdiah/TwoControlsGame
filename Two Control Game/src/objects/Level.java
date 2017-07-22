package objects;

import java.util.ArrayList;

import interactableObjects.SpawnedObject;

public class Level {
	public static ArrayList<Level> allLevels = new ArrayList<>();
	
	
	ArrayList<SpawnedObject> objects;
	String name;
	
	
	public Level (ArrayList<SpawnedObject> objects, String name){
		this.objects = objects;
		this.name = name;
	}
}
