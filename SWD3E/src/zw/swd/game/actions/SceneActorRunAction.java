package zw.swd.game.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

import zw.swd.graphics.scene.SceneActor;
import zw.swd.math.Vector2;
import zw.swd.utils.Mappings;

public class SceneActorRunAction extends SceneActorMoveAction{
	public boolean half;
	public SceneActor actor;
	public int status=0;

	public SceneActorRunAction(int direction, SceneActor actor) {
		// TODO Auto-generated constructor stub
		this.actor=actor;
		this.direction=direction;
		
	}

	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==2) return true;
		if(status==0)
		{
		this.actor.setCurrentAniByName("run_"+Mappings.getDirectionNameByDirection(direction));
		this.actor.getCurrentAni().setLoop(true);
		this.actor.setAutoUpdate(false);
		status=1;
		}
		if(status==1)
		{
//			if(actor.getCurrentAni().currentFrame==actor.getCurrentAni().frames.size()-1)
//			{
////				status=2;
////				return true;
//			}
//			else 
			{
				if(stopCmd==true) 
				{
					if(this.actor.getCurrentAni().getCurrentFrameIndex()==3)
					{
						this.status=2;
						this.actor.nextAni("stand_"+Mappings.getDirectionNameByDirection(direction));
						return true;
					}
				}
				this.actor.getCurrentAni().nextFrame(delta);
				Vector2 direction=Mappings.getDirectionVectorByDirection(this.direction);
				this.actor.moveBy(delta*direction.x*64, delta*direction.y*64);
				
//				this.actor.moveBy(direction.x, y);
			}
		}
		return false;
	}

	public void changeDirection(int direction) {
		// TODO Auto-generated method stub
		this.direction=direction;
		this.actor.setCurrentAniByName("run_"+Mappings.getDirectionNameByDirection(direction));
		this.actor.getCurrentAni().setLoop(true);
		this.actor.setAutoUpdate(false);
		status=1;
	}
}
