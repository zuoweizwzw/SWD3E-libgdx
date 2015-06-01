package zw.swd.utils;

import java.io.BufferedReader;
import java.io.FileReader;

import zw.swd.game.ItemModel;
import zw.swd.graphics.Animation;
import zw.swd.main.Cache;
import zw.swd.main.Config;

public class ItemLoader {

	public static ItemModel loadItem(String code)
	{
		ItemModel itemModel=new ItemModel();
		
		try
		{
		String path="F:/SWD3E/item2/scripts/"+code+".txt";
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line="";
		while((line=br.readLine())!=null)
		{
			if(line.indexOf("code")>=0)
			{
				itemModel.code=line.split(":")[1];
			}
			if(line.indexOf("name")>=0)
			{
				itemModel.name=line.split(":")[1];
			}
			if(line.indexOf("description")>=0)
			{
				itemModel.description=line.split(":")[1];
			}
			if(line.indexOf("type")>=0)
			{
				itemModel.type=Integer.parseInt(line.split(":")[1]);
			}
			if(line.indexOf("respath")>=0)
			{
				itemModel.resPath=line.split(":")[1];
			}
			if(line.indexOf("use_hp")>=0)
			{
				itemModel.use_hp=Integer.parseInt(line.split(":")[1]);
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Animation animation=new Animation(Config.resPath+"/"+itemModel.resPath);
		itemModel.animation=animation;
		Cache.items.put(itemModel.code, itemModel);
		return itemModel;
	}
	
	public static void loadItems(String... codes)
	{
		for(String code:codes)
		{
			loadItem(code);
		}
	}
}
