package zw.swd.game.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

import zw.swd.action.SWDAction;

public class RemoveActorAction extends SWDAction{

	Actor actor;
	int state=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(state==2) return true;
		if(state==0)
		{
			if(actor!=null) 
			{
				actor.remove();
				state=2;
				return true;
			}
			
		}
		return false;
		
	}
	
	public RemoveActorAction(Actor actor) {
		// TODO Auto-generated constructor stub
		this.actor=actor;
	}

}
