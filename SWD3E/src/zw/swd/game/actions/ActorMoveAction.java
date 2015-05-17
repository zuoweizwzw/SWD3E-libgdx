package zw.swd.game.actions;

import zw.swd.action.SWDAction;
import zw.swd.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;



	public class ActorMoveAction extends SWDAction{

		public Vector2 direction;
		public float speed;
		public Actor actor;
		public float totalDuration;
		public float steps;
		public Vector2 orignalLocation;
		public int status=0;
		

		public ActorMoveAction(Actor actor, Vector2 direction, float speed)
		{
			this.actor=actor;
			this.direction=direction;
			this.speed=speed;
			totalDuration=(direction.len()/speed);
			steps=totalDuration;
			orignalLocation=new Vector2(actor.getX(),actor.getY());
		}
		
		@Override
		public boolean act(float delta) {
			// TODO Auto-generated method stub
			if(status==0)
			{
				status=1;
			}
			if(status==1)
			{
				Vector2 v=direction.divNew(totalDuration).mulNew(delta);
				
				actor.moveBy(v.x,v.y);
				steps-=delta;
				if(steps<=0)
				{
					Vector2 target=orignalLocation.addNew(direction);
					actor.setPosition(target.x,target.y);
					this.status=2;
					return true;
				}
				
			}
			return false;
		}
	}



	




