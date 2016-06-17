package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import engine.Engine;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private MyPanel[][] blokovi;
	private MyPanel loptica;
	private MyPanel daska;
	private Engine engine = new Engine();	
	private Timer timer;
	
	public Gui(String naziv)
	{
		super(naziv);
		init();
	}
	
	private void init()
	{
		postaviDeloveIgre();
		postaviProzor();
		
		mouseListener();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dodajTimer();
		
	}
	
	private void postaviProzor()
	{
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH); 
		//setUndecorated(true);
		setVisible(true);
	}
	
	private void postaviDeloveIgre()
	{
		blokovi = new MyPanel[20][20];
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
			{
				blokovi[i][j] = new MyPanel(TipPanela.BLOK);
				blokovi[i][j].setBounds(183 + 50 * j, 30 * i, 50, 30);
				getContentPane().add(blokovi[i][j]);
			}
		
		loptica = new MyPanel(TipPanela.LOPTA);
		loptica.setBounds(500, 500, 20, 20);
		getContentPane().add(loptica);
		
		daska = new MyPanel(TipPanela.DASKA);
		daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(), engine.getDaska().getDuzina());
		getContentPane().add(daska);
	}
	
	private void mouseListener()
	{
		addMouseMotionListener(new MouseMotionListener()
		{
			
			@Override
			public void mouseMoved(MouseEvent e)
			{
				engine.getDaska().pomeriSe();
				daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(), engine.getDaska().getDuzina());
			}
			
			@Override
			public void mouseDragged(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	private void dodajTimer()
	{
		timer = new Timer(35, new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				engine.pomeriLopticu(15);
				
				if (engine.isKraj())
				{
					timer.stop();
					JOptionPane.showMessageDialog(null, "Izgubili ste!");
				}
				
				int x = engine.getLoptica().getX() - engine.getLoptica().getR();
				int y = engine.getLoptica().getY() - engine.getLoptica().getR();
				int precnik = engine.getLoptica().getR() * 2;
				
				loptica.setBounds(x, y, precnik, precnik);
			}
		});
		
		timer.start();
	}
	
}