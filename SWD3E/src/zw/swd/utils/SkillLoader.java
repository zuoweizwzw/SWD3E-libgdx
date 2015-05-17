package zw.swd.utils;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import zw.swd.game.fight.SkillModel;
import zw.swd.main.Config;

class SkillsLoader {

	public static SkillModel loadSkill(File filePath)
	{
		SkillModel model=new SkillModel();
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(filePath));
			String line=null;
			while((line=br.readLine())!=null)
			{
				if(line.indexOf("code")==0)
				{
					model.code=line.split(":")[1];
				}
				if(line.indexOf("res")==0)
				{
					model.res=line.split(":")[1];
				}
				if(line.indexOf("type")==0)
				{
					model.type=line.split(":")[1];
				}
				if(line.indexOf("aoe")==0)
				{
					model.aoe=Boolean.parseBoolean(line.split(":")[1]);
				}
				if(line.indexOf("hitframes")==0)
				{
					model.hitframes=line.split(":")[1].split(",");
				}
				if(line.indexOf("damage")==0)
				{
					model.damage=Integer.parseInt(line.split(":")[1]);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	public static HashMap<String, SkillModel> loadSkillsByRole(String roleID)
	{
		HashMap<String,SkillModel> models=new HashMap<String, SkillModel>();
		File dir=new File(Config.resPath+"\\char\\"+roleID+"\\fight\\skills");
		if(dir.exists())
		{
			for(File file:dir.listFiles())
			{
				SkillModel model=loadSkill(file);
				models.put(model.code, model);
			}
		}
		return models;
	}
}
