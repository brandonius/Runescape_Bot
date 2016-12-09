package org.bot.reflection;

import java.lang.reflect.Field;

import org.bot.Bot;

public class Camera {

	public static int getCameraX() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_cameraX
		Field f = Bot.classLoader.loadClass("dj").getDeclaredField("fy");
		f.setAccessible(true);
		//client_cameraX_multiplier
		int x = ((int) f.get(Bot.applet) * -655807297);
		
		return x;
	}
	
	public static int getCameraY() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_cameraY
		Field f = Bot.classLoader.loadClass("s").getDeclaredField("fo");
		f.setAccessible(true);
		//client_cameraY_multiplier
		int y = ((int) f.get(Bot.applet) * -1500081839);
		
		return y;
	}
	
	public static int getCameraZ() throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		//client_cameraZ
		Field f = Bot.classLoader.loadClass("gw").getDeclaredField("fb");
		f.setAccessible(true);
		//client_cameraZ_multiplier
		int z = ((int) f.get(Bot.applet) * 739598751);
		
		return z;
	}
	
	/*
	 * public static int setCameraX(int X) throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	 *
	{
		//client_cameraX
		Field f = Bot.classLoader.loadClass("w").getDeclaredField("fu");
		f.setAccessible(true);
		//client_cameraX_multiplier
		f.set(Bot.applet, X * -1080637571);
		
		return X;
	}
	*/
}
