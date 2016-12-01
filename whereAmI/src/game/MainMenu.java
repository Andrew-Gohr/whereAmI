package game;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import data.Level;
import data.MenuItem;
import view.Render;

public class MainMenu {

	static int mouseX = 0;
	static int mouseY = 0;
	static boolean first = true;
	static MenuItem[] menuList;
	static boolean newSave = true;
	static int fileIndex = 0;
	static MenuItem[] saveList;
	
	public static void start() {
		menuList = new MenuItem[5];
		
		String[] saves = FileManagment.getSaves();
		saveList = new MenuItem[saves.length];
		
		Render.menuInit();
		int savey = 200;
		int menuy = 200;
		
		String nameList[] = new String[5];
		nameList[0] = "New Game";
		nameList[1] = "Load Game";
		nameList[2] = "Create Map";
		nameList[3] = "Options";
		nameList[4] = "Quit";
		
		MenuItem newOption = new MenuItem(600, 200, 45, 20, "Save");
		newOption.setColor(1, 1, 1);
		MenuItem loadOption = new MenuItem(600, 275, 45, 20, "Load");
		loadOption.setColor(1, 1, 1);

		for (int i = 0; i < menuList.length; i++) {
			menuList[i] = new MenuItem(200, menuy, 90, 20, nameList[i]);
			menuList[i].setColor(1, 1, 1);
			menuy += 70;
		}
		for (int i = 0; i < saves.length; i++) {
			saveList[i] = new MenuItem(425, savey, 90, 20, saves[i]);
			saveList[i].setColor(1, 1, 1);
			savey += 70;
		}

		while (!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			mouseX = Mouse.getX();
			mouseY = Render.getScreenHeight() - Mouse.getY();

			for (int i = 0; i < menuList.length; i++) {
				if (menuList[i].isInBounds(mouseX, mouseY)) {

					menuList[i].setWidth(120);

					if (Mouse.isButtonDown(0)) {
						switch (i) {

						case 0:
							MainGame.play(new Level(3, 50, 50, 40, 0));
							Render.menuInit();
							break;
						case 1:
							MainGame.play(getLevel());
							Render.menuInit();
							break;
						case 2:
							MainGame.make(getLevel());
							Render.menuInit();
							break;
						case 3:
							System.out.println("sorry no options yet");
							Render.menuInit();
							break;
						case 4:
							
							System.exit(0);
							break;

						}
					}
				}

				Render.menuItem(menuList[i]);
				if (!menuList[i].isInBounds(mouseX, mouseY)) {
					menuList[i].setWidth(90);
				}
			}
			
			for (int i = 0; i < saveList.length; i++) {
				if (saveList[i].isInBounds(mouseX, mouseY)) {

					saveList[i].setWidth(120);

					if (Mouse.isButtonDown(0)) {
						fileIndex = i;
						saveList[i].setColor(0, 1, 0);
					}
					
				}
				
				if (fileIndex != i){
					saveList[i].setColor(1, 1, 1);
					}
				
				Render.menuItem(saveList[i]);
				if (!saveList[i].isInBounds(mouseX, mouseY)) {
					saveList[i].setWidth(90);
				}
			}
			
			if(Mouse.isButtonDown(0)){
				if(newOption.isInBounds(mouseX, mouseY)){
					newSave = true;
					newOption.setColor(0, 1, 0);
					loadOption.setColor(1, 1, 1);
				}
				if(loadOption.isInBounds(mouseX, mouseY)){
					newSave = false;
					loadOption.setColor(0, 1, 0);
					newOption.setColor(1, 1, 1);
				}
			}
			
			Render.menuItem(newOption);
			Render.menuItem(loadOption);
			Display.update();
			Display.sync(60);

		}
		System.exit(0);
	}
	
	public static Level getLevel(){
		if (newSave = true){
			return new Level(3, 50, 50, 40, 0);
		}else {
			return FileManagment.load(saveList[fileIndex].getText());
		}
	}
}
