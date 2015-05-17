package zw.swd.gui.actions;

import zw.swd.action.SWDAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Action;

public class WaitMouseClickAction extends SWDAction implements InputProcessor{

	public boolean clicked=false;
	public int status=0;
	public InputProcessor orignal;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			orignal=Gdx.input.getInputProcessor();
			Gdx.input.setInputProcessor(this);
			this.status=1;
		}
		if(status==1)
		{
			if(clicked)
			{
				this.status=2;
				Gdx.input.setInputProcessor(orignal);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		if(Input.Keys.SPACE==keycode) clicked=true;
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
		this.clicked=true;
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
