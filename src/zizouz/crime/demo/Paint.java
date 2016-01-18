package zizouz212.crime.theft.demo;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.text.StyledDocument;

public class Paint extends javax.swing.JTextPane implements ActionListener 
{
	private static final long serialVersionUID = 11521199786L;
	
	static class Subprocess extends Thread implements Runnable 
	{
		public Subprocess(Paint parent, String pipe) 
		{
			this.parent = parent;
			this.pipe = pipe;
		}
		Paint parent;
		String pipe;
		@Override
		public void run() 
		{
			try 
			{
				Process p = new ProcessBuilder().command("say", "\"" + pipe + "\"").start();
				p.waitFor();
			} 
			catch (Exception e) 
			{
				parent.ms100 -= 10;
			}
			
			parent.loop.exit();
			parent.timer.restart();
		}
	}
	
	public Paint(JFrame parent) 
	{
		this.parent = parent;
	}
	
	JFrame parent;
	volatile int step = 0;
	volatile int ms100 = 0;
	Icon currentImage;
	volatile Timer timer;
	volatile SecondaryLoop loop;

	public void init() 
	{
		//this.setLineWrap(true);
		//this.setWrapStyleWord(true);
		this.setOpaque(false);
		this.setEditable(false);
		this.setFocusable(false);
		this.setBackground(UIManager.getColor("Label.background"));
		this.setFont(UIManager.getFont("Label.font"));
		this.setBorder(UIManager.getBorder("Label.border"));
		this.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		this.setForeground(Color.white);
		this.setBackground(Color.black);
		
		
		
		this.timer = new Timer(100, this);
		
	}
	void nextStep() 
	{
		step += 1;
		ms100 = 0;
	}
	void start() 
	{
		this.timer.start(); Timer.setLogTimers(true);
	}
	
