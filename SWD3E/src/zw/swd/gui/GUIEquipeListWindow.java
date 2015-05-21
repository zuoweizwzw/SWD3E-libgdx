package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.gui.special.WindowStyle1;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeListWindow extends Paper{

	Picture background;
	GameModel gameModel;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public GUIEquipeListWindow() {
		// TODO Auto-generated constructor stub
		this.setName("guiequipelistwindow");
		
		background=WindowStyle1.createInstance(165, 225);
		this.addActor(background);
		
		
	}
	
	public void fillData(int type,GameModel model)
	{
		this.gameModel=model;
	}

}
