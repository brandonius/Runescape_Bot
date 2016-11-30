package org.bot.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bot.Bot;

public class Client {
	public static int getGameState() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_game_state
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("a");
		f.setAccessible(true);
		//client_game_state_multiplier
		int value = (int) f.getInt(null) * -638628455;

		return value;
	}
	
	public static String getUsername() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	{
		//client_username
		Field f = Bot.classLoader.loadClass("ad").getDeclaredField("ab");
		f.setAccessible(true);
		String username = (String) f.get(null);
		
		return username;
	}
	
	public static String getPassword() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	{
		//client_password
		Field f = Bot.classLoader.loadClass("ad").getDeclaredField("ax");
		f.setAccessible(true);
		String password = (String) f.get(null);
		
		return password;
	}
	
	public static String setUsername(String un) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_username
		Field f = Bot.classLoader.loadClass("ad").getDeclaredField("ab");
		f.setAccessible(true);
		f.set(Bot.applet, un);
		
		return un;
	}
	
	public static String setPassword(String pw) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	{
		//client_password
		Field f = Bot.classLoader.loadClass("ad").getDeclaredField("ax");
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
		} else 
		{
			return false;
		}
	}
	
	public static int getCurrentWorld() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_world
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("h");
		f.setAccessible(true);
		//client_world_multiplier
		int world = f.getInt(Bot.applet) * -262484747;
		
		return world;
	}
	
	public static void setWORLD() throws NoSuchFieldException, SecurityException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		//setWorld
		Method m = Bot.classLoader.loadClass("ah").getMethod("l", void.class);
		m.setAccessible(true);
		m.invoke(Bot.applet, 301);
	}
	
	public static int setWorld(int world) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//
		Field f = Bot.classLoader.loadClass("client").getDeclaredField("h");
		f.setAccessible(true);
		f.setInt(Bot.applet, world);
		
		return world;
	}
	

}