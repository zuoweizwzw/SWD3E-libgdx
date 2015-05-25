package zw.swd.gui;

import zw.swd.game.GameItem;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeListItem extends Paper{

	Label name;
	Label num;
	boolean selected=false;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(selected) 
		{
			Color old=new Color(this.getColor());
			Color nouvel=new Color(0,0,0.8f,0.7f);
			this.setColor(nouvel);
			this.drawRect(batch, parentAlpha);
			this.setColor(old);
			
		}
	}

	public GUIEquipeListItem() {
		// TODO Auto-generated constructor stub
		name=new Label("空");
		num=new Label("0");
		this.setSize(162, 25);
		this.name.setPosition(0, 2);
		this.addActor(name);
		
		this.num.setPosition(30, 2);
		this.addActor(num);
		this.num.alignleft=false;
	}
	
	public GUIEquipeListItem(GameItem item) {
		// TODO Auto-generated constructor stub
		super();
		fillData(item);
	}

	public void fillData(GameItem item)
	{
		this.name.setText(item.itemModel.name);
		this.num.setText(item.num);
	}
	
	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			
			this.selected=true;
		}
	}
}
