package zizouz212.crime.theft.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Data 
{
	
	public static void getUserData() 
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
	
	public static String getOSName() 
	{
		return osName + " v" + osVers;  
	}
	public static String getReadableOSName() 
	{
		return osName.split(" ")[0];
	}
	
	public static String[] getApplicationsSample(int sampleSize) 
	{
		String[] out = new String[sampleSize];
		Random gen = new Random();
		File[] apps = new File("/Applications").listFiles();
		
		for (int i = 0; i < sampleSize; i += 1)
			out[i] = apps[gen.nextInt(apps.length)].getName();
		
		return out;
	}
	public static String[] getDocumentsSample(int sampleSize) 
	{
		String[] out = new String[sampleSize];
		Random gen = new Random();
		File[] apps = new File(userHome + "/Documents").listFiles();
		
		for (int i = 0; i < sampleSize; i += 1)
			out[i] = apps[gen.nextInt(apps.length)].getName();
		
		return out;
	}
	
	public static void makePointlessFiles(String where) 
	{
		File f = new File(where);
		if (! f.exists())
			f.mkdir();
		
		for (int i = 0; i < 100; i += 1) 
		{
			try 
			{
				PrintWriter file = new PrintWriter(where + "/Thank_Zin_" + Integer.toString(i) + ".zinIsEvil", "UTF-8");
				file.write("Ha ha. Ha ha. Ha. He. Hi. Ho. He he. Ho Ho Ho. I AM EVIL!\n");
				
				file.write("\n\n\n\n\n\n\n\n\n\n\n\n");
				for (int j = 0; j < 50; j += 1)
					file.write("534095734579827542472836472938652380472385623947320856830463205648027358062308462308650283476\n\n\n");
				
				System.getProperties().list(file);
				
				file.close();
			}
			catch (IOException e) {}
		}
		
		
		
	}
	
	
	public static String name;
	public static String execPath;
	public static String userDesktop;
	public static String userHome;
	
	public static String osName;
	public static String osVers;
	public static String osArch;
	
	public static String javaVers;
	
	public static void main(String[] args) throws Exception
	{
		Data.getUserData();
		System.out.println(name + '\n' + execPath + '\n' + userDesktop);
		System.out.println(osName + '\n' + osVers + '\n' + osArch);
		System.out.println(getOSName());
		System.out.println(javaVers);
	}
	
	
}
