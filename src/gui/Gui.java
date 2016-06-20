package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import engine.Engine;
import iznenadjenja.Iznenadjenje;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel[][] blokovi;
	private JPanel[] iznenadjenja;
	private JPanel loptica;
	private MyPanel daska;
	private JLayeredPane glavniPanel;
	private Engine engine = new Engine();
	private Timer timerLoptica;
	private Timer timerIznenadjenje;

	public Gui(String naziv)
	{
		super(naziv);
		init();
	}

	private void init()
	{
		postaviDeloveIgre();
		postaviProzor();

		osveziGuiBlokovi();
		osveziGuiIznenadjenja();
		mouseListener();
		dodajTimerLoptica();
		dodajTimerIznenadjenje();
	}

	private void postaviProzor()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	private void postaviDeloveIgre()
	{
		glavniPanel = new JLayeredPane();
		// glavniPanel.setPreferredSize(new Dimension(width, height));

		blokovi = new JPanel[20][20];
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
			{
				blokovi[i][j] = new JPanel();

				FlowLayout f = (FlowLayout) blokovi[i][j].getLayout();
				f.setHgap(1);
				f.setVgap(1);

				blokovi[i][j].setBounds(183 + 50 * j, 30 * i, 50, 30);
				glavniPanel.add(blokovi[i][j], 0);
			}

		iznenadjenja = new JPanel[6];
		
		for (int i = 0; i < 6; i++)
		{
			iznenadjenja[i] = new JPanel();
			iznenadjenja[i].setPreferredSize(new Dimension(50, 50));
			iznenadjenja[i].setOpaque(true);
			
			glavniPanel.add(iznenadjenja[i], 0);
		}
		
		loptica = new JPanel();

		FlowLayout f = (FlowLayout) loptica.getLayout();
		f.setHgap(0);
		f.setVgap(0);

		loptica.setBounds(500, 500, 20, 20);
		loptica.setOpaque(true);
		ocistiPanelIDodajSliku(loptica, "/loptica.png");
		glavniPanel.add(loptica, 0);

		daska = new MyPanel(TipPanela.DASKA);
		daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
				engine.getDaska().getDuzina());
		glavniPanel.add(daska, 0);

		getContentPane().add(glavniPanel, BorderLayout.CENTER);
	}

	private void mouseListener()
	{
		addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseMoved(MouseEvent e)
			{
				engine.getDaska().pomeriSe();
				daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
						engine.getDaska().getDuzina());
			}

			@Override
			public void mouseDragged(MouseEvent e)
			{
			}
		});

	}

	private void dodajTimerLoptica()
	{
		timerLoptica = new Timer(engine.getLoptica().getBrzinaLoptice(), new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
					engine.pomeriLopticu(5);
				
				if (engine.isKraj())
				{
					timerLoptica.stop();
					JOptionPane.showMessageDialog(null, "Izgubili ste!");
				}

				int x = engine.getLoptica().getX() - engine.getLoptica().getR();
				int y = engine.getLoptica().getY() - engine.getLoptica().getR();
				int precnik = engine.getLoptica().getR() * 2;

				loptica.setBounds(x, y, precnik, precnik);
				osveziGuiBlokovi();
			}
		});

		timerLoptica.start();
	}
	
	private void dodajTimerIznenadjenje()
	{
		timerIznenadjenje = new Timer(50, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				osveziGuiIznenadjenja();
			}
		});
		
		timerIznenadjenje.start();
	}

	public void ocistiPanelIDodajSliku(JPanel panel, String image)
	{
		panel.removeAll();
		if (image != null) panel.add(new SlikaLabel(image));

		panel.revalidate();
		panel.repaint();
	}

	private void osveziGuiBlokovi()
	{
		// PRIKAZI BLOKOVE		
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (engine.getBlok(i, j) == null || engine.getBlok(i, j).isUnisten())
					ocistiPanelIDodajSliku(blokovi[i][j], null);
				else
					ocistiPanelIDodajSliku(blokovi[i][j], engine.getBlok(i, j).getPocetnaSlika());
		
	}
	
	private void osveziGuiIznenadjenja()
	{
		// PRIKAZI IZNENADJENJA
		Iznenadjenje[] izn = engine.getIznenadjenja();
		for (int i = 0; i < 6; i++)
		{
			if (izn[i].isVidljivo())
			{
				ocistiPanelIDodajSliku(iznenadjenja[i], izn[i].getSlika());
				izn[i].spustiSe();
				
				System.out.println("jbm");
			}
			else
				ocistiPanelIDodajSliku(iznenadjenja[i], null);
				
		}
		
	}

}