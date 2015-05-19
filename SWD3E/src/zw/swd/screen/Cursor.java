package zw.swd.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import zw.swd.graphics.Animation;
import zw.swd.main.Config;
import zw.swd.math.Vector2;

public class Cursor {

	Animation animation;
	Color color=new Color(1,1,1,1);
	Vector2 hotspot=new Vector2();//hotspot on the texture
	SpriteBatch batch;
	public void draw() {
		// TODO Auto-generated method stub
		batch.begin();		
		if(animation!=null) animation.draw(Gdx.input.getX()-hotspot.x, Gdx.graphics.getHeight()-Gdx.input.getY()-(animation.getHeight()-hotspot.y), batch, color, 1);
		batch.end();
	}

	public Cursor() {
		// TODO Auto-generated constructor stub
		batch=new SpriteBatch();
		animation=new Animation(Config.resPath+"/gui/37-1.png");
		hotspot.set(3, 3);
	}
}
