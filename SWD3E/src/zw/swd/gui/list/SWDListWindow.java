package zw.swd.gui.list;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;

import zw.swd.gui.Paper;
import zw.swd.gui.Picture;
import zw.swd.gui.special.WindowStyle1;

public class SWDListWindow extends Paper{

	public SWDList list;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	public SWDListWindow(int width,int height,int capacity) {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);
		this.setName("swdlistwindow");
		Picture background=WindowStyle1.createInstance(width, height);
		this.addActor(background);
		
		list=new SWDList(width-8, height-8, capacity);
		list.setPosition(4, 4);
		this.addActor(list);
		
	}
	
	public void fillData(ArrayList data)
	{
		this.list.fillData(data);
	}
	
	public void setItemType(Class<? extends SWDListItem> clazz)
	{
		this.list.setItemType(clazz);
	}

	public void setListYOffset(int y)
	{
		this.list.setListYOffset(y);
	}
	
	public void updataData()
	{
		this.list.updateData();
	}
	
	public void updateData(ArrayList data)
	{
		this.list.updateData(data);
	}
	
	public void reset()
	{
		this.list.reset();
	}
}
