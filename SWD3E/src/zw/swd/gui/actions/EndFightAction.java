package zw.swd.gui.actions;

import com.badlogic.gdx.Gdx;

import zw.swd.action.SWDAction;
import zw.swd.main.App;
import zw.swd.screen.FightScreen;
import zw.swd.screen.SceneScreen;
import zw.swd.utils.TestUtils;

public class EndFightAction extends SWDAction {

	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		App game=(App)Gdx.app.getApplicationListener();
		SceneScreen screen=(SceneScreen) game.screens.get("scene");
		screen.actor.setCurrentAniByName("stand_left");
	game.changeScreen(game.screens.get("scene"));
		
		return true;
	}

}
