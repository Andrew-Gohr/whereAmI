package data;

import java.io.Serializable;

public class Monsters implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2374595566095641971L;

	private Monster[] list;
	private int size = 0;
	public Monsters(int max) {
		this.list = new Monster[max];
	}

	

	public void addMonster(Monster monster) {
		this.list[size] = monster;
		size += 1;
	}

	public Monster getMonster(int i) {
		return this.list[i];
	}
	public int size(){
		return size;
	}
	
	
}
