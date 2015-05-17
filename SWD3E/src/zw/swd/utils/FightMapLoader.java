package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.main.Cache;
import zw.swd.main.Config;

public class FightMapLoader {

	public static void loadFightMap(String resID)
	{
		File file=new File(Config.resPath+"\\map2\\scripts\\"+resID+".txt");
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		line=br.readLine();		
		String code=line;
		
		String name=br.readLine();
		String imgRes=br.readLine();
		Animation animation=new Animation();
		Frame frame=new Frame();
		FrameKey key=new FrameKey();
		key.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"\\"+imgRes)));
		frame.keys.add(key);
		animation.addFrame(frame);
		animation.autoUpdate=false;
		animation.setName(name);
		Cache.fightMaps.put(code, animation);
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
}
