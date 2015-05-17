package zw.swd.gui;

import zw.swd.game.actions.ActorMoveAction;
import zw.swd.game.actions.RemoveActorAction;
import zw.swd.graphics.Animation;
import zw.swd.main.App;
import zw.swd.main.Config;
import zw.swd.math.Vector2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Menu extends Paper{

	public Picture background;
	public TabButton item;
	public TabButton equipe;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	
	public Menu() {
		// TODO Auto-generated constructor stub
		this.background=new Picture(Config.resPath+"/gui/3-1.png");
		this.setName("menu");
		this.copySize(background);
		this.addActor(background);
		
		Picture itemfocus=new Picture(Config.resPath+"/gui/4-1.png");
		Picture itemnormal=new Picture();
		itemnormal.setSize(itemfocus.getWidth(), itemfocus.getHeight());
		item=new TabButton(itemnormal, itemfocus)
		{
			@Override
			public void setFocus(boolean focus) {
				// TODO Auto-generated method stub
				super.setFocus(focus);
				if(focus)
				{
					Menu menu=(Menu) this.getParent();
					for(Actor actor:menu.getChildren())
					{
						if(actor!=this&&actor instanceof TabButton) ((TabButton)actor).setFocus(false);
					}
					GUI gui=(GUI) this.getParent().getParent();
					gui.background.setAnimation(new Animation(Config.resPath+"/gui/13-1.png"));
					App app=(App)Gdx.app.getApplicationListener();
				
					gui.itemrolelistpanel=new ItemRoleListPanel(app.gameModel);
					gui.itemrolelistpanel.setPosition(-204, 10);
					gui.itemrolelistpanel.startSequenceAction(new ActorMoveAction(gui.itemrolelistpanel,new Vector2(204,0),600f));
					gui.addActor(gui.itemrolelistpanel);
					
					//showitemwindow
					GUIItemWindow window=new GUIItemWindow(app.gameModel);
					gui.addActor(window);
				}
				else
				{
					if(this.getParent()!=null)
					{
					GUI gui=(GUI) this.getParent().getParent();
					gui.itemrolelistpanel.startSequenceAction(new ActorMoveAction(gui.itemrolelistpanel,new Vector2(-204,0),600f));
					gui.itemrolelistpanel.addSequenceAction(new RemoveActorAction(gui.itemrolelistpanel));
					
					}
					
				}
			}
		};
		
		item.setPosition(211, 0);
		item.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
					if(!item.isFocused)item.setFocus(true);
			}
		};		
		this.addActor(item);
		
		Picture equipefocus=new Picture(Config.resPath+"/gui/4-2.png");
		Picture equipenormal=new Picture();
		equipenormal.setSize(equipefocus.getWidth(), equipefocus.getHeight());
		equipe=new TabButton(equipenormal, equipefocus)
		{
			@Override
			public void setFocus(boolean focus) {
				// TODO Auto-generated method stub
				super.setFocus(focus);
				if(focus)
				{
					Menu menu=(Menu) this.getParent();
					for(Actor actor:menu.getChildren())
					{
						if(actor!=this&&actor instanceof TabButton) ((TabButton)actor).setFocus(false);
					}
//				GUI gui=(GUI) this.getParent().getParent();
//				gui.background.setAnimation(new Animation(Config.resPath+"/gui/13-1.png"));
//				App app=(App)Gdx.app.getApplicationListener();
//				
//				gui.itemrolelistpanel=new ItemRoleListPanel(app.gameModel);
//				gui.itemrolelistpanel.setPosition(0, 8);
//				gui.addActor(gui.itemrolelistpanel);
				}
				else
				{
					if(this.getParent()!=null)
					{
					GUI gui=(GUI) this.getParent().getParent();
					gui.removeActor(gui.itemrolelistpanel);
					}
				}
			}
		};
		
		equipe.setPosition(278, 0);
		equipe.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
					if(!equipe.isFocused)equipe.setFocus(true);
			}
		};		
		this.addActor(equipe);
		
	}
}
