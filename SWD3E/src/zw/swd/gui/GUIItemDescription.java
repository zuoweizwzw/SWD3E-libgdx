package zw.swd.gui;

import zw.swd.main.Config;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIItemDescription extends Paper{

	Label text;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	public GUIItemDescription() {
		// TODO Auto-generated constructor stub
		
		this.setSize(300, 35);
		this.setName("guiitemdescription");
		Picture leftdown=new Picture(Config.resPath+"/gui/39-7.png");
		this.addActor(leftdown);
		
		Picture leftup=new Picture(Config.resPath+"/gui/39-1.png");
		leftup.setPosition(leftdown.getX(), leftdown.getY()+23);
		this.addActor(leftup);
		
		Picture rightup=new Picture(Config.resPath+"/gui/39-3.png");
		rightup.setPosition(leftup.getX()+8+4*96-8, leftup.getY());
		this.addActor(rightup);
		
		Picture rightdown=new Picture(Config.resPath+"/gui/39-9.png");
		rightdown.setPosition(rightup.getX(), rightup.getY()-23);
		this.addActor(rightdown);
		
		
		for(int i=0;i<4;i++)
		{
			Picture down=new Picture(Config.resPath+"/gui/39-8.png");
			down.setPosition(leftdown.getX()+8+i*96, leftdown.getY());
			this.addActor(down);
		}
		
		Picture left=new Picture(Config.resPath+"/gui/39-4.png");
		left.setPhysicHeight(24);
		left.setPosition(leftdown.getX(), leftdown.getY()+8);
		this.addActor(left);
		
		for(int i=0;i<4;i++)
		{
			Picture up=new Picture(Config.resPath+"/gui/39-2.png");
			up.setPosition(leftup.getX()+8+i*96, leftup.getY());
			this.addActor(up);
		}
		
		Picture right=new Picture(Config.resPath+"/gui/39-6.png");
		right.setPhysicHeight(24);
		right.setPosition(rightup.getX(), left.getY());
		this.addActor(right);
		
		text=new Label("没有说明");
		text.setFont(FontLoader.font18);
		text.setPosition(8, 8);
		this.addActor(text);
		
	}
	
	public void setText(String text)
	{
		this.text.setText(text);
	}

}
