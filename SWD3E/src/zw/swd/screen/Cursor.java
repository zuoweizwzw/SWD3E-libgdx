package zw.swd.screen;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.main.Config;
import zw.swd.math.Vector2;

public class Cursor {

	public static Cursor current;
	Animation animation;
	Color color=new Color(1,1,1,1);
	Vector2 hotspot=new Vector2();//hotspot on the texture
	SpriteBatch batch;
	public static HashMap<String, Cursor> cursors=new HashMap<String,Cursor>();
	public void draw() {
		// TODO Auto-generated method stub
		batch.begin();		
		if(animation!=null) animation.draw(Gdx.input.getX()-hotspot.x, Gdx.graphics.getHeight()-Gdx.input.getY()-(animation.getHeight()-hotspot.y), batch, color, 1);
		batch.end();
	}

	public Cursor() {
		// TODO Auto-generated constructor stub
		batch=new SpriteBatch();
	}
	
	public static void setCursor(int type)
	{
		current=cursors.get(Integer.toString(type));
	}
	
	public static void init()
	{
		Cursor cur0=new Cursor();
		cur0.animation=new Animation(Config.resPath+"/gui/37-1.png");
		cur0.hotspot.set(3,3);
		cursors.put("0", cur0);
		
		Cursor cur1=new Cursor();
		cur1.animation=new Animation();
		cur1.animation.addFrame(new Frame(Config.resPath+"/gui/36-16.png",0.2f));
		cur1.animation.addFrame(new Frame(Config.resPath+"/gui/36-17.png",0.2f));
		cur1.hotspot.set(16,16);
		cursors.put("1", cur1);
		
		setCursor(0);
	}
}
