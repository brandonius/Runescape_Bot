package org.bot;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.bot.game.RSAppletStub;
import org.bot.net.ConfigReader;
import org.bot.reflection.Camera;
import org.bot.reflection.Client;
import org.bot.reflection.Player;

public class Bot {
	public static URLClassLoader classLoader;
	public static Applet applet;
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, InterruptedException, NoSuchMethodException, InvocationTargetException
	{
        // Create an instance of our config reader and parse the parameters
        ConfigReader configReader = new ConfigReader();
        Map<String, String> map = configReader.read();
        // Use the parameters to build the jar location we are loading
        String jarLocation = map.get("codebase") + map.get("initial_jar");
        try {
            // Use a URLClassLoader because we are loading classes from a jar at a URL
            classLoader = new URLClassLoader(new URL[]{new URL(jarLocation)});
            
            
            
            
            // Use the parameters to get the correct class, usually always "client"
            Class<?> clientClass = classLoader.loadClass(map.get("initial_class").replace(".class", ""));
            // Create a new instance of the class and cast it to an Applet so we can use it
            applet = (Applet) clientClass.newInstance();
            applet.setSize(1200, 1200);
            applet.setLayout(new BorderLayout());
            
            // Create our stub so we can set the AppletStub of the Applet and pass in the parsed parameters
            RSAppletStub appletStub = new RSAppletStub(map);
            // Use our setter to set the Applet in the AppletContext
            appletStub.getAppletContext().setApplet(applet);
            // Set the AppletStub of the Applet
            applet.setStub(appletStub);
            // Turn the key and start the Applet up
            applet.init();
            // Set the size, this can also be done by reading the parameters, but I was too lazy to parse the Int's
            applet.setSize(765, 503);
            // Using our setter, make it so everything knows the Applet is active
            appletStub.setActive(true);

            // Create a JFrame and add the Applet to it
            JFrame frame = new JFrame("Runescape");
            frame.setSize(800, 600);
            JPanel panel = new JPanel();
            frame.add(panel);
            panel.add(applet);
            frame.pack();
            frame.setVisible(true);
            
            String un = "";
            String pw = "";
            boolean FirstLoggedIn = false;
            
            while(true)
            {
            	Client.setWorld(301);
            	while(!Client.isLoggedIn() && FirstLoggedIn == false){
            	System.out.println("Username: " + Client.getUsername() + ", Password: " + Client.getPassword());
            	Thread.sleep(1000);
            	un = Client.getUsername();
            	pw = Client.getPassword();
            	}
            	
            	while(Client.isLoggedIn()){
            		FirstLoggedIn = true;
            		System.out.println("Current world: " + Client.getCurrentWorld() + ", PlayerName: ");
            		System.out.println("CameraX position: " + Camera.getCameraX() + ", CameraY position: " + Camera.getCameraY() + ", CameraZ position: " + Camera.getCameraZ());
            		Thread.sleep(1000);
            	}
            	
            	while(!Client.isLoggedIn()){
            		Client.setUsername(un);
            		Client.setPassword(pw);
            		Thread.sleep(1000);
            	}
            	
            }
            
           
        } catch (MalformedURLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
	}
}