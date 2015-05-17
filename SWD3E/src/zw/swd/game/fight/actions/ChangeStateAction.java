package zw.swd.game.fight.actions;

import zw.swd.action.SWDAction;
import zw.swd.screen.FightScreen;

public class ChangeStateAction extends SWDAction{

	public FightScreen fightScreen;
	int status;
	int state;
	@Override
	public boolean act(float delta) {
		
		// TODO Auto-generated method stub
		if(status==2) return true;
		if(status==0)
		{
			fightScreen.state=this.state;
			status=2;
			return true;
		}
		return false;
	}

	public ChangeStateAction(FightScreen fightScreen,int state) {
		// TODO Auto-generated constructor stub
		this.fightScreen=fightScreen;
		this.state=state;
	}
}
