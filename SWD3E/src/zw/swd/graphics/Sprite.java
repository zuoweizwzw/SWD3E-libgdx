package zw.swd.graphics;

import zw.swd.gui.Paper;
import zw.swd.math.Vector2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author zuowei
 *
 */
/**
 * @author zuowei
 *
 */
public class Sprite extends Actor implements AnimatedActor{
	private Animation currentAnimation;
	public Vector2 mainOffset=new Vector2();
	private Vector2 coord=new Vector2();
	public float alpha=1;
	public Rectangle collisBox;
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
	if(currentAnimation!=null) 
		{
		
			currentAnimation.draw(this.getX(), this.getY(), batch,getColor(),alpha);
			if(currentAnimation.frames.size()>0)
			{
				this.setHeight(currentAnimation.getSize().y);
				this.setWidth(currentAnimation.getSize().x);
			}
		}
	
	}

	public void setAutoUpdate(boolean autoUpdate)
	{
		this.currentAnimation.autoUpdate=autoUpdate;
	}
	
	public Sprite(String filePath) {
		// TODO Auto-generated constructor stub
		currentAnimation=new Animation(filePath);
	}
	
	
	public Sprite(){
		
	}
	
	public void setAnimation(Animation animation)
	{
		this.currentAnimation=animation;
		this.mainOffset=animation.mainOffset;
		this.setPosition(this.coord.x-animation.mainOffset.x, this.coord.y-animation.mainOffset.y);
		this.collisBox=animation.colisBox;
	}
	
	public Animation getAnimation()
	{
		return this.currentAnimation;
	}
	
	
	public void setCoord(float x, float y)	
	{
		this.coord.set(x, y);
		if(this.currentAnimation!=null)
		{
			this.setPosition(x-currentAnimation.mainOffset.x, y-currentAnimation.mainOffset.y);
		}
	}
	
	public void setCoord(Vector2 v)
	{
		this.setCoord(v.x, v.y);
	}
	
	public Animation getCurrentAni()
	{
		return this.currentAnimation;
	}
	
	public float getCoordX()
	{
		return this.coord.x;
	}
	
	public float getCoordY()
	{
		return this.coord.y;
	}
	
	public Vector2 getCoordCopy()
	{
		return new Vector2(coord.x,coord.y);
	}
	
	@Override
	public void moveBy(float x, float y) {
		// TODO Auto-generated method stub
		if (x != 0 || y != 0) {
			this.coord.x += x;
			this.coord.y += y;
			this.setCoord(coord.x, coord.y);
			positionChanged();
		}
	}
	
	@Override
	protected void positionChanged() {
		// TODO Auto-generated method stub
		if(this.getParent()!=null&&this.getParent() instanceof SceneGroup)
		{
			SceneGroup group=(SceneGroup)this.getParent();
			if(group!=null) group.sort();
		}
	}
	
	/**
	 * get center point from local position
	 */
	public Vector2 getCenterPoint()
	{
		return new Vector2(this.getX()+this.currentAnimation.centerPoint.x,this.getY()+this.currentAnimation.centerPoint.y);
	}

	@Override
	public void setAlpha(float alpha) {
		// TODO Auto-generated method stub
		this.alpha=alpha;
	}

	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return this.alpha;
	}
	
	public boolean isMouseIn()
	{
		int x=Gdx.input.getX();
		int y=480-Gdx.input.getY();
		Sprite paper=(Sprite)this;
		Vector2 v=new Vector2(this.getX(),this.getY());
		Rectangle rect=new Rectangle(v.x,v.y,paper.getWidth(),paper.getHeight());
		if(rect.contains(x, y))
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void setAnimation(String path) {
		// TODO Auto-generated method stub
		this.currentAnimation=new Animation(path);
		this.mainOffset=currentAnimation.mainOffset;
		this.setPosition(this.coord.x-currentAnimation.mainOffset.x, this.coord.y-currentAnimation.mainOffset.y);
		this.collisBox=currentAnimation.colisBox;
	}

	public boolean isColis(Sprite source) {
		// TODO Auto-generated method stub
		return collisBox.overlaps(source.collisBox);
	}
	
	
	
}
