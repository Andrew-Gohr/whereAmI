package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Monsters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2374595566095641971L;

	private ArrayList<Monster> list;

	public Monsters() {
		list = new ArrayList<Monster>();
	}

	public void addMonster(Monster monster) {
		list.add(monster);
	}

	public Monster getMonster(int i) {
		return this.list.get(i);
	}

	public int size() {
		return list.size();
	}

	public void removeMonster(int monster) {
		list.remove(monster);

	}

}
