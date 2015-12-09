package zw.swd.gui;



import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

public class TextBox extends Paper{


	public String text="";
	public BitmapFont font;
	public float firstLineHeight=130;
	public float firstCharOffset=130;
	public int lineNum=4;
	public int numPerLine=20;
	public TextBox() {
		// TODO Auto-generated constructor stub
		font=FontLoader.font24;
		font.getData().markupEnabled=true;
		
	}
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		font.draw(batch, text, this.getX()+firstCharOffset, this.getY()+firstLineHeight);
		
		
		
	}
}
