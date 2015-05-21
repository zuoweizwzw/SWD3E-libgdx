package zw.swd.gui;

import zw.swd.gui.special.WindowStyle1;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeStatusWindow extends Paper{

	Picture background;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUIEquipeStatusWindow() {
		// TODO Auto-generated constructor stub
		this.setName("guiequipestatuswindow");
		
		this.background=WindowStyle1.createInstance(235, 328);
		this.addActor(background);
	}
}
