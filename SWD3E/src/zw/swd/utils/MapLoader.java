package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import zw.swd.graphics.Sprite;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.main.Config;

public class MapLoader {

	public static SceneMap loadSceneMap(String mapNum)
	{
		SceneMap map=new SceneMap(mapNum);
		
		map.background.addActor(new Sprite(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+".png"));
		
		File controlsConfig=new File(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+"_match.txt");
		
		
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(controlsConfig));
		String line="";
		while((line=br.readLine())!=null)
		{
			if(line.indexOf("-")>=0)
			{
				String controlNum=line.split(" ")[0];
				String[] offsets=line.split(" ")[1].split(",");
				int x=Integer.parseInt(offsets[0]);
				int y=Integer.parseInt(offsets[1]);
				Sprite control=new Sprite(Config.resPath+"\\huge\\"+mapNum+"\\"+controlNum+".png");
				control.setX(x);
				control.setY(y);
				control.setName(controlNum);
				map.masks.addActor(control);
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return map;
	}
	
	
}
