package zw.swd.utils;


import zw.swd.game.GameItem;
import zw.swd.game.GameModel;
import zw.swd.game.RoleModel;
import zw.swd.game.fight.FightModel;
import zw.swd.main.Cache;
import zw.swd.main.Config;

public class TestUtils {

	public static RoleModel generateRoleModel(String resID)
	{
		RoleModel model=new RoleModel();
		model.gameID=resID+"/1";
		model.resCode=resID;
		
		if(resID.equals("001"))
		{
		model.name="陈靖仇";
		model.description="游戏主角";
		model.hp=1200;
		model.hp_max=1600;
		model.mp=200;
		model.mp_max=400;
		model.energe=10;
		model.energe_max=200;
		model.element="木";
		model.strength=10;
		model.tolerance=10;
		model.intelligence=10;
		model.agility=10;
		model.nextlevel=100;
		model.exp=0;
		model.gold=0;
		model.wood=15;
		model.water=0;
		model.fire=0;
		model.earth=0;
		model.weapon="0064";
		model.foot="0170";
		model.hand="0281";
		model.head="0284";
		model.body="0057";
		
		model.fightAvatar=Config.resPath+"\\gui\\75-1.png";
		model.skills=SkillsLoader.loadSkillsByRole(resID); 
		model.magics.add("51");
		model.magics.add("53");
		}
		if(resID.equals("002"))
		{
			model.name="于小雪";
			model.description="游戏主角";
			model.hp=300;
			model.hp_max=1600;
			model.mp=400;
			model.mp_max=400;
			model.energe=100;
			model.energe_max=200;
			model.fightAvatar=Config.resPath+"\\gui\\75-2.png";
			model.skills=SkillsLoader.loadSkillsByRole(resID);
		}
		return model;
	}
	public static FightModel generateFightModel()
	{
		FightModel model=new FightModel();
		model.allies.add(generateRoleModel("001"));
		model.enemies.add(generateRoleModel("002"));
		model.fightMapResID="fightmap/1-1";
		return model;
	}
	
	public static GameModel generateTestGameModel()
	{
		GameModel gameModel=GameModel.getInstance();
		gameModel.members.add(generateRoleModel("001"));		
		gameModel.addItem(new GameItem(Cache.items.get("0017")));				
		gameModel.addItem(new GameItem(Cache.items.get("0004")));		
		gameModel.addItem(new GameItem(Cache.items.get("0064")));
		gameModel.addItem(new GameItem(Cache.items.get("0284")));
		gameModel.addItem(new GameItem(Cache.items.get("0170")));
		gameModel.addItem(new GameItem(Cache.items.get("0281")));
		gameModel.addItem(new GameItem(Cache.items.get("0057")));
		gameModel.addItem(new GameItem(Cache.items.get("0224")));
		return gameModel;
	}
}
