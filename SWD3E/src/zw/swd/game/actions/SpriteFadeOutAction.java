package zw.swd.game.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

import zw.swd.action.SWDAction;
import zw.swd.graphics.AnimatedActor;

public class SpriteFadeOutAction extends SWDAction{

	AnimatedActor actor;
	float currentAlpha;
	public int status=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			currentAlpha=actor.getAlpha();
			status=1;
		}
		if(status==1)
		{
			currentAlpha-=delta;
			actor.setAlpha(currentAlpha);
			
			if(currentAlpha<=0)
			{
				this.status=2;
				((Actor)actor).remove();
				
				return true;
			}
		}
		return false;
	}
	public SpriteFadeOutAction(AnimatedActor actor)
	{
		this.actor=actor;
	}

}
