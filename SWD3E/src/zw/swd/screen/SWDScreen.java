package zw.swd.screen;

import java.util.ArrayList;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;
import zw.swd.graphics.SpriteMgr;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.gui.GuiMgr;
import zw.swd.gui.Paper;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public abstract class SWDScreen extends Actor implements Screen,InputProcessor{
	public SpriteMgr spriteMgr;
	public GuiMgr guiMgr;
	
	public SequenceAction rootAction=new SequenceAction();
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		rootAction.act(delta);
		
		
		
		spriteMgr.draw();
		spriteMgr.act(delta);
		
		
		guiMgr.draw();
		guiMgr.act(delta);
		
		
		
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub
		this.rootAction.addAction(action);
//		action.setActor(this);
	}
	
	public void addActions(Action... actions) {
		// TODO Auto-generated method stub
		
		for(Action action:actions)
		{
			addAction(action);
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public SWDScreen() {
		// TODO Auto-generated constructor stub
		this.spriteMgr=new SpriteMgr(this);
		this.guiMgr=new GuiMgr(this);
		this.rootAction.setActor(this);
		
	}

	public void enterScreen()
	{
		
	}
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}
	
	public abstract void init();
}
