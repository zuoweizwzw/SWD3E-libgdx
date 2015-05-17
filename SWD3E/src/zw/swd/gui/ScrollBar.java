package zw.swd.gui;

import zw.swd.graphics.Animation;
import zw.swd.main.Config;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ScrollBar extends Paper{

	public Button up;
	public int index=0;
	public Button down;
	public Picture background;
	public Picture rect;
	public int cap=0;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(rect!=null)
		{
			float rate=(float)8/cap;
			float origin=(int) (16+145-145*rate);
			float delta=(float)index*145/cap;
			int y=(int) (origin-delta);
			rect.setY(y);
		}
	}
	
	public void resetRect()
	{
		float rate=(float)8/cap;
		rect.setY( 16+145-145*rate);
	}
	
	public ScrollBar() {
		// TODO Auto-generated constructor stub
		Animation uppressedAni=new Animation(Config.resPath+"/gui/20-3.png");
		Animation upreleasedAni=new Animation(Config.resPath+"/gui/20-5.png");
		Animation downpressedAni=new Animation(Config.resPath+"/gui/20-4.png");
		Animation downreleasedAni=new Animation(Config.resPath+"/gui/20-6.png");
		up=new Button(uppressedAni,upreleasedAni);
		up.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				FightMagicList magicList=(FightMagicList) ScrollBar.this.getParent();
				if(index>0) 
				{
					index--;
					magicList.fillData(magicList.model);
				}
			}
		};
		down=new Button(downpressedAni,downreleasedAni);
		down.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				FightMagicList magicList=(FightMagicList) ScrollBar.this.getParent();
				if(index<magicList.model.magics.size()-8) 
				{
					index++;
					magicList.fillData(magicList.model);
				}
				
			}
		};
		up.setPosition(0, 160);
		down.setPosition(0, 0);
		background=new Picture(Config.resPath+"/gui/20-1.png",16,160);
		background.setPosition(2, 0);
		rect=new Picture(Config.resPath+"/gui/20-8.png");
		rect.setPosition(5, 100);
		this.addActor(background);
		this.addActor(rect);
		this.addActor(up);
		
		this.addActor(down);
		
	}
	
	
	public void setMaxCap(int cap)
	{
		this.cap=cap;
		float rate=(float)8/cap;
		rect.setPhysicHeight((int)((float)(145*rate)));
	}
	
}
