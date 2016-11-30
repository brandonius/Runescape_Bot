package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class Player {

	/*
	public static Object[] getPlayerName() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		
		//client_player
		Field f = Bot.classLoader.loadClass("ax").getDeclaredField("he");
		f.setAccessible(true);
		Object[] players = (Object[]) f.get(null);
		
		//player_name
		 Class<?> c = Bot.classLoader.loadClass("v");
		Field name = c.getDeclaredField("n");
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
	*/
}
