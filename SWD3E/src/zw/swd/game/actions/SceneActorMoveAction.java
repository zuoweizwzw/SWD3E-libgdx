package zw.swd.game.actions;

import zw.swd.action.SWDAction;

import com.badlogic.gdx.scenes.scene2d.Action;

public abstract class SceneActorMoveAction extends SWDAction{

	public boolean stopCmd=false;
	public int direction;
	public boolean checkColis=false;
	public void sendStopCmd()
	{
		this.stopCmd=true;
	}
	
	public abstract void changeDirection(int direction);
	}

