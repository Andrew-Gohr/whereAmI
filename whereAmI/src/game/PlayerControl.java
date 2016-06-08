package game;

import data.Map;
import data.Player;

public class PlayerControl {
	
	public static void move(int Dx, int Dy, Player player, Map map) {
		int tileSize = player.getTileSize();
		int x = player.getX();
		int y = player.getY();
		if (!Collisions.playerMap(Dx , Dy , player, map)) {
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

		} else {

		}
	}

	
}
