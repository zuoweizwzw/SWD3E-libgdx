package zw.swd.gui;

import zw.swd.game.GameItem;
import zw.swd.gui.list.SWDListItem;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIItemView extends Picture{

	public GUIItemView() {
		// TODO Auto-generated constructor stub
		this.setVisible(false);
		this.setSize(120, 220);
		this.setPosition(516, 172);
		this.setName("guiitemview");
	}
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		SWDListItem listItem=GUI.getInstance().itempane.itemwindow.getSelectedItem();
		if(listItem==null)
		{
			this.setVisible(false);
		}
	}
}
