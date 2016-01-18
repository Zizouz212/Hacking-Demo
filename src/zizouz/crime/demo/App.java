package zizouz212.crime.theft.demo;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import com.apple.eawt.Application;
import com.apple.eawt.FullScreenUtilities;

public class App
{
	static volatile boolean finished;
	public static void main(String[] args) throws Exception
	{
		Application.getApplication().setDockIconImage(Toolkit.getDefaultToolkit().createImage("./Resources/logo.png"));
		
		Thread.sleep(5000);
		
		JFrame f = new JFrame("Video");
		FullScreenUtilities.setWindowCanFullScreen(f, true);
		VideoPlayer v = new VideoPlayer();
		Paint p = new Paint(f);
		
		f.getContentPane().setBackground(Color.black);
		
		Data.getUserData();
		p.init();
		
		f.add(v);
		
		f.setVisible(true);
		
		v.player.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				App.finished = true;
			}
		});
		
		v.player.play();
		
		
		Application.getApplication().requestToggleFullScreen(f);
		Application.getApplication().requestForeground(true);
		Application.getApplication().requestUserAttention(true);
		
		while (true)
			if (App.finished)
				break;
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		f.remove(v);
		f.add(p);
		
		p.start();
		
	}
	
	

}
