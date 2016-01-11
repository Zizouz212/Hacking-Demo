package zizouz.crime.demo;

import java.io.File;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.Scene;

public class VideoPlayer extends javafx.embed.swing.JFXPanel implements KeyListener, ComponentListener 
{
	private static final long serialVersionUID = 11521199786L;
	public static final String path = new File("./Resources/startO.mp4").toURI().toString();
	
	public VideoPlayer(String p) 
	{
		super();
		
		this.file = new Media(p);
		this.player = new MediaPlayer(this.file);
		this.view = new MediaView(this.player);
		
		this.pane = new BorderPane();
		this.fxScene = new Scene(this.pane);
		
		this.pane.setCenter(this.view);
		
		this.fxScene.setFill(Paint.valueOf("black"));
		
		this.addComponentListener(this);
		this.addKeyListener(this);
		this.componentResized(null);
		
		this.setScene(this.fxScene);
		
		this.player.setOnEndOfMedia(new Runnable() {
			@Override public void run() 
			{
				if (auto) 
				{
					player.stop();
					player.play();
				}
				else
					player.pause();
			}
		});
	}
	public VideoPlayer() 
	{
		this(VideoPlayer.path);
	}
	
	
	protected Media file;
	protected MediaPlayer player;
	protected MediaView view;
	protected BorderPane pane;
	protected Scene fxScene;
	
	protected volatile boolean auto;
	
	@Override
	public void keyPressed(KeyEvent event) 
	{
		
	}
	@Override
	public void keyReleased(KeyEvent event) 
	{
		switch (event.getKeyCode())
		{
			case KeyEvent.VK_SPACE:
				boolean playing = this.player.getStatus().equals(Status.PLAYING);
				if (playing) 
					this.player.pause();
				else
					this.player.play();
				return;
			case KeyEvent.VK_ENTER:
				boolean inter = this.player.getStatus().equals(Status.PLAYING);
				this.player.stop();
				if (inter)
					this.player.play();
				return;
			case KeyEvent.VK_A:
				if (this.auto)
					this.auto = false;
				else
					this.auto = true;
				
				this.player.setAutoPlay(this.auto);
		}
	}
	@Override
	public void keyTyped(KeyEvent event) 
	{
		
	}
	@Override
	public void componentResized(ComponentEvent event) 
	{
		this.view.setPreserveRatio(true);
		this.view.setFitWidth(this.getWidth());
		this.view.setFitHeight(this.getHeight());
	}
	@Override
	public void componentMoved(ComponentEvent event) 
	{
		
	}
	@Override
	public void componentShown(ComponentEvent event) 
	{
		
	}
	@Override
	public void componentHidden(ComponentEvent event) 
	{
		
	}
	@Override
	protected void finalize() 
	{
		this.player.dispose();
		this.file = null;
		this.player = null;
		this.view = null;
		this.pane = null;
		this.fxScene = null;
		
	}
	// For Testing
	public static void main(String[] args) 
	{
		String p = null;
		VideoPlayer player;
		
		if (args.length > 0)
			p = args[0];
			
		if (p != null)
			player = new VideoPlayer(p);
		else
			player = new VideoPlayer();
			
		javax.swing.JFrame f = new javax.swing.JFrame();
		
		f.add(player);
		player.player.play();
		f.getContentPane().setBackground(java.awt.Color.BLACK);
		f.pack();
		f.setLocationRelativeTo(null);
		
		f.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override public void keyReleased(KeyEvent event) 
			{
				if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
					com.apple.eawt.Application.getApplication().requestToggleFullScreen(f);
			}
		});
		
		com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(f, true);
		
		if (args.length > 1)
		{
			if (args[1] != "-f" && args[0] != "-f")
			{
				f.setVisible(true);
				return;
			}
			
			f.setVisible(true);
			
			com.apple.eawt.Application.getApplication().requestToggleFullScreen(f);
			com.apple.eawt.Application.getApplication().requestForeground(true);
			
		}
		f.setVisible(true);
		
	}
	
	
}
