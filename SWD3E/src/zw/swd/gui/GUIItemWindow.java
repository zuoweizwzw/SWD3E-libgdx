package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameItem;
import zw.swd.game.GameModel;
import zw.swd.gui.list.SWDList;
import zw.swd.gui.list.SWDListItem;
import zw.swd.gui.list.SWDListWindow;
import zw.swd.gui.special.WindowStyle1;
import zw.swd.main.Config;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GUIItemWindow extends SWDListWindow{

	Picture tabs=new Picture();
	GameModel gameModel;
	
	public GUIItemWindow()
	{
		super(304,352,13);
		this.setName("guiitemwindow");
		this.setItemType(GUIItemItem.class);
		this.setListYOffset(-3);
		
		tabs.setPosition(this.getX(), this.getY()+352);
		final TabButton tab1=new TabButton(new Picture(Config.resPath+"/gui/17-47.png"), new Picture(Config.resPath+"/gui/17-3.png"));
		tab1.setPosition(0, 0);
		tab1.clickEvent=new ClickEvent() {

			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				if(button==Buttons.LEFT)
				{
					tab1.setFocus(true);
					for(Actor actor:tab1.getParent().getChildren())
					{
						if(actor!=tab1&&actor instanceof TabButton)
						{
							((TabButton)actor).setFocus(false);
						}
					}
				}
			}
			
		};
		tabs.addActor(tab1);
		
		final TabButton tab2=new TabButton(new Picture(Config.resPath+"/gui/17-48.png"), new Picture(Config.resPath+"/gui/17-4.png"));
		tab2.setPosition(50, tab1.getY());
		tab2.clickEvent=new ClickEvent() {

			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				if(button==Buttons.LEFT)
				{
					tab2.setFocus(true);
					for(Actor actor:tab2.getParent().getChildren())
					{
						if(actor!=tab2&&actor instanceof TabButton)
						{
							((TabButton)actor).setFocus(false);
						}
					}
				}
			}
			
		};
		tabs.addActor(tab2);
		
		final TabButton tab3=new TabButton(new Picture(Config.resPath+"/gui/17-49.png"), new Picture(Config.resPath+"/gui/17-7.png"));
		tab3.setPosition(100, tab1.getY());
		tab3.clickEvent=new ClickEvent() {

			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				if(button==Buttons.LEFT)
				{
					tab3.setFocus(true);
					for(Actor actor:tab3.getParent().getChildren())
					{
						if(actor!=tab3&&actor instanceof TabButton)
						{
							((TabButton)actor).setFocus(false);
						}
					}
				}
			}
			
		};
		tabs.addActor(tab3);
		
		this.addActor(tabs);
		
	}
	public void fillData(GameModel gameModel) {
		// TODO Auto-generated method stub
		this.list.fillData(gameModel.getItemsByType(-1));
		this.gameModel=gameModel;
	}

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUIItemItem getSelectedItem()
	{
		GUIItemItem item=null;
		ArrayList<SWDListItem> items=this.list.getListItems();
		for(SWDListItem listItem:items)
		{
			item=(GUIItemItem) listItem;
			if(item.isSelected()) return item;
		}
		
		return null;
	}
	

	
	public void reset()
	{
		this.list.reset();
	}
	
	
	
	
}
