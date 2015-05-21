package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.RoleModel;
import zw.swd.gui.special.WindowStyle1;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GUIEquipeStatusWindow extends Paper{

	Picture background;
	GUIEquipeStatusItem weapon;
	GUIEquipeStatusItem head;
	GUIEquipeStatusItem body;
	GUIEquipeStatusItem hand;
	GUIEquipeStatusItem foot;
	GUIEquipeStatusItem attach1;
	GUIEquipeStatusItem attach2;
	GUIEquipeStatusItem fabao1;
	GUIEquipeStatusItem fabao2;
	GUIEquipeStatusItem hujia1;
	GUIEquipeStatusItem hujia2;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public GUIEquipeStatusWindow() {
		// TODO Auto-generated constructor stub
		this.setName("guiequipestatuswindow");
		
		this.background=WindowStyle1.createInstance(235, 328);
		this.addActor(background);
		
		int interval=29;
		
		weapon=new GUIEquipeStatusItem();
		weapon.setType(0);
		weapon.setPosition(3, 295-interval*0);
		this.addActor(weapon);
		
		head=new GUIEquipeStatusItem();
		head.setType(1);
		head.setPosition(3, 295-interval*1);
		this.addActor(head);
		
		body=new GUIEquipeStatusItem();
		body.setType(2);
		body.setPosition(3, 295-interval*2);
		this.addActor(body);
		
		hand=new GUIEquipeStatusItem();
		hand.setType(3);
		hand.setPosition(3, 295-interval*3);
		this.addActor(hand);
		
		foot=new GUIEquipeStatusItem();
		foot.setType(4);
		foot.setPosition(3, 295-interval*4);
		this.addActor(foot);
		
		attach1=new GUIEquipeStatusItem();
		attach1.setType(5);
		attach1.setPosition(3, 295-interval*5);
		this.addActor(attach1);
		
		attach2=new GUIEquipeStatusItem();
		attach2.setType(6);
		attach2.setPosition(3, 295-interval*6);
		this.addActor(attach2);
		
		fabao1=new GUIEquipeStatusItem();
		fabao1.setType(7);
		fabao1.setPosition(3, 295-interval*7);
		this.addActor(fabao1);
		
		fabao2=new GUIEquipeStatusItem();
		fabao2.setType(8);
		fabao2.setPosition(3, 295-interval*8);
		this.addActor(fabao2);
		
		hujia1=new GUIEquipeStatusItem();
		hujia1.setType(9);
		hujia1.setPosition(3, 295-interval*9);
		this.addActor(hujia1);
		
		hujia2=new GUIEquipeStatusItem();
		hujia2.setType(10);
		hujia2.setPosition(3, 295-interval*10);
		this.addActor(hujia2);
		
	}
	
	public void fillData(RoleModel model)
	{
		ArrayList<Actor> actors=this.findActors(GUIEquipeStatusItem.class);
		for(Actor actor:actors)
		{
			GUIEquipeStatusItem item=(GUIEquipeStatusItem) actor;
			item.fillData(model);
		}
	}
}
