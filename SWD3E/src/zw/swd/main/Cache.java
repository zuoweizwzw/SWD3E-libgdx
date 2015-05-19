package zw.swd.main;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

import zw.swd.game.ItemModel;
import zw.swd.game.MagicModel;
import zw.swd.graphics.Animation;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.gui.Paper;
import zw.swd.scene.scripts.SceneScript;

public class Cache {

	public static HashMap<String,MagicModel> magics=new HashMap<String, MagicModel>();
	public static HashMap<String,Animation>  fightMaps=new HashMap<String, Animation>();
	public static HashMap<String,Animation> fightRoles=new HashMap<String, Animation>();
	public static HashMap<String, Paper> controls=new HashMap<String, Paper>();
	public static HashMap<String,SceneScript> sceneScripts=new HashMap<String,SceneScript>();
	public static HashMap<String, ItemModel> items=new HashMap<>();
	public static HashMap<String,Texture> textures=new HashMap<>();
	
}
