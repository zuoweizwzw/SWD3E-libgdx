package zw.swd.game.actions;

import zw.swd.action.SWDAction;

public class WaitAction extends SWDAction{

	float seconds=0;
	int state=0;
	float count=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(state==2) return true;
		if(state==0)
		{
			count+=delta;
			if(count>=seconds)
			{
				state=2;
				return true;
			}
		}
		return false;
	}

	public WaitAction(float seconds) {
		// TODO Auto-generated constructor stub
		this.seconds=seconds;
	}
}
