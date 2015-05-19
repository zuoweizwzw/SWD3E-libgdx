package zw.swd.graphics;


import java.util.ArrayList;
import java.util.HashMap;

import zw.swd.math.Vector2;
import zw.swd.utils.TextureLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;



public class Animation {
	/** Defines possible playback modes for an {@link Animation}. */
	
	

	public String code="";
	public String name="";
	public Vector2 centerPoint=new Vector2();
	public int currentFrame = -1;
	public Vector2 mainOffset=new Vector2();
	public Rectangle colisBox=new Rectangle();
	public HashMap<String,Object> userData=new HashMap<String,Object>();
	private float nextChange = 0;
	/** True if this is the first update */
	private boolean firstUpdate = true;
	public boolean autoUpdate = true;
	private float timeLeft;
	private boolean loop = true;
	private boolean stopped = false;
	public ArrayList<Frame> frames=new ArrayList<Frame>();
	
	public Animation(String filePath) {
		// TODO Auto-generated constructor stub
		Frame frame=new Frame();
		frame.duration=0.1f;
		FrameKey key=new FrameKey();
		key.texture=new TextureRegion(TextureLoader.loadTexture(filePath));
		
		frame.keys.add(key);
		this.frames.add(frame);
		if (frames.isEmpty()) {
		      nextChange = (int) (frame.duration );
		   }
		currentFrame = 0; 
	}
	
	public Animation() {
		// TODO Auto-generated constructor stub
	}

	public Animation(Texture texture) {
		// TODO Auto-generated constructor stub
		Frame frame=new Frame();
		frame.duration=0.1f;
		FrameKey key=new FrameKey();
		key.texture=new TextureRegion(texture);
		
		frame.keys.add(key);
		this.frames.add(frame);
		if (frames.isEmpty()) {
		      nextChange = (int) (frame.duration );
		   }
		currentFrame = 0; 
	}

	public Animation(String path, int width, int height) {
		// TODO Auto-generated constructor stub
		Frame frame=new Frame();
		frame.duration=0.1f;
		FrameKey key=new FrameKey();
		key.texture=new TextureRegion(TextureLoader.loadTexture(path),width,height);
		
		frame.keys.add(key);
		this.frames.add(frame);
		if (frames.isEmpty()) {
		      nextChange = (int) (frame.duration );
		   }
		currentFrame = 0; 
	}

	public void addFrame( Frame frame){
		this.frames.add(frame);
		if (frames.isEmpty()) {
		      nextChange =  (frame.duration );
		   }
		currentFrame = 0; 
	}
	
	public boolean isStopped() {
		return stopped;
	}
	
	public void stop() {
		if (frames.size() == 0) {
			return;
		}
		timeLeft = nextChange;
		nextChange=0;
		currentFrame=0;
		stopped = true;
	}
	
	public void start() {
		if (!stopped) {
			return;
		}
		if (frames.size() == 0) {
			return;
		}
		stopped = false;
		nextChange = timeLeft;
	}
	
	public void restart() {
		if (frames.size() == 0) {
			return;
		}
		stopped = false;
		currentFrame = 0;
		nextChange = (int) (((Frame) frames.get(0)).duration);
		firstUpdate = true;
	}
	
	
	public void draw(float x, float y,Batch batch, Color color,float parentAlpha)
	{
		if (frames.size() == 0) {
			return;
		}
		
		float delta = Gdx.graphics.getDeltaTime();
		
		if (firstUpdate) {
			delta = 0;
			firstUpdate = false;
		}
		
		if(autoUpdate) nextFrame(delta);
		
		Frame frame = (Frame) frames.get(currentFrame);
		frame.draw(x,y,batch,color,parentAlpha);
	}
	
	
	
	public void nextFrame(float delta) {
		if (stopped) {
			return;
		}
		if (frames.size() == 0) {
			return;
		}
		
		nextChange -= delta;
		while (nextChange < 0 && (!stopped)) {
			
			if ((currentFrame == frames.size() - 1) && (!loop) ) {
	            stopped = true; 
				break;
			}
			currentFrame = (currentFrame + 1) % frames.size();
			
			float realDuration = (float) (((Frame) frames.get(currentFrame)).duration );
			nextChange = nextChange + realDuration;
		}
	}
	
	public Frame getCurrentFrame()
	{
		return frames.get(currentFrame);
	}
	
	public Vector2 getSize()
	{
		int width= getCurrentFrame().keys.get(0).texture.getRegionWidth();
		int height= getCurrentFrame().keys.get(0).texture.getRegionHeight();
		return new Vector2(width,height);
	}
	public void setLoop(boolean loop)
	{
		this.loop=loop;
	}
	
	public int getCurrentFrameIndex()
	{
		return this.currentFrame;
	}
	
	public void pause()
	{
		this.stopped=true;
	}
	
	public void reset()
	{
		currentFrame = 0;
		if(this.frames.size()>0)
		{
			nextChange=frames.get(0).duration;
		}
		else nextChange=0;
	}
	public void setName(String name)
	
	{
		this.name=name;
	}

	public float getTotalDuration() {
		// TODO Auto-generated method stub
		float total=0;
		
		for(Frame frame:frames)
		{
			total+=frame.duration;
		}
		return total;
	}

	public void setAutoUpdate(boolean autoUpdate) {
		// TODO Auto-generated method stub
		this.autoUpdate=autoUpdate;
	}

	public ArrayList<Frame> getFrames() {
		// TODO Auto-generated method stub
		return frames;
	}
	
	public int getWidth() {
		return ((Frame) frames.get(currentFrame)).getWidth();
	}

	public int getHeight() {
		return ((Frame) frames.get(currentFrame)).getHeight();
	}
	
	public void setPhysicSize(int width,int height) {
		// TODO Auto-generated method stub
		if(this.frames.size()>0)
		{
			this.frames.get(0).keys.get(0).texture.setRegionHeight(height);
			this.frames.get(0).keys.get(0).texture.setRegionHeight(width);
		}
	}

	public void setPhysicHeight(int height) {
		// TODO Auto-generated method stub
		if(this.frames.size()>0)
		{
			this.frames.get(0).keys.get(0).texture.setRegionHeight(height);
		}
	}

	public void setPhysicWidth(int width) {
		// TODO Auto-generated method stub
		if(this.frames.size()>0)
		{
			this.frames.get(0).keys.get(0).texture.setRegionWidth(width);
		}
	}
}
