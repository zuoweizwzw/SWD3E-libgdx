package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.graphics.Animation;
import zw.swd.main.Config;

import com.badlogic.gdx.graphics.g2d.Batch;

public class EquipeRoleListPanel extends Paper{

	Picture background;
	Picture avatar;

	ItemRolePanel panel;
	RoleModel model;
	Label element;
	Label strength;
	Label tolerance;
	Label intelligence;
	Label agility;
	Label nextlevel;
	Label exp;
	Label gold;
	Label wood;
	Label water;
	Label fire;
	Label earth;
	
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public EquipeRoleListPanel() {
		// TODO Auto-generated constructor stub
		this.setName("equiperolelistpanel");
		background=new Picture(Config.resPath+"/gui/56-5(3).png");		
		this.addActor(background);
		
		this.avatar=new Picture();
		avatar.setPosition(88, 425);
		this.addActor(avatar);
		
		Button left=new Button(new Animation(Config.resPath+"/gui/51-6.png"), new Animation(Config.resPath+"/gui/51-5.png"));
		left.setPosition(avatar.getX()-50, avatar.getY()+10);
		this.addActor(left);
		
		Button right=new Button(new Animation(Config.resPath+"/gui/51-8.png"), new Animation(Config.resPath+"/gui/51-7.png"));
		right.setPosition(avatar.getX()+50, avatar.getY()+10);
		this.addActor(right);
		
		panel=ItemRolePanel.createInstance();
		panel.setPosition(15, 300);
		this.addActor(panel);
		
		int interval=21;
		
		Label elementtext=new Label("属性");
		elementtext.setPosition(25, panel.getY()-25);
		this.addActor(elementtext);
		
		element=new Label("空");
		element.setPosition(105, elementtext.getY());
		this.addActor(element);	
		
		Label strengthtext=new Label("力量");
		strengthtext.setPosition(25, panel.getY()-25-interval*1);
		this.addActor(strengthtext);
		
		strength=new Label("空");
		strength.setPosition(105, strengthtext.getY());
		this.addActor(strength);	
		
		Label tolerancetext=new Label("耐力");
		tolerancetext.setPosition(25, panel.getY()-25-interval*2);
		this.addActor(tolerancetext);
		
		tolerance=new Label("空");
		tolerance.setPosition(105, tolerancetext.getY());
		this.addActor(tolerance);
		
		Label intelligencetext=new Label("智慧");
		intelligencetext.setPosition(25, panel.getY()-25-interval*3);
		this.addActor(intelligencetext);
		
		intelligence=new Label("空");
		intelligence.setPosition(105, intelligencetext.getY());
		this.addActor(intelligence);
		
		Label agilitytext=new Label("敏捷");
		agilitytext.setPosition(25, panel.getY()-25-interval*4);
		this.addActor(agilitytext);
		
		agility=new Label("空");
		agility.setPosition(105, agilitytext.getY());
		this.addActor(agility);
		
		Label nextleveltext=new Label("下一级");
		nextleveltext.setPosition(25, panel.getY()-25-interval*5);
		this.addActor(nextleveltext);
		
		nextlevel=new Label("空");
		nextlevel.setPosition(105, nextleveltext.getY());
		this.addActor(nextlevel);
		
		Label exptext=new Label("经验值");
		exptext.setPosition(25, panel.getY()-25-interval*6);
		this.addActor(exptext);
		
		exp=new Label("空");
		exp.setPosition(105, exptext.getY());
		this.addActor(exp);
		
		Label goldtext=new Label("[金]");
		goldtext.setPosition(25, panel.getY()-25-interval*7);
		this.addActor(goldtext);
		
		gold=new Label("空");
		gold.alignleft=false;
		gold.setPosition(105, goldtext.getY());
		this.addActor(gold);
		
		Label woodtext=new Label("[木]");
		woodtext.setPosition(25, panel.getY()-25-interval*8);
		this.addActor(woodtext);
		
		wood=new Label("空");
		wood.alignleft=false;
		wood.setPosition(105, woodtext.getY());
		this.addActor(wood);
		
		Label watertext=new Label("[水]");
		watertext.setPosition(25, panel.getY()-25-interval*9);
		this.addActor(watertext);
		
		water=new Label("空");
		water.alignleft=false;
		water.setPosition(105, watertext.getY());
		this.addActor(water);
		
		Label firetext=new Label("[火]");
		firetext.setPosition(25, panel.getY()-25-interval*10);
		this.addActor(firetext);
		
		fire=new Label("空");
		fire.alignleft=false;
		fire.setPosition(105, firetext.getY());
		this.addActor(fire);
		
		Label earthtext=new Label("[土]");
		earthtext.setPosition(25, panel.getY()-25-interval*11);
		this.addActor(earthtext);
		
		earth=new Label("空");
		earth.alignleft=false;
		earth.setPosition(105, earthtext.getY());
		this.addActor(earth);
		
	}

	public void fillData(RoleModel role) {
		// TODO Auto-generated method stub
		this.model=role;
		
		GUIEquipePane equipe=(GUIEquipePane) this.getParent();
		
		panel.updateData(role); 
		this.element.setText(role.element);
		this.strength.setText(role.strength);
		this.tolerance.setText(role.tolerance);
		this.intelligence.setText(role.intelligence);
		this.agility.setText(role.agility);
		this.nextlevel.setText(role.nextlevel);
		this.exp.setText(role.exp);
		this.gold.setText(role.gold+"%");
		this.wood.setText(role.wood+"%");
		this.water.setText(role.water+"%");
		this.fire.setText(role.fire+"%");
		this.earth.setText(role.earth+"%");
	}
}
