package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.AbsoluteFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;




import zw.swd.game.MagicModel;
import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.main.Cache;
import zw.swd.main.Config;

public class MagicLoader {

	public static AssetManager assetManager;
	public static void loadMagic(String code)
	{
		MagicModel model=new MagicModel();
		File file=new File(Config.resPath+"\\magic\\scripts\\"+code+".txt");
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine())!=null)
		{
			if(line.indexOf("code")==0)
			{
				model.code=code;
			}
			if(line.indexOf("name")==0)
			{
				String name=line.split(":")[1];
				model.name=name;
			}
			if(line.indexOf("aoe")==0)
			{
				String aoe=line.split(":")[1];
				model.aoe=Boolean.parseBoolean(aoe);
			}
			if(line.indexOf("description")==0)
			{
				String description=line.split(":")[1];
				model.description=description;
			}
			if(line.indexOf("type")==0)
			{
				String type=line.split(":")[1];
				model.displayType=Integer.parseInt(type);
			}
			if(line.indexOf("damag")==0)
			{
				String damage=line.split(":")[1];
				model.damage=Integer.parseInt(damage);
			}
			if(line.indexOf("element")==0)
			{
				String element=line.split(":")[1];
				model.element=Integer.parseInt(element);
			}
			if(line.indexOf("castToAllies")==0)
			{
				String castToAllies=line.split(":")[1];
				model.castToAllies=Boolean.parseBoolean(castToAllies);
			}
			if(line.indexOf("hitframes")==0)
			{
				String[] hitframes=line.split(":")[1].split(",");
				model.hitframes=hitframes;
			}
			if(line.indexOf("mpCost")==0)
			{
				String mpCost=line.split(":")[1];
				model.mpCost=Integer.parseInt(mpCost);
			}
			if(line.indexOf("offset")==0)
			{
				String[] offset=line.split(":")[1].split(",");
				model.offset.set(Integer.parseInt(offset[0]), Integer.parseInt(offset[1]));
			}
			if(line.indexOf("length")==0)
			{
				String length=line.split(":")[1];
				final Animation animation=new Animation();
				long t1=System.currentTimeMillis();
				for(int i=1;i<Integer.parseInt(length)+1;i++)
				{
					Frame frame=new Frame();
					final FrameKey key=new FrameKey();
					frame.duration=0.1f;
					TextureLoader.TextureParameter parameters=new TextureLoader.TextureParameter();
					parameters.loadedCallback=new AssetLoaderParameters.LoadedCallback() {

						@Override
						public void finishedLoading(AssetManager assetManager,
								String fileName, Class type) {
							// TODO Auto-generated method stub
							key.texture=new TextureRegion((Texture) assetManager.get(fileName));
							
						}
					};
					assetManager.load(Config.resPath+"/magic/"+code+"-"+i+".png", Texture.class,parameters);
					
//					assetManager.finishLoading();
					
					
//					Texture.setAssetManager(manager);
//					key.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"\\magic\\"+code+"-"+i+".png")));
					frame.keys.add(key);
					animation.addFrame(frame);
				}
				long t2=System.currentTimeMillis();
				animation.code="magic/"+code;
				model.anis=animation;
			}
		}
		Cache.magics.put(code, model);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadMagics(String...codes)
	{
		assetManager=ResourceLoader.assetManager;
		
		assetManager.setLoader(Texture.class, new TextureLoader(new AbsoluteFileHandleResolver()));
		Texture.setAssetManager(MagicLoader.assetManager);
		for(String code:codes)
		{
			loadMagic(code);
		}
	}
}
