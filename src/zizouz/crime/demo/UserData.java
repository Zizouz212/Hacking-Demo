package zizouz.crime.demo;

class UserData 
{
	public static void getData() 
	{
		name = System.getProperty("user.name").substring(0, 1).toUpperCase() + 
				System.getProperty("user.name").substring(1, System.getProperty("user.name").length());
		execPath = System.getProperty("user.dir");
		userDesktop = System.getProperty("user.home") + "/Desktop";
		userHome = System.getProperty("user.home");
		
		osName = System.getProperty("os.name");
		osVers = System.getProperty("os.version");
		osArch = System.getProperty("os.arch");
		
		javaVers = System.getProperty("java.version"); 
	}
	
	public static String name;
	public static String execPath;
	public static String userDesktop;
	public static String userHome;
	
	public static String osName;
	public static String osVers;
	public static String osArch;
	
	public static String javaVers;
	
}
