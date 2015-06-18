package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.graphics.Animation;
import zw.swd.main.Config;
import zw.swd.screen.Cursor;
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


	public ItemRolePanel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateData(RoleModel model)
	{
		this.model=model;
		if(model.resCode.equals("001"))
		{
		background.setAnimation(new Animation(Config.resPath+"/gui/2-6.png"));
		}
		this.levelnum.setText(Integer.toString(model.level));
		this.exp.setText(Integer.toString(model.nextlevel-model.exp));
		this.name.setText(model.name);
		this.hp.setText(Integer.toString(model.hp));
		this.hpmax.setText(Integer.toString(model.hp_max));
		this.hpprogress.setPhysicWidth((int)(((float)model.hp/(float)model.hp_max)*82));
		this.mp.setText(Integer.toString(model.mp));
		this.mpmax.setText(Integer.toString(model.mp_max));
		this.mpprogress.setPhysicWidth((int)(((float)model.mp/(float)model.mp_max)*82));
		this.energe.setText(Integer.toString(model.energe));
		this.energemax.setText(Integer.toString(model.energe_max));
		this.energeprogress.setPhysicWidth((int)(((float)model.energe/(float)model.energe_max)*82));
	}
	
	public static ItemRolePanel createInstance()
	{
		ItemRolePanel panel=new ItemRolePanel();
		panel.setName("itemrolepanel");
		panel.background=new Picture();
		panel.setSize(176, 131);
		panel.addActor(panel.background);
		
		panel.levelnum=new Label("0");
		panel.levelnum.setPosition(81, 100);
		panel.addActor(panel.levelnum);
		
		panel.leveltext=new Label("级/");
		panel.leveltext.setPosition(101, 100);
		panel.addActor(panel.leveltext);
		
		panel.exp=new Label("0");
		panel.exp.setPosition(128, 100);
		panel.addActor(panel.exp);
		
		panel.name=new Label("空");
		panel.name.setPosition(90, 80);
		panel.addActor(panel.name);
		
		panel.hp=new Label("0");
		panel.hp.setPosition(124, 60);
		panel.hp.setFont(FontLoader.font14);
		panel.hp.alignleft=false;
		panel.addActor(panel.hp);
		
		panel.hpsplit=new Label("/");
		panel.hpsplit.setPosition(125, 60);
		panel.hpsplit.setFont(FontLoader.font14);
		panel.addActor(panel.hpsplit);
		
		panel.hpmax=new Label("0");
		panel.hpmax.setPosition(132, 60);
		panel.hpmax.setFont(FontLoader.font14);
		panel.addActor(panel.hpmax);
		
		panel.hpbackground=new Picture(Config.resPath+"/gui/16-4.png");
		panel.hpbackground.setPosition(90, 57);
		panel.addActor(panel.hpbackground);
		
		panel.hpprogress=new Picture(Config.resPath+"/gui/16-1.png");
		panel.hpprogress.setPosition(90, 57);
		panel.hpprogress.setPhysicWidth(0);
		panel.addActor(panel.hpprogress);
		
		panel.mp=new Label("0");
		panel.mp.setPosition(124, 36);
		panel.mp.setFont(FontLoader.font14);
		panel.mp.alignleft=false;
		panel.addActor(panel.mp);
		
		panel.mpsplit=new Label("/");
		panel.mpsplit.setPosition(125, 36);
		panel.mpsplit.setFont(FontLoader.font14);
		panel.addActor(panel.mpsplit);
		
		panel.mpmax=new Label("0");
		panel.mpmax.setPosition(132, 36);
		panel.mpmax.setFont(FontLoader.font14);
		panel.addActor(panel.mpmax);
		
		panel.mpbackground=new Picture(Config.resPath+"/gui/16-4.png");
		panel.mpbackground.setPosition(90, 33);
		panel.addActor(panel.mpbackground);
		
		panel.mpprogress=new Picture(Config.resPath+"/gui/16-2.png");
		panel.mpprogress.setPosition(90, 33);
		panel.mpprogress.setPhysicWidth(0);
		panel.addActor(panel.mpprogress);
		
		panel.energe=new Label("0");
		panel.energe.setPosition(124, 12);
		panel.energe.setFont(FontLoader.font14);
		panel.energe.alignleft=false;
		panel.addActor(panel.energe);
		
		panel.energesplit=new Label("/");
		panel.energesplit.setPosition(125, 12);
		panel.energesplit.setFont(FontLoader.font14);
		panel.addActor(panel.energesplit);
		
		panel.energemax=new Label("0");
		panel.energemax.setPosition(132, 12);
		panel.energemax.setFont(FontLoader.font14);
		panel.addActor(panel.energemax);
		
		panel.energebackground=new Picture(Config.resPath+"/gui/16-4.png");
		panel.energebackground.setPosition(90, 9);
		panel.addActor(panel.energebackground);
		
		panel.energeprogress=new Picture(Config.resPath+"/gui/16-3.png");
		panel.energeprogress.setPosition(90, 9);
		panel.energeprogress.setPhysicWidth(0);
		panel.addActor(panel.energeprogress);
		
		return panel;
	}
	
	@Override
	public void drawOverAll(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(GUI.getInstance().status==1&&isMouseIn())
		{
			this.drawRect(batch, parentAlpha,new Color(0,0,0.6f,0.6f));
		}
	}
	
	@Override
	public void onClickEvent(int button) {
		// TODO Auto-generated method stub
		if(isMouseIn())
		{
			if(GUI.getInstance().status==1)
			{
				GUIItemWindow window=GUI.getInstance().findActor("guiitemwindow");
				window.getSelectedItem().gameItem.itemModel.use(model);
				window.getSelectedItem().gameItem.num--;
				if(window.getSelectedItem().gameItem.num==0)
				{
					GameModel.getInstance().removeItem(window.getSelectedItem().gameItem);
					GUI.getInstance().status=0;
					Cursor.setCursor(0);
				}
				this.updateData(model);
				window.updateData();
			}
		}
	}

}
