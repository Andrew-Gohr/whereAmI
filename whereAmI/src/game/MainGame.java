package game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import data.Level;
import data.Map;
import data.Monster;
import data.Monsters;
import data.Player;
import data.TextureID;
import data.Tile;
import view.LaunchPadForm;
import view.Render;

public class MainGame {

	static int X = 0;
	static int Y = 0;
	static int DX = 0;
	static int DY = 0;
	static int X2 = 0;
	static int Y2 = 0;
	// checks if the click/keypress is the first respectively
	static boolean first = true;
	static boolean spaceFirst = false;

	// data variables
	static Map map;
	static Player player;
	static Monsters monsters;

	public static void play(Level level) {

		Render.gameInit();

		map = level.getMap(level.getlIndex());
		player = level.getPlayer(level.getlIndex());
		monsters = level.getMonsters(level.getlIndex());

		Tile saveTile = new Tile(Display.getWidth() - 50, Display.getHeight() - 50, 50, TextureID.SAVETILE.getValue());
		Tile quitTile = new Tile(Display.getWidth() - 50, Display.getHeight() - 150, 50, TextureID.QUITTILE.getValue());

		while (!Display.isCloseRequested()) {
			DX = Mouse.getDX();
			DY = Mouse.getDY();
			X = Mouse.getX();
			Y = Mouse.getY();

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			if (Collisions.playerTile(DX, DY, player, map.getEntryPoint()) && spaceFirst
					&& Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				if (level.getlIndex() > 0) {
					changeMap(-1, level);
					spaceFirst = false;
				}
			}
			if (Collisions.playerTile(DX, DY, player, map.getExitPoint()) && spaceFirst
					&& Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				if (level.getlIndex() < level.getlength() - 1) {
					changeMap(1, level);
					spaceFirst = false;
				}
			}

			// left click
			if (Mouse.isButtonDown(0)) {

				if (saveTile.isInBounds(X, Y) && first) {

					FileManagment.saveTo(level, LaunchPadForm.getSaveString());
				}
				if (quitTile.isInBounds(X, Y) && first) {
					break;
				}
			}

			// right click
			// if (Mouse.isButtonDown(1)) {
			//
			//
			// }

			// middle click
			if (Mouse.isButtonDown(2)) {
				MapControl.move(DX, DY, map);
				PlayerControl.move(DX, DY, player, map);
				MonsterControl.moveMap(DX, DY, monsters);
			}

			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				PlayerControl.move(0, 2, player, map);
			}

			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				PlayerControl.move(-2, 0, player, map);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				PlayerControl.move(0, -2, player, map);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				PlayerControl.move(2, 0, player, map);
			}

