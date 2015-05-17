package zw.swd.gui;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class ControlFactory {

	public static Paper getDialog1Back()
	{
		Paper paper=new Paper()
		{
			
			@Override
			public void drawCustomer(Batch batch, float parentAlpha) {
				// TODO Auto-generated method stub
				drawRect(batch,parentAlpha);
				
			}
			
			
		};
		paper.setWidth(640);
		paper.setHeight(140);
		paper.setColor(0,0,1,0.4f);
		return paper;
	}
}
