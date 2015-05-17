package zw.swd.game;

import zw.swd.graphics.Animation;
import zw.swd.math.Vector2;

public class MagicModel {

	public String code="";
	public int displayType;//0恢复类，1攻击类，2辅助类
	public boolean aoe=false;
	public boolean castToAllies=false;
	public String name="";
	public String description;
	public int mpCost;
	public int element=0;//0金1木2水3火4土
	public Animation anis;
	public String[] hitframes;
	public Vector2 offset=new Vector2();
	public int damage=0;
	
	
}
