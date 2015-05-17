package zw.swd.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.Batch;

import zw.swd.game.MagicModel;
import zw.swd.graphics.fight.FightRole;
import zw.swd.main.App;
import zw.swd.main.Config;
import zw.swd.screen.FightScreen;

public class FightMagicItem extends ListItem{

	public Picture element;
	public Label name;
	public Label cost;
	public MagicModel model;
	
	public FightMagicItem(MagicModel model) {
		// TODO Auto-generated constructor stub
		this.model=model;
		element=new Picture(Config.resPath+"/gui/132-"+(model.element+1)+".png");
		element.setPosition(0, -2);
		this.addActor(element);
		
		name=new Label(model.name);
		name.setPosition(30, -2);
		this.addActor(name);
		
		cost=new Label(Integer.toString(model.mpCost));
		cost.setPosition(148, -2);
		this.addActor(cost);
		
		this.setSize(180, 19);
		
		
	}
	
	public void update(MagicModel model)
	{
		this.model=model;
		this.element=new Picture(Config.resPath+"/gui/132-"+(model.element+1)+".png");
		this.name.setText(model.name);
		this.cost.setText(Integer.toString(model.mpCost));
	}

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			App game=(App)Gdx.app.getApplicationListener();
			FightScreen screen=((FightScreen)game.currentScreen);
			MagicTips tips=(MagicTips) screen.guiMgr.findActorByName("magictips");
			tips.setVisible(true);
			tips.setText(this.model.description);
			this.drawBorder(batch, parentAlpha);
			
		}
	}
	
	@Override
	public void isClick(int button) {
		// TODO Auto-generated method stub
		if(button==Buttons.LEFT)
		{
		if(this.model.aoe)
		{
			App game=(App)Gdx.app.getApplicationListener();
			FightScreen screen=((FightScreen)game.currentScreen);
			screen.guiMgr.findActorByName("magicselectwindow").remove();
			screen.state=2;
			FightRole[] enemies=new FightRole[screen.battle.enemies.size()];
			screen.battle.enemies.toArray(enemies);
			screen.actionMgr.playCast(screen.battle.currentRole, enemies, model);
			
		}
		}
	}
	
	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			if(button==Buttons.LEFT)
			{
			if(this.model.aoe)
			{
				App game=(App)Gdx.app.getApplicationListener();
				FightScreen screen=((FightScreen)game.currentScreen);
				screen.guiMgr.findActorByName("magicselectwindow").remove();
				screen.state=2;
				FightRole[] enemies=new FightRole[screen.battle.enemies.size()];
				screen.battle.enemies.toArray(enemies);
				screen.actionMgr.playCast(screen.battle.currentRole, enemies, model);
				
			}
			}
		}
	}
}
