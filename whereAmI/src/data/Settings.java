package data;

import java.io.Serializable;

public class Settings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6988949200974578488L;
	private int resIndex;
	private int loadIndex;
	private boolean fullScreen;
	private boolean newGame;
	private boolean play;
	private Level level;
	private String saveString;
	private boolean valid;

	public Settings() {

	}

	public int getResIndex() {
		return resIndex;
	}

	public void setResIndex(int resIndex) {
		this.resIndex = resIndex;
	}

	public boolean isFullScreen() {
		return fullScreen;
	}

	public void setFullScreen(boolean fullScreen) {
		this.fullScreen = fullScreen;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getSaveString() {
		return saveString;
	}

	public void setSaveString(String saveString) {
		this.saveString = saveString;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isNewGame() {
		return newGame;
	}

	public void setNewGame(boolean newGame) {
		this.newGame = newGame;
	}

	public int getLoadIndex() {
		return loadIndex;
	}

	public void setLoadIndex(int loadIndex) {
		this.loadIndex = loadIndex;
	}

}
