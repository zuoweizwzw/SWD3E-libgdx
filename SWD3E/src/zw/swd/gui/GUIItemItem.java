package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameItem;
import zw.swd.gui.list.SWDListItem;
import zw.swd.main.App;
import zw.swd.screen.Cursor;
import zw.swd.screen.FightScreen;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIItemItem extends SWDListItem{

	public Label name;
	public Label num;
	public GameItem gameItem;
	public boolean selected=false;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
//		if(isMouseIn())
//		{			
//			this.drawBorder(batch, parentAlpha);			
//		}
		if(selected) 
		{
			Color old=new Color(this.getColor());
			Color nouvel=new Color(0,0,0.8f,0.7f);
			this.setColor(nouvel);
			this.drawRect(batch, parentAlpha);
			this.setColor(old);
			
		}
	}
	
	public GUIItemItem(int width, int height)
	{
		super(width, height);
		name=new Label("空");
		name.font=FontLoader.font24;
		name.setPosition(20, -1);
		this.addActor(name);
		this.num=new Label("空");
		this.num.setPosition(250, -1);
		this.num.font=FontLoader.font24;
		this.num.alignleft=false;
		this.addActor(num);
	}
	
	@Override
	public void fillData(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof GameItem)
		{
			GameItem item=(GameItem) o;
			gameItem=item;
			this.name.setText(item.itemModel.name);
			this.num.setText(item.num);
		}
	}
	
	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			if(GUI.getInstance().status==0)
			{
			this.selected=true;
			ArrayList<Paper> peers=this.getSameTypePapersFromParent();
			for(Paper paper:peers)
			{
				GUIItemItem item=(GUIItemItem) paper;
				item.selected=false;
			}
			}
		}
	}
	
	@Override
	public void onDoubleClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			if(GUI.getInstance().status==0)
			{
			Cursor.setCursor(1);
			GUI.getInstance().status=1;
			}
		}
	}
	
}
