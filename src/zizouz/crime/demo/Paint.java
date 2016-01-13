package zizouz.crime.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;


public class Paint extends javax.swing.JPanel 
{
	private static final long serialVersionUID = 11521199786L;
	 
	int position = 0;
	int subPosition = 0;
	
	
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		switch(position) 
		{
			case 0:
				break;
			default:
				return;
		}
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

	
	protected void doNext() 
	{
		position += 1;
		subPosition = 0;
	}
	
	
	
}
