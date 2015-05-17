package zw.swd.gui;

import zw.swd.main.Config;

public class GuiUtils {

	public static Paper getNumberCombo(String numSerial,int type)
	{
		String res="";
		int offsetX=0;
		if(type==0) 
		{
			res="97";
		}
		
		Picture paper=new Picture();
		int posX = 0,posY;
		for(int i=0;i<numSerial.length();i++)
		{
			char c=numSerial.charAt(i);
			int dig=Integer.parseInt(Character.toString(c));
			String path=Config.resPath+"/gui/"+res+"-"+(dig+1)+".png";
			Picture digPaper=new Picture(path);
			int width=digPaper.getAnimation().getWidth();
			digPaper.setPosition(posX, 0);
			posX=posX+width;
			paper.addActor(digPaper);
		}
		return paper;
	}
}
