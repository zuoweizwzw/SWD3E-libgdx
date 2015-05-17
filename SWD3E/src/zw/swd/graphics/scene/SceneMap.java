package zw.swd.graphics.scene;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

import zw.swd.graphics.SceneGroup;
import zw.swd.graphics.Sprite;

public class SceneMap extends Group{

	public String mapNum="";
//	public ArrayList<Sprite> masks=new ArrayList<Sprite>();
	
	public Group background=new Group();
	public Group masks=new Group();
	public SceneGroup sprites=new SceneGroup();
	
	public SceneMap(String mapNum) {
		// TODO Auto-generated constructor stub
		this.mapNum=mapNum;
		this.addActor(background);
		this.addActor(sprites);
		this.addActor(masks);
	
	}
	
	
}
