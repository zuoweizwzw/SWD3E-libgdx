package zw.swd.game;

import zw.swd.graphics.Animation;

public class ItemModel {

	public String code="";
	public String name="";
	public String description;
	public String resPath="";
	public int type=0;
	public int equipe_attack=0;
	public int equipe_defense=0;
	public int equipe_agility=0;
	public int equipe_maxhp=0;
	public int equipe_maxmp=0;
	public int equipe_maxenerge=0;
	public int equipe_gold=0;
	public int equipe_wood=0;
	public int equipe_water=0;
	public int equipe_fire=0;
	public int equipe_earth=0;
	public int use_hp=0;
	public int use_mp=0;
	public int use_energe=0;
	public int use_hppercent=0;
	public int use_mppercent=0;
	public int use_energepercent=0;
	public int use_allhp=0;
	public int use_allmp=0;
	public int use_allenerge=0;
	public int use_allhppercent=0;
	public int use_allmppercent=0;
	public int use_allenergepercent=0;
	public boolean cure_death=false;
	public boolean cure_poison=false;
	public boolean cure_blind=false;
	
	public int use_hpmax=0;
	public int use_mpmax=0;
	public int use_energemax=0;
	
	
	public int proficiency=0;
	
	//0恢复,1剑，2环，3刀，4杵,5男头部，6女头部，7男身体，8女身体，9男手部，10女手部，11男足部，12女足部
	//13饰品，14法宝，15护驾,16增益辅助，17攻击辅助,18剧情
	public Animation animation;
	
	
	public void use_hp(RoleModel model)
	{
		model.hp+=use_hp;
		if(model.hp>model.hp_max)
		{
			model.hp=model.hp_max;
		}
	}
	
	public boolean isUseAll()
	{
		if(use_allhp>0||use_allmp>0||use_allenerge>0||use_allhppercent>0||use_allmppercent>0||use_allenergepercent>0)
		{
			return true;
		}
		else return false;
	}
	
	public void use(RoleModel model)
	{
		use_hp(model);
	}
	
}
