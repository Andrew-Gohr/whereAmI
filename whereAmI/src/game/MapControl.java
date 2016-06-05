package game;

import data.Map;
import view.Render;
import view.TextureControl;

public class MapControl {
	public static void move(int Dx, int Dy, Map map) {
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				TileControl.move(Dx, Dy, map.getCoord(i, j));
			}
		}
	}

	public static void updateAdjacent(int i, int j, Map map) {
		updateTile(i + 1, j, map);
		updateTile(i - 1, j, map);
		updateTile(i, j + 1, map);
		updateTile(i, j - 1, map);

	}

	public static void updateTile(int i, int j, Map map) {
		boolean up = map.getCoord(i + 1, j).isWall();
		boolean down = map.getCoord(i - 1, j).isWall();
		boolean right = map.getCoord(i, j + 1).isWall();
		boolean left = map.getCoord(i, j - 1).isWall();
		if (map.getCoord(i, j).isWall())
			map.getCoord(i, j).setTexture(TextureControl.findWallTexture(right, left, up, down));
	}

	public static void render(Map map) {
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				// if (map.getCoord(i, j).isWall())
				Render.Tile(map.getCoord(i, j));
			}
		}
	}

}
