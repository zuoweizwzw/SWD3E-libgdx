package zw.swd.exscreens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;

import javax.security.auth.callback.TextOutputCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MapDefiner implements Screen, InputProcessor{

	public Texture map;
	SpriteBatch batch;
	public int mapx,mapy;
	public ShapeRenderer renderer;
	MapData data;
	String mapNum="1-1";
	public MapDefiner(SpriteBatch batch) {
		// TODO Auto-generated constructor stub
		this.batch=batch;
		this.renderer=new ShapeRenderer();
		renderer.setAutoShapeType(true);
		
		this.map=new Texture(Gdx.files.absolute("F:\\SWD3E\\huge\\"+mapNum+"\\"+mapNum+".png"));
		String path="F:\\SWD3E\\huge\\"+mapNum+"\\"+mapNum+"_data.txt";
		data=loadMapData(path);
		
	}

	private MapData loadMapData(String path) {
		// TODO Auto-generated method stub
		MapData data=new MapData();
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(path));
			String line=br.readLine();
			String[] strs=line.split(",");
			int x=Integer.parseInt(strs[0]);
			int y=Integer.parseInt(strs[1]);
			data.data=new int[x][y];
			for(int i=0;i<x;i++)
			{
				line=br.readLine();
				for(int j=0;j<y;j++)
				{
					String[] lines=line.split(" ");
					data.data[i][j]=Integer.parseInt(lines[j]);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Keys.ENTER)
		{
			try
			{
				BufferedWriter bw=new BufferedWriter(new FileWriter("F:\\SWD3E\\huge\\"+mapNum+"\\"+mapNum+"_data.txt"));
				FileWriter fw=new FileWriter("F:\\SWD3E\\huge\\"+mapNum+"\\"+mapNum+"_data.txt");
				fw.write(data.data.length+","+data.data[0].length+"\r\n");
				
				for(int i=0;i<data.data.length;i++)
				{
					for(int j=0;j<data.data[i].length;j++)
					{
						fw.write(Integer.toString(data.data[i][j])+" ");
					}
					fw.write("\r\n");
				}
				fw.flush();
				fw.close();
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.draw(map, mapx, mapy);
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		renderer.begin();
		
		renderer.set(ShapeType.Filled);
		renderer.setColor(1, 0, 0, 0.3f);
		for(int i=0;i<data.data.length;i++)
		{
			for(int j=0;j<data.data[i].length;j++)
			{
				if(data.data[i][j]==1) renderer.rect(j*8, i*8, 8, 8);
			}
		}
		
		int mx=Gdx.input.getX();
		int my=Gdx.input.getY();
		renderer.setColor(1, 1, 1, 1f);
		renderer.rect((mx/8)*8,((480-my)/8)*8,8,8);
		renderer.end();
		
		if(Gdx.input.isButtonPressed(Buttons.LEFT))
		{
			data.data[(480-my)/8][(mx/8)]=1;
		}
		if(Gdx.input.isButtonPressed(Buttons.RIGHT))
		{
			data.data[(480-my)/8][(mx/8)]=0;
		}
		Gdx.gl.glDisable(GL20.GL_BLEND);
		batch.begin();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	class MapData
	{
		public int[][] data;
	}
}
