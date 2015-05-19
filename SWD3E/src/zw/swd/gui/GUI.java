package zw.swd.gui;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUI extends Paper{

	Menu menu;
	public Picture background=new Picture();
	public GUIItemPane itempane=new GUIItemPane();
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUI() {
		// TODO Auto-generated constructor stub
		this.addActor(background);
		
		this.menu=new Menu();
		this.menu.setY(434);
		this.setName("gui");
		this.addActor(menu);
		
		this.addActor(itempane);
	}
	
	
	public void show()
	{
		this.setVisible(true);
		this.menu.item.clickEvent.onClick(Buttons.LEFT);
	}

	public void hide() {
		// TODO Auto-generated method stub
		if(this.menu.item.isFocused) this.menu.item.setFocus(false);
		if(this.menu.equipe.isFocused) this.menu.equipe.setFocus(false);
		this.setVisible(false);
//		this.itempane.hide();
	}
}
