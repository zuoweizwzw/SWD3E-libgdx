package zw.swd.utils;

import zw.swd.main.Cache;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureLoader {

	public static Texture loadTexture(String path)
	{
		Texture texture;
		
		if(Cache.textures.containsKey(path))
		{
			texture=Cache.textures.get(path);
		}
		else
		{
			texture=new Texture(Gdx.files.absolute(path));
			Cache.textures.put(path, texture);
		}
		return texture;
	}
}
