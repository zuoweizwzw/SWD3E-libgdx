package zw.swd.gui.actions;

import zw.swd.action.SWDAction;
import zw.swd.gui.Dialog1;
import zw.swd.gui.Paper;
import zw.swd.gui.Picture;
import zw.swd.screen.SWDScreen;
import zw.swd.utils.FaceLoader;

import com.badlogic.gdx.scenes.scene2d.Action;

public class OpenDialogAction extends SWDAction{

	SWDScreen screen;
	public int status=0;
	Dialog1 dialog;
	public OpenDialogAction(SWDScreen screen,String faceRes) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
		Dialog1 dialog=(Dialog1)screen.guiMgr.findActorByName("gui/dialog1");
		this.dialog=dialog;
		dialog.face.setAnimation(FaceLoader.faces.get(faceRes));
		
	}
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		
		if(this.status==0)
		{
			dialog.face.setX(0-dialog.face.getWidth());
			dialog.clearText();
			dialog.setVisible(true);
			dialog.background.setWidth(0);
			this.status=1;
		}
		if(this.status==1)
		{
			dialog.background.setWidth(dialog.background.getWidth()+delta*2400);
			dialog.face.moveBy(8.8f, 0);
			if(dialog.background.getWidth()>=640)
			{
				dialog.background.setWidth(640);
				dialog.face.setX(-10);
				this.status=2;
				this.notifyScriptFinished();
				return true;
			}
		}
		return false;
		
	}

}
