package zw.swd.game.actions;

import zw.swd.action.SWDAction;
import zw.swd.graphics.AnimatedActor;
import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AnimationAction extends SWDAction {

	public int state=0;
	public Animation animation;
	public AnimatedActor actor;
	public boolean loop=false;
	private boolean removeActoronEnd=false;
	
	
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(state==2) return true;
		if(state==0)
		{
			animation.restart();
			animation.autoUpdate=false;
			animation.setLoop(loop);
			this.actor.setAnimation(animation);
			state=1;
			
		}
		if(state==1) 
		{
			
			if(animation.currentFrame==animation.frames.size()-1&&!loop)
			{
				state=2;
//				animation.reset();
				if(this.removeActoronEnd) this.actor.remove();
				return true;
			}
			else animation.nextFrame(delta);
		}
		
		return false;
	}

	public AnimationAction(AnimatedActor actor,Animation animation) {
		// TODO Auto-generated constructor stub
		this.animation=animation;
		
		this.actor=actor;
	}
	
	public AnimationAction(boolean removeActoronEnd,AnimatedActor actor,Animation animation) {
		// TODO Auto-generated constructor stub
		this.animation=animation;
		this.removeActoronEnd=removeActoronEnd;
		this.actor=actor;
	}
	
	public AnimationAction(AnimatedActor actor,Animation animation,boolean loop)
	{
		this.animation=animation;
		this.actor=actor;
		this.loop=loop;
	}

	public Action setLoop(boolean loop) {
		// TODO Auto-generated method stub
		this.loop=loop;
		return this;
	}

	public int getCurrentAnimationFrame() {
		// TODO Auto-generated method stub
		return animation.currentFrame;
	}
	

}
