package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.game.actions.ActorMoveAction;
import zw.swd.main.App;
import zw.swd.main.Config;
import zw.swd.math.Vector2;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class GUIEquipePane extends GUIPane{

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
		
		equiperolelistpanel=EquipeRoleListPanel.getInstance();		
		equiperolelistpanel.setPosition(-204, 10);
		this.addActor(equiperolelistpanel);
		
		guiequipestatuswindow=GUIEquipeStatusWindow.getInstance();
		guiequipestatuswindow.setPosition(200, -328);//58
		this.addActor(guiequipestatuswindow);
		
		guiequipelistwindow=GUIEquipeListWindow.getInstance();
		guiequipelistwindow.setPosition(640, 160);//444
		this.addActor(guiequipelistwindow);
		
		guiequipechangewindow=GUIEquipeChangeWindow.getInstance();
		guiequipechangewindow.setPosition(640, 59);//444
		this.addActor(guiequipechangewindow);
		
		App app=(App)Gdx.app.getApplicationListener();
		this.fillData(app.gameModel);
	}
	
	public void show()
	{
		//test
		this.isshowing=true;
		this.setVisible(true);
		this.guiequipestatuswindow.reset();
		this.guiequipelistwindow.reset();
		this.guiequipechangewindow.reset(); 
		
		attackpic.setVisible(true);
		attack.setVisible(true);
		defensepic.setVisible(true);
		defense.setVisible(true);
		agilitypic.setVisible(true);
		agility.setVisible(true);
		
		this.startParellAction(new ActorMoveAction(equiperolelistpanel,new Vector2(204, 0),600f));
		this.addAction(new ActorMoveAction(guiequipestatuswindow,new Vector2(0, 58+328),1200f));
		this.addAction(new ActorMoveAction(guiequipelistwindow,new Vector2(-196, 0),600f));
		this.addAction(new ActorMoveAction(guiequipechangewindow,new Vector2(-196, 0),600f));
	}
	
	
	
	public void fillData(GameModel model)
	{
		this.model=model;
		this.equiperolelistpanel.fillData(model.members.get(index)); 
		this.guiequipestatuswindow.fillData(model.members.get(index));
		this.agility.setText(getCurrentRoleModel().getAgility());
		this.attack.setText(getCurrentRoleModel().getAttack());
		this.defense.setText(getCurrentRoleModel().getDefense());
	}
	
	public void updateData()
	{
		this.fillData(this.model);
	}
	
	public void hide()
	{
		if(this.isshowing)
		{
		this.startParellAction(new ActorMoveAction(equiperolelistpanel,new Vector2(-204, 0),600f));
		this.addAction(new ActorMoveAction(guiequipestatuswindow,new Vector2(0, -58-328),1200f));
		this.addAction(new ActorMoveAction(guiequipelistwindow,new Vector2(196, 0),600f));
		this.addAction(new ActorMoveAction(guiequipechangewindow,new Vector2(196, 0),600f));
		attackpic.setVisible(false);
		attack.setVisible(false);
		defensepic.setVisible(false);
		defense.setVisible(false);
		agilitypic.setVisible(false);
		agility.setVisible(false);
		this.isshowing=false;
		}
	}
	
	public RoleModel getCurrentRoleModel()
	{
		return this.model.members.get(index);
	}
}
