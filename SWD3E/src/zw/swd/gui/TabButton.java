package zw.swd.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.Batch;

public class TabButton extends Paper{

	public Picture normal;
	public Picture focus;
	public ClickEvent clickEvent;
	public boolean isFocused;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	public TabButton(Picture normal, Picture focus) {
		// TODO Auto-generated constructor stub
		this.setPictures(normal, focus);
		this.setFocus(false);
	}
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub
		this.clearChildren();
		this.isFocused=focus;
		if(!focus) 
		{
			this.addActor(normal);
			this.copySize(normal);
		}
		else 
		{
			this.addActor(this.focus);
			this.copySize(this.focus);
		}
	}
	
	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		
		if(isMouseIn())
		{
			
			if(clickEvent!=null)
			{
				clickEvent.onClick(Buttons.LEFT);
			}
		}
	}
	
	public void setPictures(Picture normal, Picture focus)
	{
		this.normal=normal;
		
		this.focus=focus;
	}

}
