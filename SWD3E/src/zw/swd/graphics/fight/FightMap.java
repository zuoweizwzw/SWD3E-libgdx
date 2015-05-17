package zw.swd.graphics.fight;


import zw.swd.graphics.Sprite;
import zw.swd.main.Cache;

public class FightMap extends Sprite{

	public FightMap(String mapID) {
		// TODO Auto-generated constructor stub
		this.setAnimation(Cache.fightMaps.get(mapID));
		this.setPosition(0, 80);
	}
}
