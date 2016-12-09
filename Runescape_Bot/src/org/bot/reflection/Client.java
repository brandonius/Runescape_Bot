package org.bot.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import org.bot.Bot;

public class Client {
	public static int getGameState() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_game_state
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("d");
		f.setAccessible(true);
		//client_game_state_multiplier
		int value = (int) f.getInt(null) * -730851945;

		return value;
	}
	
	public static String getUsername() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	{
		//client_username
		Field f = Bot.classLoader.loadClass("ar").getDeclaredField("af");
		f.setAccessible(true);
		String username = (String) f.get(null);
		
		return username;
	}
	
	public static String getPassword() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	{
		//client_password
		Field f = Bot.classLoader.loadClass("ar").getDeclaredField("ac");
		f.setAccessible(true);
		String password = (String) f.get(null);
		
		return password;
	}
	
	public static String setUsername(String un) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_username
		Field f = Bot.classLoader.loadClass("ar").getDeclaredField("af");
		f.setAccessible(true);
		f.set(Bot.applet, un);
		
		return un;
	}
	
	public static String setPassword(String pw) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	{
		//client_password
		Field f = Bot.classLoader.loadClass("ar").getDeclaredField("ac");
		f.setAccessible(true);
		f.set(Bot.applet, pw);
		
		return pw;
	}
	
	public static boolean isLoggedIn() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		int state = getGameState();
		
		if(state == 30)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	public static int getCurrentWorld() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_world
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("g");
		f.setAccessible(true);
		//client_world_multiplier
		int world = f.getInt(Bot.applet) * 1544660437;
		
		return world;
	}
	
	public static void setWorld() throws NoSuchFieldException, SecurityException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		//setWorld
		byte b = 1;
		Class<?> c = Bot.classLoader.loadClass("aa");
		Method m = Bot.classLoader.loadClass("dq").getDeclaredMethod("f", c, byte.class);
		m.setAccessible(true);
		Field f = c.getDeclaredField("h");
		f.setAccessible(true);
		Object O = f.get(Bot.applet);
		m.invoke(Bot.applet, O, b);	
	}
	
	
}