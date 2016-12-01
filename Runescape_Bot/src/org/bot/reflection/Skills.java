package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class Skills {

	public static int[] getCurrentSkillLevels() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_current_levels
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("hn");
		f.setAccessible(true);
		
		//skills according to hiscores order
		int[] levels = (int[]) f.get(null);
		
		return levels;
	}
	
	public static int getWoodCuttingLevel() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		int[] lList = getRealSkillLevels();
		return lList[8];
	}
	
	public static int[] getRealSkillLevels() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_real_levels
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("hc");
		f.setAccessible(true);

		//skills according to hiscores order
		int[] levels = (int[]) f.get(null);
		
		return levels;
	}
	
	public static int[] getSkillsExperiences() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_experiences
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("hg");
		f.setAccessible(true);

		//skills according to hiscores order
		int[] xps = (int[]) f.get(null);
		
		return xps;
	}
	
	public static int getWoodCuttingXp() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		int[] xpList = getSkillsExperiences();
		return xpList[8];
	}
}
