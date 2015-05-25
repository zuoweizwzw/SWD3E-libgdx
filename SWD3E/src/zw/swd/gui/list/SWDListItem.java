package zw.swd.gui.list;

import com.badlogic.gdx.graphics.g2d.Batch;

import zw.swd.gui.Paper;

public class SWDListItem extends Paper{

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(this.isMouseIn())
		{
			drawBorder(batch, parentAlpha);
			
		}
	}
	
	public SWDListItem(int width,int height) {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);
	}

	public void fillData(Object o) {
		// TODO Auto-generated method stub
		
	}

}
