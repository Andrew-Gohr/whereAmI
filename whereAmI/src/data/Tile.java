package data;

import java.io.Serializable;

public class Tile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 526846608434645372L;
	private int x, y;
	private int tileSize;
	private boolean wall = true;
	private int texture;

	private float colorRed, colorBlue, colorGreen;

	public Tile(int x, int y, int tileSize, int texture) {
		this.x = x;
		this.y = y;
		this.tileSize = tileSize;
		this.texture = texture;
		
	}

	public Tile() {
	}

	public boolean isInBounds(int mouseX, int mouseY) {

		return mouseX > (x - (tileSize)) && mouseX < x + tileSize && mouseY > (y - (tileSize)) && mouseY < y + tileSize;
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
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		
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
}