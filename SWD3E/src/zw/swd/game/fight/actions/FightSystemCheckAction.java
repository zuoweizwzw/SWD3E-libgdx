package zw.swd.game.fight.actions;

import zw.swd.action.SWDAction;
import zw.swd.game.fight.FightModel;
import zw.swd.screen.FightScreen;

public class FightSystemCheckAction extends SWDAction{

	FightScreen fightScreen;
	public FightSystemCheckAction(FightScreen fightScreen) {
		// TODO Auto-generated constructor stub
		this.fightScreen=fightScreen;
	}

	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		FightModel fightModel=fightScreen.model;
		if(fightModel.enemies.size()==0)
		{
			
		}
		return false;
	}

}
