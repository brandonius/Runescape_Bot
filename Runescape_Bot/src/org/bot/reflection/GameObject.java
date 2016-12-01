package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class GameObject {

	public static Object[] getGameObjects() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		Field f = Bot.classLoader.loadClass("cw").getDeclaredField("l");
		f.setAccessible(true);
		
		Object[] GObjects = (Object[]) f.get(null);
		
		return GObjects;
	}
	
	public static int getGameObjectsId() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		Field f = Bot.classLoader.loadClass("cm").getDeclaredField("y");
		f.setAccessible(true);
		
		for(Object o : getGameObjects())
		{
			int i = (int) f.getInt(o) * 1354109553;
			System.out.println("Gameobject ID: " + i);
		}
		
		return 1;
	}
}
