package zw.swd.scene.scripts;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import zw.swd.action.SWDAction;
import zw.swd.game.actions.AnimationAction;
import zw.swd.game.actions.SceneActorRunAction;
import zw.swd.game.actions.SceneActorWalkAction;
import zw.swd.gui.GuiMgr;
import zw.swd.gui.actions.CloseDialogAction;
import zw.swd.gui.actions.OpenDialogAction;
import zw.swd.gui.actions.ShowDialogTextAction;
import zw.swd.gui.actions.StartFightAction;
import zw.swd.gui.actions.WaitMouseClickAction;
import zw.swd.math.Vector2;
import zw.swd.screen.SceneScreen;

public class SceneScriptsEngine {

	SceneScreen screen;
	SceneScript currentScript;
	public SceneScriptsEngine(SceneScreen sceneScreen) {
		// TODO Auto-generated constructor stub
		this.screen=sceneScreen;
	}

	public Action opendialog()
	{
		SWDAction action=new OpenDialogAction(screen,"face/001/1r");
		action.setScript(currentScript);
		return action;
	}
	
	public Action closedialog()
	{
		Action action=new CloseDialogAction(screen);
		return action;
	}
	
	public void sequence(Action...actions)
	{
		this.screen.addActions(actions);
	}

	public Action showmsg(String msg)
	{
		SequenceAction sequence=new SequenceAction();
		Action action=new ShowDialogTextAction(screen,msg);
		sequence.addAction(action);
		sequence.addAction(new WaitMouseClickAction());
		return sequence;
	}
	
	public Action walkactor(String actorID, int deltax,int deltay)
	{
		Action action=new SceneActorWalkAction(new Vector2(deltax,deltay),screen.actor);
		return action;
	}
	public Action playactorani(String actorID,String ani)
	{
		Action action=new AnimationAction(screen.actor,screen.actor.getCurrentAniByName(ani));
		return action;
	}
	public Action startfight(String fightmodel)
	{
		Action action=new StartFightAction(screen);
		return action;
	}
	
	
}
