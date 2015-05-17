package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.main.Config;

public class FaceLoader {

	public static HashMap<String,Animation> faces=new HashMap<String, Animation>();
	public static void loadFaces()
	{
		File dir=new File(Config.resPath+"\\face\\scripts");
		File[] files=dir.listFiles();
		
		for(File file:files)
		{
			Animation ani=new Animation();
			try
			{
				BufferedReader br=new BufferedReader(new FileReader(file));
				String line="";
				while((line=br.readLine())!=null)
				{
					if(!line.equals("\r\n"))
					{
						if(line.indexOf("no")==0)
						{
							String no=line.split(":")[1];
							line=br.readLine();
							String role=line.split(":")[1];
							line=br.readLine();
							String name=line.split(":")[1];
							line=br.readLine();
							String img=line.split(":")[1];
							Frame f=new Frame();
							FrameKey fk=new FrameKey();
							
							fk.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"\\"+img)));
							f.keys.add(fk);
							ani.addFrame(f);
							ani.autoUpdate=false;
							faces.put("face/"+role+"/"+no, ani);
							
							Animation anir=new Animation();
							Frame fr=new Frame();
							FrameKey fkr=new FrameKey();
							fkr.texture=new TextureRegion(fk.texture);
							fkr.texture.flip(true, false);
							fr.keys.add(fkr);
							anir.addFrame(fr);;
							anir.autoUpdate=false;
							faces.put("face/"+role+"/"+no+"r", anir);
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
