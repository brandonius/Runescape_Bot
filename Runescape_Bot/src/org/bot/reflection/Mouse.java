package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class Mouse {

	public static Object getMouseObject() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		Field f = Bot.classLoader.loadClass("dm").getDeclaredField("n");
		f.setAccessible(true);
		
		Object objM = f.get(Bot.applet);
		return objM;
	}
	
	
	
	public static int[] getMousePos() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		int[] pos = {0,0};
		try
		{
			//mouseX
			Field f = Bot.classLoader.loadClass("dm").getDeclaredField("c");
			f.setAccessible(true);
			
			pos[0] = f.getInt(Bot.applet) * 104323431;
			//mouseY
			f = Bot.classLoader.loadClass("dm").getDeclaredField("p");
			f.setAccessible(true);
			
			pos[1] = f.getInt(Bot.applet) * -1078458213;
			return pos;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return pos;
			
	}
	
	public static boolean setMouseActive()
	{
		
		return false;
		
	}
	
	public static boolean setMouseInactive(){
		return false;
		
	}
}
