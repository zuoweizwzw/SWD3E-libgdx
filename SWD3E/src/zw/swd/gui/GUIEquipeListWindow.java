package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameItem;
import zw.swd.game.GameModel;
import zw.swd.gui.list.SWDList;
import zw.swd.gui.list.SWDListWindow;
import zw.swd.gui.list.SWDTestListItem;
import zw.swd.gui.special.WindowStyle1;
import zw.swd.main.App;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeListWindow extends SWDListWindow{

	Picture background;
	GameModel gameModel;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public GUIEquipeListWindow() {
		// TODO Auto-generated constructor stub
		super(165,225,9);
		this.setListYOffset(-3);
		this.setName("guiequipelistwindow");
		this.setItemType(SWDTestListItem.class);
		App app=(App) Gdx.app.getApplicationListener();
		ArrayList<GameItem> objects=app.gameModel.items;
		this.fillData(objects);
	}
	
	public void fillData(int type,GameModel model)
	{
		this.gameModel=model;
	}

}
