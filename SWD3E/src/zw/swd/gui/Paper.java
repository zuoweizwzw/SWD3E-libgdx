package zw.swd.gui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import zw.swd.graphics.AnimatedActor;
import zw.swd.graphics.Animation;

public abstract class Paper extends Group implements AnimatedActor{

	protected Animation currentAnimation;
	public Vector2 scaleSize;
	
	private boolean isActing=false;;
	
	ShapeRenderer renderer=new ShapeRenderer();
	public float alpha=1;
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(!this.isVisible()) return;
		
		if(currentAnimation!=null) 
		{		
			currentAnimation.draw(this.getX(), this.getY(), batch,getColor(),alpha);	
		}
		
		drawCustomer(batch,parentAlpha);
		
		super.draw(batch, parentAlpha);
		
		
	}
	
	

	public abstract void drawCustomer(Batch batch, float parentAlpha);
	
	public Vector2 getStagePosition()
	{
		Vector2 v=this.localToStageCoordinates(new Vector2(0,0));
		return v;
	}
	public Paper() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void setAnimation(Animation animation)
	{
		this.currentAnimation=animation;
//		if(animation.frames.size()>0) this.setWidth(animation.frames.get(0).keys.get(0).texture.getRegionWidth());
		this.copyAniSize(animation);
	}
	private void copyAniSize(Animation animation) {
		// TODO Auto-generated method stub
		if(animation!=null)
		{
			if(animation.frames.size()>0)
			{
				this.setWidth(animation.frames.get(0).keys.get(0).texture.getRegionWidth());
				this.setHeight(animation.frames.get(0).keys.get(0).texture.getRegionHeight());
			}
		}
	}

	@Override
	public Animation getAnimation()
	{
		return this.currentAnimation;
	}
	@Override
	public void setAlpha(float alpha)
	{
		
		this.alpha=alpha;
		for(Actor actor: this.getChildren())
		{
			Paper paper=(Paper)(actor);
			paper.setAlpha(alpha);
		}
	}
	@Override
	public float getAlpha()
	{
		return this.alpha;
	}
	
	
	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		super.setVisible(visible);
	}
	
	public boolean isMouseIn()
	{
		int x=Gdx.input.getX();
		int y=480-Gdx.input.getY();
		Paper paper=(Paper)this;
		Vector2 v=paper.getStagePosition();
		Rectangle rect=new Rectangle(v.x,v.y,paper.getWidth(),paper.getHeight());
		if(rect.contains(x, y))
		{
			
			return true;
		}
		return false;
		
	}
	
	public void isClick(int button)
	{
		
	}
	
	protected void drawBorder(Batch batch, float parentAlpha)
	{
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		renderer.begin(ShapeType.Line);
		renderer.setColor(this.getColor());
		Vector2 v=this.getStagePosition();
		renderer.rect(v.x,v.y, this.getWidth(), this.getHeight());
		
		renderer.end();
		
		batch.begin();
	}
	
	protected void drawRect(Batch batch,float parentAlpha) {
		// TODO Auto-generated method stub
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		renderer.begin(ShapeType.Filled);
		renderer.setColor(this.getColor());
		Vector2 v=this.getStagePosition();
		renderer.rect(v.x,v.y, this.getWidth(), this.getHeight());
		renderer.end();
		batch.begin();
		
	}
	//no mouseIn assert	
	public void  onClickEvent(int button)
	{
		for(Paper paper:this.getAllPapers())
		{
			if(paper.isVisible()) paper.onClickEvent(button);
		}
	}
	
	public void copySize(Paper paper)
	{
		
		this.setWidth(paper.getWidth());
		this.setHeight(paper.getHeight());
	}
	
	public ArrayList<Paper> getAllPapers()
	{
		ArrayList<Paper> papers=new ArrayList<>();
		
		for(Actor actor:this.getChildren())
		{
			if(actor instanceof Paper)
			{
				papers.add((Paper)actor);
			}
		}
		return papers;
	}
	
	public ArrayList<Paper> getAllDeepPapers()
	{
		ArrayList<Paper> papers=new ArrayList<>();
		for(Paper paper:getAllPapers())
		{
			papers.add(paper);
			papers.addAll(paper.getAllDeepPapers());
		}
		return papers;
	}
	
	public boolean isActing()
	{
		if(this.rootSequence.size()!=0||this.getActions().size!=0)
		{
			return true;
		}
		else return false;
	}
	
}
