package game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import data.Map;
import data.Monster;
import data.Monsters;
import data.Player;
import data.Save;
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
	static boolean first = true;

	static Map map;
	static Player player;
	static Monsters monsters;

	public static void startGame(Save save) {

		map = save.getMap();
		player = save.getPlayer();
		monsters = save.getMonsters();
		int mapWidth = map.getWidth();
		int mapHeight = map.getHeight();

		Tile saveTile = new Tile(Display.getWidth() - 50, Display.getHeight() - 50, 50, 3);
		Tile quitTile = new Tile(Display.getWidth() - 50, Display.getHeight() - 150, 50, 2);
		while (!Display.isCloseRequested()) {
			DX = Mouse.getDX();
			DY = Mouse.getDY();
			X = Mouse.getX();
			Y = Mouse.getY();

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			if (Mouse.isButtonDown(0)) {
				if (!Keyboard.isKeyDown(Keyboard.KEY_M)) {
					if (saveTile.isInBounds(X, Y) && first == true) {

						Save toSave = new Save(map, player, monsters);
						FileManagment.saveTo(toSave, LaunchPadForm.getSaveString());
					}
					if (quitTile.isInBounds(X, Y) && first == true) {
						break;
					}

					for (int i = 0; i < mapWidth; i++) {
						for (int j = 0; j < mapHeight; j++) {

							if (map.getCoord(i, j).isInBounds(X, Y) && (Mouse.isButtonDown(0))) {
								map.getCoord(i, j).setWall(true);
								MapControl.updateTile(i, j, map);
								MapControl.updateAdjacent(i, j, map);
							}
						}
					}
				} else if (first == true){
					monsters.addMonster(new Monster(X, Y, 15, 0));
				}
			}
			if (Mouse.isButtonDown(1)) {

				if (!Keyboard.isKeyDown(Keyboard.KEY_M)) {
					for (int i = 0; i < mapWidth; i++) {
						for (int j = 0; j < mapHeight; j++) {

							if (map.getCoord(i, j).isInBounds(X, Y) && (Mouse.isButtonDown(1))) {
								map.getCoord(i, j).setWall(false);
								map.getCoord(i, j).setTexture(21);
								MapControl.updateAdjacent(i, j, map);
							}
						}
					}
				} else {
					for (int i = 0; i < monsters.size(); i++){
					if(monsters.getMonster(i).isInBounds(X, Y)){
						monsters.removeMonster(i);
					}
					}
				}
			}
			if (Mouse.isButtonDown(2)) {
				MapControl.move(DX, DY, map);
				PlayerControl.move(DX, DY, player, map);
				for (int i = 0; i < monsters.size(); i++) {
					MonsterControl.move(DX, DY, monsters.getMonster(i), map);
				}
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

			if (Mouse.isButtonDown(0) && first == true) {
				first = false;
			} else if (!Mouse.isButtonDown(0)) {
				first = true;
			}
			MapControl.render(map);
			player.render();
			Render.monsters(monsters);
			Render.Tile(saveTile);
			Render.Tile(quitTile);

			Display.update();

			Display.sync(60);
		}

		Display.destroy();
		System.exit(0);

	}
}
