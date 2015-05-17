package zw.swd.game.fight.actions;

import zw.swd.action.SWDAction;
import zw.swd.graphics.Animation;
import zw.swd.graphics.fight.FightRole;
import zw.swd.math.Vector2;

public class FightRoleMoveAction extends SWDAction{

	public FightRole source;
	public FightRole target;
	public int status=0;
	Animation animation;
	private Vector2 distance;
	private Vector2 unit;
	private float step=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==2) return true;
		if(status==0)
		{
			this.source.setAnimation(animation);
			animation.reset();
			step=animation.getTotalDuration();
			animation.setAutoUpdate(false);
			float orignalx=0;
			float targetx=0;
			orignalx=(int) (this.source.getCoordX()+ (Integer)this.source.getAnimation().userData.get("leftAlign"));
			targetx=(int) (target.getCoordX()+(Integer)this.target.getAnimation().userData.get("leftAlign"));
			float deltay=(int) (target.getCoordY()-source.getCoordY()-1);
			distance=new Vector2(targetx-orignalx,deltay);
			unit=distance.divNew(step);
			status=1;
			
		}
		if(status==1)
		{
			step-=delta;
			if(step<=0) 
			{
				status=2;
				return true;
			}
			animation.nextFrame(delta);
			
			source.moveBy(unit.mulNew(delta).x, unit.mulNew(delta).y);
			
		}
		return false;
	}
	public FightRoleMoveAction(FightRole source, FightRole target,Animation animation) {
		// TODO Auto-generated constructor stub
		this.source=source;
		this.target=target;
		this.animation=animation;
	}

}
