package zw.swd.gui;

import zw.swd.main.App;
import zw.swd.screen.SceneScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GUI extends Paper implements InputProcessor{

	Menu menu;
	public Picture background=new Picture();
	public GUIItemPane itempane=new GUIItemPane();
	public GUIEquipePane equipepane=new GUIEquipePane();
	public boolean hiding=false;
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

	public GUI() {
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
			for(Paper paper:this.getAllPapers())
			{
				if(paper.isVisible()) paper.onClickEvent(button);
			}
		}
		if (button == Buttons.RIGHT) {
			if(this.itempane.isActing()) return false;
			this.hide();
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
