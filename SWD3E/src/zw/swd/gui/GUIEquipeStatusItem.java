package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameModel;
import zw.swd.game.ItemModel;
import zw.swd.game.RoleModel;
import zw.swd.graphics.Animation;
import zw.swd.main.Cache;
import zw.swd.main.Config;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GUIEquipeStatusItem extends Paper{

	public Label label;
	public Picture icon;
	public Label item;
	public ItemModel model;
	private boolean selected=false;
	public int type=0;//0武器1头部2身体3手部4足部5饰品一6饰品二7法宝一8法宝二9护驾一10护架二
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(this.selected)
		{
			Color old=new Color(this.getColor());
			this.setColor(new Color(0,0,1,0.75f));
			this.drawRect(batch, parentAlpha);
			this.setColor(old);
		}
	}
	
	public GUIEquipeStatusItem() {
		// TODO Auto-generated constructor stub
		this.setSize(229, 27);
		
		label=new Label("空");
		label.setPosition(5, 0);
		label.setFont(FontLoader.font24);
		this.addActor(label);
		
		icon=new Picture();
		icon.setPosition(60, 0);
		this.addActor(icon);
		
		item=new Label("空");
		item.setPosition(90, 0);
		item.setFont(FontLoader.font24);
		this.addActor(item);
	}
	
	
	public void setType(int type)
	{
		this.type=type;
		if(type==0) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-1.png"));
			this.label.setText("武器");
		}
		if(type==1) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-2.png"));
			this.label.setText("头部");
		}
		if(type==2) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-3.png"));
			this.label.setText("身体");
		}
		if(type==3) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-4.png"));
			this.label.setText("手部");
		}
		if(type==4) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-5.png"));
			this.label.setText("足部");
		}
		if(type==5||type==6) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-6.png"));
			this.label.setText("饰品");
		}
		if(type==7||type==8) 
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-7.png"));			
			this.label.setText("法宝");
		}
		if(type==9||type==10)
		{
			this.icon.setAnimation(new Animation(Config.resPath+"/gui/18-8.png"));
			this.label.setText("护驾");
		}
	}
	
	public void fillData(RoleModel role)
	{
		if(this.type==0&&!role.weapon.equals("")) this.model=Cache.items.get(role.weapon);
		if(this.type==1&&!role.head.equals("")) this.model=Cache.items.get(role.head);
		if(this.type==2&&!role.body.equals("")) this.model=Cache.items.get(role.body);
		if(this.type==3&&!role.hand.equals("")) this.model=Cache.items.get(role.hand);
		if(this.type==4&&!role.foot.equals("")) this.model=Cache.items.get(role.foot);
		if(this.type==5&&!role.attach1.equals("")) this.model=Cache.items.get(role.attach1);
		if(this.type==6&&!role.attach2.equals("")) this.model=Cache.items.get(role.attach2);
		if(this.type==7&&!role.fabao1.equals("")) this.model=Cache.items.get(role.fabao1);
		if(this.type==8&&!role.fabao2.equals("")) this.model=Cache.items.get(role.fabao2);
		if(this.type==9&&!role.hujia1.equals("")) this.model=Cache.items.get(role.hujia1);
		if(this.type==10&&!role.hujia2.equals("")) this.model=Cache.items.get(role.hujia2);
		
		if(this.model!=null) this.item.setText(this.model.name);
		
	}

	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		if(this.isMouseIn())
		{
			this.setFocus(true);
		}
	}
	
	public void setFocus(boolean focus)
	{
		if(focus)
		{
			if(!this.selected)
			{
				GUIEquipeChangeWindow.getInstance().clearData();
			}
			this.selected=true;
			GUIEquipeStatusWindow parent=(GUIEquipeStatusWindow) this.getParent();
			ArrayList<Actor> actors=parent.findActors(GUIEquipeStatusItem.class);
			for(Actor actor:actors)
			{
				if(actor!=this)
				{
					GUIEquipeStatusItem item=(GUIEquipeStatusItem) actor;
					item.setFocus(false);
				}
			}
			if(type==0)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(1);
				
			}
			
			if(type==1)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(5);
			}
			
			if(type==2)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(7);
			}
			
			if(type==3)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(9);
			}
			
			if(type==4)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(11);
			}
			
			if(type==5||type==6)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(13);
			}
			
			if(type==7||type==8)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(14);
			}
			
			if(type==9||type==10)
			{
				if(GUIEquipePane.getInstance().getCurrentRoleModel().resCode.equals("001"))
					GUIEquipePane.getInstance().guiequipelistwindow.updateData(15);
			}
		}
		else
		{
			this.selected=false;
		}
	}
	
	public boolean isSelected()
	{
		return this.selected;
	}
	
	public String getLocationFromType()
	{
		String location="";
		if(type==0) location="weapon";
		if(type==1) location="head";
		if(type==2) location="body";
		if(type==3) location="hand";
		if(type==4) location="foot";
		if(type==5) location="attach1";
		if(type==6) location="attach2";
		if(type==7) location="fabao1";
		if(type==8) location="fabao2";
		if(type==9) location="hujia1";
		if(type==10) location="hujia2";
		
		return location;
	}
}
