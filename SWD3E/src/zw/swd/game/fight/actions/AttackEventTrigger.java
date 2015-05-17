package zw.swd.game.fight.actions;


import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import zw.swd.game.actions.ActorMoveAction;
import zw.swd.game.actions.AnimationAction;
import zw.swd.game.actions.SpriteFadeOutAction;
import zw.swd.game.fight.SkillModel;
import zw.swd.graphics.fight.FightRole;
import zw.swd.gui.GuiUtils;
import zw.swd.gui.Paper;
import zw.swd.main.App;
import zw.swd.main.Global;
import zw.swd.math.Vector2;
import zw.swd.screen.FightScreen;

public class AttackEventTrigger extends EventTrigger{

	public FightRoleAttackAction attack;
	public String[] triggerFrames;
	public int lastFrame=-1;
	public SkillModel skill;
	public FightRole target;
	public AttackEventTrigger(FightRoleAttackAction attack,FightRole target,SkillModel skill) {
		// TODO Auto-generated constructor stub
		this.attack=attack;
		this.triggerFrames=skill.hitframes;
		this.target=target;
		this.skill=skill;
	}

	private void playTargetHurt(FightRole target, int damage)
	{
		target.startSequenceAction(new AnimationAction(target,target.getFightAnimation("hurt")));
		target.addSequenceAction(new AnimationAction(target,target.getFightAnimation("stand")).setLoop(true));
		App game=(App)Gdx.app.getApplicationListener();
		
		FightScreen fightScreen=(FightScreen)game.currentScreen;
		Paper paper=GuiUtils.getNumberCombo(Integer.toString(damage),0);
		paper.setPosition((float)(target.getCoordX()+(target.ally?-40:40)),target.getCoordY()+40);
		fightScreen.guiMgr.addActor(paper);
		paper.addSequenceAction(new ActorMoveAction(paper,new Vector2(0,8),200f));
		paper.addSequenceAction(new ActorMoveAction(paper,new Vector2(0,-8),200f));
		paper.addSequenceAction(new ActorMoveAction(paper,new Vector2(0,8),200f));
		Action sequence=Actions.sequence(new ActorMoveAction(paper,new Vector2(0,-40),130f),new SpriteFadeOutAction(paper));
		paper.addSequenceAction(sequence);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		int currentFrame=attack.getCurrentAnimationFrame();
		if(currentFrame==lastFrame)
		{
			return;
		}
		else if(currentFrame==lastFrame+1)
		{
			
			lastFrame++;
			if(Arrays.asList(triggerFrames).contains(Integer.toString(lastFrame)))
			{				
				playTargetHurt(target,skill.damage);				
			}
			
			if(Integer.toString(lastFrame).equals(triggerFrames[triggerFrames.length-1]))
			{
				this.end=true;
			}
		}
	}

}
