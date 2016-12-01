package data;


public class MenuItem {
	/**
	 * 
	 */

	private int x, y;
	private int width;
	private int height;
	private boolean wall = true;
	private int texture = 0;
	private String text;

	private float colorRed, colorBlue, colorGreen;

	public MenuItem(int x, int y, int width, int height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;

	}

	public MenuItem() {
	}

	public boolean isInBounds(int mouseX, int mouseY) {
		return mouseX > (x - width) && mouseX < x + width && mouseY > (y - height) && mouseY < y + height;

	}

	public void setColor(float red, float green, float blue) {
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
		return width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTextX() {
		return x - width + 5;
	}

	public int getTextY() {
		return y - height / 2 - 5;
	}

	public int getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}

}
