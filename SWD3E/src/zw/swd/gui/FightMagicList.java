package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.MagicModel;
import zw.swd.game.RoleModel;
import zw.swd.main.Cache;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FightMagicList extends List{

	ScrollBar scroll=new ScrollBar();
	int listcap=8;
	public RoleModel model;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public FightMagicList() {
		// TODO Auto-generated constructor stub
		scroll.setPosition(185, 0);
		this.setName("fightmagiclist");
		this.addActor(scroll);
	}

	@Override
	public void fillData(Object object) {
		// TODO Auto-generated method stub
		RoleModel model=(RoleModel)object;
		this.model=model;
		scroll.setMaxCap(model.magics.size());
		if(model.magics.size()<=8) scroll.setVisible(false);
		else scroll.setVisible(true);
		ArrayList<Actor> items=this.findActors(FightMagicItem.class);
		for(Actor actor:items)
		{
			actor.remove();
		}
		
		if(model.magics.size()>8)
		{
		for(int i=scroll.index;i<scroll.index+8;i++)
		{
			String code=model.magics.get(i);
			MagicModel magicModel=Cache.magics.get(code);
			FightMagicItem item=new FightMagicItem(magicModel);
			item.setPosition(5, (7-i+(scroll.index))*20+8);
			this.addActor(item);
		}
		}
		else
		{
			for(int i=0;i<model.magics.size();i++)
			{
				String code=model.magics.get(i);
				MagicModel magicModel=Cache.magics.get(code);
				FightMagicItem item=new FightMagicItem(magicModel);
				item.setPosition(5, (7-i+(scroll.index))*20+8);
				this.addActor(item);
			}
		}
		
//		for(String code:model.magics)
//		{
//			MagicModel magicModel=Cache.magics.get(code);
//			FightMagicItem item=new FightMagicItem(magicModel);
//			int count=this.getItems().size();
//			
//			item.setPosition(5, (7-count)*20+8);
//			this.addActor(item);
//			
//		}
	}
	
	public void updateDate()
	{
		
	}

	public ArrayList<FightMagicItem> getItems()
	{
		ArrayList<FightMagicItem> items=new ArrayList<>();
		ArrayList<Actor> actors=this.findActors(FightMagicItem.class);
		for(Actor actor:actors)
		{
			items.add((FightMagicItem)actor);
		}
		return items;
	}
	
}
