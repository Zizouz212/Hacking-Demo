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

import javax.swing.JFrame;

public class VideoPlayer extends javafx.embed.swing.JFXPanel implements KeyListener, ComponentListener 
{
	private static final long serialVersionUID = 11521199786L;
	public static final String path = new File("./Resources/intro.mp4").toURI().toString();
	
	public VideoPlayer() 
	{
		super();
		
		this.file = new Media(VideoPlayer.path);
		this.player = new MediaPlayer(this.file);
		this.view = new MediaView(this.player);
		
		this.pane = new BorderPane();
		this.fxScene = new Scene(this.pane);
		
		this.pane.setCenter(this.view);
		
		this.fxScene.setFill(Paint.valueOf("black"));
		
		this.addComponentListener(this);
		this.addKeyListener(this);
		
		this.setScene(this.fxScene);
	}
	
	protected final Media file;
	protected final MediaPlayer player;
	protected final MediaView view;
	protected final BorderPane pane;
	protected final Scene fxScene;
	
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
				boolean playing = this.player.getStatus().equals(Status.PLAYING);
				this.player.stop();
				if (playing)
					this.player.play();
				return;
		}
	}
	@Override
	public void keyTyped(KeyEvent event) 
	{
		
	}
	
	
	
}
