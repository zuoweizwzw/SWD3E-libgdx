package zw.swd.graphics;

import java.util.Collections;
import java.util.Comparator;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class SceneGroup extends Group{

	public static final Comparator<Actor> comparator=new Comparator<Actor>() {
		
		@Override
		public int compare(Actor o1, Actor o2) {
			// TODO Auto-generated method stub
			Sprite s1=(Sprite)o1;
			Sprite s2=(Sprite)o2;
			if(s1.getCoordY()>=s2.getCoordY())  return -1;
			else return 1;
		}
	};

	public void sort() {
		// TODO Auto-generated method stub
		this.getChildren().sort(comparator);
		
	}
	
	
	
	
	
	
	
}
