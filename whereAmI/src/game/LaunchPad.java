package game;

import javax.swing.JFrame;

import view.LaunchPadForm;

public class LaunchPad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7314783106829742165L;

	static LaunchPadForm form;

	public static void run() {
		form = new LaunchPadForm();
		form.setTitle("Game LaunchPad");
		form.pack();
		form.setLocationRelativeTo(null);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.setVisible(true);

	}

	public static void exit() {
		form.setVisible(false);
		form.dispose();
	}

}
