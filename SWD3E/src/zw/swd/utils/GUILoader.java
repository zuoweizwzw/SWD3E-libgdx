package zw.swd.utils;

import java.io.FileInputStream;

import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

import zw.swd.graphics.Animation;
import zw.swd.gui.Paper;
import zw.swd.main.Cache;
import zw.swd.main.Config;

public class GUILoader {

	public static Paper loadControls()
	{
		XmlReader reader=new XmlReader();
		try
		{
		Element root=reader.parse(new FileInputStream(Config.resPath+"\\gui\\scripts\\1.xml"));
		int count=root.getChildCount();
		for(int i=0;i<count;i++)
		{
			Element controlElement=root.getChild(i);
			if(!controlElement.getName().equals("control")) continue;
			Paper paper=loadControl(controlElement);
			Cache.controls.put(paper.getName(), paper);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Paper loadControl(Element controlElement) throws Exception
	{
		String type=controlElement.get("type");
		Class c=Class.forName(type);
		Paper paper=(Paper) c.newInstance();
		paper.setName(controlElement.get("id"));
		if(controlElement.getAttributes().containsKey("size"))
		{
		String size_str=controlElement.get("size");
		paper.setSize(Float.parseFloat(size_str.split(",")[0]), Float.parseFloat(size_str.split(",")[1]));
		}
		if(controlElement.getAttributes().containsKey("location"))
		{
		String location_str=controlElement.get("location");
		paper.setPosition(Float.parseFloat(location_str.split(",")[0]), Float.parseFloat(location_str.split(",")[1]));
		}
		int count=controlElement.getChildCount();
		for(int i=0;i<count;i++)
		{
			Element element=controlElement.getChild(i);
			if(element.getName().equals("img"))
			{
				String path=element.get("src");
				Animation animation=new Animation(Config.resPath+"\\"+path);
				paper.setAnimation(animation);
				
			}
			if(element.getName().equals("control"))
			{
				Paper child=loadControl(element);
				paper.addActor(child);
			}
		}
		return paper;
	}
}
