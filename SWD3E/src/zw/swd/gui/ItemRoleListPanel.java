package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.main.Config;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ItemRoleListPanel extends Paper{

	Picture background;
	GameModel model;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public ItemRoleListPanel()
	{
		this.setName("itemrolelistpanel");
		background=new Picture(Config.resPath+"/gui/1-1.png");
		this.addActor(background);
		for(int i=0;i<3;i++)
		{
			ItemRolePanel itemrolepanel=ItemRolePanel.createInstance();
			itemrolepanel.setPosition(14, 284-i*131);
			itemrolepanel.setVisible(false);
			this.addActor(itemrolepanel);
		}
		
	}
	
	public void fillData(GameModel model)
	{
		this.model=model;
		ArrayList<ItemRolePanel> panels=getRolePanels();
		
		for(int i=0;i<model.members.size();i++)
		{
			panels.get(i).updateData(model.members.get(i));
			panels.get(i).setVisible(true);
		}
	}
	
	public ArrayList<ItemRolePanel> getRolePanels()
	{
		ArrayList<ItemRolePanel> panels=new ArrayList<>();
		
		ArrayList<Actor> actors=this.findActors(ItemRolePanel.class);
		for(Actor actor:actors)
		{
			panels.add((ItemRolePanel)actor);
		}
		
		return panels;
	}
	
	

}
