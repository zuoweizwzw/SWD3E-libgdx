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
	public int type;
	private static GUIEquipeListWindow instance=null;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public static GUIEquipeListWindow getInstance()
	{
		if(instance==null)
		{
			instance=new GUIEquipeListWindow();
		}
		return instance;
	}
	
	private GUIEquipeListWindow() {
		// TODO Auto-generated constructor stub
		super(165,225,9);
		this.setListYOffset(-3);
		this.setName("guiequipelistwindow");
		this.setItemType(GUIEquipeListItem.class);
		App app=(App) Gdx.app.getApplicationListener();
//		ArrayList<GameItem> objects=app.gameModel.getItemsByType(-1);
//		this.fillData(objects);
	}
	
	public void fillData(int type,GameModel model)
	{
		this.gameModel=model;
	}
	
	@Override
	public void reset()
	{
		this.list.clearData();
		this.list.reset();
	}
	
	public void updateData()
	{
		this.updateData(this.type);
	}
	
	public void updateData(int type)
	{
		this.type=type;
		ArrayList<GameItem> items=GameModel.getInstance().getItemsByType(type);
		this.updateData(items);
	}

}
