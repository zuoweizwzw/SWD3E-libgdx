package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.main.App;
import zw.swd.main.Config;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipePane extends Paper{

	private static GUIEquipePane instance;
	public int index=0;
	EquipeRoleListPanel equiperolelistpanel;
	Picture attackpic;
	Label attack;
	Picture defensepic;
	Label defense;
	Picture agilitypic;
	Label agility;
	GUIEquipeStatusWindow guiequipestatuswindow;
	GUIEquipeListWindow guiequipelistwindow;
	GUIEquipeChangeWindow guiequipechangewindow;
	public GameModel model;
	
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public static GUIEquipePane getInstance()
	{
		if(instance==null)
		{
			instance=new GUIEquipePane();
		}
		return instance;
	}
	
	private GUIEquipePane() {
		// TODO Auto-generated constructor stub
		this.setName("guiequipepane");
		//test
		this.setVisible(false);
		
		attackpic=new Picture(Config.resPath+"/gui/23-1.png");
		attackpic.setPosition(200, 400);
		this.addActor(attackpic);
		
		attack=new Label("0");
		attack.setFont(FontLoader.font24);
		attack.setPosition(attackpic.getX()+54, attackpic.getY()-4);
		this.addActor(attack);
		
		defensepic=new Picture(Config.resPath+"/gui/23-2.png");
		defensepic.setPosition(320, 400);
		this.addActor(defensepic);
		
		defense=new Label("0");
		defense.setFont(FontLoader.font24);
		defense.setPosition(defensepic.getX()+54, defensepic.getY()-4);
		this.addActor(defense);
		
		agilitypic=new Picture(Config.resPath+"/gui/23-3.png");
		agilitypic.setPosition(440, 400);
		this.addActor(agilitypic);
		
		agility=new Label("0");
		agility.setFont(FontLoader.font24);
		agility.setPosition(agilitypic.getX()+54, agilitypic.getY()-4);
		this.addActor(agility);
		
		equiperolelistpanel=new EquipeRoleListPanel();		
		equiperolelistpanel.setPosition(0, 10);
		this.addActor(equiperolelistpanel);
		
		guiequipestatuswindow=new GUIEquipeStatusWindow();
		guiequipestatuswindow.setPosition(200, 58);
		this.addActor(guiequipestatuswindow);
		
		guiequipelistwindow=new GUIEquipeListWindow();
		guiequipelistwindow.setPosition(444, 160);
		this.addActor(guiequipelistwindow);
		
		guiequipechangewindow=new GUIEquipeChangeWindow();
		guiequipechangewindow.setPosition(444, 59);
		this.addActor(guiequipechangewindow);
		
		App app=(App)Gdx.app.getApplicationListener();
		this.fillData(app.gameModel);
	}
	
	public void show()
	{
		//test
		this.setVisible(true);
		this.guiequipelistwindow.reset();
	}
	
	public void fillData(GameModel model)
	{
		this.model=model;
		this.equiperolelistpanel.fillData(model.members.get(index)); 
		this.guiequipestatuswindow.fillData(model.members.get(index));
	}
	
	public void hide()
	{
		//test
		this.setVisible(false);
	}
	
	public RoleModel getCurrentRoleModel()
	{
		return this.model.members.get(index);
	}
}