			if (Mouse.isButtonDown(0) && first) {
				first = false;
			} else if (!Mouse.isButtonDown(0)) {
				first = true;
			}
			// check if spacebar was the first press
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && spaceFirst) {
				spaceFirst = false;
			} else if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				spaceFirst = true;
			}

			MonsterControl.AI(monsters, player, map);
			// render everything
			MapControl.render(map);
			player.render();
			Render.monsters(monsters);
			Render.Tile(saveTile);
			Render.Tile(quitTile);

			Display.update();
			Display.sync(60);

		}
	}

	public static void make(Level level) {

		Render.gameInit();

		map = level.getMap(level.getlIndex());
		player = level.getPlayer(level.getlIndex());
		monsters = level.getMonsters(level.getlIndex());

		Tile saveTile = new Tile(Display.getWidth() - 50, Display.getHeight() - 50, 50, TextureID.SAVETILE.getValue());
		Tile quitTile = new Tile(Display.getWidth() - 50, Display.getHeight() - 150, 50, TextureID.QUITTILE.getValue());

		while (!Display.isCloseRequested()) {
			DX = Mouse.getDX();
			DY = Mouse.getDY();
			X = Mouse.getX();
			Y = Mouse.getY();

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			if (Collisions.playerTile(DX, DY, player, map.getEntryPoint()) && spaceFirst
					&& Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				if (level.getlIndex() > 0) {
					changeMap(-1, level);
					spaceFirst = false;
				}
			}
			if (Collisions.playerTile(DX, DY, player, map.getExitPoint()) && spaceFirst
					&& Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				if (level.getlIndex() < level.getlength() - 1) {
					changeMap(1, level);
					spaceFirst = false;
				}
			}

			// left click
			if (Mouse.isButtonDown(0)) {
				if (!Keyboard.isKeyDown(Keyboard.KEY_M) && !Keyboard.isKeyDown(Keyboard.KEY_E)
						&& !Keyboard.isKeyDown(Keyboard.KEY_X)) {
					if (saveTile.isInBounds(X, Y) && first == true) {

						FileManagment.saveTo(level, LaunchPadForm.getSaveString());
					}
					if (quitTile.isInBounds(X, Y) && first == true) {
						break;
					}

					// check each tile for a collision with mouse
					for (int i = 0; i < map.getWidth(); i++) {
						for (int j = 0; j < map.getHeight(); j++) {
							// update adjacent tiles and set as a wall
							if (map.getCoord(i, j).isInBounds(X, Y)) {
								map.getCoord(i, j).setWall(true);
								MapControl.updateTile(i, j, map);
								MapControl.updateAdjacent(i, j, map);
							}
						}
					}

					// add a monster if first click
				}
				if (first == true && Keyboard.isKeyDown(Keyboard.KEY_M) && !Keyboard.isKeyDown(Keyboard.KEY_E)
						&& !Keyboard.isKeyDown(Keyboard.KEY_X)) {
					monsters.addMonster(new Monster(X, Y, 25, TextureID.MONSTER.getValue()));
				} else if (Keyboard.isKeyDown(Keyboard.KEY_E) && !Keyboard.isKeyDown(Keyboard.KEY_M)
						&& !Keyboard.isKeyDown(Keyboard.KEY_X)) {
					map.setEntryPoint(X, Y);
				} else if (Keyboard.isKeyDown(Keyboard.KEY_X) && !Keyboard.isKeyDown(Keyboard.KEY_E)
						&& !Keyboard.isKeyDown(Keyboard.KEY_M)) {
					map.setExitPoint(X, Y);
				}
			}

			// right click
			if (Mouse.isButtonDown(1)) {

				if (!Keyboard.isKeyDown(Keyboard.KEY_M)) {

					// check each tile for collisions with the mouse
					for (int i = 0; i < map.getWidth(); i++) {
						for (int j = 0; j < map.getHeight(); j++) {
							// set tile as a floor and update adjacent
							if (map.getCoord(i, j).isInBounds(X, Y)) {
								map.getCoord(i, j).setWall(false);
								map.getCoord(i, j).setTexture(TextureID.FLOOR.getValue());
								MapControl.updateAdjacent(i, j, map);
							}
						}
					}

					// remove monster if colliding with mouse
				} else {
					for (int i = 0; i < monsters.size(); i++) {
						if (monsters.getMonster(i).isInBounds(X, Y)) {
							monsters.removeMonster(i);
						}
					}
				}
			}

			// middle click
			if (Mouse.isButtonDown(2)) {
				MapControl.move(DX, DY, map);
				PlayerControl.move(DX, DY, player, map);

				MonsterControl.moveMap(DX, DY, monsters);

			}

			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				PlayerControl.move(0, 2, player, map);
			}

			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				PlayerControl.move(-2, 0, player, map);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				PlayerControl.move(0, -2, player, map);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				PlayerControl.move(2, 0, player, map);
			}

			if (Mouse.isButtonDown(0) && first) {
				first = false;
			} else if (!Mouse.isButtonDown(0)) {
				first = true;
			}

			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && spaceFirst) {
				spaceFirst = false;
			} else if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				spaceFirst = true;
			}

			// render everything
			MapControl.render(map);
			player.render();
			Render.monsters(monsters);
			Render.Tile(saveTile);
			Render.Tile(quitTile);

			Display.update();
			Display.sync(60);

		}
		System.out.println("shutting down");
		Display.destroy();
		System.exit(0);
	}

	private static void changeMap(int num, Level level) {
		level.setlIndex(level.getlIndex() + num);
		map = level.getMap(level.getlIndex());
		player = level.getPlayer(level.getlIndex());
		monsters = level.getMonsters(level.getlIndex());
	}
}
