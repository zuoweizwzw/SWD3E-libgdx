package zw.swd.gui;

import zw.swd.graphics.Animation;
import zw.swd.main.Config;

import com.badlogic.gdx.graphics.g2d.Batch;

public class GUIItemListScroll extends Paper{

	public Button up;
	public int index=0;
	public Button down;
	public Picture background;
	public Picture rect;
	public int cap=13;
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(rect!=null)
		{
			float rate=(float)13/cap;
			float origin=(int) (16+324-324*rate);
			float delta=(float)index*324/cap;
			int y=(int) (origin-delta);
			rect.setY(y);
		}
	}

	public void resetRect()
	{
		float rate=(float)13/cap;
		rect.setY( 16+324-324*rate);
	}
	
	public GUIItemListScroll() {
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
				GUIItemList magicList=(GUIItemList) GUIItemListScroll.this.getParent();
				if(index>0) 
				{
					index--;
					magicList.scrollData();
				}
			}
		};
		down=new Button(downpressedAni,downreleasedAni);
		down.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				GUIItemList magicList=(GUIItemList) GUIItemListScroll.this.getParent();
				if(index<magicList.gameModel.items.size()-13) 
				{
					index++;
					magicList.scrollData();
				}
				
			}
		};
		up.setPosition(0, 336);
		down.setPosition(0, 0);
		background=new Picture(Config.resPath+"/gui/20-1.png",16,336);
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
		float rate=(float)13/cap;
		rect.setPhysicHeight((int)((float)(324*rate)));
	}
}
