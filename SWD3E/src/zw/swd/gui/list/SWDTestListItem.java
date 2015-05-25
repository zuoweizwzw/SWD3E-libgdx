package zw.swd.gui.list;

import zw.swd.game.GameItem;
import zw.swd.gui.Label;

public class SWDTestListItem extends SWDListItem{

	Label name;
	Label num;
	public SWDTestListItem(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		name=new Label("空");
		num=new Label("0");
		this.name.setPosition(0, 2);
		this.addActor(name);
		
		this.num.setPosition(140, 2);
		this.addActor(num);
		this.num.alignleft=false;
	}

	@Override
	public void fillData(Object o) {
		// TODO Auto-generated method stub
		GameItem gameItem=(GameItem) o;
		this.name.setText(gameItem.itemModel.name);
		this.num.setText(gameItem.num);
	}
}
