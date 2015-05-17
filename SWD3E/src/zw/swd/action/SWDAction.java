package zw.swd.action;

import zw.swd.main.Global;
import zw.swd.scene.scripts.SceneScript;

import com.badlogic.gdx.scenes.scene2d.Action;

public abstract class SWDAction extends Action{

	public int id=-1;
	public SWDAction() {
		// TODO Auto-generated constructor stub
		id=Global.getID();
	}
	
	public SceneScript script;
	
	public void notifyScriptUpdate()
	{
		if(script!=null) script.invokeUpdate(this);
	}
	
	public void notifyScriptFinished()
	{
		if(script!=null) script.invokeFinished(this);
	}
	
	public void setScript(SceneScript script)
	{
		this.script=script;
	}
}
