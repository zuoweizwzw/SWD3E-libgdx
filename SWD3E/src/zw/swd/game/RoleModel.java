package zw.swd.game;

import java.util.ArrayList;
import java.util.HashMap;

import zw.swd.game.fight.SkillModel;
import zw.swd.graphics.fight.FightRole;
import zw.swd.main.Cache;

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
	
	
	public int getAttack()
	{
		int weapon_value=0;
		ItemModel weapon=Cache.items.get(this.weapon);
		if(weapon!=null) weapon_value=weapon.equipe_attack;
		
		int head_value=0;
		ItemModel head=Cache.items.get(this.head);
		if(head!=null) head_value=head.equipe_attack;
		
		int body_value=0;
		ItemModel body=Cache.items.get(this.body);
		if(body!=null) body_value=body.equipe_attack;
		
		int hand_value=0;
		ItemModel hand=Cache.items.get(this.hand);
		if(hand!=null) hand_value=hand.equipe_attack;
		
		int foot_value=0;
		ItemModel foot=Cache.items.get(this.foot);
		if(foot!=null) foot_value=foot.equipe_attack;
		
		int attach1_value=0;
		ItemModel attach1=Cache.items.get(this.attach1);
		if(attach1!=null) attach1_value=attach1.equipe_attack;
		
		int attach2_value=0;
		ItemModel attach2=Cache.items.get(this.attach2);
		if(attach2!=null) attach2_value=attach2.equipe_attack;
		
		
		return this.strength+weapon_value+hand_value+head_value+body_value+foot_value+attach1_value+attach2_value;
	}
	
	public int getDefense()
	{
		int weapon_value=0;
		ItemModel weapon=Cache.items.get(this.weapon);
		if(weapon!=null) weapon_value=weapon.equipe_defense;
		
		int head_value=0;
		ItemModel head=Cache.items.get(this.head);
		if(head!=null) head_value=head.equipe_defense;
		
		int body_value=0;
		ItemModel body=Cache.items.get(this.body);
		if(body!=null) body_value=body.equipe_defense;
		
		int hand_value=0;
		ItemModel hand=Cache.items.get(this.hand);
		if(hand!=null) hand_value=hand.equipe_defense;
		
		int foot_value=0;
		ItemModel foot=Cache.items.get(this.foot);
		if(foot!=null) foot_value=foot.equipe_defense;
		
		int attach1_value=0;
		ItemModel attach1=Cache.items.get(this.attach1);
		if(attach1!=null) attach1_value=attach1.equipe_defense;
		
		int attach2_value=0;
		ItemModel attach2=Cache.items.get(this.attach2);
		if(attach2!=null) attach2_value=attach2.equipe_defense;
		
		
		return this.tolerance+weapon_value+hand_value+head_value+body_value+foot_value+attach1_value+attach2_value;
	}
	
	public int getAgility()
	{
		int weapon_value=0;
		ItemModel weapon=Cache.items.get(this.weapon);
		if(weapon!=null) weapon_value=weapon.equipe_agility;
		
		int head_value=0;
		ItemModel head=Cache.items.get(this.head);
		if(head!=null) head_value=head.equipe_agility;
		
		int body_value=0;
		ItemModel body=Cache.items.get(this.body);
		if(body!=null) body_value=body.equipe_agility;
		
		int hand_value=0;
		ItemModel hand=Cache.items.get(this.hand);
		if(hand!=null) hand_value=hand.equipe_agility;
		
		int foot_value=0;
		ItemModel foot=Cache.items.get(this.foot);
		if(foot!=null) foot_value=foot.equipe_agility;
		
		int attach1_value=0;
		ItemModel attach1=Cache.items.get(this.attach1);
		if(attach1!=null) attach1_value=attach1.equipe_agility;
		
		int attach2_value=0;
		ItemModel attach2=Cache.items.get(this.attach2);
		if(attach2!=null) attach2_value=attach2.equipe_agility;
		
		
		return this.agility+weapon_value+hand_value+head_value+body_value+foot_value+attach1_value+attach2_value;
	}
	
	public void switchItem(ItemModel item,String location)
	{
		if(location.equals("weapon"))
		{
			this.weapon=item.code;
		}
		if(location.equals("head"))
		{
			this.head=item.code;
		}
		if(location.equals("body"))
		{
			this.body=item.code;
		}
		if(location.equals("hand"))
		{
			this.hand=item.code;
		}
		if(location.equals("foot"))
		{
			this.foot=item.code;
		}
		if(location.equals("attach1"))
		{
			this.attach1=item.code;
		}
		if(location.equals("attach2"))
		{
			this.attach2=item.code;
		}
		if(location.equals("fabao1"))
		{
			this.fabao1=item.code;
		}
		if(location.equals("fabao2"))
		{
			this.fabao2=item.code;
		}
		if(location.equals("hujia1"))
		{
			this.hujia1=item.code;
		}
		if(location.equals("hujia2"))
		{
			this.hujia2=item.code;
		}
		
	}
	
}
