package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class Skills {

	public static int[] getCurrentSkillLevels() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_current_levels
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("hn");
		f.setAccessible(true);
		
		int[] levels = (int[]) f.get(null);
		
		return levels;
	}
	
	public static int[] getRealSkillLevels() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_real_levels
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("hc");
		f.setAccessible(true);
		
		int[] levels = (int[]) f.get(null);
		
		return levels;
	}
	
	public static int[] getSkillExperiences() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("hg");
		f.setAccessible(true);
		
		int[] xps = (int[]) f.get(null);
		
		return xps;
	}
}
