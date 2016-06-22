package data;

import java.io.Serializable;
import java.util.Arrays;

public class Map implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1022754103688505047L;
	private Tile[][] grid;
	private int tileSize;
	private int width;
	private int height;
	private Tile entryPoint;
	private Tile exitPoint;

	public Map(int width, int height, int tileSize) {
		this.width = width;
		this.height = height;
		this.setTileSize(tileSize);
		entryPoint = new Tile(200, 30, tileSize, TextureID.ENTRY.getValue());
		exitPoint = new Tile(600, 30, tileSize, TextureID.EXIT.getValue());
		grid = new Tile[width][height];
		int x = 0;
		int y = 0;
		for (int i = 0; i < width; i++) {
			y += tileSize * 2;
			x = 0;
			for (int j = 0; j < height; j++) {
				x += tileSize * 2;
				grid[i][j] = new Tile(x, y, tileSize, TextureID.NONE.getValue());
			}
		}
	}

	public void setCoord(int x, int y, Tile value) {
		this.grid[x][y] = value;
	}

	public Tile getCoord(int x, int y) {
		if (x > height - 1 || x < 0 || y < 0 || y > width - 1) {
			Tile nullTile = new Tile();
			nullTile.setWall(true);
			return nullTile;
		}
		return this.grid[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public Tile getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(int x, int y) {
		this.entryPoint.setX(x);
		this.entryPoint.setY(y);
	}

	public Tile getExitPoint() {
		return exitPoint;
	}

	public void setExitPoint(int x, int y) {
		this.exitPoint.setX(x);
		this.exitPoint.setY(y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(grid);
		result = prime * result + height;
		result = prime * result + tileSize;
		result = prime * result + width;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Map other = (Map) obj;
		if (!Arrays.deepEquals(grid, other.grid))
			return false;
		if (height != other.height)
			return false;
		if (tileSize != other.tileSize)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

}
