package formActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.LaunchPad;

public class ExitGame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		LaunchPad.exit();
		System.exit(0);
	}

}
