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
		return 0;
	}

	public static void loadWalls() {
		TextureID.ALL.setValue(loadTexture("tiles/allSides.png", "PNG")); // 5
		TextureID.DOWN.setValue(loadTexture("tiles/down.png", "PNG")); // 6
		TextureID.LEFT.setValue(loadTexture("tiles/left.png", "PNG")); // 7
		TextureID.LEFTDOWN.setValue(loadTexture("tiles/leftDown.png", "PNG")); // 8
		TextureID.LEFTRIGHTDOWN.setValue(loadTexture("tiles/leftRightDown.png", "PNG")); // 9
		TextureID.LEFTUP.setValue(loadTexture("tiles/leftUp.png", "PNG")); // 10
		TextureID.LEFTUPDOWN.setValue(loadTexture("tiles/leftUpDown.png", "PNG")); // 11
		TextureID.LEFTUPRIGHT.setValue(loadTexture("tiles/leftUpRight.png", "PNG")); // 12
		TextureID.NONE.setValue(loadTexture("tiles/noSides.png", "PNG")); // 13
		TextureID.RIGHT.setValue(loadTexture("tiles/right.png", "PNG")); // 14
		TextureID.RIGHTDOWN.setValue(loadTexture("tiles/rightDown.png", "PNG")); // 15
		TextureID.UP.setValue(loadTexture("tiles/up.png", "PNG")); // 16
		TextureID.UPRIGHT.setValue(loadTexture("tiles/upRight.png", "PNG")); // 17
		TextureID.UPRIGHTDOWN.setValue(loadTexture("tiles/upRightDown.png", "PNG")); // 18
		TextureID.UPDOWN.setValue(loadTexture("tiles/upDown.png", "PNG")); // 19
		TextureID.LEFTRIGHT.setValue(loadTexture("tiles/leftRight.png", "PNG")); // 20
		TextureID.FLOOR.setValue(loadTexture("tiles/dungeonFloor.png", "PNG")); // 21
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
		return 3;
	}

}
