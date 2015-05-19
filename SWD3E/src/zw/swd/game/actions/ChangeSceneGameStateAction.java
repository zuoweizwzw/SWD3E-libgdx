package zw.swd.game.actions;

import com.badlogic.gdx.Gdx;

import zw.swd.action.SWDAction;
import zw.swd.main.App;
import zw.swd.screen.FightScreen;
import zw.swd.screen.SceneScreen;

public class ChangeSceneGameStateAction extends SWDAction{

	int gameState;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		
		App app=(App) Gdx.app.getApplicationListener();
		if(app.currentScreen instanceof SceneScreen)
		{
			((SceneScreen)app.currentScreen).gameState=this.gameState;
		}
		return true;
	}

	public ChangeSceneGameStateAction(int gameState) {
		// TODO Auto-generated constructor stub
		
		this.gameState=gameState;
	}
}
