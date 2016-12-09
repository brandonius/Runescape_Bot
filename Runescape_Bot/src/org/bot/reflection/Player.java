package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class Player {
	
	public static Object[] getPlayerObject() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//Gets all the player in an Object array list.
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("gv");
		f.setAccessible(true);
		Object[] players = (Object[]) f.get(null);
		
		return players;
	}
	
	public static void getCombatLevel() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		Object[] players = getPlayerObject();
		
		Field f = Bot.classLoader.loadClass("v").getDeclaredField("c");
		f.setAccessible(true);
		
		for(Object o : players)
		{
			if(o != null)
			{
				System.out.println(f.getInt(o) * -711119153);
			}
		}
	}

	
	public static Object[] getPlayerName() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		
		//client_players
		Object[] players = getPlayerObject();
		
		//player_name
		 Class<?> c = Bot.classLoader.loadClass("r");
		Field name = c.getDeclaredField("o");
		name.setAccessible(true);
		
		for(Object o : players)
		{
			if(o != null)
			{
				String the_name = (String) name.get(o);
				System.out.println(the_name);
			}
		}
		 
		
		return players;
		
	}
	
	public static int[] getPlayerPos() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		Field f = Bot.classLoader.loadClass("ag").getDeclaredField("ag");
		f.setAccessible(true);
		int x = f.getInt(Bot.applet) * 990979225;
		f = Bot.classLoader.loadClass("ag").getDeclaredField("au");
		f.setAccessible(true);
		int y = f.getInt(Bot.applet) * 1096974759;
		int[] pos = {x,y};
		
		return pos;
	}
	
}
