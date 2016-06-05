package data;

public enum TextureID {
	QUITTILE(0),
	SAVETILE(0),
	ALL(0), 
	DOWN(0), 
	LEFT(0), 
	LEFTDOWN(0), 
	LEFTRIGHTDOWN(0), 
	LEFTUP(0), 
	LEFTUPDOWN(0), 
	LEFTUPRIGHT(0), 
	NONE(0), 
	RIGHT(0), 
	RIGHTDOWN(0), 
	UP(0), 
	UPRIGHT(0), 
	UPRIGHTDOWN(0),
	UPDOWN(0),
	LEFTRIGHT(0),
	FLOOR(0);

	private int id;

	TextureID(int id) {
		this.id = id;
	}

	public int getValue() {
		return id;
	}
	public void setValue(int id) {
		this.id = id;
	}
}