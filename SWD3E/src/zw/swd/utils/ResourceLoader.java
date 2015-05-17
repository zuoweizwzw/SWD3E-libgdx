package zw.swd.utils;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.AbsoluteFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;

public class ResourceLoader {

	public static AssetManager assetManager=new AssetManager();
	public ResourceLoader() {
		// TODO Auto-generated constructor stub
		TextureLoader textureLoader=new TextureLoader(new AbsoluteFileHandleResolver());
		assetManager.setLoader(Texture.class,textureLoader);
	}
	
	public Texture getTexture(String name)
	{
		if(this.assetManager.isLoaded(name))
		{
			return this.assetManager.get(name);
		}
		else
		{
			System.out.println("Resource: "+name+" is not AsyncLoaded, try to SyncLoad");
			Texture texture=new Texture(Gdx.files.absolute(name));
			
			if(texture!=null)
			{
				return texture;
			}			
			else return null;
		}
	}
	
	public static void loadMagicTexture(String...code)
	{
		
	}
	
	public Texture loadTextureImd(String path)
	{
		Texture texture=new Texture(Gdx.files.absolute(path));
		return texture;
	}

	public static void update() {
		// TODO Auto-generated method stub
		assetManager.update();
	}
	
	
}
