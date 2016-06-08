package view;

import java.awt.GridLayout;
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
import data.Map;
import data.Monsters;
import data.Player;
import data.Save;
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
	static JRadioButton fullScreen, loadGame, newGame;
	static JTextField newSave;
	static JLabel statusField;
	static DisplayMode[] modes;

	public LaunchPadForm() {

		String[] displays = null;
		try {
			System.out.println("Loading Resolutions...");
			modes = Display.getAvailableDisplayModes();
			displays = new String[modes.length];
			int j = 0;
			for (int i = 0; i < modes.length; i++) {

				if (modes[i].isFullscreenCapable()) {

					displays[j] = Integer.toString(modes[i].getWidth()) + " x "
							+ Integer.toString(modes[i].getHeight());
					j++;
					System.out.println(i);
				}

			}
			System.out.println("...Done");

		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		JPanel jp = new JPanel();

		ButtonGroup loadType = new ButtonGroup();

		jp.setLayout(new GridLayout(5, 2));
		jp.add(resSelect = new JComboBox<Object>(displays));
		jp.add(fullScreen = new JRadioButton("FullScreen"));
		jp.add(newGame = new JRadioButton("New Game"));
		jp.add(loadGame = new JRadioButton("Load Game"));
		loadType.add(newGame);
		loadType.add(loadGame);
		jp.add(newSave = new JTextField("new_game"));

		jp.add(loadSelect = new JComboBox<Object>(FileManagment.getSaves()));
		jp.add(exitButton = new JButton("Quit"));
		jp.add(runGame = new JButton("Enter The Building"));

		jp.add(statusField = new JLabel(""));

		runGame.addActionListener(new RunGame());
		exitButton.addActionListener(new ExitGame());

		add(jp);

	}

	public static DisplayMode getSelectedDisplay() {
		return modes[resSelect.getSelectedIndex()];

	}

	public static boolean isFullScreen() {

		return fullScreen.isSelected();

	}

	public static Save getSave() {
		if (loadGame.isSelected()) {
			return FileManagment.load((String) loadSelect.getSelectedItem());
		} else if (newGame.isSelected()) {
			Map map = new Map(50, 50, 30);
			Player player = new Player(40, 40, 10);
			Monsters Monsters = new Monsters();

			return new Save(map, player, Monsters);
		}
		return null;
	}

	public static String getSaveString() {

		return newSave.getText();
	}

	public static boolean isvalid() {
		return loadGame.isSelected() || newGame.isSelected();
	}

	public static void setStatus(String status) {
		statusField.setText(status);

	}
}
