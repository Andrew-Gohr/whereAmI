package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import data.Level;
public class FileManagment {
	// static Save save;
	public static void saveTo(Level level, String file) {

		File theFile = new File("saves/" + file);

		if (theFile.exists())
			theFile.delete();

		if (!theFile.exists()) {
			System.out.println("creating directory: " + file);

			try (FileOutputStream fops = new FileOutputStream(theFile)) {
				ObjectOutputStream output = new ObjectOutputStream(fops);
				output.writeObject((Object) level);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Level load(String file) {

		File theFile = new File(file);

		Level level = null;

		try (FileInputStream fips = new FileInputStream(theFile)) {
			ObjectInputStream output = new ObjectInputStream(fips);
			level = (Level) output.readObject();
			return level;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return level;

	}

	public static String[] getSaves() {

		File dir = new File("saves/");

		File[] directoryListing = dir.listFiles();
		String[] saves = new String[directoryListing.length];
		if (directoryListing != null) {
			// for (File child : directoryListing) {
			for (int i = 0; i < directoryListing.length; i++) {

				saves[i] = directoryListing[i].getPath();
				System.out.println(directoryListing[i].getPath());
			}
		}
		return saves;

	}

}
