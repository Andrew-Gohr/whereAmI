package data;

import java.io.Serializable;
import java.util.Arrays;

import view.Render;

public class Monster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7236083898535912467L;
	private int x, y;
	private int tileSize;
	private int texture;

	private int[] a, b, c;

	public Monster(int x, int y, int tileSize, int texture) {
		this.x = x;
		this.y = y;
		this.setTileSize(tileSize);
		this.setTexture(texture);
		a = new int[2];
		b = new int[2];
		c = new int[2];
		this.a[0] = (x - (tileSize));
		this.a[1] = (y - (tileSize));
		this.b[0] = (x);
		this.b[1] = (y + (tileSize));
		this.c[0] = (x + (tileSize));
		this.c[1] = (y - (tileSize));
	}

	public void render() {
		Render.monster(this);
	}
	
	public boolean isInBounds(int mouseX, int mouseY) {

		return mouseX > a[0] && mouseX < b[0] + tileSize && mouseY > a[1] && mouseY < b[1];
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
		this.a[0] = (x - (tileSize));
		this.b[0] = (x);
		this.c[0] = (x + (tileSize));
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		this.a[1] = (y - (tileSize));
		this.b[1] = (y + (tileSize));
		this.c[1] = (y - (tileSize));
	}

	public int getTexture() {
		return texture;
	}

	public void setTexture(int texture) {
		this.texture = texture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(a);
		result = prime * result + Arrays.hashCode(b);
		result = prime * result + Arrays.hashCode(c);
		result = prime * result + texture;
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
		Monster other = (Monster) obj;
		if (!Arrays.equals(a, other.a))
			return false;
		if (!Arrays.equals(b, other.b))
			return false;
		if (!Arrays.equals(c, other.c))
			return false;
		if (texture != other.texture)
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
