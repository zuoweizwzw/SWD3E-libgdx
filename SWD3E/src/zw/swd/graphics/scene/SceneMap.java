package zw.swd.graphics.scene;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;

import zw.swd.graphics.SceneGroup;
import zw.swd.graphics.Sprite;

public class SceneMap extends Group{

	ShapeRenderer renderer=new ShapeRenderer();
	public String mapNum="";
//	public ArrayList<Sprite> masks=new ArrayList<Sprite>();
	
	public Group background=new Group();
	public Group masks=new Group();
	public SceneGroup sprites=new SceneGroup();
	public int[][] data;
	
	public SceneMap(String mapNum) {
		// TODO Auto-generated constructor stub
		this.mapNum=mapNum;
		this.addActor(background);
		this.addActor(sprites);
		this.addActor(masks);
	
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		drawRect(batch, parentAlpha);
	}
	
	private void drawRect(Batch batch,float parentAlpha)
	{
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		renderer.begin(ShapeType.Filled);
		renderer.setColor(new Color(1,0,0,0.7f));
		
		
		
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				if(data[i][j]==1) renderer.rect(j*8, i*8, 8, 8);
			}
		}
		renderer.end();
		batch.begin();
	}
	
	
}
