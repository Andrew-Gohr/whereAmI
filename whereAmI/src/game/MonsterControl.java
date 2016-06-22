package game;

import data.Map;
import data.Monster;
import data.Monsters;
import data.Player;

public class MonsterControl {

	public static void AI(Monsters monsters, Player player, Map map) {
		for (int i = 0; i < monsters.size(); i++) {
			if (210 > Math.sqrt(Math.pow(monsters.getMonster(i).getX() - player.getX(), 2)
					+ Math.pow(monsters.getMonster(i).getY() - player.getY(), 2))) {
				if (player.getX() > monsters.getMonster(i).getX()) {
					move(1, 0, monsters.getMonster(i), map, monsters);
				} else if (player.getX() < monsters.getMonster(i).getX()) {
					move(-1, 0, monsters.getMonster(i), map, monsters);
				}

				if (player.getY() > monsters.getMonster(i).getY()) {
					move(0, 1, monsters.getMonster(i), map, monsters);
				} else if (player.getY() < monsters.getMonster(i).getY()) {
					move(0, -1, monsters.getMonster(i), map, monsters);
				}
			}
		}
	}

	public static void move(int Dx, int Dy, Monster monster, Map map, Monsters monsters) {
		int tileSize = monster.getTileSize();
		int x = monster.getX();
		int y = monster.getY();
		if (!Collisions.monsterMap(Dx, Dy, monster, map) && !Collisions.monsterMonsters(Dx, Dy, monster, monsters)) {
			int[] a = new int[2];
			int[] b = new int[2];
			int[] c = new int[2];

			monster.setX(x += Dx);
			a[0] = (x - (tileSize));
			b[0] = (x);
			c[0] = (x + (tileSize));
			monster.setY(y += Dy);
			a[1] = (y - (tileSize));
			b[1] = (y + (tileSize));
			c[1] = (y - (tileSize));

			monster.setA(a);
			monster.setB(b);
			monster.setC(c);
		}
	}

	public static void moveMap(int Dx, int Dy, Monsters monsters) {
		for (int i = 0; i < monsters.size(); i++) {
			int tileSize = monsters.getMonster(i).getTileSize();
			int x = monsters.getMonster(i).getX();
			int y = monsters.getMonster(i).getY();

			int[] a = new int[2];
			int[] b = new int[2];
			int[] c = new int[2];

			monsters.getMonster(i).setX(x += Dx);
			a[0] = (x - (tileSize));
			b[0] = (x);
			c[0] = (x + (tileSize));
			monsters.getMonster(i).setY(y += Dy);
			a[1] = (y - (tileSize));
			b[1] = (y + (tileSize));
			c[1] = (y - (tileSize));

			monsters.getMonster(i).setA(a);
			monsters.getMonster(i).setB(b);
			monsters.getMonster(i).setC(c);
		}

	}

}
