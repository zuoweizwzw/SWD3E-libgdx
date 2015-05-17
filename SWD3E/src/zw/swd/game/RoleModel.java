package zw.swd.game;

import java.util.ArrayList;
import java.util.HashMap;

import zw.swd.game.fight.SkillModel;
import zw.swd.graphics.fight.FightRole;

public class RoleModel {

public FightRole fightRole;
	
	
	public String gameID="";
	public String resCode="";
	public String name="";
	public String description="";
	public int level=1;
	public int hp;
	public int hp_max;
	public int mp;
	public int mp_max;
	public int energe;
	public int energe_max;
	public int exp=100;
	public int exp_max;
	public ArrayList<String> magics=new ArrayList<String>();
	public String fightAvatar="";
	public HashMap<String,SkillModel> skills=new HashMap<String,SkillModel>();
}
