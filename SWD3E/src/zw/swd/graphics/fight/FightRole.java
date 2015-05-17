package zw.swd.graphics.fight;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import zw.swd.game.RoleModel;
import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;
import zw.swd.main.Cache;

public class FightRole extends Sprite{

	public RoleModel roleModel;
	public int index;
	public boolean ally=true;
	ShapeRenderer renderer=new ShapeRenderer();
	public Color borderColor;
	public boolean selectable=false;
	
	public FightRole(RoleModel roleModel) {
		// TODO Auto-generated constructor stub
		this.roleModel=roleModel;
		
	}
	
	public Animation getFightAnimation(String name)
	{
		return Cache.fightRoles.get(roleModel.resCode+"/fight/"+name+"_"+(ally?"left":"right"));
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		if(this.selectable)
		if(this.getAnimation()!=null)
		{
			drawBorder(batch,parentAlpha);
		}
	}
	
	private void drawBorder(Batch batch, float parentAlpha)
	{
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		renderer.begin(ShapeType.Line);
		renderer.setColor(this.borderColor);
		Rectangle rect=(Rectangle) this.getAnimation().userData.get("collisRect");
		Rectangle newRect=new Rectangle(rect.x+this.getX(),rect.y+this.getY(),rect.width,rect.height);
		
		renderer.rect(newRect.x,newRect.y, newRect.getWidth(), newRect.getHeight());
		renderer.end();
		batch.begin();
	}
	
	@Override
	public boolean isMouseIn() {
		// TODO Auto-generated method stub
		int x=Gdx.input.getX();
		int y=480-Gdx.input.getY();
		if(this.getAnimation()==null) return false;
		Rectangle rect=(Rectangle) this.getAnimation().userData.get("collisRect");
		Rectangle newRect=new Rectangle(rect.x+this.getX(),rect.y+this.getY(),rect.width,rect.height);
		
		if(newRect.contains(x, y))
		{
			return true;
		}
		return false;
	}
	
	public void setBorderVisible(Color color)
	{
		this.selectable=true;
		this.borderColor=color;
	}
	
	public void setBorderInvisible()
	{
		this.selectable=false;
	}
	
}


