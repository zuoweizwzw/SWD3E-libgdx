package zw.swd.gui;

import zw.swd.graphics.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Button extends Paper{

	public Animation pressedAni;
	public Animation releasedAni;
	public ClickEvent clickEvent;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			if(Gdx.input.isButtonPressed(Buttons.LEFT))
			{
				
				this.setAnimation(pressedAni);
				return;
			}
			
		}
		this.setAnimation(releasedAni);
		
	}
	
	public Button(Animation pressedAni,Animation releasedAni) {
		// TODO Auto-generated constructor stub
		this.pressedAni=pressedAni;
		this.releasedAni=releasedAni;
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

}
