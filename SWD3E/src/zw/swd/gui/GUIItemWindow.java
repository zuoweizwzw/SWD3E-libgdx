package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.main.Config;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GUIItemWindow extends Paper{

	GUIItemList list;
	Picture tabs=new Picture();
	public GUIItemWindow(GameModel gameModel) {
		// TODO Auto-generated constructor stub
		this.setPosition(208, 40);
		this.setName("guiitemwindow");
		this.setSize(304, 353);
		list=new GUIItemList(gameModel);
		this.setColor(new Color(0,0,0,0.7f));
		
		Picture leftdown=new Picture(Config.resPath+"/gui/39-7.png");
		this.addActor(leftdown);
		
		Picture rightdown=new Picture(Config.resPath+"/gui/39-9.png");
		rightdown.setPosition(leftdown.getX()+3*96, leftdown.getY());
		this.addActor(rightdown);
		
		Picture leftup=new Picture(Config.resPath+"/gui/39-1.png");
		leftup.setPosition(leftdown.getX(), leftdown.getY()+7*48);
		this.addActor(leftup);
		
		Picture rightup=new Picture(Config.resPath+"/gui/39-3.png");
		rightup.setPosition(leftup.getX()+3*96, leftup.getY());
		this.addActor(rightup);
		
		for(int i=0;i<3;i++)
		{
			Picture down=new Picture(Config.resPath+"/gui/39-8.png");
			down.setPosition(leftdown.getX()+8+i*96, leftdown.getY());
			this.addActor(down);
		}
		
		for(int i=0;i<7;i++)
		{
			Picture left=new Picture(Config.resPath+"/gui/39-4.png");
			left.setPosition(leftdown.getX(), leftdown.getY()+8+i*48);
			this.addActor(left);
		}
		
		for(int i=0;i<3;i++)
		{
			Picture up=new Picture(Config.resPath+"/gui/39-2.png");
			up.setPosition(leftup.getX()+8+i*96, leftup.getY());
			this.addActor(up);
		}
		
		for(int i=0;i<7;i++)
		{
			Picture right=new Picture(Config.resPath+"/gui/39-6.png");
			right.setPosition(rightdown.getX(), rightdown.getY()+8+i*48);
			this.addActor(right);
		}
		
		tabs.setPosition(leftup.getX(), leftup.getY()+16);
		final TabButton tab1=new TabButton(new Picture(Config.resPath+"/gui/17-47.png"), new Picture(Config.resPath+"/gui/17-3.png"));
		tab1.setPosition(0, 0);
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
		
		final TabButton tab2=new TabButton(new Picture(Config.resPath+"/gui/17-48.png"), new Picture(Config.resPath+"/gui/17-4.png"));
		tab2.setPosition(50, tab1.getY());
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
		
		final TabButton tab3=new TabButton(new Picture(Config.resPath+"/gui/17-49.png"), new Picture(Config.resPath+"/gui/17-7.png"));
		tab3.setPosition(100, tab1.getY());
		tab3.clickEvent=new ClickEvent() {

			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				if(button==Buttons.LEFT)
				{
					tab3.setFocus(true);
					for(Actor actor:tab3.getParent().getChildren())
					{
						if(actor!=tab3&&actor instanceof TabButton)
						{
							((TabButton)actor).setFocus(false);
						}
					}
				}
			}
			
		};
		tabs.addActor(tab3);
		
		this.addActor(tabs);
	}

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

}
