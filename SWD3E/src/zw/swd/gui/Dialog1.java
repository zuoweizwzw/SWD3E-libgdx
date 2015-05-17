package zw.swd.gui;

import zw.swd.utils.FaceLoader;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;


public class Dialog1 extends Paper{

	public Paper background;
	public TextBox textBox;
	public Picture face;
	
	
	public Dialog1() {
		// TODO Auto-generated constructor stub
		this.background=ControlFactory.getDialog1Back();
		this.face=new Picture();
		this.textBox=new TextBox();
		
		this.addActor(background);
		this.addActor(face);
		this.addActor(textBox);
		this.setName("gui/dialog1");
		
	}


	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
//		FontLoader.font18.setColor(Color.RED);
	}
	public void clearText()
	{
		this.textBox.text="";
	}
}
