package zw.swd.gui;

import java.util.ArrayList;
import java.util.HashMap;

import zw.swd.screen.SWDScreen;
import zw.swd.utils.FaceLoader;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public class GuiMgr extends Stage {

	public SWDScreen screen;
	public SequenceAction rootAction=new SequenceAction();
	public GuiMgr(SWDScreen screen) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.addActor(new Dialog1());
		this.findActorByName("gui/dialog1").setVisible(false);
	}

	
	public Paper findActorByName(String name)
	{
		if(getRoot().findActor(name) instanceof Paper) return getRoot().findActor(name);
		else return null;
	}
	
	public ArrayList<Paper> getAllPapers()
	{
		ArrayList<Paper> papers=new ArrayList<>();
		for(Actor actor:getRoot().getChildren())
		{
			if(actor instanceof Paper)
			{
				papers.add((Paper)actor);
			}
		}
		return papers;
	}
	
	public void removeActorByName(String name)
	{
		Actor actor=getRoot().findActor(name);
		if(actor!=null && actor instanceof Paper)  getRoot().removeActor(actor);
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		rootAction.act(delta);
	}

	public ArrayList<Paper> getAllDeepPapers() {
		// TODO Auto-generated method stub
		ArrayList<Paper> papers=new ArrayList<>();
		for(Paper paper:this.getAllPapers())
		{
			papers.add(paper);
			papers.addAll(paper.getAllDeepPapers());
		}
		return papers;
	}
	
	
}
