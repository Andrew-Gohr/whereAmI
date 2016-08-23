package view;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import data.Level;
import data.Settings;
import formActions.ExitGame;
import formActions.RunGame;
import game.FileManagment;

public class LaunchPadForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 867101575549217027L;
	static JButton runGame, exitButton;
	static JComboBox<Object> resSelect, loadSelect;
	static JRadioButton fullScreen, loadGame, newGame, playGame, makeGame;
	static JTextField newSave;
	static JLabel statusField;
	static DisplayMode[] modes;

	public LaunchPadForm() {

		String[] displays = null;
		try {
			modes = Display.getAvailableDisplayModes();
			displays = new String[modes.length];
			int j = 0;
			for (int i = 0; i < modes.length; i++) {

				if (modes[i].isFullscreenCapable()) {

					displays[j] = Integer.toString(modes[i].getWidth()) + " x "
							+ Integer.toString(modes[i].getHeight());
					j++;
				}

			}

		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		JPanel jp = new JPanel();

		ButtonGroup loadType = new ButtonGroup();
		ButtonGroup playType = new ButtonGroup();

		jp.setLayout(new GridLayout(6, 1));
		jp.add(resSelect = new JComboBox<Object>(displays));
		jp.add(fullScreen = new JRadioButton("FullScreen"));
		jp.add(newGame = new JRadioButton("New Game"));
		jp.add(loadGame = new JRadioButton("Load Game"));
		loadType.add(newGame);
		loadType.add(loadGame);
		jp.add(playGame = new JRadioButton("Play"));
		jp.add(makeGame = new JRadioButton("make"));
		playType.add(playGame);
		playType.add(makeGame);

		jp.add(newSave = new JTextField("new_game"));

		jp.add(loadSelect = new JComboBox<Object>(FileManagment.getSaves()));
		jp.add(exitButton = new JButton("Quit"));
		jp.add(runGame = new JButton("Enter The Building"));
		jp.add(statusField = new JLabel(""));
		loadSettings();

		runGame.addActionListener(new RunGame());
		exitButton.addActionListener(new ExitGame());

		add(jp);

	}

	public static DisplayMode getSelectedDisplay() {
		return modes[resSelect.getSelectedIndex()];

	}

	public static int getResIndex() {
		return resSelect.getSelectedIndex();
	}

	public static boolean isFullScreen() {

		return fullScreen.isSelected();

	}

	public static boolean getPlay() {
		return playGame.isSelected();
	}

	public static Level getSave() {
		if (loadGame.isSelected()) {
			return FileManagment.load((String) loadSelect.getSelectedItem());
		} else {
			return new Level(3, 50, 50, 40, 0);
		}
	}

	public static String getSaveString() {

		return newSave.getText();
	}

	public static int getLoadIndex() {
		return loadSelect.getSelectedIndex();
	}

	public static boolean isvalid() {
		return loadGame.isSelected() || newGame.isSelected();
	}

	public static boolean isNew() {
		return newGame.isSelected();

	}

	public static void setStatus(String status) {
		statusField.setText(status);

	}

	private static void loadSettings() {
		Settings settings;
		String file = "config/launch";
		File theFile = new File(file);

		System.out.println("Attempting Read " + file);
		try (FileInputStream fips = new FileInputStream(theFile)) {
			ObjectInputStream output = new ObjectInputStream(fips);
			settings = (Settings) output.readObject();
			setFields(settings);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setFields(Settings settings) {
		if (settings.isFullScreen()) {
			fullScreen.setSelected(true);
		} else {
			fullScreen.setSelected(false);
		}

		loadSelect.setSelectedIndex(settings.getLoadIndex());
		resSelect.setSelectedIndex(settings.getResIndex());
		newGame.setSelected(settings.isNewGame());
		loadGame.setSelected(!settings.isNewGame());
		playGame.setSelected(settings.isPlay());
		makeGame.setSelected(!settings.isPlay());

	}

}