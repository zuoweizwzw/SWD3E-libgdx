package zw.swd.graphics.scene;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;

//场景地图上行走的角色
public class SceneActor extends Sprite{

	
	public String roleNum;
	public HashMap<String,Animation> pool=new HashMap<String, Animation>();
	
	
	public SceneActor(String roleNum) {
		// TODO Auto-generated constructor stub
		this.roleNum=roleNum;
		this.setName(roleNum);
		
	}
	
	
	
	
	public void setCurrentAniByName(String aniName)
	{
		this.setAnimation(this.pool.get(roleNum+"/"+aniName));
		
	}
	
	public void nextAni(String aniName)
	{
		this.getCurrentAni().reset();
		this.setAnimation(this.pool.get(roleNum+"/"+aniName));
	}
	
	public Animation getCurrentAniByName(String aniName)
	{
		return this.pool.get(roleNum+"/"+aniName);
	}
	
}
