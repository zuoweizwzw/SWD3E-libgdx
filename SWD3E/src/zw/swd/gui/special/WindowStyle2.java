package zw.swd.gui.special;

import zw.swd.gui.Picture;
import zw.swd.main.Config;

public class WindowStyle2 {

	public static Picture createInstance(int width, int height)
	{
		Picture picture=new Picture();
		picture.setSize(width, height);
		
		Picture leftdown=new Picture(Config.resPath+"/gui/116-7.png");
		picture.addActor(leftdown);
		
		Picture rightdown=new Picture(Config.resPath+"/gui/116-9.png");
		rightdown.setPosition(leftdown.getX()+width-16, leftdown.getY());
		picture.addActor(rightdown);
		
		Picture leftup=new Picture(Config.resPath+"/gui/116-1.png");
		leftup.setPosition(leftdown.getX(), leftdown.getY()+height-16);
		picture.addActor(leftup);
		
		Picture rightup=new Picture(Config.resPath+"/gui/116-3.png");
		rightup.setPosition(rightdown.getX(), rightdown.getY()+height-16);
		picture.addActor(rightup);
		
		Picture up=new Picture(Config.resPath+"/gui/116-2.png");
		up.setPhysicWidth(width-16);
		up.setPosition(leftup.getX()+8, leftup.getY());
		picture.addActor(up);
		
		Picture right=new Picture(Config.resPath+"/gui/116-6.png");
		right.setPhysicHeight(height-16);
		right.setPosition(rightdown.getX(), rightdown.getY()+8);
		picture.addActor(right);
		
		Picture down=new Picture(Config.resPath+"/gui/116-8.png");
		down.setPhysicWidth(width-16);
		down.setPosition(leftdown.getX()+8, leftdown.getY());
		picture.addActor(down);
		
		Picture left=new Picture(Config.resPath+"/gui/116-4.png");
		left.setPhysicHeight(height-16);
		left.setPosition(leftdown.getX(), leftdown.getY()+8);
		picture.addActor(left);
		
		
		
		return picture;
	}
}
