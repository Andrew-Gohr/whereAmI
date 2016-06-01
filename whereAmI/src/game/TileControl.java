package game;

import data.Tile;

public class TileControl {
	public static void move(int Dx, int Dy, Tile tile) {
		// int tileSize = tile.getTileSize();
		int x = tile.getX();
		int y = tile.getY();
		tile.setX(x += Dx);
		tile.setY(y += Dy);
		// int[] a = new int[2];
		// int[] b = new int[2];
		// int[] c = new int[2];
		// int[] d = new int[2];
		// a[0] = (x - (tileSize));
		// a[1] = (y - (tileSize));
		// b[0] = (x - (tileSize));
		// b[1] = (y + (tileSize));
		// c[0] = (x + (tileSize));
		// c[1] = (y + (tileSize));
		// d[0] = (x + (tileSize));
		// d[1] = (y - (tileSize));
		// tile.setA(a);
		// tile.setB(b);
		// tile.setC(c);
		// tile.setD(d);
	}
}
