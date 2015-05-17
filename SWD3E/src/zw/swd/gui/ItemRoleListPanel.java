package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.main.Config;

import com.badlogic.gdx.graphics.g2d.Batch;

public class ItemRoleListPanel extends Paper{

	Picture background;
	GameModel model;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public ItemRoleListPanel(GameModel model) {
		// TODO Auto-generated constructor stub
		background=new Picture(Config.resPath+"/gui/1-1.png");
		this.model=model;
		this.addActor(background);
		
		for(int i=0;i<model.members.size();i++)
		{
			RoleModel role=model.members.get(i);
			ItemRolePanel itemrolepanel=new ItemRolePanel(role);
			itemrolepanel.setPosition(14, 284+i*131);
			this.addActor(itemrolepanel);
		}
	}

}
