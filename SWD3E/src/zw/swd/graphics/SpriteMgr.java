package zw.swd.graphics;

import java.util.ArrayList;

import zw.swd.gui.GuiMgr;
import zw.swd.screen.SWDScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public class SpriteMgr extends Stage{
	public SWDScreen screen;
	
	public SpriteMgr(SWDScreen screen) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
	}
	
	public GuiMgr getGuiMgr()
	{
		return this.screen.guiMgr;
	}
	
	
	
}
