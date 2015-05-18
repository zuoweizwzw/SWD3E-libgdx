package zw.swd.main;

import java.util.HashMap;

import zw.swd.game.GameModel;
import zw.swd.screen.FightScreen;
import zw.swd.screen.SWDScreen;
import zw.swd.screen.SceneScreen;
import zw.swd.utils.FaceLoader;
import zw.swd.utils.FightMapLoader;
import zw.swd.utils.FightRoleLoader;
import zw.swd.utils.FontLoader;
import zw.swd.utils.GUILoader;
import zw.swd.utils.ItemLoader;
import zw.swd.utils.MagicLoader;
import zw.swd.utils.ResourceLoader;
import zw.swd.utils.SceneEventsLoader;
import zw.swd.utils.TestUtils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class App extends Game{

	public HashMap<String,SWDScreen> screens=new HashMap<String, SWDScreen>();
	public SWDScreen currentScreen;
	public ResourceLoader resourceLoader=new ResourceLoader();
	public GameModel gameModel;
	@Override
	public void create () {
		
		initGame();		
		SceneScreen screen=new SceneScreen();
		screens.put("scene", screen);
		Gdx.input.setInputProcessor(screen);
		this.setScreen(screen);
		this.currentScreen=screen;
		
//		MapMatcher matcher=new MapMatcher(batch);
//		setScreen(matcher);
//		Gdx.input.setInputProcessor(matcher);
		
//		MapDefiner definer=new MapDefiner(batch);
//		setScreen(definer);
//		Gdx.input.setInputProcessor(definer);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ResourceLoader.update();
		super.render();
	}
	
	public void initGame()
	{
		FontLoader.loadFont();
		
		SceneEventsLoader.loadScripts("1");
//		SceneEventsLoader.loadScripts("methods");
		FaceLoader.loadFaces();
//		MagicLoader.loadMagics("51","53");
		ItemLoader.loadItems("0017","0004");
//		FightMapLoader.loadFightMap("1-1");
//		FightRoleLoader.loadFightRole("001");
//		FightRoleLoader.loadFightRole("002");
		GUILoader.loadControls();
		GameModel gameModel=TestUtils.generateTestGameModel();
		this.gameModel=gameModel;
	}
	
	public void changeScreen(SWDScreen screen)
	{
		if(screen instanceof FightScreen)
		{
			this.screens.put("fight", screen);
			this.screens.get("scene").pause();
			Gdx.input.setInputProcessor(screen);
			screen.init();
			this.setScreen(screen);
		}
		if(screen instanceof SceneScreen)
		{
			this.screens.remove("fight");
			Gdx.input.setInputProcessor(screen);
			this.setScreen(screen);
		}
		this.currentScreen=screen;
	}
	
	

}
