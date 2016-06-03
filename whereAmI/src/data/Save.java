package data;

import java.io.Serializable;

public class Save implements Serializable {

	/**
	 * @param map
	 * @param player
	 */

	private static final long serialVersionUID = 934848145731881301L;
	private Map map = null;
	private Player player = null;
	private Monsters monsters = null;

	public Save(Map map, Player player, Monsters monsters) {

		this.map = map;
		this.player = player;
		this.monsters = monsters;
	}

	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Save other = (Save) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}

	public Monsters getMonsters() {
		return monsters;
	}

	public void setMonsters(Monsters monsters) {
		this.monsters = monsters;
	}

}
