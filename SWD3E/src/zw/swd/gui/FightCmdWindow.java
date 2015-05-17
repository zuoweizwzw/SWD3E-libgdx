package zw.swd.gui;

import zw.swd.game.RoleModel;
import zw.swd.main.App;
import zw.swd.main.Config;
import zw.swd.screen.FightScreen;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class FightCmdWindow extends Paper{

	Picture background;
	Picture up;
	Picture down;
	TextButton attack;
	TextButton magic;
	TextButton item;
	public RoleModel model;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public static FightCmdWindow create()
	{
		final FightCmdWindow window=new FightCmdWindow();
		window.setSize(160, 120);
		window.background=new Picture(Config.resPath+"/gui/82-3.png");
		window.background.setRegion(0, 0, 160, 120);
		
		window.addActor(window.background);
		window.setName("fightcmdwindow");
		window.setVisible(false);
		window.setPosition(240, 240);
		
		window.up=new Picture(Config.resPath+"/gui/82-1.png");
		window.down=new Picture(Config.resPath+"/gui/82-2.png");
		window.up.setPosition(-4, 118);
		window.down.setPosition(-4, 0);
		window.addActor(window.up);
		window.addActor(window.down);
		
		window.attack=new TextButton("攻击");
		window.attack.setPosition(7, 57);
		window.attack.setColor(Color.RED);
		window.attack.setFont(FontLoader.font24);
		window.attack.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				App game=(App)Gdx.app.getApplicationListener();
				((FightScreen)game.currentScreen).enterState(1);
			}
		};
		window.addActor(window.attack);
		
		window.magic=new TextButton("奇术");
		window.magic.setPosition(57, 57);
		window.magic.setColor(Color.RED);
		window.magic.setFont(FontLoader.font24);
		window.magic.clickEvent=new ClickEvent()
		{
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				App game=(App)Gdx.app.getApplicationListener();
				((FightScreen)game.currentScreen).enterState(3);
				window.setVisible(false);
				MagicSelectWindow magic=new MagicSelectWindow(window.model);
				((FightScreen)game.currentScreen).guiMgr.addActor(magic);
				
			}
			
		};
		window.addActor(window.magic);
		
		window.item=new TextButton("物品");
		window.item.setPosition(107, 57);
		window.item.setColor(Color.RED);
		window.item.setFont(FontLoader.font24);
		window.addActor(window.item);
		
		return window;
	}
	
	public void setRoleModel(RoleModel model)
	{
		this.model=model;
	}
}
