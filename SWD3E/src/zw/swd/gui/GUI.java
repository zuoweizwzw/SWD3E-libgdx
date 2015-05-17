package zw.swd.gui;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUI extends Paper{

	Menu menu;
	Picture background=new Picture();
	ItemRoleListPanel itemrolelistpanel;
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
	}
}