	synchronized void goNext() 
	{
		Subprocess command;
		
		switch (step) 
		{
			case 0:
				if (ms100 < 10)
					this.setText("Stop.");
				else if (ms100 < 20)
					this.setText("Stop. Look.");
				else if (ms100 < 30)
					this.setText("Stop. Look. Listen.");
				else if (ms100 < 40)
					this.setText("Stop. Look. Listen. I'm not actually a video.");
				else if (ms100 > 55)
					this.nextStep();
				return;
			case 1:
				if (ms100 < 10)
					this.setText("I'm not 'Quicktime'. I'm something else.");
				else if (ms100 > 25)
					this.nextStep();
				return;
			case 2:
				if (ms100 < 10)
					this.setText("So then, what am I?");
				else if (ms100 > 25)
					this.nextStep();
				return;
				
			case 3:
				if (ms100 < 10)
					this.setText("I am malicious.");
				else if (ms100 < 20)
					this.setText("I am malicious. I am a virus.");
				else if (ms100 < 30)
					this.setText("I am malicious. I am a virus. I am spyware.");
				else if (ms100 < 40)
					this.setText("I am malicious. I am a virus. I am spyware. I am malware.");
				else if (ms100 > 50)
					this.nextStep();
				return;
			case 4:
				this.setText("Call me anything.");
				if (ms100 > 20)
					this.nextStep();
				return;
			case 5:
				this.setText("But remember, I still look like a video.");
				if (ms100 > 30)
					this.nextStep();
				return;
			case 6:
				this.setText("So what can I do?");
				if (ms100 > 30)
					this.nextStep();
				return;
			
			case 7:
				this.setText("I can...");
				if (ms100 > 10)
					this.nextStep();
				return;
			
			case 8:
				this.setText("Find your name. Hello " + Data.name + "!");
				if (ms100 == 1) 
				{
					this.timer.stop(); System.out.println("Timer stopped");
					command = new Subprocess(this, "Hello " + Data.name);
					command.start();
					
					loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
					loop.enter();
				}
				
				if (ms100 > 10)
					this.nextStep();
				return;
			case 9:
				this.setText("Oh, I didn't mention I could access the system voice?");
				timer.stop();
				command = new Subprocess(this, "Oh. I didn't mention I could access the system voice?");
				command.start();
				
				loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
				loop.enter();
				
				if (ms100 > 0)
					this.nextStep();
				return;
			case 10:
				this.setText("I know your computer. You have a " + Data.getOSName() + " computer? Cool!");
				timer.stop();
				command = new Subprocess(this, "You've got a " + Data.getReadableOSName() + " computer? Cool!");
				command.start();
				
				loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
				loop.enter();
				
				if (ms100 > 0)
					this.nextStep();
				return;
			case 11:
				if (ms100 == 1) 
				{
					this.setText("Let me get your password... ");
					timer.stop();
					command = new Subprocess(this, "Let me get your password... Um... I'll stop talking.");
					command.start();
					
					loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
					loop.enter();
				}
				
				if (ms100 == 2)
					this.setText("I'm not saying that!");
				
				if (ms100 > 20)
					this.nextStep();
				return;
			case 12:
				this.setText("What else can I do, you ask?");
				
				if (ms100 > 15)
					this.nextStep();
				return;
			case 13:
				this.setText("I can read, create, modify, and destroy your files.");
				
				if (ms100 > 10)
					this.nextStep();
				return;
			case 14:
				String[] appSample = Data.getApplicationsSample(3);
				
				if (ms100 == 1)
					this.setText("You've got " + appSample[0] + ", " + appSample[1] + ", " + appSample[2] + " installed? Good taste.");
				
				
				if (ms100 > 30)
					this.nextStep();
				return;
			case 15:
				String docSample = Data.getDocumentsSample(1)[0];
				
				if (ms100 == 1)
					this.setText("Here's a document I found: " + docSample);
				
				if (ms100 > 30)
					this.nextStep();
				return;
			case 16:
				if (ms100 < 5)
					this.setText("Just a little tweak here...");
				
				else if (ms100 < 15)
					this.setText("There. Finished.");
				
				else if (ms100 < 35)
					this.setText("Oh, I'm still full screen? Let me show you what I've done when you weren't looking :) ");
				
				else if (ms100 == 50)
				{
					new Thread(new Runnable() {
						@Override
						public void run() 
						{
							try 
							{
								Data.makePointlessFiles(Data.userDesktop + "/HackingDemo");
								
								Desktop.getDesktop().open(new java.io.File(Data.userDesktop + "/HackingDemo"));
								System.out.println(Data.userDesktop + "/HackingDemo");
								parent.setExtendedState(JFrame.ICONIFIED);
								Thread.sleep(2500);
								loop.exit();
							}
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					}).start();
				
					loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
					loop.enter();
				
					this.setText("Fascinating, isn't it?");
					this.parent.setExtendedState(JFrame.NORMAL);
					this.parent.requestFocus();
					
					try 
					{
						Thread.sleep(3000);
					} catch (InterruptedException e){}
					
					com.apple.eawt.Application.getApplication().requestUserAttention(true);
					com.apple.eawt.Application.getApplication().requestForeground(true);
					try 
					{
						Thread.sleep(5000);
					} catch (InterruptedException e){}
					//com.apple.eawt.Application.getApplication().requestToggleFullScreen(this.parent);
					
				}
				
				if (ms100 > 80)
					this.nextStep();
				return;
				
			case 17:
				this.setText("Step up to cybercrime. Don't let people like me do this");
				
				if (ms100 > 35)
					this.nextStep();
				return;
			case 18:
				this.setText("In 2012, the RCMP received around 4000 incidents of cybercrime. "
						+ "85% was where technology was ued as an instrument to commit another crime, "
						+ "such as fraud, identity theft, to more serious crimes, such as human and "
						+ "drug trafficking, and child sexual exploitation.");
				
				if (ms100 > 95)
					this.nextStep();
				return;
			case 19:
				this.setText("73% of victims of violent incidents involving cybercrimes were known by the accused.");
				
				if (ms100 > 80) 
					this.nextStep();
				return;
			case 20:
				this.setText("42% of victims associated with cybercrimes were less than 17 years old.");
				
				if (ms100 > 80)
					this.nextStep();
				return;
				
			default:
				this.setText("Crimes over the internet are committed to often. They shouldn't happen at all. "
						+ "Everyone has the right to feel safe over the internet. Step up to cybercrime.");
				
		}
	}
	
	public static void main(String[] args) 
	{
		JFrame f = new JFrame(); Data.getUserData();
		
		com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(f, true);
		
		
		Paint p = new Paint(f); f.getContentPane().setBackground(Color.black);
		f.add(p);
		p.init();
		f.pack();
		f.setVisible(true);
		
		com.apple.eawt.Application.getApplication().requestToggleFullScreen(f);
		
		p.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		ms100 += 1;
		synchronized(this) 
		{
			this.goNext();
		}
	}
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
	}
	@Override
	protected void paintBorder(Graphics graphics) 
	{
		super.paintBorder(graphics);
	}
	@Override
	protected void paintChildren(Graphics graphics) 
	{
		super.paintChildren(graphics);
	}

}
