package game;

import data.Map;
import data.Player;

public class PlayerControl {
	public static void move(int Dx, int Dy, Player player, Map map) {
		int tileSize = player.getTileSize();
		int x = player.getX();
		int y = player.getY();
		if (PlayerColiding(Dx + (x - (tileSize)), Dx + (x + (tileSize)), Dy + (y - (tileSize)), Dy + (y + (tileSize)),
				map)) {

		} else {
			player.setX(x += Dx);
			player.setY(y += Dy);
			int[] a = new int[2];
			int[] b = new int[2];
			int[] c = new int[2];
			a[0] = (x - (tileSize));
			a[1] = (y - (tileSize));
			b[0] = (x);
			b[1] = (y + (tileSize));
			c[0] = (x + (tileSize));
			c[1] = (y - (tileSize));
			player.setA(a);
			player.setB(b);
			player.setC(c);

		}
	}

	public static boolean PlayerColiding(int x1, int x2, int y1, int y2, Map map) {

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				if (map.getCoord(i, j).isWall()) {
				int X1 = map.getCoord(i, j).getA()[0];
				int Y1 = map.getCoord(i, j).getA()[1];
				int X2 = map.getCoord(i, j).getC()[0];
				int Y2 = map.getCoord(i, j).getC()[1];
				
					if (x1 < X2 && x2 > X1 && y1 < Y2 && y2 > Y1) {

						return true;
					}
				}

			}
		}
		return false;
	}
}
