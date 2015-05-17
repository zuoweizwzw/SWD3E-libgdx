package zw.swd.game.fight.actions;

import zw.swd.action.SWDAction;
import zw.swd.graphics.Animation;
import zw.swd.graphics.fight.FightRole;

public class FightRoleAttackAction extends SWDAction{

	public int status=0;
	FightRole source;
	FightRole target;
	Animation animation;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==2) return true;
		if(status==0)
		{
			this.source.setAnimation(animation);
			animation.reset();
			animation.setLoop(false);
			animation.setAutoUpdate(false);
			status=1;
		}
		if(status==1)
		{
			if(animation.getCurrentFrameIndex()==animation.getFrames().size()-1)
			{
				this.status=2;
			}
			animation.nextFrame(delta);
		}
		return false;
	}
	
	public FightRoleAttackAction(FightRole source, Animation animation, FightRole target) {
		// TODO Auto-generated constructor stub
		this.source=source;
		this.target=target;
		this.animation=animation;
	}

	public int getCurrentAnimationFrame()
	{
		return this.animation.getCurrentFrameIndex();
	}
}
