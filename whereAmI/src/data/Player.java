package data;

import java.io.Serializable;

import view.Render;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4127383728789377913L;
	private int x, y;
	private int tileSize;

	public Player(int x, int y, int tileSize) {
		this.setX(x);
		this.setY(y);
		this.setTileSize(tileSize);
	}

	public void render() {
		Render.Player(this);
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tileSize;
		result = prime * result + x;
		result = prime * result + y;
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
		Player other = (Player) obj;
		if (tileSize != other.tileSize)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}