package zw.swd.gui;

import zw.swd.main.App;
import zw.swd.screen.Cursor;
import zw.swd.screen.SceneScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl.LwjglInput;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GUI extends Paper implements InputProcessor{

	private static GUI instance;
	Menu menu;
	public Picture background=new Picture();
	public GUIItemPane itempane=GUIItemPane.getInstance();
	public GUIEquipePane equipepane=GUIEquipePane.getInstance();
	public boolean hiding=false;
	int status=0;//0普通,1//使用物品中
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		if(hiding)
		{
			if(!this.itempane.isActing())	
			{
				this.setVisible(false);
				this.hiding=false;
				App app=(App) Gdx.app.getApplicationListener();
				((SceneScreen)app.currentScreen).gameState=0;
				Gdx.input.setInputProcessor(app.currentScreen);
			}
		}
	}

	public static GUI getInstance()
	{
		if(instance==null)
		{
			instance=new GUI();
		}
		
		return instance;
	}
	
	private GUI() {
		// TODO Auto-generated constructor stub
		this.addActor(background);
		
		this.menu=new Menu();
		this.menu.setY(434);
		this.setName("gui");
		this.addActor(menu);
		
		this.addActor(itempane);
		
		this.addActor(equipepane);
	}
	
	
	public void show()
	{
		this.setVisible(true);
		this.menu.item.clickEvent.onClick(Buttons.LEFT);
	}

	public void hide() {
		// TODO Auto-generated method stub
		if(this.menu.item.isFocused) this.menu.item.setFocus(false);
		if(this.menu.equipe.isFocused) this.menu.equipe.setFocus(false);
		this.hiding=true;
		
//		this.itempane.hide();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		if(button==Buttons.LEFT)
		{		
			LwjglInput input=(LwjglInput) Gdx.input;
			
			for(Paper paper:this.getAllPapers())
			{
				if(paper.isVisible()) paper.onClickEvent(button);
			}
			
			if(input.isDoubleClick())
			{
				for(Paper paper:this.getAllPapers())
				{
					if(paper.isVisible()) paper.onDoubleClickEvent(button);
				}
			}
		}
		if (button == Buttons.RIGHT) {
			if(this.status==0)
			{
			if(this.itempane.isActing()) return false;
			this.hide();
			}
			else if(this.status==1)
			{
				this.status=0;
				Cursor.setCursor(0);
			}
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isActing() {
		// TODO Auto-generated method stub
		if(super.isActing()||this.itempane.isActing()||this.equipepane.isActing())
		{
			return true;
		}
		else return false;
	}
}
