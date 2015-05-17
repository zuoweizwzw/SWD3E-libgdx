package zw.swd.game.actions;

import zw.swd.graphics.scene.SceneActor;
import zw.swd.math.Vector2;
import zw.swd.utils.Mappings;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction;

public class SceneActorWalkAction extends SceneActorMoveAction{

	public boolean half;
	public SceneActor actor;
	public int status=0;
	public Vector2 delta;
	public Vector2 targetDelta;

	public SceneActorWalkAction(int direction, SceneActor actor) {
		// TODO Auto-generated constructor stub
		this.actor=actor;
		this.direction=direction;
	}
	
	public SceneActorWalkAction(Vector2 delta, SceneActor actor) {
		// TODO Auto-generated constructor stub
		this.actor=actor;
		this.direction=Mappings.getDirectionByNormalVector(delta);
		this.delta=delta;
	}

	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==2) return true;
		if(status==0)
		{
		this.actor.setCurrentAniByName("walk_"+Mappings.getDirectionNameByDirection(direction));
		this.actor.getCurrentAni().setLoop(true);
		this.actor.setAutoUpdate(false);
		if(this.delta!=null) targetDelta=new Vector2();
		status=1;
		}
		if(status==1)
		{
			{
				if(this.delta==null)
				{
				if(stopCmd==true) 
				{
					if(this.actor.getCurrentAni().getCurrentFrameIndex()==3||
							this.actor.getCurrentAni().getCurrentFrameIndex()==7)
					{
						this.status=2;
						this.actor.nextAni("stand_"+Mappings.getDirectionNameByDirection(direction));
						return true;
					}
				}
				}
				else
				{
					if(this.targetDelta.len()>=this.delta.len())
					{
						this.status=2;
						this.actor.nextAni("stand_"+Mappings.getDirectionNameByDirection(direction));
						Vector2 offset=this.delta.subNew(this.targetDelta);
						this.actor.moveBy(offset.x, offset.y);
						return true;
					}
				}
				this.actor.getCurrentAni().nextFrame(delta);
				Vector2 direction=Mappings.getDirectionVectorByDirection(this.direction);
				this.actor.moveBy(delta*direction.x*32, delta*direction.y*32);
				if(this.delta!=null)
				{
					this.targetDelta.add(delta*direction.x*32, delta*direction.y*32);
				}
//				this.actor.moveBy(direction.x, y);
			}
		}
		return false;
	}

	public void changeDirection(int direction) {
		// TODO Auto-generated method stub
		this.direction=direction;
		this.actor.setCurrentAniByName("walk_"+Mappings.getDirectionNameByDirection(direction));
		this.actor.getCurrentAni().setLoop(true);
		this.actor.setAutoUpdate(false);
		status=1;
	}
}
