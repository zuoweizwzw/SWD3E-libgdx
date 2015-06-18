package zw.swd.gui;

import zw.swd.game.GameItem;
import zw.swd.game.GameModel;
import zw.swd.game.ItemModel;
import zw.swd.game.RoleModel;
import zw.swd.gui.list.SWDListItem;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeListItem extends SWDListItem{

	Label name;
	Label num;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(isSelected()) 
		{
			Color old=new Color(this.getColor());
			Color nouvel=new Color(0,0,0.8f,0.7f);
			this.setColor(nouvel);
			this.drawRect(batch, parentAlpha);
			this.setColor(old);
			
		}
	}

	public GUIEquipeListItem(int width,int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
		name=new Label("空");
		num=new Label("0");
		this.name.setPosition(0, 2);
		this.addActor(name);
		
		this.num.setPosition(140, 2);
		this.addActor(num);
		this.num.alignleft=false;
	}
	

	@Override
	public void fillData(Object o)
	{
		super.fillData(o);
		GameItem gameItem=(GameItem) o;
		this.name.setText(gameItem.itemModel.name);
		this.num.setText(gameItem.num);
	}
	
	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			this.setSelected(true);
		}
	}
	
	@Override
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		super.setSelected(selected);
		
		if(selected)
		{
			for(SWDListItem listItem:GUIEquipeListWindow.getInstance().getListItems())
			{
				if(listItem!=this) listItem.setSelected(false);
			}
			
			RoleModel role=GUIEquipePane.getInstance().getCurrentRoleModel();
			ItemModel current=GUIEquipeStatusWindow.getInstance().getSelectedItem().model;
			GameItem gameItem=(GameItem) this.data;
			ItemModel nouvel=gameItem.itemModel;
			GUIEquipeChangeWindow.getInstance().fillData(role, current, nouvel);
		}

	}
	
	@Override
	public boolean onDoubleClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			ItemModel current=GUIEquipeStatusWindow.getInstance().getSelectedItem().model;
			ItemModel nouvel=((GameItem) this.data).itemModel;
			String location=GUIEquipeStatusWindow.getInstance().getSelectedItem().getLocationFromType();
			
			GUIEquipePane.getInstance().getCurrentRoleModel().switchItem(nouvel, location);
			
			GameModel.getInstance().reduceItem((GameItem) this.data,1);
			
			if(current!=null) GameModel.getInstance().addItem(current,1);
			
			GUIEquipeListWindow.getInstance().updateData();
			
			GUIEquipeStatusWindow.getInstance().fillData();
			
			GUIEquipeChangeWindow.getInstance().reset();
			
			GUIEquipePane.getInstance().updateData();
			
			return true;
			
		}
		return false;
		
	}
}
