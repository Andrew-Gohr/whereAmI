package game;

import data.Tile;

public class TileControl {
	public static void move(int Dx, int Dy, Tile tile) {
		// int tileSize = tile.getTileSize();
		int x = tile.getX();
		int y = tile.getY();
		tile.setX(x += Dx);
		tile.setY(y += Dy);
	}
}
