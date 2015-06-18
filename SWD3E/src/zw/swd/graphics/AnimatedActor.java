package zw.swd.graphics;

public interface AnimatedActor {

	public void setAnimation(Animation animation);
	public Animation getAnimation();

	public void setAnimation(String path);
	
	public void setAlpha(float alpha);
	public float getAlpha();
	public boolean remove();
}
