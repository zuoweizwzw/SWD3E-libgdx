package zw.swd.exscreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MapMatcher implements Screen,InputProcessor{

	SpriteBatch batch;
	public Texture map;
	public Texture control;
	public int x,y;
	public int mapx,mapy;
	public MapMatcher(SpriteBatch batch) {
		// TODO Auto-generated constructor stub
		this.batch=batch;
		this.map=new Texture(Gdx.files.absolute("F:\\SWD3E\\huge\\1-1\\1-1.png"));
		this.control=new Texture(Gdx.files.absolute("F:\\SWD3E\\huge\\1-1\\1-8.png"));
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
	batch.draw(map, mapx, mapy);	
	batch.draw(control,x+mapx,y+mapy);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Keys.LEFT)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.x-=32;
			}
			else this.x-=8;
		}
		if(keycode==Keys.RIGHT)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.x+=32;
			}
			else this.x+=8;
		}
		if(keycode==Keys.UP)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.y+=32;
			}
			else this.y+=8;
		}
		if(keycode==Keys.DOWN)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.y-=32;
			}
			else this.y-=8;
		}
		
		if(keycode==Keys.W)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.mapy-=32;
				
			}
			else 
				{
				this.mapy-=32;
				
				}
		}
		
		if(keycode==Keys.S)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.mapy+=32;
			}
			else 
				{
				this.mapy+=32;				
				}
		}
		
		if(keycode==Keys.A)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.mapx+=32;
			}
			else 
				{
				this.mapx+=32;				
				}
		}
		
		if(keycode==Keys.D)
		{
			if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT))
			{
				this.mapx-=32;
			}
			else 
				{
				this.mapx-=32;				
				}
		}
		
		System.out.println(x+","+y);
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

}
