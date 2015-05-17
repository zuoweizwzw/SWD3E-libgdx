package zw.swd.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MagicCaption extends Paper{

	public Label text;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		drawRect(batch, parentAlpha);
	}
	
	public MagicCaption() {
		// TODO Auto-generated constructor stub
		this.setSize(180, 30);
		this.setColor(new Color(0,0,0.5f,0.8f));
		this.setAlpha(alpha);
		text=new Label();
		text.setY(3);
		this.addActor(text);
		this.setName("magiccaption");
	}
	
	public void setText(String text)
	{
		this.text.setText(text);
		this.text.centerX();
	}

}
