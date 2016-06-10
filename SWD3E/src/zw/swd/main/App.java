package zw.swd.main;

import java.io.IOException;
import java.util.HashMap;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.CursorLoader;

import zw.swd.exscreens.MapDefiner;
import zw.swd.exscreens.MapMatcher;
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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
		Mouse.setClipMouseCoordinatesToWindow(true);

		try {
			Cursor cursor=CursorLoader.get().getCursor("F:/SWD3E"+"\\gui\\37-1.png", 0, 0);
			
			Mouse.setNativeCursor(cursor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		MapMatcher matcher=new MapMatcher(new SpriteBatch());
//		setScreen(matcher);
//		Gdx.input.setInputProcessor(matcher);
		
//		MapDefiner definer=new MapDefiner(new SpriteBatch());
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
		SceneEventsLoader.loadScripts("2");
//		SceneEventsLoader.loadScripts("methods");
		FaceLoader.loadFaces();
		MagicLoader.loadMagics("51","53");
		ItemLoader.loadItems("0017","0004","0064","0170","0281","0284","0057","0224");
		FightMapLoader.loadFightMap("1-1");

		FightRoleLoader.loadFightRole("001");
		FightRoleLoader.loadFightRole("002");
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
