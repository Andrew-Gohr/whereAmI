package data;

import java.io.Serializable;
import java.util.Arrays;

public class Level implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5224323053724908036L;
	private Map map[];

	Level(int maps) {

		map = new Map[maps];

	}

	public Map getMap(int i) {
		return map[i];
	}

	public void setMap(Map map, int i) {
		this.map[i] = map;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(map);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (!Arrays.equals(map, other.map))
			return false;
		return true;
	}

}
