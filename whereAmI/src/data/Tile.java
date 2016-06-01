package data;

import java.io.Serializable;
import java.util.Arrays;

public class Tile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 526846608434645372L;
	private int x, y;
	private int tileSize;
	private int[] a, b, c, d;
	private boolean wall = true;
	private int texture;

	private float colorRed, colorBlue, colorGreen;

	public Tile(int x, int y, int tileSize, int texture) {
		this.x = x;
		this.y = y;
		this.tileSize = tileSize;
		this.texture = texture;
		a = new int[2];
		b = new int[2];
		c = new int[2];
		d = new int[2];
		this.a[0] = (x - (tileSize));
		this.a[1] = (y - (tileSize));
		this.b[0] = (x - (tileSize));
		this.b[1] = (y + (tileSize));
		this.c[0] = (x + (tileSize));
		this.c[1] = (y + (tileSize));
		this.d[0] = (x + (tileSize));
		this.d[1] = (y - (tileSize));
	}

	public Tile() {
	}

	public boolean isInBounds(int mouseX, int mouseY) {

		return mouseX > a[0] && mouseX < d[0] && mouseY > a[1] && mouseY < b[1];
	}

	public void setColor(float red, float blue, float green) {
		this.colorRed = red;
		this.colorBlue = blue;
		this.colorGreen = green;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.a[0] = (int) (x - (tileSize));
		// this.a[1] = (int) (y - (tileSize));
		this.b[0] = (int) (x - (tileSize));
		// this.b[1] = (int) (y + (tileSize));
		this.c[0] = (int) (x + (tileSize));
		// this.c[1] = (int) (y + (tileSize));
		this.d[0] = (int) (x + (tileSize));
		// this.d[1] = (int) (y - (tileSize));
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		// this.a[0] = (int) (x - (tileSize));
		this.a[1] = (int) (y - (tileSize));
		// this.b[0] = (int) (x - (tileSize));
		this.b[1] = (int) (y + (tileSize));
		// this.c[0] = (int) (x + (tileSize));
		this.c[1] = (int) (y + (tileSize));
		// this.d[0] = (int) (x + (tileSize));
		this.d[1] = (int) (y - (tileSize));
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

	public int[] getD() {
		return d;
	}

	public void setD(int[] d) {
		this.d = d;
	}

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

	public float getRed() {
		// TODO Auto-generated method stub
		return colorRed;
	}

	public float getGreen() {
		// TODO Auto-generated method stub
		return colorGreen;
	}

	public float getBlue() {
		// TODO Auto-generated method stub
		return colorBlue;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize, Map map) {
		this.tileSize = tileSize;
	}

	public int getTexture() {
		return texture;
	}

	public void setTexture(int texture) {
		this.texture = texture;
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
		result = prime * result + Float.floatToIntBits(colorBlue);
		result = prime * result + Float.floatToIntBits(colorGreen);
		result = prime * result + Float.floatToIntBits(colorRed);
		result = prime * result + Arrays.hashCode(d);
		result = prime * result + texture;
		result = prime * result + tileSize;
		result = prime * result + (wall ? 1231 : 1237);
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
		Tile other = (Tile) obj;
		if (!Arrays.equals(a, other.a))
			return false;
		if (!Arrays.equals(b, other.b))
			return false;
		if (!Arrays.equals(c, other.c))
			return false;
		if (Float.floatToIntBits(colorBlue) != Float.floatToIntBits(other.colorBlue))
			return false;
		if (Float.floatToIntBits(colorGreen) != Float.floatToIntBits(other.colorGreen))
			return false;
		if (Float.floatToIntBits(colorRed) != Float.floatToIntBits(other.colorRed))
			return false;
		if (!Arrays.equals(d, other.d))
			return false;
		if (texture != other.texture)
			return false;
		if (tileSize != other.tileSize)
			return false;
		if (wall != other.wall)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
