package game;

import data.Map;
import data.Monster;
import data.Monsters;
import data.Player;
import data.Tile;

public class Collisions {
	public static boolean playerMap(int Dx, int Dy, Player player, Map map) {
		Tile tile;
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				tile = map.getCoord(i, j);
				if (map.getCoord(i, j).isWall()) {
					int x1 = Dx + (player.getX() - player.getTileSize());
					int x2 = Dx + (player.getX() + player.getTileSize());
					int y1 = Dy + (player.getY() - player.getTileSize());
					int y2 = Dy + (player.getY() + player.getTileSize());
					int X1 = tile.getX() - tile.getTileSize();
					int Y1 = tile.getY() - tile.getTileSize();
					int X2 = tile.getX() + tile.getTileSize();
					int Y2 = tile.getY() + tile.getTileSize();

					if (x1 < X2 && x2 > X1 && y1 < Y2 && y2 > Y1) {

						return true;
					}
				}

			}
		}
		return false;
	}

	public static boolean monsterMap(int Dx, int Dy, Monster monster, Map map) {
		Tile tile;
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				tile = map.getCoord(i, j);
				if (map.getCoord(i, j).isWall()) {
					int x1 = Dx + (monster.getX() - monster.getTileSize());
					int x2 = Dx + (monster.getX() + monster.getTileSize());
					int y1 = Dy + (monster.getY() - monster.getTileSize());
					int y2 = Dy + (monster.getY() + monster.getTileSize());
					int X1 = tile.getX() - tile.getTileSize();
					int Y1 = tile.getY() - tile.getTileSize();
					int X2 = tile.getX() + tile.getTileSize();
					int Y2 = tile.getY() + tile.getTileSize();

					if (x1 < X2 && x2 > X1 && y1 < Y2 && y2 > Y1) {

						return true;
					}
				}

			}
		}
		return false;
	}

	public static boolean monsterMonsters(int Dx, int Dy, Monster monster, Monsters monsters) {
		boolean collided = false;

		int x1 = Dx + (monster.getX() + monster.getTileSize());
		int x2 = Dx + (monster.getX() - monster.getTileSize());
		int y1 = Dy + (monster.getY() + monster.getTileSize());
		int y2 = Dy + (monster.getY() - monster.getTileSize());

		for (int i = 0; i < monsters.size(); i++) {

			if (!monster.equals(monsters.getMonster(i))) {

				int X1 = (monsters.getMonster(i).getX() + monsters.getMonster(i).getTileSize());
				int X2 = (monsters.getMonster(i).getX() - monsters.getMonster(i).getTileSize());
				int Y1 = (monsters.getMonster(i).getY() + monsters.getMonster(i).getTileSize());
				int Y2 = (monsters.getMonster(i).getY() - monsters.getMonster(i).getTileSize());

				if (x1 > X2 && x2 < X1 && y1 > Y2 && y2 < Y1)
					collided = true;

			}
		}
		return collided;
	}

	public static boolean playerMonsters(int Dx, int Dy, Player player, Monsters monsters) {
		boolean collided = false;
		int x1 = Dx + (player.getX() + player.getTileSize());
		int x2 = Dx + (player.getX() - player.getTileSize());
		int y1 = Dy + (player.getY() + player.getTileSize());
		int y2 = Dy + (player.getY() - player.getTileSize());
		for (int i = 0; i < monsters.size(); i++) {

			int X1 = (monsters.getMonster(i).getX() + monsters.getMonster(i).getTileSize());
			int X2 = (monsters.getMonster(i).getX() - monsters.getMonster(i).getTileSize());
			int Y1 = (monsters.getMonster(i).getY() + monsters.getMonster(i).getTileSize());
			int Y2 = (monsters.getMonster(i).getY() - monsters.getMonster(i).getTileSize());

			if (x1 > X2 && x2 < X1 && y1 > Y2 && y2 < Y1) {
				collided = true;
			}
		}
		return collided;
	}

	public static boolean playerTile(int Dx, int Dy, Player player, Tile tile) {

		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		int X1 = 0;
		int Y1 = 0;
		int X2 = 0;
		int Y2 = 0;

		if (tile.isWall()) {
			x1 = Dx + (player.getX() - player.getTileSize());
			x2 = Dx + (player.getX() + player.getTileSize());
			y1 = Dy + (player.getY() - player.getTileSize());
			y2 = Dy + (player.getY() + player.getTileSize());
			X1 = tile.getX() - tile.getTileSize();
			Y1 = tile.getY() - tile.getTileSize();
			X2 = tile.getX() + tile.getTileSize();
			Y2 = tile.getY() + tile.getTileSize();

		}
		return (x1 < X2 && x2 > X1 && y1 < Y2 && y2 > Y1);
	}
}
