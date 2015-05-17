package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;




import com.badlogic.gdx.math.Rectangle;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.main.Cache;
import zw.swd.main.Config;
import zw.swd.math.Vector2;

public class FightRoleLoader {

	public static void loadFightRole(String roleID){
		File dir=new File(Config.resPath+"\\char\\"+roleID+"\\fight");
		for(File file:dir.listFiles())
		{
			if(file.getName().indexOf(".ani")<0) continue;
			try
			{
				Animation animation=new Animation();
				BufferedReader br=new BufferedReader(new FileReader(file));
				String line;
				line=br.readLine();
				String code=line;
				String id=br.readLine();
				String foot_str=br.readLine();
				int offsetX=Integer.parseInt(foot_str.split(",")[0]);
				int offsetY=Integer.parseInt(foot_str.split(",")[1]);
				animation.mainOffset=new Vector2(offsetX, offsetY);
				int leftAlign=Integer.parseInt(br.readLine());
				animation.userData.put("leftAlign", leftAlign);
				String[] collisRect_str=br.readLine().split(",");
				Rectangle rect=new Rectangle(Integer.parseInt(collisRect_str[0]), Integer.parseInt(collisRect_str[1]), Integer.parseInt(collisRect_str[2]), Integer.parseInt(collisRect_str[3]));
				animation.userData.put("collisRect", rect);
				int length=Integer.parseInt(br.readLine());
				
				
				for(int i=1;i<length+1;i++)
				{
					Frame frame=new Frame();
					float duration=Float.parseFloat(br.readLine());
					frame.duration=duration;
					int keyNum=Integer.parseInt(br.readLine());
					for(int j=0;j<keyNum;j++)
					{
						FrameKey key=new FrameKey();
						
						String[] img_str=br.readLine().split(" ");
						String path=img_str[0];
						boolean flip=false;
						if(img_str.length>=2)
						{
						flip=Boolean.parseBoolean(img_str[1]);
						}
						key.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"/"+path)));
						
						key.texture.flip(flip, false);
						frame.keys.add(key);
					}
					animation.addFrame(frame);
				}
				Cache.fightRoles.put(id, animation);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
