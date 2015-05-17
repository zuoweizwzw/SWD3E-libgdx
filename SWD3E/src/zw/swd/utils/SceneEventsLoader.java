package zw.swd.utils;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

import com.badlogic.gdx.scenes.scene2d.Action;

import zw.swd.main.Cache;
import zw.swd.main.Config;
import zw.swd.scene.scripts.SceneScript;

public class SceneEventsLoader {

	public static void loadScripts(String code)
	{
		File dir=new File(Config.resPath+"\\events");
		for(File file:dir.listFiles())
		{
			if(file.getName().equals(code+".groovy"))
			{
				
				ImportCustomizer importCustomizer=new ImportCustomizer();
				importCustomizer.addImport("Action", "com.badlogic.gdx.scenes.scene2d.Action");
				CompilerConfiguration conf=new CompilerConfiguration();
				conf.addCompilationCustomizers(importCustomizer);
				GroovyShell shell=new GroovyShell(conf);
				
				StringBuffer sb=new StringBuffer();
				try
				{
				BufferedReader br=new BufferedReader(new FileReader(file));
				String line="";
				
				
				while((line=br.readLine())!=null)
				{
					sb.append(line+"\n");
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				Script script=shell.parse(sb.toString());
				SceneScript sceneScript=new SceneScript(code,script);
				
				Cache.sceneScripts.put(code, sceneScript);
			}
		}
	}
}
