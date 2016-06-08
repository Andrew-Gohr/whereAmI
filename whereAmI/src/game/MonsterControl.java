package game;

import data.Map;
import data.Monster;
import data.Monsters;
import data.Player;

public class MonsterControl {
	
	public static void AI(Monsters monsters, Player player, Map map) {
		int x = 0,y = 0;
		for (int i = 0; i < monsters.size(); i++){
			if (player.getX() > monsters.getMonster(i).getX()) {
				x = 1;
			}
			else if (player.getX() < monsters.getMonster(i).getX()){
				x = -1;
			}
			else {
				x = 0;
			}
			if (player.getY() > monsters.getMonster(i).getY()) {
				y = 1;
			}
			else if (player.getY() < monsters.getMonster(i).getY()){
				y = -1;
			}
			else {
				y = 0;
			}
			
				move(x, y, monsters.getMonster(i), map, monsters);
				
			
			
		}
	}

	public static void move(int Dx, int Dy, Monster monster, Map map, Monsters monsters) {
		int tileSize = monster.getTileSize();
		int x = monster.getX();
		int y = monster.getY();
		int[] a = new int[2];
		int[] b = new int[2];
		int[] c = new int[2];
		if (!xMonsterColiding(x, monster, map, monsters)) {
			monster.setX(x += Dx);
			
			a[0] = (x - (tileSize));
			b[0] = (x);
			c[0] = (x + (tileSize));
		}
		if (!yMonsterColiding(y, monster, map, monsters)) {
			
			monster.setY(y += Dy);
			a[1] = (y - (tileSize));
			b[1] = (y + (tileSize));
			c[1] = (y - (tileSize));
			
		}
		monster.setA(a);
		monster.setB(b);
		monster.setC(c);
	}

	public static boolean xMonsterColiding(int Dx, Monster monster, Map map, Monsters monsters) {
		boolean collided = false;
		//for (int i = 0; i < monsters.size(); i++){
			
		//}
		
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				if (map.getCoord(i, j).isWall()) {
					collided = (monster.xwillCollide(Dx, map.getCoord(i, j).getX(), map.getCoord(i, j).getTileSize()));
					}
				}
		}
		return collided;
	}
	public static boolean yMonsterColiding(int Dy, Monster monster, Map map, Monsters monsters) {
		boolean collided = false;
		//for (int i = 0; i < monsters.size(); i++){
			
		//}
		
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				if (map.getCoord(i, j).isWall()) {
					collided = (monster.ywillCollide(Dy, map.getCoord(i, j).getY(), map.getCoord(i, j).getTileSize()));
					}
				}
		}
		return collided;
	}

}
