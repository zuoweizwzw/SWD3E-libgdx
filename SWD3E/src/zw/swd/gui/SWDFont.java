package zw.swd.gui;

import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SWDFont {

	public SpriteBatch fontBatch;
	public BitmapFont font;
	public void draw(String text,float x, float y)
	{
		fontBatch.begin();
		font.draw(fontBatch, text, x, y);
		fontBatch.end();
		
	}
	public SWDFont() {
		// TODO Auto-generated constructor stub
		fontBatch=new SpriteBatch();
		this.font=FontLoader.font18;
	}
	public void setFont(BitmapFont font)
	{
		this.font=font;
	}
}
