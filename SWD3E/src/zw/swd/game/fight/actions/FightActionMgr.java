package zw.swd.game.fight.actions;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;

import zw.swd.game.MagicModel;
import zw.swd.game.actions.ActorMoveAction;
import zw.swd.game.actions.AnimationAction;
import zw.swd.game.actions.RemoveActorAction;
import zw.swd.game.actions.WaitAction;
import zw.swd.game.fight.SkillModel;
import zw.swd.graphics.fight.FightRole;
import zw.swd.gui.MagicCaption;
import zw.swd.gui.Paper;
import zw.swd.gui.Picture;
import zw.swd.main.App;
import zw.swd.math.Vector2;
import zw.swd.screen.FightScreen;

public class FightActionMgr {

	public ArrayList<EventTrigger> triggers=new ArrayList<EventTrigger>();
	public FightScreen fightScreen;
	public void update()
	{
		for(int i=0;i<triggers.size();i++)
		{
			EventTrigger trigger=triggers.get(i);
			if(!trigger.end)
			{
				trigger.update();
			}
			else
			{
				triggers.remove(trigger);
			}
		}
	}
	
	public FightActionMgr(FightScreen fightScreen)
	{
		this.fightScreen=fightScreen;
	}
	
	public void playAttack(FightRole source, FightRole target, SkillModel skill)
	{
		source.startSequenceAction(new FightRoleMoveAction(source,
				target,source.getFightAnimation("move")));
		FightRoleAttackAction attack=new FightRoleAttackAction(source,source.getFightAnimation((skill.res)),
				target);
		source.addSequenceAction(attack);
		source.addSequenceAction(new FightRoleBackAction(source,source.getFightAnimation("back")));
		source.addSequenceAction(new ChangeStateAction(fightScreen,-1));
		source.addSequenceAction(new AnimationAction(source,source.getFightAnimation("stand")).setLoop(true));
		
		AttackEventTrigger trigger=new AttackEventTrigger(attack,target,skill);
		this.triggers.add(trigger);
		
	}
	
	public void playCast(FightRole source, FightRole[] targets, MagicModel magic)
	{
		source.startSequenceAction(new AnimationAction(source,source.getFightAnimation("preparecast")));
		source.addSequenceAction(new AnimationAction(source,source.getFightAnimation("cast")));
		
		
		
		if(magic.aoe)
		{
			Paper magicPaper=new Picture();
			
			
			magicPaper.setAlpha(0.7f);
			Vector2 offset=magic.offset;
			magicPaper.setPosition(offset.x,offset.y);
			FightScreen screen=(FightScreen) ((App)Gdx.app.getApplicationListener()).currentScreen;
			screen.magicgroup.addActor(magicPaper);
			AnimationAction magicAnimation=new AnimationAction(true,magicPaper,magic.anis);
			source.addSequenceAction(magicAnimation);
			source.addSequenceAction(new ChangeStateAction(fightScreen,-1));
			source.addSequenceAction(new AnimationAction(source,source.getFightAnimation("stand")).setLoop(true));
			MagicEventTrigger trigger=new MagicEventTrigger(magicAnimation,targets,magic);
			this.triggers.add(trigger);
			
			MagicCaption caption=new MagicCaption();
			caption.setText(magic.name);
			caption.setPosition(230, 520);
			screen.magicgroup.addActor(caption);
			ActorMoveAction movedown=new ActorMoveAction(caption, new Vector2(0,-80), 150f);
			caption.startSequenceAction(movedown);
			caption.addSequenceAction(new WaitAction(3.5f));
			ActorMoveAction moveup=new ActorMoveAction(caption, new Vector2(0,80), 200f);
			caption.addSequenceAction(moveup);
			caption.addSequenceAction(new RemoveActorAction(caption));
		}
		else
		{
			
		}
		
		
	}
}
