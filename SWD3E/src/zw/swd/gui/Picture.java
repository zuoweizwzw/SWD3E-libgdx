package zw.swd.gui;

import zw.swd.graphics.Animation;
import zw.swd.math.Vector2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Picture extends Paper{

	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	public Picture() {
		// TODO Auto-generated constructor stub
		
	}
	public Picture(String fightAvatar) {
		// TODO Auto-generated constructor stub
		this.setAnimation(new Animation(fightAvatar));
		Vector2 size=this.getAnimation().getSize();
		this.setSize(size.x,size.y);
	}
	
	public void setPhysicSize(int width,int height)
	{
		if(this.getAnimation()!=null) this.getAnimation().setPhysicSize(width,height);
	}
	
	
	public Picture(String path,int width,int height)
	{
		this.setAnimation(new Animation(path,width,height));
		this.setSize(width,height);
	}
	
	public Picture(Texture texture)
	{
		this.setAnimation(new Animation(texture)); 
		Vector2 size=this.getAnimation().getSize();
		this.setSize(size.x,size.y);
		
	}
	
	public void setRegion(int x,int y,int width,int height)
	{
		this.getAnimation().getCurrentFrame().setRegion(x,y,width,height);
		this.setSize(width, height);
	}

	@Override
	public void setAnimation(Animation animation) {
		// TODO Auto-generated method stub
		super.setAnimation(animation);
		Vector2 size=this.getAnimation().getSize();
		this.setSize(size.x,size.y);
		
	}
	
	public int getPicWidth()
	{
		if(this.getAnimation()!=null)
		{
			if(this.getAnimation().frames.size()>0)
			{
				return this.getAnimation().frames.get(0).keys.get(0).texture.getRegionWidth();
			}
		}
		return 0;
	}
	
	public int getPicHeight()
	{
		if(this.getAnimation()!=null)
		{
			if(this.getAnimation().frames.size()>0)
			{
				return this.getAnimation().frames.get(0).keys.get(0).texture.getRegionHeight();
			}
		}
		return 0;
	}
	
	public void setPhysicHeight(int height)
	{
		if(this.getAnimation()!=null) this.getAnimation().setPhysicHeight(height);
	}
	
	public void setPhysicWidth(int width)
	{
		if(this.getAnimation()!=null) this.getAnimation().setPhysicWidth(width);
	}
}
