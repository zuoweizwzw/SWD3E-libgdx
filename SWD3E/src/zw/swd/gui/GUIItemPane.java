package zw.swd.gui;

import zw.swd.game.GameModel;
import zw.swd.game.actions.ActorMoveAction;
import zw.swd.game.actions.WaitAction;
import zw.swd.main.App;
import zw.swd.math.Vector2;
import zw.swd.screen.SceneScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIItemPane extends GUIPane{

	public ItemRoleListPanel itemrolelistpanel;
	public GUIItemWindow itemwindow;
	public GUIItemView view;
	private static GUIItemPane instance=null; 
	public GUIItemDescription description;
	GameModel gameModel;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	public static GUIItemPane getInstance()
	{
		if(instance==null)
		{
			instance=new GUIItemPane();
		}
		return instance;
	}
	
	private GUIItemPane() {
		// TODO Auto-generated constructor stub
		itemrolelistpanel=new ItemRoleListPanel();
		itemrolelistpanel.setPosition(-204, 10);
		itemwindow=new GUIItemWindow();
		
//		itemwindow.setPosition(432+304, 40);//208正常位置x，304宽度
		itemwindow.setPosition(640, 40);
		view=new GUIItemView();
		description=new GUIItemDescription();
		description.setPosition(208, -(1+40));
		
		this.addActor(itemrolelistpanel);
		this.addActor(itemwindow);
		this.addActor(view);
		this.addActor(description);
		
		App app=(App)Gdx.app.getApplicationListener();
		this.fillData(app.gameModel);
	}
	
	public void fillData(GameModel gameModel)
	{
		this.gameModel=gameModel;
		itemrolelistpanel.fillData(gameModel);
		itemwindow.fillData(gameModel);
	}
	
	public void show()
	{
		this.isshowing=true;
		itemwindow.reset();
		this.startParellAction(new ActorMoveAction(itemrolelistpanel,new Vector2(204,0),600f));
		this.addAction(new ActorMoveAction(itemwindow,new Vector2(-(432),0),1500f));
		this.addAction(new ActorMoveAction(description,new Vector2(0,1+40),140f));
	}
	
	public void hide()
	{
		if(isshowing)
		{
		this.startParellAction(new ActorMoveAction(itemrolelistpanel,new Vector2(-204,0),600f));
		this.addAction(new ActorMoveAction(itemwindow,new Vector2((432),0),1500f));
		this.addAction(new ActorMoveAction(description,new Vector2(0,-(1+40)),140f));
		this.addAction(new WaitAction(0.3f));
		this.view.setVisible(false);
		}
	}
	
}
