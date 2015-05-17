package zw.swd.gui;

import zw.swd.game.RoleModel;
import zw.swd.main.Config;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class MagicSelectWindow extends Paper{

	Picture tabs=new Picture();
	FightMagicList list=new FightMagicList();
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		drawRect(batch, parentAlpha);
	}
	
	public MagicSelectWindow(RoleModel model) {
		// TODO Auto-generated constructor stub
		this.setName("magicselectwindow");
		this.setPosition(220, 200);
		this.setSize(190, 175);
		this.setColor(new Color(0,0,0,0.7f));
		
		Picture leftdown=new Picture(Config.resPath+"/gui/116-7.png");
		this.addActor(leftdown);
		
		for(int i=0;i<4;i++)
		{
			Picture down=new Picture(Config.resPath+"/gui/116-8.png");
			down.setPosition(leftdown.getX()+16+i*40, leftdown.getY()-1);
			this.addActor(down);
		}
		
		for(int i=0;i<3;i++)
		{
			Picture left=new Picture(Config.resPath+"/gui/116-4.png");
			left.setPosition(leftdown.getX(), leftdown.getY()+16+i*48);
			this.addActor(left);
		}
		
		
		Picture leftup=new Picture(Config.resPath+"/gui/116-1.png");
		leftup.setPosition(leftdown.getX(), leftdown.getY()+160);
		this.addActor(leftup);
		
		for(int i=0;i<4;i++)
		{
			Picture up=new Picture(Config.resPath+"/gui/116-2.png");
			up.setPosition(leftup.getX()+16+i*40, leftup.getY()+8);
			this.addActor(up);
		}
		Picture rightup=new Picture(Config.resPath+"/gui/116-3.png");
		rightup.setPosition(leftup.getX()+176, leftup.getY());
		this.addActor(rightup);
		
		
		
		Picture rightdown=new Picture(Config.resPath+"/gui/116-9.png");
		rightdown.setPosition(rightup.getX(), rightup.getY()-160);
		this.addActor(rightdown);
		
		for(int i=0;i<3;i++)
		{
			Picture right=new Picture(Config.resPath+"/gui/116-6.png");
			right.setPosition(rightdown.getX()+8+1, rightdown.getY()+16+i*48);
			this.addActor(right);
		}
		
		tabs.setPosition(leftup.getX(), leftup.getY()+16);
		final TabButton tab1=new TabButton(new Picture(Config.resPath+"/gui/91-1.png"), new Picture(Config.resPath+"/gui/92-1.png"));
		tab1.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				if(button==Buttons.LEFT)
				{
					tab1.setFocus(true);
					for(Actor actor:tab1.getParent().getChildren())
					{
						if(actor!=tab1&&actor instanceof TabButton)
						{
							((TabButton)actor).setFocus(false);
						}
					}
				}
			}
		};
		
		tabs.addActor(tab1);
		tab1.clickEvent.onClick(0);
		
		final TabButton tab2=new TabButton(new Picture(Config.resPath+"/gui/91-2.png"), new Picture(Config.resPath+"/gui/92-2.png"));
		tab2.setPosition(60, tab1.getY());
		tab2.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				if(button==Buttons.LEFT)
				{
				tab2.setFocus(true);
				for(Actor actor:tab2.getParent().getChildren())
				{
					if(actor!=tab2&&actor instanceof TabButton)
					{
						((TabButton)actor).setFocus(false);
					}
				}
				}
			}
		};
		tabs.addActor(tab2);
		
		final TabButton tab3=new TabButton(new Picture(Config.resPath+"/gui/91-3.png"), new Picture(Config.resPath+"/gui/92-3.png"));
		tab3.setPosition(120, tab1.getY());
		tab3.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				tab3.setFocus(true);
				for(Actor actor:tab3.getParent().getChildren())
				{
					if(actor!=tab3&&actor instanceof TabButton)
					{
						((TabButton)actor).setFocus(false);
					}
				}
			}
		};
		tabs.addActor(tab3);
		this.addActor(tabs);
		
		
		this.addActor(list);
		this.fillData(model);
		list.scroll.resetRect();
	}

	public void fillData(RoleModel model)
	{
		this.list.fillData(model);
	}
}
