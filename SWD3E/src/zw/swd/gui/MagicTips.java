package zw.swd.gui;

import zw.swd.main.App;
import zw.swd.screen.FightScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MagicTips extends Paper{

	public Label text;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		App game=(App)Gdx.app.getApplicationListener();
		FightScreen screen=((FightScreen)game.currentScreen);
		FightMagicList list=(FightMagicList) screen.guiMgr.findActorByName("fightmagiclist");
		boolean visible=false;
		if(list!=null)
		{
			for(FightMagicItem item:list.getItems())
			{
				if(item.isMouseIn())
				{
				visible=true;
				}
			}
		}
		this.setVisible(visible);
		drawRect(batch, parentAlpha);
	}
	
	public MagicTips() {
		// TODO Auto-generated constructor stub
		this.setColor(new Color(0,0,0.8f,0.6f));
		text=new Label();
		this.addActor(text);
		this.setName("magictips");
	}
	
	public void setText(String text)
	{
		this.text.setText(text);
		this.text.centerX();
	}

}
