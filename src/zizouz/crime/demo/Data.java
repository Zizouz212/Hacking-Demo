package zizouz.crime.demo;

import java.awt.Image;
import java.io.File;

class Data 
{
	public static void getData() 
	{
		name = System.getProperty("user.name").substring(0, 1).toUpperCase() + 
				System.getProperty("user.name").substring(1, System.getProperty("user.name").length());
		execPath = System.getProperty("user.dir");
		userHome = System.getProperty("user.home");
		
		osName = System.getProperty("os.name");
		osVers = System.getProperty("os.version");
		osArch = System.getProperty("os.arch");
		
		javaVers = System.getProperty("java.version"); 
		
		apps = new File("/Applications").listFiles();
		desktop = new File(userHome + "/Desktop").listFiles();
		docs = new File(userHome + "/Documents").listFiles();
	}
	
	public static String name;
	public static String execPath;
	public static String userHome;
	
	public static String osName;
	public static String osVers;
	public static String osArch;
	
	public static String javaVers;
	
	public static File[] apps;
	public static File[] desktop;
	public static File[] docs;
	
	public static String getOSName() 
	{
		return osName + " v" + osVers;
	}
	
	// Image support
	
	public static java.util.List<Image> images = new java.util.ArrayList<Image>();
	
	public static void load() 
	{
		java.awt.Toolkit kit = java.awt.Toolkit.getDefaultToolkit();
		for (File i : new File("./Resources/Images").listFiles()) 
			images.add(kit.createImage(i.getAbsolutePath()));
		
	}
	
}
