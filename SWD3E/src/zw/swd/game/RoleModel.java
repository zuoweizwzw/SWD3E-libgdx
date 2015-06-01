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
	public int exp_max;
	public String element="空";
	public int strength=0;
	public int tolerance=0;
	public int intelligence=0;
	public int agility=0;
	public int nextlevel=100;
	public int exp=0;
	public int gold=0;
	public int wood=0;
	public int water=0;
	public int fire=0;
	public int earth=0;
	public String weapon="";
	public int weaponType=1;
	public String head="";
	public String body="";
	public String hand="";
	public String foot="";
	public String attach1="";
	public String attach2="";
	public String fabao1="";
	public String fabao2="";
	public String hujia1="";
	public String hujia2="";
	public ArrayList<String> magics=new ArrayList<String>();
	public String fightAvatar="";
	public HashMap<String,SkillModel> skills=new HashMap<String,SkillModel>();
}
