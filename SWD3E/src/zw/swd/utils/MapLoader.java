package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import zw.swd.game.event.MapEvent;
import zw.swd.graphics.Sprite;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.main.Config;

public class MapLoader {

	public static SceneMap loadSceneMap(String mapNum)
	{
		SceneMap map=new SceneMap(mapNum);
		
		map.background.addActor(new Sprite(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+".png"));
		
		File controlsConfig=new File(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+"_match.txt");
		
		File dataConfig=new File(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+"_data.txt");
		
		File mapEventsPath=new File(Config.resPath+"\\events\\mapEvents\\"+mapNum+".txt");
		map.data=loadData(dataConfig);
		loadMapEvents(map, mapEventsPath);
		
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
	
	private static int[][] loadData(File path)
	{
		int[][] data=null;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(path));
			String line1=br.readLine();
			
			int line=Integer.parseInt(line1.split(",")[0]);
			int colum=Integer.parseInt(line1.split(",")[1]);
			data=new int[line][colum];
			
			String[] lines=new String[line];
			for(int i=0;i<line;i++)
			{
				lines[i]=br.readLine();
			}
			
			for(int i=0;i<line;i++)
			{
				String[] lin=lines[lines.length-i-1].split(" ");
				
				for(int j=0;j<lin.length;j++)
				{
					data[i][j]=Integer.parseInt(lin[j]);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static void loadMapEvents(SceneMap map,File path)
	{
		ArrayList<MapEvent> mapEvents=new ArrayList<>();
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(path));
			String line="";
			while((line=br.readLine())!=null)
			{
				String[] strs=line.split(" ");
				String eventNum=strs[0];
				MapEvent mapEvent=new MapEvent(eventNum);
				
				mapEvent.setCoord(Integer.parseInt(strs[1].split(",")[0]), Integer.parseInt(strs[1].split(",")[1]));
				mapEvent.setSize(Integer.parseInt(strs[2].split(",")[0]), Integer.parseInt(strs[2].split(",")[1]));
				map.addMapEvent(mapEvent);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
