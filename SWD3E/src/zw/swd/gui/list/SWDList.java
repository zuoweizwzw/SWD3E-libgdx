package zw.swd.gui.list;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import zw.swd.gui.Paper;
public class SWDList extends Paper{

	SWDListScroll scroll;
	public int capacity=0;
	public ArrayList data;
	public int listYOffset=0;
	public Class<? extends SWDListItem> clazz;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		Color old=new Color(this.getColor());
		this.setColor(new Color(0,0,1,1));
		this.drawBorder(batch, parentAlpha);
		this.setColor(old);
	}
	
	public SWDList(int width,int height,int capacity) {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);
		this.capacity=capacity;
		this.clazz=SWDListItem.class;
		scroll=new SWDListScroll(height,capacity);
		scroll.setPosition(width-16, 0);
		scroll.setVisible(false);
		this.addActor(scroll);
	}
	
	public void setCapacity(int capacity)
	{
		this.capacity=capacity;
	}
	
	public void fillData(ArrayList data)
	{
		this.data=data;
		scroll.setMaxCap(data.size());
		if(data.size()<=capacity) this.scroll.setVisible(false);
		else this.scroll.setVisible(true);
		int heightperitem=((int)this.getHeight()-capacity)/capacity;
		for(SWDListItem item:this.getListItems())
		{
			item.remove();
		}
		for(int i=0;i<data.size();i++)
		{
			Object o=data.get(i);
			SWDListItem item=null;
			try {
				Constructor<SWDListItem> c=(Constructor<SWDListItem>) clazz.getConstructor(int.class,int.class);
				item=c.newInstance((int)this.getWidth()-20,heightperitem);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			item.setY((this.getHeight()-heightperitem)-i*heightperitem-i+this.listYOffset);			
			if(i<scroll.index||i>=scroll.index+capacity)
			{
				item.setVisible(false);
			}
			item.fillData(o);
			this.addActor(item);
			
		}
	}
	
	public void setItemType(Class<? extends SWDListItem> clazz)
	{
		this.clazz=clazz;
	}
	
	public void scrollData()
	{
		ArrayList<SWDListItem> items=this.getListItems();
		int heightperitem=((int)this.getHeight()-capacity)/capacity;
		int i=0;
		for(int j=0;j<items.size();j++)
		{
			SWDListItem item=items.get(j);
			if(j>=scroll.index&&j<scroll.index+capacity)
			{
				item.setY((this.getHeight()-heightperitem)-i*heightperitem-i+this.listYOffset);
				item.setVisible(true);
				item.fillData(item.data);
				i++;
			}
			else item.setVisible(false);
		}
	}
	
	public ArrayList<SWDListItem> getListItems()
	{
		ArrayList<SWDListItem> items=new ArrayList<>();
		for(Actor actor:this.findActors(SWDListItem.class))
		{
			if(actor instanceof SWDListItem)
			{
				items.add((SWDListItem)actor);
			}
		}
		return items;
	}
	
	
	public void removeItem(SWDListItem item)
	{
		this.removeActor(item);
	}
	
	public void setListYOffset(int y)
	{
		this.listYOffset=y;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.updateData();
		this.scroll.index=0;
		for(SWDListItem item:this.getListItems())
		{
			item.setSelected(false);
		}
		
	}
	
	public void updateData(ArrayList data)
	{
		this.data=data;
		scroll.setMaxCap(data.size());
		if(data.size()<=capacity) this.scroll.setVisible(false);
		else this.scroll.setVisible(true);
		ArrayList<SWDListItem> oldItems=this.getListItems();
		int heightperitem=((int)this.getHeight()-capacity)/capacity;
		for(SWDListItem item:this.getListItems())
		{
			item.remove();
		}
		for(int i=0;i<data.size();i++)
		{
			Object o=data.get(i);
			SWDListItem item=ItemsContainData(oldItems, o);
			if(item!=null)
			{
				
			}
			else
			{
				try {
					Constructor<SWDListItem> c=(Constructor<SWDListItem>) clazz.getConstructor(int.class,int.class);
					item=c.newInstance((int)this.getWidth()-16,heightperitem);				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if(i<scroll.index||i>=scroll.index+capacity)
			{
				item.setVisible(false);
			}
			else item.setVisible(true);
			item.fillData(o);
			item.setY((this.getHeight()-heightperitem)-i*heightperitem-i+this.listYOffset);
			this.addActor(item);
		}
		scrollData();
		
	}
	
	public void updateData()
	{
		if(this.data!=null&&this.data.size()!=0) updateData(this.data);
	}
	
	public boolean dataContainItem(SWDListItem item)
	{
		for(Object o:this.data)
		{
			if(o==item.data) return true;
		}
		
		return false;
	}
	
	public boolean ItemsContainData(Object o)
	{
		for(SWDListItem item:this.getListItems())
		{
			if(item.data==o) return true;
		}
		
		return false;
	}
	
	public SWDListItem ItemsContainData(ArrayList<SWDListItem> items,Object o)
	{
		for(SWDListItem item:items)
		{
			if(item.data==o)
			{
				return item;
			}
		}
		return null;
	}

	public void clearData() {
		// TODO Auto-generated method stub
		this.data=null;
		this.clearChildren(SWDListItem.class);
	}

	
	
}
