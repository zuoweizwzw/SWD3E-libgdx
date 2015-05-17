package zw.swd.scene.scripts;

import org.codehaus.groovy.reflection.CachedMethod;
import org.codehaus.groovy.runtime.metaclass.ClosureMetaMethod;

import zw.swd.main.Cache;
import zw.swd.screen.SceneScreen;
import groovy.lang.Closure;
import groovy.lang.MetaClass;
import groovy.lang.MetaClassImpl;
import groovy.lang.MetaMethod;
import groovy.lang.Script;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.sun.corba.se.spi.orbutil.closure.ClosureFactory;

public class SceneScript {

	public Script script;
	public String code="";

	SequenceAction sequence=new SequenceAction();
	public SceneScript(String code,Script script) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.script=script;
		
		
	}

	public void run(SceneScriptsEngine engine) {
		// TODO Auto-generated method stub
		engine.currentScript=this;		
		script.getBinding().setVariable("_", engine);
		script.run();
		
	}
	
	public boolean hasMethod(String method,Object[] arguTypes)
	{
		if(script.getMetaClass().getMetaMethod(method, arguTypes)!=null)
		{
			return true;
		}
		else return false;
	}
	
	public void invokeUpdate(Action action)
	{
		if(hasMethod("onUpdate",null))	script.invokeMethod("onUpdate", action);
	}
	
	public void invokeFinished(Action action)
	{
		if(hasMethod("onFinished",null))	script.invokeMethod("onFinished", action);
	}
	
	public void test()
	{
		System.out.println("testtest");
	}
}
