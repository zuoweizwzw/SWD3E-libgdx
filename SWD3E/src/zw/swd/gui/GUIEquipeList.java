package zw.swd.gui;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeList extends Paper{

	GUIEquipeListScroll scroll;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUIEquipeList() {
		// TODO Auto-generated constructor stub
		scroll=new GUIEquipeListScroll();
		scroll.setPosition(165, 0);
	}
}
