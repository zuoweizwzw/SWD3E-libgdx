package zw.swd.game.fight.actions;

import zw.swd.action.SWDAction;
import zw.swd.graphics.Animation;
import zw.swd.graphics.fight.FightRole;
import zw.swd.math.Vector2;
import zw.swd.screen.FightScreen;

public class FightRoleBackAction extends SWDAction{

	public FightRole source;
	public Animation animation;
	private Vector2 distance;
	private Vector2 unit;
	private float step=0;
	public int status=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			this.source.setAnimation(animation);
			animation.reset();
			step=animation.getTotalDuration();
			animation.setAutoUpdate(false);
			float orignalx;
			float targetx;
			orignalx=source.getCoordX();
			float targety;
			if(source.ally)
			{
				targetx=FightScreen.alliesPositions.get(source.index).x;
				targety=FightScreen.alliesPositions.get(source.index).y;
			}
			else
			{
				targetx=FightScreen.enemiesPositions.get(source.index).x;
				targety=FightScreen.enemiesPositions.get(source.index).y;
			}
			float orignaly;
			orignaly=source.getCoordY();
			distance=new Vector2(targetx-orignalx,targety-orignaly);
			unit=distance.divNew((float)(step));
			status=1;
			
		}
		if(status==1)
		{
			step-=delta;
			if(step<=0)
			{
				if(source.ally)
				{
//					source.setLocation(520, 180+source.index*100);
					source.setCoord(FightScreen.alliesPositions.get(source.index));
				}
				else
				{
					source.setCoord(FightScreen.enemiesPositions.get(source.index));
				}
				status=2;
				return true;
			}
			
			animation.nextFrame(delta);
			source.moveBy(unit.mulNew(delta).x, unit.mulNew(delta).y);
			
		}
		return false;
	}
	public FightRoleBackAction(FightRole source, Animation animation)
	{
		this.source=source;
		this.animation=animation;
	}
}
