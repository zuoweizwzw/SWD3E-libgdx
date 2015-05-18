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
		model.fightAvatar=Config.resPath+"\\gui\\75-1.png";
		model.skills=SkillsLoader.loadSkillsByRole(resID); 
		model.magics.add("51");
		model.magics.add("53");
		}
		if(resID.equals("002"))
		{
			model.name="于小雪";
			model.description="游戏主角";
			model.hp=1200;
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
		GameModel gameModel=new GameModel();
		gameModel.members.add(generateRoleModel("001"));
		for(int i=0;i<16;i++)
		{
		GameItem gameItem=new GameItem(Cache.items.get("0017"));
		gameModel.items.add(gameItem);
		}
		GameItem gameItem=new GameItem(Cache.items.get("0004"));
		gameModel.items.add(gameItem);
		return gameModel;
	}
}
