package zw.swd.graphics.scene;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import zw.swd.game.event.MapEvent;
import zw.swd.graphics.SceneGroup;
import zw.swd.graphics.Sprite;
import zw.swd.math.Vector2;

public class SceneMap extends Group{

	ShapeRenderer renderer=new ShapeRenderer();
	public String mapNum="";
//	public ArrayList<Sprite> masks=new ArrayList<Sprite>();
	
	public Group background=new Group();
	public Group masks=new Group();
	public SceneGroup sprites=new SceneGroup();
	public int[][] data;
	public Group mapEvents=new Group();
	
	public SceneMap(String mapNum) {
		// TODO Auto-generated constructor stub
		this.mapNum=mapNum;
		this.addActor(background);
		this.addActor(sprites);
		this.addActor(masks);
		this.addActor(mapEvents);
	
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		drawRect(batch, parentAlpha);
	}
	
	//画地图可走的方块
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
	
	public ArrayList<Sprite> getColisObjects(Sprite source)
	{
		ArrayList<Sprite> objects=new ArrayList<>();
		for(Sprite sprite:this.sprites.getSprites())
		{
			if(sprite.isColis(source))
			{
				objects.add(sprite);
				
			}
		}
		return objects;
	}
	
	public void checkMap()
	{
		
	}
	
	public boolean meetBarrier(Sprite sprite, Vector2 delta)
	{
		Vector2 target=sprite.getCoordCopy().addNew(delta);
		
		int x=(int) (target.x/8);
		int y=(int) (target.y/8);
		if(data[y][x]==0) return true;

		return false;
	}
	
	public void addMapEvent(MapEvent mapEvent)
	{
		this.mapEvents.addActor(mapEvent);
	}
	
	public MapEvent meetMapEvent(Sprite sprite)
	{
		Vector2 coord=new Vector2(sprite.getCoordX(),sprite.getCoordY());
		MapEvent mapEvent=null;
		for(Actor event_actor:this.mapEvents.getChildren())
		{
			MapEvent event=(MapEvent) event_actor;
			boolean meet=event.getRect().contains(coord.getGdxVector2());
			if(meet) mapEvent=event;
		}
		return mapEvent;
	}
	
}
