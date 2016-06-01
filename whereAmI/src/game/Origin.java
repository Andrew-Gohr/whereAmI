package game;

import java.io.File;

import org.lwjgl.LWJGLUtil;

public class Origin {

	public static void main(String[] args) {
		
		File JGLLib = null;
		
		switch (LWJGLUtil.getPlatform()) {
		case LWJGLUtil.PLATFORM_WINDOWS: {
			JGLLib = new File("native/windows/");

		}
			break;

		case LWJGLUtil.PLATFORM_LINUX: {
			JGLLib = new File("native/linux/");

		}
			break;

		case LWJGLUtil.PLATFORM_MACOSX: {
			JGLLib = new File("native/macosx/");

		}
			break;
		}
		
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		LaunchPad.run();

	}

}
