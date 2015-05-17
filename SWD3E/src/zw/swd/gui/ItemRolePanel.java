package zw.swd.gui;

import zw.swd.game.RoleModel;
import zw.swd.main.Config;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class ItemRolePanel extends Paper{

	
	Picture background;
	Label levelnum;
	Label leveltext;
	Label exp;
	Label name;
	Label hp;
	Label hpsplit;
	Label hpmax;
	Picture hpbackground;
	Picture hpprogress;
	Label mp;
	Label mpsplit;
	Label mpmax;
	Picture mpbackground;
	Picture mpprogress;
	Label energe;
	Label energesplit;
	Label energemax;
	Picture energebackground;
	Picture energeprogress;
	RoleModel model;
	public ItemRolePanel(RoleModel model) {
		// TODO Auto-generated constructor stub
		this.model=model;
		if(model.resCode.equals("001"))
		{
		background=new Picture(Config.resPath+"/gui/2-6.png");
		}
		this.addActor(background);
		this.copySize(background);
		
		this.levelnum=new Label(Integer.toString(model.level));
		this.levelnum.setPosition(81, 100);
		this.addActor(levelnum);
		
		this.leveltext=new Label("级/");
		this.leveltext.setPosition(101, 100);
		this.addActor(leveltext);
		
		this.exp=new Label(Integer.toString(model.exp));
		this.exp.setPosition(128, 100);
		this.addActor(exp);
		
		this.name=new Label(model.name);
		this.name.setPosition(90, 80);
		this.addActor(name);
		
		this.hp=new Label(Integer.toString(model.hp));
		this.hp.setPosition(124, 60);
		this.hp.setFont(FontLoader.font14);
		this.hp.alignleft=false;
		this.addActor(hp);
		
		this.hpsplit=new Label("/");
		this.hpsplit.setPosition(125, 60);
		this.hpsplit.setFont(FontLoader.font14);
		this.addActor(hpsplit);
		
		this.hpmax=new Label(Integer.toString(model.hp_max));
		this.hpmax.setPosition(132, 60);
		this.hpmax.setFont(FontLoader.font14);
		this.addActor(hpmax);
		
		this.hpbackground=new Picture(Config.resPath+"/gui/16-4.png");
		this.hpbackground.setPosition(90, 57);
		this.addActor(hpbackground);
		
		this.hpprogress=new Picture(Config.resPath+"/gui/16-1.png");
		this.hpprogress.setPosition(90, 57);
		this.hpprogress.setPhysicWidth((int)(((float)model.hp/(float)model.hp_max)*82));
		this.addActor(hpprogress);
		
		this.mp=new Label(Integer.toString(model.mp));
		this.mp.setPosition(124, 36);
		this.mp.setFont(FontLoader.font14);
		this.mp.alignleft=false;
		this.addActor(mp);
		
		this.mpsplit=new Label("/");
		this.mpsplit.setPosition(125, 36);
		this.mpsplit.setFont(FontLoader.font14);
		this.addActor(mpsplit);
		
		this.mpmax=new Label(Integer.toString(model.mp_max));
		this.mpmax.setPosition(132, 36);
		this.mpmax.setFont(FontLoader.font14);
		this.addActor(mpmax);
		
		this.mpbackground=new Picture(Config.resPath+"/gui/16-4.png");
		this.mpbackground.setPosition(90, 33);
		this.addActor(mpbackground);
		
		this.mpprogress=new Picture(Config.resPath+"/gui/16-2.png");
		this.mpprogress.setPosition(90, 33);
		this.mpprogress.setPhysicWidth((int)(((float)model.mp/(float)model.mp_max)*82));
		this.addActor(mpprogress);
		
		this.energe=new Label(Integer.toString(model.energe));
		this.energe.setPosition(124, 12);
		this.energe.setFont(FontLoader.font14);
		this.energe.alignleft=false;
		this.addActor(energe);
		
		this.energesplit=new Label("/");
		this.energesplit.setPosition(125, 12);
		this.energesplit.setFont(FontLoader.font14);
		this.addActor(energesplit);
		
		this.energemax=new Label(Integer.toString(model.energe_max));
		this.energemax.setPosition(132, 12);
		this.energemax.setFont(FontLoader.font14);
		this.addActor(energemax);
		
		this.energebackground=new Picture(Config.resPath+"/gui/16-4.png");
		this.energebackground.setPosition(90, 9);
		this.addActor(energebackground);
		
		this.energeprogress=new Picture(Config.resPath+"/gui/16-3.png");
		this.energeprogress.setPosition(90, 9);
		this.energeprogress.setPhysicWidth((int)(((float)model.energe/(float)model.energe_max)*82));
		this.addActor(energeprogress);
		
	}

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateData()
	{
		
	}
	
	

}
