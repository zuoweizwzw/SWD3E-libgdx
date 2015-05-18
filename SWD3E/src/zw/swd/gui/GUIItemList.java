package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameItem;
import zw.swd.game.GameModel;
import zw.swd.game.ItemModel;
import zw.swd.game.MagicModel;
import zw.swd.game.RoleModel;
import zw.swd.main.Cache;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

public class GUIItemList extends List{

	GameModel gameModel;
	GUIItemListScroll scroll;
	int listcap=13;
	public GUIItemList(GameModel gameModel) {
		// TODO Auto-generated constructor stub
		this.gameModel=gameModel;
		scroll=new GUIItemListScroll();
		scroll.setPosition(285, 0);
		this.setName("guiitemlist");
		this.addActor(scroll);
	}

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void fillData(Object object) {
		// TODO Auto-generated method stub
		GameModel model=(GameModel)object;
		this.gameModel=model;
		scroll.setMaxCap(model.items.size());
		if(model.items.size()<=13) scroll.setVisible(false);
		else scroll.setVisible(true);
		ArrayList<Actor> items=this.findActors(GUIItemItem.class);
		for(Actor actor:items)
		{
			actor.remove();
		}
		
		
		
		if(model.items.size()>13)
		{
			for(int i=0;i<model.items.size();i++)
			{
				String code=model.items.get(i).itemModel.code;
				ItemModel itemModel=model.items.get(i).itemModel;
				final GUIItemItem item=new GUIItemItem(model.items.get(i));
				item.clickEvent=new ClickEvent()
				{

					@Override
					public void onClick(int button) {
						// TODO Auto-generated method stub
						item.selected=true;
						GUIItemList list=(GUIItemList) item.getParent();
						for(GUIItemItem other:list.getItems())
						{
							if(other!=item)
							{
								other.selected=false;
							}
						}
					}
					
				};
				
				item.setPosition(5, (12-i+(scroll.index))*26+6);
				this.addActor(item);
				if(i<scroll.index||i>=scroll.index+13)
				{
					item.setVisible(false);
				}
				else item.setVisible(true);
			}
			
//			for(int i=scroll.index;i<scroll.index+13;i++)
//			{
//				String code=model.items.get(i).itemModel.code;
//				ItemModel magicModel=model.items.get(i).itemModel;
//				final GUIItemItem item=new GUIItemItem(model.items.get(i));
//				item.clickEvent=new ClickEvent() {
//					
//					@Override
//					public void onClick(int button) {
//						// TODO Auto-generated method stub
//						item.selected=true;
//						GUIItemList list=(GUIItemList) item.getParent();
//						for(GUIItemItem other:list.getItems())
//						{
//							if(other!=item)
//							{
//								other.selected=false;
//							}
//						}
//					}
//				};
//				item.setPosition(5, (12-i+(scroll.index))*26+6);
//				this.addActor(item);
//			}
		}
		else
		{
			for(int i=0;i<model.items.size();i++)
			{
				String code=model.items.get(i).itemModel.code;
				GameItem magicModel=model.items.get(i);
				GUIItemItem item=new GUIItemItem(magicModel);
				item.setPosition(5, (12-i+(scroll.index))*26+6);
				this.addActor(item);
			}
		}
	}
	
	public ArrayList<GUIItemItem> getItems()
	{
		ArrayList<GUIItemItem> items=new ArrayList<>();
		ArrayList<Actor> actors=this.findActors(GUIItemItem.class);
		for(Actor actor:actors)
		{
			items.add((GUIItemItem)actor);
		}
		return items;
	}
	
	public void scrollData()
	{
		GameModel model=this.gameModel;
		this.gameModel=model;
		scroll.setMaxCap(model.items.size());
		if(model.items.size()<=13) scroll.setVisible(false);
		else scroll.setVisible(true);
		ArrayList<GUIItemItem> items=this.getItems();
		
		if(model.items.size()>13)
		{
			for(int i=0;i<items.size();i++)
			{
				GUIItemItem item=items.get(i);
				
				item.setPosition(5, (12-i+(scroll.index))*26+6);
				if(i<scroll.index||i>=scroll.index+13)
				{
					item.setVisible(false);
				}
				else item.setVisible(true);
			}
		}
		else
		{
			for(int i=0;i<items.size();i++)
			{
				GUIItemItem item=items.get(i);
				item.setPosition(5, (12-i+(scroll.index))*26+6);
				if(i<scroll.index||i>=scroll.index+13)
				{
					item.setVisible(false);
				}
				else item.setVisible(true);
			}
		}
		
	}

}
