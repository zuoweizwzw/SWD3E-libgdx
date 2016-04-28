package zw.swd.game.event;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import zw.swd.graphics.Sprite;
import zw.swd.main.Cache;
import zw.swd.scene.scripts.SceneScript;
import zw.swd.scene.scripts.SceneScriptsEngine;

/*****
 * 地图事件，需要主角踩到方能触发
 * @author zuowei
 *
 */
public class MapEvent extends Sprite{

	SceneScript script;
	ShapeRenderer renderer=new ShapeRenderer();
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		drawRect(batch,parentAlpha);
	}
	private void drawRect(Batch batch,float parentAlpha)
	{
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		renderer.begin(ShapeType.Filled);
		renderer.setColor(new Color(0,1,0,0.7f));
		
		renderer.rect(this.getCoordX(), this.getCoordY(), this.getWidth(), this.getHeight());
		renderer.end();
		batch.begin();
	}
	
	public void trigger()
	{
		script=Cache.sceneScripts.get("1");
		script.run(new SceneScriptsEngine());
		
		this.remove();
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(this.getCoordX(),this.getCoordY(),this.getWidth(),this.getHeight());
	}
}
