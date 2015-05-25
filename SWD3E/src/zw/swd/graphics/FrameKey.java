package zw.swd.graphics;

import zw.swd.utils.TextureLoader;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class FrameKey {

	public float offsetX;
	public float offsetY;
	public TextureRegion texture;
	public void draw(float x, float y, Batch batch, Color color, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(texture, x-offsetX, y-offsetY);
		
	}
	public void setRegion(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		this.texture.setRegion(x, y, width, height);
	}
	
	public FrameKey(String path) {
		// TODO Auto-generated constructor stub
		this.texture=new TextureRegion(TextureLoader.loadTexture(path));

	}
	public FrameKey() {
		// TODO Auto-generated constructor stub
	}
	
}
