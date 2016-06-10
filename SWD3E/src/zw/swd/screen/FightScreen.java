package zw.swd.screen;

import java.util.ArrayList;





import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import zw.swd.game.RoleModel;
import zw.swd.game.actions.AnimationAction;
import zw.swd.game.fight.Battle;
import zw.swd.game.fight.FightModel;
import zw.swd.game.fight.actions.FightActionMgr;
import zw.swd.graphics.SceneGroup;
import zw.swd.graphics.Sprite;
import zw.swd.graphics.fight.FightMap;
import zw.swd.graphics.fight.FightRole;
import zw.swd.gui.FightCmdWindow;
import zw.swd.gui.FightStatePanel;
import zw.swd.gui.MagicTips;
import zw.swd.gui.Paper;
import zw.swd.gui.Picture;
import zw.swd.gui.actions.EndFightAction;
import zw.swd.main.App;
import zw.swd.main.Cache;
import zw.swd.math.Vector2;



public class FightScreen extends SWDScreen{

	public FightModel model;
	public FightActionMgr actionMgr=new FightActionMgr(this);
	public SceneGroup sceneGroup=new SceneGroup();
	public Group magicgroup=new Group();
	public FightRole mouseRole;
	public Battle battle=new Battle(this);
	public int state=-1;//-1系统中，0选择命令，1选择攻击目标，2播放动画，3选择奇术，4选择奇术对象
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		actionMgr.update();
		battle.update(delta);
		checkMouseRole();
		super.render(delta);
		
	}
	private void checkMouseRole() {
		// TODO Auto-generated method stub
		boolean checked=false;
		for(Actor actor:this.sceneGroup.getChildren())
		{
			FightRole sprite=(FightRole)actor;
			if(sprite.isMouseIn()&&!checked) 
				{
				if(this.state==1)
					{
					if(!sprite.ally) sprite.setBorderVisible(Color.RED);
					}
				this.mouseRole=sprite;
				checked=true;
				}
			else
			{
				sprite.setBorderInvisible();
			}
		}
		if(!checked) this.mouseRole=null;
	}
	public static final HashMap<Integer,Vector2> alliesPositions=new HashMap<Integer,Vector2>(){
		{
		put(0,new Vector2(550,300));
		put(1,new Vector2(550,200));
		put(2,new Vector2(500,100));
		}
		
	};
	
	public static final HashMap<Integer,Vector2> enemiesPositions=new HashMap<Integer,Vector2>(){
		{
		put(0,new Vector2(100,300));
		put(1,new Vector2(100,200));
		put(2,new Vector2(100,100));
		}
		
	};
	
	public FightScreen(FightModel model) {
		
		super();
		
		// TODO Auto-generated constructor stub
		this.model=model;
		
//		init();
		
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Keys.SPACE)
			{
			this.rootAction.addAction(new EndFightAction());
			}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
//		actionMgr.playAttack(allies.get(0), enemies.get(0), allies.get(0).roleModel.skills.get("001/attack1"));
//		actionMgr.playCast(allies.get(0), new FightRole[]{enemies.get(0)},  Cache.magics.get("51"));
		
//		this.guiMgr.findActorByName("fightcmdwindow").setVisible(true); 
		
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
		if(button==Buttons.RIGHT)
		{
			if(state==1) 
				{
				this.guiMgr.findActorByName("fightcmdwindow").setVisible(true);
				this.state=0;
				}
			if(state==3) 
			{
				this.guiMgr.findActorByName("magicselectwindow").setVisible(false);
				this.guiMgr.removeActorByName("magicselectwindow");
				this.guiMgr.findActorByName("fightcmdwindow").setVisible(true);
				this.state=0;
			}
		}
		
		if(button==Buttons.LEFT)
		{
			if(this.state==1)
			{
				if(this.mouseRole!=null&&!this.mouseRole.ally)
				{
					this.state=2;
					this.mouseRole.setBorderInvisible();
					this.actionMgr.playAttack(this.battle.currentRole, this.mouseRole, this.battle.currentRole.roleModel.skills.get("001/attack1"));
					
				}
			}
			if(this.state==3||this.state==0)
			{
				
				for(Paper paper:this.guiMgr.getAllPapers())
				{
					if(paper.isVisible()) paper.onClickEvent(button);
				}
				
			}
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
	public void init() {
		// TODO Auto-generated method stub
		
		this.guiMgr.addActor(Cache.controls.get("fightstateframe"));
		MagicTips tips=new MagicTips();
		tips.setPosition(0, 96);
		tips.setSize(640, 28);
		tips.setVisible(false);
		this.guiMgr.addActor(tips);
		this.guiMgr.addActor(FightCmdWindow.create());
		
		this.spriteMgr.addActor(new FightMap(this.model.fightMapResID));
		this.spriteMgr.addActor(sceneGroup);
		this.spriteMgr.addActor(magicgroup);
		for(int i=0;i<this.model.allies.size();i++)
		{
			RoleModel role=model.allies.get(i);
			FightRole fightRole=new FightRole(role);
			fightRole.setName(role.resCode);
			fightRole.index=i;
			fightRole.setCoord(alliesPositions.get(i));
//			fightRole.setAnimation(Cache.fightRoles.get(role.resCode+"/fight/stand_left"));
			fightRole.startSequenceAction(new AnimationAction(fightRole,fightRole.getFightAnimation("stand"),true));
			this.sceneGroup.addActor(fightRole);
			this.battle.allies.add(fightRole);
			this.battle.actionList.add(fightRole);
			FightStatePanel panel=(FightStatePanel)Cache.controls.get("fightstateframe").findActor("fightstatepanel"+(i+1));
			panel.initData(role);
			
		}
		for(int i=0;i<this.model.enemies.size();i++)
		{
			RoleModel role=model.enemies.get(i);
			FightRole fightRole=new FightRole(role);
			
			fightRole.setName(role.resCode);
			fightRole.ally=false;
			fightRole.index=0;
			fightRole.setCoord(enemiesPositions.get(i));
			
			fightRole.startSequenceAction(new AnimationAction(fightRole,fightRole.getFightAnimation("stand"),true));
			this.sceneGroup.addActor(fightRole);
			this.battle.enemies.add(fightRole);
			this.battle.actionList.add(fightRole);
		}
		
	}
	
	public void enterState(int state)
	{
		this.state=state;
		if(state==1)
		{
			this.guiMgr.findActorByName("fightcmdwindow").setVisible(false);
		}
	}
	
	public void backToSceneScreen()
	{
		
	}
	
	public void showWinWindow()
	{
		
	}

}
