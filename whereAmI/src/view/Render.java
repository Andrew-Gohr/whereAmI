package view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import data.Tile;
import data.Player;
import data.TextureID;
import data.Monster;
import data.Monsters;

public class Render {
	private static int screenWidth;
	private static int screenHeight;

	public static void init(DisplayMode displayMode, boolean fullScreen) {

		screenWidth = displayMode.getWidth();
		screenHeight = displayMode.getHeight();

		System.out.println("Setting up DisplayMode");
		try {

			if (!fullScreen) {
				Display.setDisplayMode(displayMode);
			} else {
				Display.setDisplayModeAndFullscreen(displayMode);
				Display.setFullscreen(true);
				System.out.println("Fullscreen True");
			}

			Display.create();

		} catch (LWJGLException e) {

			e.printStackTrace();
		}
		System.out.printf("%d X %d \n", screenWidth, screenHeight);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, 0, screenHeight, 1, -1);
		// GL11.glOrtho(100, 100, 100, 100, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		System.out.println("loading Textures");
		TextureID.QUITTILE.setValue(TextureControl.loadTexture("quit.png", "PNG"));
		TextureID.SAVETILE.setValue(TextureControl.loadTexture("save.png", "PNG"));
		TextureID.ERR.setValue(TextureControl.loadTexture("ERROR.png", "PNG"));
		TextureID.ENTRY.setValue(TextureControl.loadTexture("ladderDN.png", "PNG"));
		TextureID.EXIT.setValue(TextureControl.loadTexture("ladderUP.png", "PNG"));

		TextureControl.loadWalls();
	}

	public static void Tile(Tile tile) {

		// GL11.glColor3f(tile.getRed(), tile.getGreen(), tile.getBlue());
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tile.getTexture());
		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1); // top left
		GL11.glVertex2f(tile.getX() - tile.getTileSize(), tile.getY() - tile.getTileSize());
		GL11.glTexCoord2f(0, 0); // bottom left
		GL11.glVertex2f(tile.getX() - tile.getTileSize(), tile.getY() + tile.getTileSize());
		GL11.glTexCoord2f(1, 0); // bottom right
		GL11.glVertex2f(tile.getX() + tile.getTileSize(), tile.getY() + tile.getTileSize());
		GL11.glTexCoord2f(1, 1); // top right
		GL11.glVertex2f(tile.getX() + tile.getTileSize(), tile.getY() - tile.getTileSize());
		GL11.glEnd();
	}

	public static void Player(Player player) {
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glColor3d(1, 1, 1);
		GL11.glVertex2f(player.getX() - player.getTileSize(), player.getY() - player.getTileSize());
		GL11.glVertex2f(player.getX(), player.getY() + player.getTileSize());
		GL11.glVertex2f(player.getX() + player.getTileSize(), player.getY() - (player.getTileSize()));
		GL11.glEnd();
	}

	public static void monster(Monster monster) {
		// GL11.glBindTexture(GL11.GL_TEXTURE_2D, monster.getTexture());
		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_TRIANGLES);
		// GL11.glTexCoord2d(0, 0);
		GL11.glVertex2f(monster.getA()[0], monster.getA()[1]);
		// GL11.glTexCoord2d(0.5, 1);
		GL11.glVertex2f(monster.getB()[0], monster.getB()[1]);
		// GL11.glTexCoord2d(1, 0);
		GL11.glVertex2f(monster.getC()[0], monster.getC()[1]);
		GL11.glEnd();

	}

	public static void monsters(Monsters monsters) {
		for (int i = 0; i < monsters.size(); i++) {
			monster(monsters.getMonster(i));

		}

	}

}
