package zw.swd.main;

import java.util.HashMap;

import zw.swd.events.Switch;

public class Global {

	private static int actionID=-1;
	public static int getID()
	{
		actionID++;
		return actionID;
	}
	
	public static HashMap<String,Switch> switches=new HashMap<>();
	
	
}
