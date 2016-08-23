package game;

import java.io.File;

import org.lwjgl.LWJGLUtil;

public class Origin {

	public static void main(String[] args) {
		System.out.println("Starting up");
		File JGLLib = null;

		switch (LWJGLUtil.getPlatform()) {
		case LWJGLUtil.PLATFORM_WINDOWS: {
			System.out.println("Running on a windows box");
			JGLLib = new File("native/windows/");

		}
			break;

		case LWJGLUtil.PLATFORM_LINUX: {
			System.out.println("Running on a linux box");
			JGLLib = new File("native/linux/");

		}
			break;

		case LWJGLUtil.PLATFORM_MACOSX: {
			System.out.println("Running on a fruit box");
			JGLLib = new File("native/macosx/");

		}
			break;
		}

		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		LaunchPad.run();

	}

}
