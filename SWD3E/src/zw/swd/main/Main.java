package zw.swd.main;



import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=640;
		config.foregroundFPS=100;
		config.height=480;
		new LwjglApplication(new App(), config);
		
	}
}
