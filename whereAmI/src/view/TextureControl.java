package view;

import java.io.IOException;
import data.TextureID;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureControl {

	public static int loadTexture(String texToLoad, String type) {
		try {
			Texture texture;
			texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream("/res/" + texToLoad));

			System.out.println("Texture loaded:    " + texToLoad);
			System.out.println(">> Image width:    " + texture.getImageWidth());
			System.out.println(">> Image height:   " + texture.getImageHeight());
			System.out.println(">> Texture ID:     " + texture.getTextureID() + "\n");
			return texture.getTextureID();
		} catch (IOException ioe) {
			System.out.println(ioe);

		}
		return TextureID.ERR.getValue();
	}

	public static void loadWalls() {
		TextureID.ALL.setValue(loadTexture("tiles/allSides.png", "PNG"));
		TextureID.DOWN.setValue(loadTexture("tiles/down.png", "PNG"));
		TextureID.LEFT.setValue(loadTexture("tiles/left.png", "PNG"));
		TextureID.LEFTDOWN.setValue(loadTexture("tiles/leftDown.png", "PNG"));
		TextureID.LEFTRIGHTDOWN.setValue(loadTexture("tiles/leftRightDown.png", "PNG"));
		TextureID.LEFTUP.setValue(loadTexture("tiles/leftUp.png", "PNG"));
		TextureID.LEFTUPDOWN.setValue(loadTexture("tiles/leftUpDown.png", "PNG"));
		TextureID.LEFTUPRIGHT.setValue(loadTexture("tiles/leftUpRight.png", "PNG"));
		TextureID.NONE.setValue(loadTexture("tiles/noSides.png", "PNG"));
		TextureID.RIGHT.setValue(loadTexture("tiles/right.png", "PNG"));
		TextureID.RIGHTDOWN.setValue(loadTexture("tiles/rightDown.png", "PNG"));
		TextureID.UP.setValue(loadTexture("tiles/up.png", "PNG"));
		TextureID.UPRIGHT.setValue(loadTexture("tiles/upRight.png", "PNG"));
		TextureID.UPRIGHTDOWN.setValue(loadTexture("tiles/upRightDown.png", "PNG"));
		TextureID.UPDOWN.setValue(loadTexture("tiles/upDown.png", "PNG"));
		TextureID.LEFTRIGHT.setValue(loadTexture("tiles/leftRight.png", "PNG"));
		TextureID.FLOOR.setValue(loadTexture("tiles/dungeonFloor.png", "PNG"));
	}

	public static int findWallTexture(boolean right, boolean left, boolean up, boolean down) {
		if (!up && !down && !right && !left) {
			return TextureID.ALL.getValue();
		} else if (up && down && left && right) {
			return TextureID.NONE.getValue();
		} else if (!up && down && right && left) {
			return TextureID.UP.getValue();

		} else if (!up && !down && right && left) {
			return TextureID.UPDOWN.getValue();
		} else if (!up && !down && !right && left) {
			return TextureID.UPRIGHTDOWN.getValue();
		} else if (up && !down && right && left) {
			return TextureID.DOWN.getValue();
		} else if (up && !down && !right && left) {
			return TextureID.RIGHTDOWN.getValue();
		} else if (up && !down && !right && !left) {
			return TextureID.LEFTRIGHTDOWN.getValue();
		} else if (up && down && !right && left) {
			return TextureID.RIGHT.getValue();
		} else if (up && down && !right && !left) {
			return TextureID.LEFTRIGHT.getValue();
		} else if (up && down && right && !left) {
			return TextureID.LEFT.getValue();
		} else if (!up && down && right && !left) {
			return TextureID.LEFTUP.getValue();
		} else if (up && !down && right && !left) {
			return TextureID.LEFTDOWN.getValue();
		} else if (!up && down && !right && left) {
			return TextureID.UPRIGHT.getValue();
		} else if (!up && down && !right && !left) {
			return TextureID.LEFTUPRIGHT.getValue();
		} else if (!up && !down && right && !left) {
			return TextureID.LEFTUPDOWN.getValue();
		}
		return TextureID.ERR.getValue();
	}

}
