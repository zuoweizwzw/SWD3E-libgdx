package zw.swd.gui;

import zw.swd.game.GameItem;
import zw.swd.main.App;
import zw.swd.screen.FightScreen;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIItemItem extends ListItem{

	public Label name;
	public Label num;
	GameItem gameItem;
	public boolean selected=false;
	public ClickEvent clickEvent;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{			
			this.drawBorder(batch, parentAlpha);			
		}
		if(selected) 
		{
			Color old=new Color(this.getColor());
			Color nouvel=new Color(0,0,0.8f,0.7f);
			this.setColor(nouvel);
			this.drawRect(batch, parentAlpha);
			this.setColor(old);
			
		}
	}

	public GUIItemItem(GameItem gameItem) {
		// TODO Auto-generated constructor stub
		this.gameItem=gameItem;
		this.setSize(280, 25);
		name=new Label(gameItem.itemModel.name);
		name.font=FontLoader.font24;
		name.setPosition(20, -1);
		this.addActor(name);
		
		this.num=new Label(Integer.toString(gameItem.num));
		this.num.setPosition(250, -1);
		this.num.font=FontLoader.font24;
		this.num.alignleft=false;
		this.addActor(num);
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
