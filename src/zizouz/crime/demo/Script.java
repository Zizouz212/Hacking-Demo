package zizouz.crime.demo;

public class Script 
{
	
	public static final String[][] script = new String[][] {
		
		{"Stop. Look. Listen. I'm not actually a video.", "display"}, // Step 0
		{"I'm not 'QuickTime'. I'm something else", "display"}, // Step 1
		{"So then, what am I?", "display"}, // Step 2
		
		{"I am malicious. I am a virus. I am spyware. I am malware.", "display"} // Step 3
		{"Call me anything.", "display"}, // Step 4
		{"But remember. I still look like a video.", "display"}, // Step 5
		{"So what can I do?", "display"}, // Step 6
		
		{"I can...", "display"}, // Step 7.0
			
			{"Find your name. Hello <>", "say"}, // Step 7.1
			{"Oh, I didn't mention I could access the system voice?", "say"}, // Step 7.2
			{"I know your operating system. You have a <> machine? Cool.", "say"}, // Step 7.3
			{"Let me get your password. Your password is... I'm not saying that", "say"}, // Step 7.4
			
		{"What else can I do, you ask?", "say"}, // Step 8.0
			
			{"I can read all. Of your files", "say"}, // Step 8.1
			{"I can make thousands of files", "say"}, // Step 8.2
			{"I can delete them, change them, modify them", "say"}, // Step 8.3
			{"I can even delete your entire computer", "say"}, // Step 8.4
			
		{"Let's see...", "say"}, // Step 9.0
		
			{"You've got <>, <>, and <> installed?", "display"}, // Step 9.1
			{"Here's a document I found... <>", "display"}, // Step 9.2
			
		{"I forgot, I'm still full screen! Let me show you what I have done when you haven't been looking!", "say"}, // Step 10
		
		/*
			java.awt.Desktop().getDesktop().browse(directory);
		*/
		
		
		{"Step up to cybercrime. Don't let us do this", "display"}, // Step 11
		
		{"In 2012, the RCMP received around 4000 incidents of cybercrime. 85% was where technology was ued as an instrument to commit another crime, such as fraud, identity theft, to more serious crimes, such as human and drug trafficking, and child sexual exploitation.", "display"}, // Step 12
		
		{"73% of victims of violent incidents involving cybercrimes were known by the accused.", "display"}, // Step 13
		
		{"42% of victims associated with cybercrimes were less than 17 years old.", "display"}, // Step 14
		
	};

	




}
