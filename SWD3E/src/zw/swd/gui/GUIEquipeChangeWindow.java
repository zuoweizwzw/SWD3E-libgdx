package zw.swd.gui;

import zw.swd.gui.special.WindowStyle1;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeChangeWindow extends Paper{

	Picture background;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUIEquipeChangeWindow() {
		// TODO Auto-generated constructor stub
		background=WindowStyle1.createInstance(186, 94);
		this.addActor(background);
	}
}