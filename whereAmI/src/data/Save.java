package data;

import java.io.Serializable;

public class Save implements Serializable {

	/**
	 * @param map
	 * @param player
	 */

	private static final long serialVersionUID = 934848145731881301L;
	private Level level = null;
	private Player player = null;
	private Monsters monsters = null;

	public Save(Level level, Player player, Monsters monsters) {

		this.level = level;
		this.player = player;
		this.monsters = monsters;
	}

	public Level getlevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Monsters getMonsters() {
		return monsters;
	}

	public void setMonsters(Monsters monsters) {
		this.monsters = monsters;
	}

}
