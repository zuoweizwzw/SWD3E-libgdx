package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameModel;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GUIItemList extends List{

	GameModel gameModel;
	GUIItemListScroll scroll;
	public GUIItemList(GameModel gameModel) {
		// TODO Auto-generated constructor stub
		this.gameModel=gameModel;
		scroll=new GUIItemListScroll();
		scroll.setPosition(185, 0);
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
