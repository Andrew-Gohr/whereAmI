package view;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureControl {

	public static void loadTexture(String texToLoad, String type) {
		try {
			Texture texture;
			texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream("/res/" + texToLoad));

			System.out.println("Texture loaded:    " + texToLoad);
			System.out.println(">> Image width:    " + texture.getImageWidth());
			System.out.println(">> Image height:   " + texture.getImageHeight());
			System.out.println(">> Texture ID:     " + texture.getTextureID() + "\n");

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public static void loadWalls() {
		loadTexture("tiles/allSides.png", "PNG"); // 5
		loadTexture("tiles/down.png", "PNG"); // 6
		loadTexture("tiles/left.png", "PNG"); // 7
		loadTexture("tiles/leftDown.png", "PNG"); // 8
		loadTexture("tiles/leftRightDown.png", "PNG"); // 9
		loadTexture("tiles/leftUp.png", "PNG"); // 10
		loadTexture("tiles/leftUpDown.png", "PNG"); // 11
		loadTexture("tiles/leftUpRight.png", "PNG"); // 12
		loadTexture("tiles/noSides.png", "PNG"); // 13
		loadTexture("tiles/right.png", "PNG"); // 14
		loadTexture("tiles/rightDown.png", "PNG"); // 15
		loadTexture("tiles/up.png", "PNG"); // 16
		loadTexture("tiles/upRight.png", "PNG"); // 17
		loadTexture("tiles/upRightDown.png", "PNG"); // 18
		loadTexture("tiles/upDown.png", "PNG"); // 19
		loadTexture("tiles/leftRight.png", "PNG"); // 20
		loadTexture("tiles/dungeonFloor.png", "PNG"); // 21
	}

	public static int findWallTexture(boolean right, boolean left, boolean up, boolean down) {
		if (!up && !down && !right && !left) {
			return 5;
		} else if (up && down && left && right) {
			return 13;
		} else if (!up && down && right && left) {
			return 16;

		} else if (!up && !down && right && left) {
			return 19;
		} else if (!up && !down && !right && left) {
			return 18;
		} else if (up && !down && right && left) {
			return 6;
		} else if (up && !down && !right && left) {
			return 15;
		} else if (up && !down && !right && !left) {
			return 9;
		} else if (up && down && !right && left) {
			return 14;
		} else if (up && down && !right && !left) {
			return 20;
		} else if (up && down && right && !left) {
			return 7;
		} else if (!up && down && right && !left) {
			return 10;
		} else if (up && !down && right && !left) {
			return 8;
		} else if (!up && down && !right && left) {
			return 17;
		} else if (!up && down && !right && !left) {
			return 12;
		} else if (!up && !down && right && !left) {
			return 11;
		}
		return 3;
	}

}
