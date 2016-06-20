package gui;

import java.awt.BorderLayout;
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

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel[][] blokovi;
	private JPanel loptica;
	private MyPanel daska;
	private JLayeredPane glavniPanel;
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

		osveziGui();
		mouseListener();
		dodajTimer();
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

		//System.out.println(glavniPanel.getSize().toString());
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
				engine.pomeriLopticu(10);

				if (engine.isKraj())
				{
					timer.stop();
					JOptionPane.showMessageDialog(null, "Izgubili ste!");
				}

				int x = engine.getLoptica().getX() - engine.getLoptica().getR();
				int y = engine.getLoptica().getY() - engine.getLoptica().getR();
				int precnik = engine.getLoptica().getR() * 2;

				loptica.setBounds(x, y, precnik, precnik);
				loptica.revalidate();
				loptica.repaint();

				osveziGui();
			}
		});

		timer.start();
	}

	public void ocistiPanelIDodajSliku(JPanel panel, String image)
	{
		panel.removeAll();
		if (image != null) panel.add(new SlikaLabel(image));

		panel.revalidate();
		panel.repaint();
	}

	private void osveziGui()
	{
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (engine.getBlok(i, j) == null || engine.getBlok(i, j).isUnisten())
					ocistiPanelIDodajSliku(blokovi[i][j], null);
				else
					ocistiPanelIDodajSliku(blokovi[i][j], engine.getBlok(i, j).getPocetnaSlika());
	}

}