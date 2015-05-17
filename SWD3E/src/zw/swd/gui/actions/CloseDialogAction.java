package zw.swd.gui.actions;

import zw.swd.action.SWDAction;
import zw.swd.gui.Dialog1;
import zw.swd.screen.SWDScreen;

import com.badlogic.gdx.scenes.scene2d.Action;

public class CloseDialogAction extends SWDAction{

	public SWDScreen screen;
	public int status=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		Dialog1 dialog=(Dialog1)screen.guiMgr.findActorByName("gui/dialog1");
		if(status==0)
		{
			dialog.clearText();
			status=1;
		}
		if(status==1)
		{
			dialog.background.setWidth(dialog.background.getWidth()-delta*2400);
			dialog.face.moveBy(-8.8f, 0);
			if(dialog.background.getWidth()<=0)
			{
				dialog.background.setWidth(0);
				dialog.face.setX(0-dialog.face.getWidth());
				dialog.setVisible(false);
				this.status=2;
				return true;
			}
		}
		return false;
	}

	public CloseDialogAction(SWDScreen screen) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
	}
}
