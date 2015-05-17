package zw.swd.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class TextButton extends Paper {

	public Label text;
	public ClickEvent clickEvent;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			drawRect(batch,parentAlpha);
		}
	}
	
	@Override
	public void isClick(int button) {
		// TODO Auto-generated method stub
		if(clickEvent!=null)
		{
			clickEvent.onClick(Buttons.LEFT);
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
	
	public TextButton(String text) {
		// TODO Auto-generated constructor stub
		this.text=new Label(text);
		this.addActor(this.text);
//		this.text.setY(this.text.getHeight());
		this.setSize(this.text.getWidth(), this.text.getHeight());
		
	}
	
	@Override
	public void setSize(float width, float height) {
		// TODO Auto-generated method stub
//		this.text.setSize(width, height);
		super.setSize(width, height);
	}
	
	public void setFont(BitmapFont font)
	{
		this.text.setFont(font);
		this.setSize(this.text.getWidth(), this.text.getHeight());
	}

}
