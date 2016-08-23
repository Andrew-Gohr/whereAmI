package formActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import data.Settings;
import game.LaunchPad;
import game.MainGame;
import view.LaunchPadForm;
import view.Render;

public class RunGame implements ActionListener {

	static Settings settings;

	@Override
	public void actionPerformed(ActionEvent e) {
		settings = new Settings();

		if (LaunchPadForm.isvalid()) {

			Render.init(LaunchPadForm.getSelectedDisplay(), LaunchPadForm.isFullScreen());
			getSettings();
			saveSettings();
			LaunchPad.exit();
			if (settings.isPlay()) {
				System.out.println("Game started in Play mode");
				MainGame.play(settings.getLevel());
			} else {
				System.out.println("Game started in Make mode");
				MainGame.make(settings.getLevel());
			}
		} else {
			LaunchPadForm.setStatus("Select a Load Type.");
		}

	}

	private void getSettings() {
		System.out.println("Loading Launch Settings");
		settings.setResIndex(LaunchPadForm.getResIndex());
		settings.setFullScreen(LaunchPadForm.isFullScreen());
		settings.setNewGame(LaunchPadForm.isNew());
		settings.setLevel(LaunchPadForm.getSave());
		settings.setPlay(LaunchPadForm.getPlay());
		settings.setLoadIndex(LaunchPadForm.getLoadIndex());
		settings.setSaveString(LaunchPadForm.getSaveString());
		settings.setValid(LaunchPadForm.isvalid());
	}

	public static void saveSettings() {
		System.out.println("saving Settings");
		String file = "launch";
		File theFile = new File("config/" + file);

		if (theFile.exists()) {
			System.out.println("Removing old " + file);
			theFile.delete();
		}

		if (!theFile.exists()) {
			System.out.println("Creating " + file);

			try (FileOutputStream fops = new FileOutputStream(theFile)) {
				ObjectOutputStream output = new ObjectOutputStream(fops);
				output.writeObject((Object) settings);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}