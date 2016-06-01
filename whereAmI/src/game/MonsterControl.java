package game;

import data.Map;
import data.Monster;

public class MonsterControl {
	
	
	public static void move(int Dx, int Dy, Monster monster, Map map) {
		int tileSize = monster.getTileSize();
		int x = monster.getX();
		int y = monster.getY();
		if (MonsterColiding(Dx + (x - (tileSize)), Dx + (x + (tileSize)), Dy + (y - (tileSize)), Dy + (y + (tileSize)),
				map)) {

		} else {
			monster.setX(x += Dx);
			monster.setY(y += Dy);
			int[] a = new int[2];
			int[] b = new int[2];
			int[] c = new int[2];
			a[0] = (x - (tileSize));
			a[1] = (y - (tileSize));
			b[0] = (x);
			b[1] = (y + (tileSize));
			c[0] = (x + (tileSize));
			c[1] = (y - (tileSize));
			monster.setA(a);
			monster.setB(b);
			monster.setC(c);

		}
	}

	public static boolean MonsterColiding(int x1, int x2, int y1, int y2, Map map) {

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				int X1 = map.getCoord(i, j).getA()[0];
				int Y1 = map.getCoord(i, j).getA()[1];
				int X2 = map.getCoord(i, j).getC()[0];
				int Y2 = map.getCoord(i, j).getC()[1];
				if (map.getCoord(i, j).isWall()) {
					if (x1 < X2 && x2 > X1 && y1 < Y2 && y2 > Y1) {

						return true;
					}
				}

			}
		}
		return false;
	}
	
}
