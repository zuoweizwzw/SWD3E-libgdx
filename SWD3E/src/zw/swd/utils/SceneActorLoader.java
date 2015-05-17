package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.main.Config;

public class SceneActorLoader {

	public static final HashMap<String,Animation> loadSceneActorAnis(String roleNum)
	{
		HashMap<String,Animation> anis=new HashMap<String,Animation>();
		
		File dir=new File(Config.resPath+"\\char\\"+roleNum+"\\anis");
		File[] files=dir.listFiles();
		for(File file:files)
		{
			Animation ani=new Animation();
			try
			{
				BufferedReader br=new BufferedReader(new FileReader(file));
				String code=br.readLine();
				String name=br.readLine();
				String mainOffset_str=br.readLine();
				ani.mainOffset.set(Integer.parseInt(mainOffset_str.split(",")[0]),Integer.parseInt(mainOffset_str.split(",")[1]));
				String centerPoint_str=br.readLine();
				ani.centerPoint.set(Integer.parseInt(centerPoint_str.split(",")[0]),Integer.parseInt(centerPoint_str.split(",")[1]));
				String colisBox_str=br.readLine();
				String colisBox_origin_str=colisBox_str.split(" ")[0];
				String colisBox_size_str=colisBox_str.split(" ")[1];
				ani.colisBox.setX(Integer.parseInt(colisBox_origin_str.split(",")[0]));
				ani.colisBox.setY(Integer.parseInt(colisBox_origin_str.split(",")[1]));
				ani.colisBox.setWidth(Integer.parseInt(colisBox_size_str.split(",")[0]));
				ani.colisBox.setHeight(Integer.parseInt(colisBox_size_str.split(",")[1]));
				int count=Integer.parseInt(br.readLine());
				ani.code=code;
				ani.name=name;
				for(int i=0;i<count;i++)
				{
					Frame frame=new Frame();
					frame.duration=Float.parseFloat(br.readLine());
					int keyCount=Integer.parseInt(br.readLine());
					for(int j=0;j<keyCount;j++)
					{
						FrameKey key=new FrameKey();
						String[] strs=br.readLine().split(" ");
						String fileName=strs[0];
						key.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"\\"+fileName)));
						
						if(strs.length==3)
						{
							boolean flip=Boolean.parseBoolean(strs[2]);
							if(flip) key.texture.flip(true, false);
						}
						
						int offsetX=Integer.parseInt(strs[1].split(",")[0]);
						int offsetY=Integer.parseInt(strs[1].split(",")[1]);
						key.offsetX=offsetX;
						key.offsetY=offsetY;
						frame.keys.add(key);
					}
					ani.addFrame(frame);
				}
				anis.put(name, ani);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return anis;
	}
}
