package data;

import java.io.Serializable;
import java.util.Arrays;

public class Level implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5224323053724908036L;
	private Map maps[];
	private Player players[];
	private Monsters monsters[];
	private int lIndex;

	public Level(int num, int width, int height, int tileSize, int lIndex) {
		
		maps = new Map[num];
		players = new Player[num];
		monsters = new Monsters[num];
		
		for (int i = 0; i < maps.length;i++ ){
			maps[i] = new Map(width, height, tileSize);
			players[i] = new Player(40, 40, tileSize/2);
			monsters[i] = new Monsters();
		}

	}
	public Level(Map maps[], Player players[], Monsters monsters[], int lIndex){
		this.maps = maps;
		this.players = players;
		this.monsters = monsters;
	}

	public Map getMap(int i) {
		return maps[i];
	}

	public void setMap(Map map, int i) {
		this.maps[i] = map;
	}
	
	public Map[] getMaps() {
		return maps;
	}
	
	public void setMaps(Map[] maps) {
		this.maps = maps;
	}
	
	public Player getPlayer(int i){
		return players[i];	
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setPlayer(int i, Player player){
		this.players[i] = player;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public Monsters getMonsters(int i) {
		return monsters[i];
	}
	public Monsters[] getMonsters() {
		return monsters;
	}
	
	public void setMonsters(int i, Monsters monsters){
		this.monsters[i] = monsters;
	}
	
	public void setMonsters(Monsters[] monsters) {
		this.monsters = monsters;
	}
	
	public int getlength(){
		return maps.length;
	}
	
	public int getlIndex() {
		return lIndex;
	}
	public void setlIndex(int lIndex) {
		this.lIndex = lIndex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(maps);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (!Arrays.equals(maps, other.maps))
			return false;
		return true;
	}

}
