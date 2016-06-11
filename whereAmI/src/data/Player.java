package data;

import java.io.Serializable;
import java.util.Arrays;

import view.Render;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4127383728789377913L;
	private int x, y;
	private int tileSize;

	private int[] a, b, c;

	public Player(int x, int y, int tileSize) {
		a = new int[2];
		b = new int[2];
		c = new int[2];
		this.setX(x);
		this.setY(y);
		this.setTileSize(tileSize);
	}

	public void render() {
		Render.Player(this);
	}

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}

	public int[] getB() {
		return b;
	}

	public void setB(int[] b) {
		this.b = b;
	}

	public int[] getC() {
		return c;
	}

	public void setC(int[] c) {
		this.c = c;
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
		a[0] = x - tileSize;
		b[0] = x;
		c[0] = x + tileSize;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		a[1] = (y - (tileSize));
		b[1] = (y + (tileSize));
		c[1] = (y - (tileSize));
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
		result = prime * result + Arrays.hashCode(a);
		result = prime * result + Arrays.hashCode(b);
		result = prime * result + Arrays.hashCode(c);
		result = prime * result + tileSize;
		result = prime * result + x;
		result = prime * result + y;
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
		Player other = (Player) obj;
		if (!Arrays.equals(a, other.a))
			return false;
		if (!Arrays.equals(b, other.b))
			return false;
		if (!Arrays.equals(c, other.c))
			return false;
		if (tileSize != other.tileSize)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}