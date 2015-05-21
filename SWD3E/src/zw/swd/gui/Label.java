package zw.swd.gui;

import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Label extends Paper{
	public BitmapFont font;
	public String text="";
	public boolean alignleft=true;
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.setShader(FontLoader.fontShader);
		Color color=font.getColor();
		if(this.getColor()!=null) font.setColor(this.getColor());
//		font.draw(batch, text, this.getX(), this.getY()+font.getCapHeight()+font.getAscent()-font.getDescent());
		if(this.alignleft)	font.drawMultiLine(batch, text, this.getX(), this.getY()+font.getCapHeight()+font.getAscent()-font.getDescent(), 0, HAlignment.LEFT);
		else font.drawMultiLine(batch, text, this.getX(), this.getY()+font.getCapHeight()+font.getAscent()-font.getDescent(), 0, HAlignment.RIGHT);
		font.setColor(color);
		batch.setShader(null);
		
	}

	public Label() {
		// TODO Auto-generated constructor stub
		this("空");
//		font.setColor(Color.RED);
//		font.setMarkupEnabled(true);
	}
	
	public Label(String text)
	{
		
		font=FontLoader.font18;
		setText(text);
	}
	public void setText(String  text)
	{
		this.text=text;
		TextBounds textBound=font.getBounds(text);		
		this.setSize(textBound.width, font.getLineHeight()+font.getAscent());
		
	}
	
	public void setText(int  text)
	{
		String texts=Integer.toString(text);
		setText(texts);
		
	}
	
	public String getText()
	{
		return this.text;
	}
	public void setFont(BitmapFont font)
	{
		this.font=font;
		this.setText(this.text);
	}

	//centertext in the parent
	public void centerX() {
		// TODO Auto-generated method stub
		if(this.getParent()!=null)
		{
			Group group=this.getParent();
			TextBounds textBound=font.getBounds(text);
			float width=group.getWidth();
			this.setX(width/2-textBound.width/2);
			
		}
	}
}
