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

		try {

			if (!fullScreen) {
				Display.setDisplayMode(displayMode);
			} else {
				Display.setDisplayModeAndFullscreen(displayMode);
				Display.setFullscreen(true);
			}

			Display.create();

		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, 0, screenHeight, 1, -1);
		// GL11.glOrtho(100, 100, 100, 100, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		TextureID.QUITTILE.setValue(TextureControl.loadTexture("quit.png", "PNG"));
		TextureID.SAVETILE.setValue(TextureControl.loadTexture("save.png", "PNG"));
		TextureID.ERR.setValue(TextureControl.loadTexture("ERROR.png", "PNG"));
		TextureID.ENTRY.setValue(TextureControl.loadTexture("ladder.png", "PNG"));
		TextureID.EXIT.setValue(TextureID.ENTRY.getValue());
		TextureID.MONSTER.setValue(TextureControl.loadTexture("monster.png", "PNG"));
		TextureControl.loadWalls();
	}

	public static void Tile(Tile tile) {

		// GL11.glColor3f(tile.getRed(), tile.getGreen(), tile.getBlue());
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tile.getTexture());
		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1); // top left
		GL11.glVertex2f(tile.getA()[0], tile.getA()[1]);
		GL11.glTexCoord2f(0, 0); // bottom left
		GL11.glVertex2f(tile.getB()[0], tile.getB()[1]);
		GL11.glTexCoord2f(1, 0); // bottom right
		GL11.glVertex2f(tile.getC()[0], tile.getC()[1]);
		GL11.glTexCoord2f(1, 1); // top right
		GL11.glVertex2f(tile.getD()[0], tile.getD()[1]);
		GL11.glEnd();
	}

	public static void Player(Player player) {
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glColor3d(1, 1, 1);
		GL11.glVertex2f(player.getA()[0], player.getA()[1]);
		GL11.glVertex2f(player.getB()[0], player.getB()[1]);
		GL11.glVertex2f(player.getC()[0], player.getC()[1]);
		GL11.glEnd();
	}

	public static void monster(Monster monster) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, monster.getTexture());
		GL11.glColor3d(1, 1, 1);
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glTexCoord2d(0, 0);
		GL11.glVertex2f(monster.getA()[0], monster.getA()[1]);
		GL11.glTexCoord2d(0.5, 1);
		GL11.glVertex2f(monster.getB()[0], monster.getB()[1]);
		GL11.glTexCoord2d(1, 0);
		GL11.glVertex2f(monster.getC()[0], monster.getC()[1]);
		GL11.glEnd();

	}

	public static void monsters(Monsters monsters) {
		for (int i = 0; i < monsters.size(); i++) {
			monster(monsters.getMonster(i));

		}

	}

}
