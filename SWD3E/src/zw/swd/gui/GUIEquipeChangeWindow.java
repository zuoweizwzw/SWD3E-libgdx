package zw.swd.gui;

import zw.swd.game.ItemModel;
import zw.swd.game.RoleModel;
import zw.swd.gui.special.WindowStyle1;
import zw.swd.main.Config;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIEquipeChangeWindow extends Paper{

	private static GUIEquipeChangeWindow instance;
	
	Label oldAttack;
	Label newAttack;
	Label oldDefense;
	Label newDefense;
	Label oldAgility;
	Label newAgility;
	Picture attackpic=new Picture();
	Picture defensepic=new Picture();
	Picture agilitypic=new Picture();
	Picture proficiencypic;
	Picture background;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public static GUIEquipeChangeWindow getInstance()
	{
		if(instance==null)
		{
			instance=new GUIEquipeChangeWindow();
		}
		
		return instance;
	}
	
	private GUIEquipeChangeWindow() {
		// TODO Auto-generated constructor stub
		background=WindowStyle1.createInstance(186, 94);
		this.addActor(background);
		
		Label attack=new Label("攻击");
		attack.setPosition(15, 66);
		this.addActor(attack);
		
		Label defense=new Label("防御");
		defense.setPosition(15, 46);
		this.addActor(defense);
		
		Label agility=new Label("敏捷");
		agility.setPosition(15, 26);
		this.addActor(agility);
		
		Label proficiency=new Label("熟练度");
		proficiency.setPosition(15, 6);
		this.addActor(proficiency);
		
		oldAttack=new Label();
		oldAttack.setText("");
		oldAttack.setPosition(110, 66);
		oldAttack.alignleft=false;
		this.addActor(oldAttack);
		
		attackpic.setAnimation(Config.resPath+"/gui/54-1.png");
		attackpic.setPosition(114, 68);
		this.addActor(attackpic);
		
		newAttack=new Label();
		newAttack.setText("");
		newAttack.setPosition(135, 66);
		this.addActor(newAttack);
		
		oldDefense=new Label();
		oldDefense.setText("");
		oldDefense.setPosition(110, 46);
		oldDefense.alignleft=false;
		this.addActor(oldDefense);
		
		defensepic.setAnimation(Config.resPath+"/gui/54-1.png");
		defensepic.setPosition(114, 48);
		this.addActor(defensepic);
		
		newDefense=new Label();
		newDefense.setText("");
		newDefense.setPosition(135, 46);
		this.addActor(newDefense);
		
		oldAgility=new Label();
		oldAgility.setText("");
		oldAgility.setPosition(110, 26);
		oldAgility.alignleft=false;
		this.addActor(oldAgility);
		
		agilitypic.setAnimation(Config.resPath+"/gui/54-1.png");
		agilitypic.setPosition(114, 28);
		this.addActor(agilitypic);
		
		newAgility=new Label();
		newAgility.setText("");
		newAgility.setPosition(135, 26);
		this.addActor(newAgility);
		
	}
	
	public void fillData(RoleModel role, ItemModel current,ItemModel nouvel)
	{
		int currentattack=0;
		if(current!=null) currentattack=current.equipe_attack;
		this.oldAttack.setText(role.getAttack());
		int newattack=role.getAttack()-currentattack+nouvel.equipe_attack;
		if(newattack>role.getAttack()) this.attackpic.setAnimation(Config.resPath+"/gui/54-1.png");
		else if(newattack<role.getAttack()) this.attackpic.setAnimation(Config.resPath+"/gui/55-1.png");
		else this.attackpic.setAnimation("");
		this.newAttack.setText(newattack);
		
		int currentdefense=0;
		if(current!=null) currentdefense=current.equipe_defense;
		this.oldDefense.setText(role.getDefense());
		int newdefense=role.getDefense()-currentdefense+nouvel.equipe_defense;
		if(newdefense>role.getDefense()) this.defensepic.setAnimation(Config.resPath+"/gui/54-1.png");
		else if(newdefense<role.getDefense()) this.defensepic.setAnimation(Config.resPath+"/gui/55-1.png");
		else this.defensepic.setAnimation("");
		this.newDefense.setText(newdefense);
		
		int currentdagility=0;
		if(current!=null) currentdagility=current.equipe_agility;
		this.oldAgility.setText(role.getAgility());
		int newagility=role.getAgility()-currentdagility+nouvel.equipe_agility;
		if(newagility>role.getAgility()) this.agilitypic.setAnimation(Config.resPath+"/gui/54-1.png");
		else if(newagility<role.getAgility()) this.agilitypic.setAnimation(Config.resPath+"/gui/55-1.png");
		else this.agilitypic.setAnimation("");
		this.newAgility.setText(newagility);
	}
	
	public void clearData()
	{
		this.newAgility.setText("");
		this.newDefense.setText("");
		this.newAttack.setText("");
		
		this.attackpic.setAnimation("");
		this.defensepic.setAnimation("");
		this.agilitypic.setAnimation("");
		
	}

	public void reset() {
		// TODO Auto-generated method stub
		RoleModel role=GUIEquipePane.getInstance().getCurrentRoleModel();
		if(role!=null)
		{
			this.oldAgility.setText(role.getAgility());
			this.oldDefense.setText(role.getDefense());
			this.oldAttack.setText(role.getAttack());
			
			this.attackpic.setAnimation("");
			this.defensepic.setAnimation("");
			this.agilitypic.setAnimation("");
			
			this.newAgility.setText("");
			this.newDefense.setText("");
			this.newAttack.setText("");
		}
		
	}
}
