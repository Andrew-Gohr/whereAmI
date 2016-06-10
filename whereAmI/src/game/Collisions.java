package game;

import data.Map;
import data.Monster;
import data.Monsters;
import data.Player;

public class Collisions {
	public static boolean playerMap(int Dx, int Dy, Player player, Map map) {

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				if (map.getCoord(i, j).isWall()) {
					int x1 = Dx + (player.getX() - player.getTileSize());
					int x2 = Dx + (player.getX() + player.getTileSize());
					int y1 = Dy + (player.getY() - player.getTileSize());
					int y2 = Dy + (player.getY() + player.getTileSize());
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
	
	public static boolean monsterMap(int Dx, int Dy, Monster monster, Map map) {

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				if (map.getCoord(i, j).isWall()) {
					int x1 = Dx + (monster.getX() - monster.getTileSize());
					int x2 = Dx + (monster.getX() + monster.getTileSize());
					int y1 = Dy + (monster.getY() - monster.getTileSize());
					int y2 = Dy + (monster.getY() + monster.getTileSize());
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
	
	public static boolean monsterMonsters(int Dx, int Dy, Monster monster, Monsters monsters) {
		boolean collided = false;
		
		int x1 = Dx + (monster.getX() + monster.getTileSize());
		int x2 = Dx + (monster.getX() - monster.getTileSize());
		int y1 = Dy + (monster.getY() + monster.getTileSize());
		int y2 = Dy + (monster.getY() - monster.getTileSize());
		
			for (int i = 0; i < monsters.size(); i++) {
				
				
				if(!monster.equals(monsters.getMonster(i))){
					
					int X1 = (monsters.getMonster(i).getX() + monsters.getMonster(i).getTileSize());
					int X2 = (monsters.getMonster(i).getX() - monsters.getMonster(i).getTileSize());
					int Y1 = (monsters.getMonster(i).getY() + monsters.getMonster(i).getTileSize());
					int Y2 = (monsters.getMonster(i).getY() - monsters.getMonster(i).getTileSize());
				
						if (x1 > X2 && x2 < X1 && y1 > Y2 && y2 < Y1){
							collided = true;
						}
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
				
						if (x1 > X2 && x2 < X1 && y1 > Y2 && y2 < Y1){
							collided = true;
						}
			}		
			return collided;
	}
}
