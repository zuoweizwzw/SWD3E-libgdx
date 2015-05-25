package zw.swd.gui.list;

import com.badlogic.gdx.graphics.g2d.Batch;

import zw.swd.graphics.Animation;
import zw.swd.gui.Button;
import zw.swd.gui.ClickEvent;
import zw.swd.gui.Paper;
import zw.swd.gui.Picture;
import zw.swd.main.Config;

public class SWDListScroll extends Paper{

	public int index=0;
	public Button up;
	public Button down;
	public Picture background;
	public Picture rect;
	public int capacity;
	public int maxCap;//list表里的item总数
	public SWDListScroll(int height,int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		this.setHeight(height);
		this.setWidth(16);
		Animation uppressedAni=new Animation(Config.resPath+"/gui/20-3.png");
		Animation upreleasedAni=new Animation(Config.resPath+"/gui/20-5.png");
		Animation downpressedAni=new Animation(Config.resPath+"/gui/20-4.png");
		Animation downreleasedAni=new Animation(Config.resPath+"/gui/20-6.png");
		up=new Button(uppressedAni,upreleasedAni);
		down=new Button(downpressedAni,downreleasedAni);
		
		up.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				SWDList list=(SWDList)SWDListScroll.this.getParent();
				if(index>0)
				{
					index--;
					list.scrollData();
				}
			}
		};
		
		down.clickEvent=new ClickEvent() {
			
			@Override
			public void onClick(int button) {
				// TODO Auto-generated method stub
				SWDList list=(SWDList)SWDListScroll.this.getParent();
				if(index<list.data.size()-list.capacity)
				{
					index++;
					list.scrollData();
				}
			}
		};
		
		up.setPosition(-2, height-up.getHeight());
		down.setPosition(-2, 0);
		
		background=new Picture(Config.resPath+"/gui/20-1.png");
		background.setPhysicHeight(height-32);
		background.setPosition(0, 16);
		this.addActor(background);
		
		rect=new Picture(Config.resPath+"/gui/20-8.png");
		rect.setX(3);
		this.addActor(rect);
		
		this.addActor(up);
		this.addActor(down);
	}
	
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(rect!=null)
		{
//			float rate=(float)13/cap;
//			float origin=(int) (16+324-324*rate);
//			float delta=(float)index*324/cap;
//			int y=(int) (origin-delta);
//			rect.setY(y);
			float rate=((float)this.capacity)/maxCap;
			float origin=this.background.getY()+this.background.getPicHeight();
			float delta=index*this.background.getPicHeight()/maxCap;
			rect.setY(origin-delta-rect.getPicHeight());
		}
	}
	
	public void setMaxCap(int maxCap)
	{
		this.maxCap=maxCap;
		float rate=((float)capacity)/(float)maxCap;
		this.rect.setPhysicHeight((int)(rate*this.background.getPicHeight()));
	}

}
