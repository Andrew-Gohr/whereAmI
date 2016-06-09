package game;

import data.Map;
import data.Player;

public class PlayerControl {
	
	public static void move(int Dx, int Dy, Player player, Map map) {

		if (!Collisions.playerMap(Dx, Dy, player, map)) {
			player.setX(player.getX() + Dx);
			player.setY(player.getY() + Dy);
		} else {

		}
	}

	
}
