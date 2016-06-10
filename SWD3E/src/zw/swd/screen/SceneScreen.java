package zw.swd.screen;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import zw.swd.game.actions.AnimationAction;
import zw.swd.game.actions.ActorMoveAction;
import zw.swd.game.actions.SceneActorMoveAction;
import zw.swd.game.actions.SceneActorRunAction;
import zw.swd.game.actions.SceneActorWalkAction;
import zw.swd.game.event.MapEvent;
import zw.swd.graphics.Sprite;
import zw.swd.graphics.scene.SceneActor;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.gui.ControlFactory;
import zw.swd.gui.Dialog1;
import zw.swd.gui.GUI;
import zw.swd.gui.Menu;
import zw.swd.gui.Paper;
import zw.swd.gui.actions.CloseDialogAction;
import zw.swd.gui.actions.OpenDialogAction;
import zw.swd.gui.actions.ShowDialogTextAction;
import zw.swd.gui.actions.StartFightAction;
import zw.swd.gui.actions.WaitMouseClickAction;
import zw.swd.main.Cache;
import zw.swd.math.Vector2;
import zw.swd.scene.scripts.SceneScript;
import zw.swd.scene.scripts.SceneScriptsEngine;
import zw.swd.utils.FontLoader;
import zw.swd.utils.MagicLoader;
import zw.swd.utils.MapLoader;
import zw.swd.utils.Mappings;
import zw.swd.utils.SceneActorLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

public class SceneScreen extends SWDScreen {

	public SceneMap sceneMap;
	public SceneActor actor;
	public int gameState = 0;//-1鼠标移动主角，0普通状态，1执行脚本状态，2GUI状态，3GUI动画状态

	SceneScript currentScript;
	GUI gui;
	public SceneScreen() {
		// TODO Auto-generated constructor stub
		super();
		this.setSceneMap("1-1");
		
		actor = new SceneActor("001");
		actor.pool = SceneActorLoader.loadSceneActorAnis("001");
		actor.setCurrentAniByName("stand_left");
		actor.setCoord(320, 240);

		this.sceneMap.sprites.addActor(actor);
		MapEvent mapEvent=new MapEvent("2");
		mapEvent.setCoord(320, 200);
		mapEvent.setSize(24, 24);
		this.sceneMap.addMapEvent(mapEvent);
		gui=GUI.getInstance();
		this.guiMgr.addActor(gui);
		gui.setVisible(false);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		super.render(delta);
		if(this.rootAction.getActions().size==0&&gameState==1)
		{
			this.gameState=0;
		}
		else if(this.rootAction.getActions().size!=0)
		{
			this.gameState=1;
		}
		handleAnalogInput();
		
		
	}

	private void handleAnalogInput() {
		// TODO Auto-generated method stub
		if(Gdx.input.getInputProcessor()!=this) return;
		handleMouseAnalog();
	}

	private void handleMouseAnalog() {
		// TODO Auto-generated method stub
		if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
			if(gameState==0) moveActor();
		}
	}

	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
//		this.gameState=1;
//		SequenceAction sequence=Actions.sequence(				
//				new StartFightAction(this)
//				);
//		this.guiMgr.addAction(sequence);
		
//		SequenceAction sequence=Actions.sequence(new OpenDialogAction(this,"face/001/1r"));
//		sequence.addAction(new ShowDialogTextAction(this,"[#0000FF]陈靖仇:\n[#FFFBFF]我的家乡已经受到了严重的威胁！请求援助！"));
//		this.guiMgr.addAction(sequence);
		
		if(this.gameState==0)
		{
			if(keycode==Keys.SPACE)	
			{
				stopActorMove();
				currentScript=Cache.sceneScripts.get("1");
				currentScript.run(new SceneScriptsEngine(this));
//				this.gameState=1;
			}
			if(keycode==Keys.ENTER)
			{
				if(this.gameState==0)
				{
					if(!gui.isActing())
					{
					this.stopActorMove();
					Gdx.input.setInputProcessor(gui);
					if(this.gui.itempane.isActing()) return false;
					this.gameState=2;
					this.gui.show();
					}
					
				}
			}
			if(keycode==Keys.S)
			{
				this.stopActorMove();
			}
		}

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
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if (button == Buttons.RIGHT) {
			stopActorMove();
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if(button==Buttons.LEFT)
		{
			if(gameState==2)
			{
				for(Paper paper:this.guiMgr.getAllPapers())
				{
					if(paper.isVisible()) paper.onClickEvent(button);
				}
			}
		}
		
		if (button == Buttons.RIGHT) {
			if(gameState==2)
			{
//				this.guiMgr.removeActorByName("gui");
				if(gui.itempane.isActing()) return false;
				gui.hide();//
			}
		}
		
		return false;
	}
	
	private void stopActorMove()
	{
		if (gameState == 0) {

			if (actor.getActions().size > 0
					&& actor.getActions().get(0) instanceof SceneActorMoveAction) {
				SceneActorMoveAction action = (SceneActorMoveAction) this.actor
						.getActions().get(0);
				action.stopCmd = true;
			}
		}
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

	public void setSceneMap(String mapId) {
		SceneMap sceneMap=MapLoader.loadSceneMap(mapId);
		this.sceneMap = sceneMap;
		this.spriteMgr.removeActors(SceneMap.class);
		this.spriteMgr.addActor(sceneMap);
	}

	private void moveActor() {

		Vector2 mouse = new Vector2(Gdx.input.getX(), 480 - Gdx.input.getY());
		Vector2 centerPoint = actor.getCenterPoint();
		Vector3 centerPoint_screen = this.spriteMgr.getCamera().project(
				new Vector3(centerPoint.x, centerPoint.y, 0));
		Vector2 deltaVec = mouse.subNew(new Vector2(centerPoint_screen.x,
				centerPoint_screen.y));

		int direction = (Mappings.getDirectionByVector(deltaVec));

		if (direction == -1)
			return;

		if (gameState == 0) {
			
			if (this.actor.getActions().size == 0) {

				if (deltaVec.len() <= 32)
					return;
				if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))this.actor
						.addAction(new SceneActorRunAction(direction, actor));
				else this.actor
				.addAction(new SceneActorWalkAction(direction, actor));
			} else if (actor.getActions().get(0) instanceof SceneActorMoveAction) {

				SceneActorMoveAction action = (SceneActorMoveAction) this.actor
						.getActions().get(0);
				if (deltaVec.len() <= 32) {
					action.stopCmd = true;
				}
				
				if(action instanceof SceneActorWalkAction&&Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
				{
					actor.removeAction(action);
					this.actor.addAction(new SceneActorRunAction(direction, actor));					
				}
				if(action instanceof SceneActorRunAction&&!Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
				{
					actor.removeAction(action);
					this.actor.addAction(new SceneActorWalkAction(direction, actor));					
				}
				if (action.direction != direction) {
					action.changeDirection(direction);
				}
			}

		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean checkColis(Sprite sprite,Vector2 delta)
	{
		
		Vector2 location=this.actor.getCoordCopy();
		 
		//check map
		
		
		return false;
	}
	
	private void addSprite(Sprite sprite)
	{
		this.sceneMap.sprites.addActor(sprite);
	}
	
}
