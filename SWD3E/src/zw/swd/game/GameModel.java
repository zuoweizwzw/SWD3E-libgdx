package zw.swd.game;

import java.util.ArrayList;

public class GameModel {

	public ArrayList<RoleModel> members=new ArrayList<>();
	private ArrayList<GameItem> items=new ArrayList<>();
	private static GameModel instance;
	
	public static GameModel getInstance()
	{
		if(instance==null)
		{
			instance=new GameModel();
		}
		return instance;
	}
	
	private GameModel()
	{
		
	}
	
	public ArrayList<GameItem> getItemsByType(int type)
	{
		if(type==-1) return items;
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
	
	public void addItem(GameItem item,int num)
	{
		if(this.items.contains(item))
		{
			item.num+=num;
		}
		else 
		{
			this.items.add(item);
			item.num=num;
		}
	}
	
	public void addItem(ItemModel model, int num)
	{
		boolean exist=false;
		for(GameItem item:items)
		{
			if(item.itemModel==model)
			{
				exist=true;
				item.num++;
			}
		}
		if(!exist)
		{
			GameItem nouvel=new GameItem(model);
			nouvel.num=num;
			this.addItem(nouvel);
		}
	}

	public void addItem(GameItem item)
	{
		addItem(item,1);
	}
	
	public void reduceItem(GameItem item, int i) {
		// TODO Auto-generated method stub
		item.num-=i;
		if(item.num==0) this.removeItem(item);
	}
	
}
