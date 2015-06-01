package zw.swd.game;

import java.util.ArrayList;

public class GameModel {

	public ArrayList<RoleModel> members=new ArrayList<>();
	public ArrayList<GameItem> items=new ArrayList<>();
	
	public ArrayList<GameItem> getItemsByType(int type)
	{
		ArrayList<GameItem> typeitems=new ArrayList<>();
		for(GameItem item:items)
		{
			if(item.itemModel.type==type)
			{
				typeitems.add(item);
			}
		}
		return typeitems;
	}
	
	public void removeItem(GameItem item)
	{
		items.remove(item);
	}
	
}
