package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import engine.Engine;
import iznenadjenja.Iznenadjenje;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Engine engine = new Engine();
	private JPanel contentPane;
	private JPanel[][] blokovi;
	private JPanel[] iznenadjenja;
	private JPanel loptica;
	private JPanel daska;
	private JLayeredPane glavniPanel;
	private Timer timerLoptica;
	private Timer timerIznenadjenje;
	private JPanel panelLevo;
	private JPanel panelDesno;
	private JLabel zivoti;

	public Gui(String title)
	{
		super(title);
		init();
	}

	private void init()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		glavniPanel = new JLayeredPane();
		glavniPanel.setOpaque(true);
		glavniPanel.setBackground(Color.BLACK);
		glavniPanel.setBounds(183, 0, 1000, 741);
		contentPane.add(glavniPanel);

		panelLevo = new JPanel(null);
		panelLevo.setBackground(Color.WHITE);
		panelLevo.setBounds(0, 0, 183, 741);
		contentPane.add(panelLevo);

		panelDesno = new JPanel();
		panelDesno.setBackground(Color.WHITE);
		panelDesno.setBounds(1183, 0, 180, 741);
		contentPane.add(panelDesno);

		setVisible(true);

		postaviDeloveIgre();
		mouseListener();
		osveziGuiBlokovi();
		dodajTimerLoptica();
		dodajTimerIznenadjenje();

	}

	private void postaviDeloveIgre()
	{
		// BLOKOVI
		blokovi = new JPanel[20][20];

		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
			{
				blokovi[i][j] = new JPanel();

				FlowLayout f = (FlowLayout) blokovi[i][j].getLayout();
				f.setHgap(0);
				f.setVgap(0);

				blokovi[i][j].setBounds(50 * j, 25 * i, 50, 25);
				blokovi[i][j].setOpaque(true);
				blokovi[i][j].setBackground(Color.BLACK);
				glavniPanel.add(blokovi[i][j], 0);
			}

		// IZNENADJENJA
		iznenadjenja = new JPanel[6];

		for (int i = 0; i < 6; i++)
		{
			iznenadjenja[i] = new JPanel();
			iznenadjenja[i].setSize(50, 50);
			iznenadjenja[i].setOpaque(true);
			iznenadjenja[i].setVisible(false);

			FlowLayout f = (FlowLayout) iznenadjenja[i].getLayout();
			f.setHgap(0);
			f.setVgap(0);

			glavniPanel.add(iznenadjenja[i], 0);
		}

		// DASKA
		daska = new JPanel();

		FlowLayout g = (FlowLayout) daska.getLayout();
		g.setHgap(0);
		g.setVgap(0);

		daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
				engine.getDaska().getDuzina());
		daska.setOpaque(true);
		ocistiPanelIDodajSliku(daska, "/Daska100.png");
		glavniPanel.add(daska, 0);

		zivoti = new JLabel("BROJ ZIVOTA: " + engine.getBrojZivota());
		zivoti.setFont(new Font("Arial", Font.BOLD, 15));
		zivoti.setBounds(10, 11, 163, 67);
		panelLevo.add(zivoti);

		// LOPTICA
		loptica = new JPanel();

		FlowLayout f = (FlowLayout) loptica.getLayout();
		f.setHgap(0);
		f.setVgap(0);

		int x = engine.getLoptica().getX() - engine.getLoptica().getR();
		int y = engine.getLoptica().getY() - engine.getLoptica().getR();
		int precnik = engine.getLoptica().getR() * 2;

		loptica.setBounds(x, y, precnik, precnik);
		loptica.setOpaque(true);
		loptica.setBackground(Color.BLACK);
		ocistiPanelIDodajSliku(loptica, "/Loptica.png");
		glavniPanel.add(loptica, 0);

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

		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseReleased(MouseEvent e)
			{
				timerLoptica.start();
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

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

				engine.predjiNivo();

				int x = engine.getLoptica().getX() - engine.getLoptica().getR();
				int y = engine.getLoptica().getY() - engine.getLoptica().getR();
				int precnik = engine.getLoptica().getR() * 2;
				loptica.setBounds(x, y, precnik, precnik);

				osveziGuiBlokovi();

			}
		});
	}

	private void dodajTimerIznenadjenje()
	{
		timerIznenadjenje = new Timer(50, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean primljenaDaska = false;

				osveziGuiIznenadjenja();
				primljenaDaska = engine.prihvatiIznenadjenje();
				timerLoptica.setDelay(engine.getLoptica().getBrzinaLoptice());
				zivoti.setText("BROJ ZIVOTA: " + engine.getBrojZivota());

				if (primljenaDaska)
				{
					daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
							engine.getDaska().getDuzina());
					ocistiPanelIDodajSliku(daska, "/Daska" + engine.getDaska().getSirina() + ".png");
				}

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
			if (izn[i] != null)
			{
				if (izn[i].isVidljivo())
				{
					iznenadjenja[i].setVisible(true);
					iznenadjenja[i].setBounds(izn[i].getX(), izn[i].getY(), izn[i].getSirina(), izn[i].getVisina());
					ocistiPanelIDodajSliku(iznenadjenja[i], izn[i].getSlika());
					izn[i].spustiSe();
				}
			}
			else
			{
				iznenadjenja[i].setVisible(false);
			}

		}
	}

}
