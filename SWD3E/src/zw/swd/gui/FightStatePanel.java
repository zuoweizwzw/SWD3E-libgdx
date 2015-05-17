package zw.swd.gui;

import java.util.ArrayList;

import zw.swd.game.RoleModel;
import zw.swd.graphics.Animation;

public class FightStatePanel extends Picture{

	public void initData(RoleModel roleModel){
		
	Picture avatar=	this.findActor("avatar");
	avatar.setAnimation(new Animation(roleModel.fightAvatar));		
	
	Picture p1=(Picture)this.findActor("hp_pro");
	p1.getAnimation().getCurrentFrame().keys.get(0).texture.setRegionWidth(roleModel.hp*48/roleModel.hp_max);
	
	Picture p2=(Picture)this.findActor("mp_pro");
	p2.getAnimation().getCurrentFrame().keys.get(0).texture.setRegionWidth(roleModel.mp*48/roleModel.mp_max);
	
	Picture p3=(Picture)this.findActor("energe_pro");
	p3.getAnimation().getCurrentFrame().keys.get(0).texture.setRegionWidth(roleModel.energe*48/roleModel.energe_max);
	
	Label name=(Label)this.findActor("name");
	name.setText(roleModel.name);
	
	}
}
