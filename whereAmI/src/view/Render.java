package view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import data.Tile;
import data.Player;
import data.TextureID;
import data.MenuItem;
import data.Monster;
import data.Monsters;

public class Render {
	private static int screenWidth;
	private static int screenHeight;
	private static UnicodeFont font;

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
		System.out.printf(" Initializing display with %d X %d resolution\n", screenWidth, screenHeight);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, 0, screenHeight, 1, -1);
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

	public static void gameInit() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, 0, screenHeight, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public static void menuInit() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, screenHeight, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 20);
		font = new UnicodeFont(awtFont);
		font.getEffects().add(new ColorEffect(java.awt.Color.blue));
		font.setPaddingRight(2);

		font.addAsciiGlyphs();
		try {
			font.loadGlyphs();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public static void menuItem(MenuItem menuItem) {

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, menuItem.getTexture());

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3d(menuItem.getRed(), menuItem.getGreen(), menuItem.getBlue());
		GL11.glTexCoord2f(0, 1); // top left
		GL11.glVertex2f(menuItem.getX() - menuItem.getWidth(), menuItem.getY() - menuItem.getHeight());
		GL11.glTexCoord2f(0, 0); // bottom left
		GL11.glVertex2f(menuItem.getX() - menuItem.getWidth(), menuItem.getY() + menuItem.getHeight());
		GL11.glTexCoord2f(1, 0); // bottom right
		GL11.glVertex2f(menuItem.getX() + menuItem.getWidth(), menuItem.getY() + menuItem.getHeight());
		GL11.glTexCoord2f(1, 1); // top right
		GL11.glVertex2f(menuItem.getX() + menuItem.getWidth(), menuItem.getY() - menuItem.getHeight());
		GL11.glEnd();
		font.drawString(menuItem.getTextX(), menuItem.getTextY(), menuItem.getText());
	}

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}

}
