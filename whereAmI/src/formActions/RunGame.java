package formActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.LaunchPad;
import game.MainGame;
import view.LaunchPadForm;
import view.Render;

public class RunGame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (LaunchPadForm.isvalid()) {
			LaunchPad.exit();

			Render.init(LaunchPadForm.getSelectedDisplay(), LaunchPadForm.isFullScreen());

			MainGame.startGame(LaunchPadForm.getSave(), LaunchPadForm.gelPlay());
		} else {
			LaunchPadForm.setStatus("Select a Load Type.");
		}

	}

}
