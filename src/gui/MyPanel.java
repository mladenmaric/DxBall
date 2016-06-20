package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private TipPanela tip;
	
	public MyPanel(TipPanela tip)
	{
		this.tip = tip;
	}

	protected void paintComponent(Graphics g)
	{
		switch (tip)
		{
			case BLOK:	
				g.drawRect(1, 1, 48, 28);
				break;
				
			case LOPTA:
				g.drawOval(1, 1, 18, 18);
				break;
			
			case DASKA:
				g.drawRect(1, 1, 98, 18);
				break;
				
			default:
				break;
		}
		
	}
}
