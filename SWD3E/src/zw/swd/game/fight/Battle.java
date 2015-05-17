package zw.swd.game.fight;

import java.util.ArrayList;
import java.util.LinkedList;

import zw.swd.graphics.fight.FightRole;
import zw.swd.gui.FightCmdWindow;
import zw.swd.screen.FightScreen;

public class Battle {

	public float timer=0;
	
	public ArrayList<FightRole> actionList=new ArrayList<>();
	public ArrayList<FightRole> allies=new ArrayList<FightRole>();
	public ArrayList<FightRole> enemies=new ArrayList<FightRole>();
	public FightRole currentRole;
	FightScreen fightScreen;
	public Battle(FightScreen fightScreen) {
		// TODO Auto-generated constructor stub
		this.fightScreen=fightScreen;
	}
	public void update(float delta)
	{
		if(fightScreen.state==-1)
		{
		timer+=delta;
		if(timer>=1)
		{
			nextTurn();
		}
		}
		
	}
	private void nextTurn() {
		// TODO Auto-generated method stub
		timer=0;
		int index=-1;
		if(currentRole!=null) 
			{
			index=actionList.indexOf(currentRole);
			index++;
			if(index==actionList.size()) index=0;
			}
		else index=0;
		currentRole=actionList.get(index);
		if(currentRole.ally)
		{
			fightScreen.guiMgr.findActorByName("fightcmdwindow").setVisible(true);
			((FightCmdWindow)fightScreen.guiMgr.findActorByName("fightcmdwindow")).setRoleModel(currentRole.roleModel);
			fightScreen.state=0;
		}
		else
		{
			fightScreen.state=2;
			fightScreen.actionMgr.playAttack(currentRole, this.allies.get(0), currentRole.roleModel.skills.get(currentRole.roleModel.resCode+"/attack1"));
//			currentRole=null;
		}
		
	}
}
