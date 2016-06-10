package zw.swd.game.fight.actions;

import com.badlogic.gdx.Gdx;

import zw.swd.action.SWDAction;
import zw.swd.main.App;
import zw.swd.screen.FightScreen;
import zw.swd.screen.SceneScreen;
import zw.swd.utils.TestUtils;

public class ChangeMapAction extends SWDAction{

	public String mapId;
	int x;
	int y;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		App game=(App)Gdx.app.getApplicationListener();
		SceneScreen screen=(SceneScreen) game.currentScreen;
		screen.sceneMap.sprites.removeActor(screen.actor);
		screen.setSceneMap(mapId);
		screen.actor.setCoord(x, y);
		screen.sceneMap.sprites.addActor(screen.actor);
		
		return true;
	}

	public ChangeMapAction(String mapId,int x,int y) {
		// TODO Auto-generated constructor stub
		this.mapId=mapId;
		this.x=x;
		this.y=y;
	}
}
