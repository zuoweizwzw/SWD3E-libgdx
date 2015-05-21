package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.main.App;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipePane extends Paper{

	EquipeRoleListPanel equiperolelistpanel;
	Picture attackpic;
	Label attack;
	Picture defensepic;
	Label defense;
	Picture agilitypic;
	Label agility;
	GUIEquipeStatusWindow guiequipestatuswindow;
	
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUIEquipePane() {
		// TODO Auto-generated constructor stub
		this.setName("guiequipepane");
		//test
		this.setVisible(false);
		equiperolelistpanel=new EquipeRoleListPanel();		
		equiperolelistpanel.setPosition(0, 10);
		this.addActor(equiperolelistpanel);
		
		guiequipestatuswindow=new GUIEquipeStatusWindow();
		guiequipestatuswindow.setPosition(200, 58);
		this.addActor(guiequipestatuswindow);
		
		App app=(App)Gdx.app.getApplicationListener();
		this.fillData(app.gameModel);
	}
	
	public void show()
	{
		//test
		this.setVisible(true);
	}
	
	public void fillData(GameModel model)
	{
		this.equiperolelistpanel.fillData(model);
	}
	
	public void hide()
	{
		//test
		this.setVisible(false);
	}
}
