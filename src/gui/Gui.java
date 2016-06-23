package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import engine.Engine;
import iznenadjenja.BonusZivot;
import iznenadjenja.Iznenadjenje;
import iznenadjenja.ProbojnostLoptice;
import iznenadjenja.ProduzenjeDaske;
import iznenadjenja.SkracenjeDaske;
import iznenadjenja.SmanjenjeZivota;
import iznenadjenja.UbrzanjeLoptice;
import iznenadjenja.UsporenjeLoptice;
import iznenadjenja.VatrenostLoptice;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Engine engine = new Engine();
	private JPanel contentPane;
	private JPanel[][] blokovi;
	private PanelIznenadjenja[] iznenadjenja;
	private JPanel loptica;
	private JPanel daska;
	private JLayeredPane glavniPanel;
	private Timer timerLoptica;
	private Timer timerIznenadjenje;
	private JPanel panelLevo;
	private JPanel panelDesno;
	private JPanel levaOgrada;
	private JPanel desnaOgrada;

	public Gui(String title)
	{
		super(title);
		init();
	}

	private void init()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		glavniPanel = new JLayeredPane();
		glavniPanel.setOpaque(true);
		glavniPanel.setBackground(Color.BLACK);
		glavniPanel.setBounds(183, 0, 1000, 741);
		contentPane.add(glavniPanel);

		panelLevo = new JPanel();
		panelLevo.setBackground(Color.BLACK);
		panelLevo.setBounds(0, 0, 183, 741);
		panelLevo.setLayout(null);
		contentPane.add(panelLevo);

		panelDesno = new JPanel();
		panelDesno.setBackground(Color.BLACK);
		panelDesno.setBounds(1183, 0, 183, 741);
		panelDesno.setLayout(null);
		contentPane.add(panelDesno);
		
		//System.out.println(getHeight());

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

		// DASKA
		daska = new JPanel();

		FlowLayout g = (FlowLayout) daska.getLayout();
		g.setHgap(0);
		g.setVgap(0);

		daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
				engine.getDaska().getVisina());
		daska.setOpaque(true);
		ocistiPanelIDodajSliku(daska, "/Daska100.png");
		glavniPanel.add(daska, 0);
		
		levaOgrada = new JPanel();
		levaOgrada.setBounds(163, 0, 20, 741);
		levaOgrada.setLayout(null);
		panelLevo.add(levaOgrada);
		
		JLabel l1 = new JLabel(new ImageIcon(getClass().getResource("/Levo.png")));
		l1.setOpaque(true);
		l1.setSize(20, 741);
		levaOgrada.add(l1);
		
		JPanel skor = new JPanel();
		skor.setOpaque(false);
		skor.setBounds(10, 11, 143, 50);
		panelLevo.add(skor);
		
		JLabel l3 = new JLabel(new ImageIcon(getClass().getResource("/Skor.png")));
		l3.setOpaque(false);
		l3.setSize(143, 40);
		skor.add(l3);
		
		JPanel skorBrojevi = new JPanel();
		skorBrojevi.setOpaque(false);
		skorBrojevi.setBounds(10, 77, 143, 89);
		panelLevo.add(skorBrojevi);
		
		desnaOgrada = new JPanel();
		desnaOgrada.setBounds(0, 0, 20, 741);
		desnaOgrada.setLayout(null);
		panelDesno.add(desnaOgrada);
		
		JLabel l2 = new JLabel(new ImageIcon(getClass().getResource("/Desno.png")));
		l2.setOpaque(true);
		l2.setSize(20, 741);
		desnaOgrada.add(l2);
		
		JPanel slikeZivota = new JPanel();
		slikeZivota.setOpaque(false);
		slikeZivota.setBounds(67, 134, 59, 314);
		panelDesno.add(slikeZivota);
		
		JPanel zivoti = new JPanel();
		zivoti.setOpaque(false);
		zivoti.setBounds(30, 11, 143, 89);
		panelDesno.add(zivoti);
		
		JLabel l4 = new JLabel(new ImageIcon(getClass().getResource("/Zivoti.png")));
		//l4.setOpaque(false);
		l4.setSize(143, 40);
		zivoti.add(l4);
		

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
		ocistiPanelIDodajSliku(loptica, engine.getLoptica().getSlika());
		glavniPanel.add(loptica, 0);
		
		// IZNENADJENJA
		uzmiIznenadjenja();
		

	}
	
	private void uzmiIznenadjenja()
	{
		int p = 0;
		iznenadjenja = new PanelIznenadjenja[engine.getNivo() + 3];
		
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (engine.getBlok(i, j) != null && engine.getBlok(i, j).getIznenadjenje() != null)
				{
					iznenadjenja[p] = new PanelIznenadjenja(engine.getBlok(i, j).getIznenadjenje());
					iznenadjenja[p].setSize(50, 50);
					iznenadjenja[p].setOpaque(true);
					iznenadjenja[p].setVisible(false);
					
					FlowLayout f = (FlowLayout) iznenadjenja[p].getLayout();
					f.setHgap(0);
					f.setVgap(0);
					
					ocistiPanelIDodajSliku(iznenadjenja[p], engine.getBlok(i, j).getIznenadjenje().getSlika());
					glavniPanel.add(iznenadjenja[p], 0);
					
					p++;
				}
					
					
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
						engine.getDaska().getVisina());
				
				if (engine.isPomeranjeLopticeSaDaskom())
				{
					engine.getLoptica().setX(engine.getDaska().getX() + engine.getDaska().getSirina() / 2);	
					
					int x = engine.getLoptica().getX() - engine.getLoptica().getR();
					int y = engine.getLoptica().getY() - engine.getLoptica().getR();
					int precnik = engine.getLoptica().getR() * 2;

					loptica.setBounds(x, y, precnik, precnik);
				}
				
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
				if (engine.isPomeranjeLopticeSaDaskom())
					engine.setPomeranjeLopticeSaDaskom(false);
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
					
					engine.setKraj(false);
					unistiPaneleIznenadjenja();
					
					
					osveziGuiBlokovi();
					osveziGuiIznenadjenja();
					
					engine.postaviPocetneVrednosti();
					timerLoptica.setDelay(engine.getLoptica().getBrzinaLoptice());
					
					daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
							engine.getDaska().getVisina());
					ocistiPanelIDodajSliku(daska, "/Daska" + engine.getDaska().getSirina() + ".png");
					
					engine.getLoptica().setX(engine.getDaska().getX() + engine.getDaska().getSirina() / 2);	
					
					int x = engine.getLoptica().getX() - engine.getLoptica().getR();
					int y = engine.getLoptica().getY() - engine.getLoptica().getR();
					int precnik = engine.getLoptica().getR() * 2;

					loptica.setBounds(x, y, precnik, precnik);
					ocistiPanelIDodajSliku(loptica, engine.getLoptica().getSlika());
					
					
					if (engine.getBrojZivota() == 0)
					{
						JOptionPane.showMessageDialog(null, "Izgubili ste!");
						System.exit(0);
					}

				}

				if (engine.predjiNivo())
				{
					timerLoptica.stop();
					unistiPaneleIznenadjenja();
					
					osveziGuiBlokovi();
					osveziGuiIznenadjenja();
					timerLoptica.setDelay(engine.getLoptica().getBrzinaLoptice());
					
					daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
							engine.getDaska().getVisina());
					ocistiPanelIDodajSliku(daska, "/Daska" + engine.getDaska().getSirina() + ".png");
					
					engine.getLoptica().setX(engine.getDaska().getX() + engine.getDaska().getSirina() / 2);	
					
					int x = engine.getLoptica().getX() - engine.getLoptica().getR();
					int y = engine.getLoptica().getY() - engine.getLoptica().getR();
					int precnik = engine.getLoptica().getR() * 2;

					loptica.setBounds(x, y, precnik, precnik);
					ocistiPanelIDodajSliku(loptica, engine.getLoptica().getSlika());
					
					uzmiIznenadjenja();
				}

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
				Iznenadjenje izn = engine.prihvatiIznenadjenje();

				if (izn instanceof BonusZivot || izn instanceof SmanjenjeZivota)
				{
					//zivoti.setText("BROJ ZIVOTA: " + engine.getBrojZivota());
					
					if (izn instanceof SmanjenjeZivota)
					{
						engine.postaviPocetneVrednosti();
						osveziGuiBlokovi();
						timerLoptica.stop();
					}
				}
				else if (izn instanceof ProduzenjeDaske || izn instanceof SkracenjeDaske)
				{
					daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
							engine.getDaska().getVisina());
					
					ocistiPanelIDodajSliku(daska, "/Daska" + engine.getDaska().getSirina() + ".png");
				}
				else if (izn instanceof UbrzanjeLoptice || izn instanceof UsporenjeLoptice)
				{
					timerLoptica.setDelay(engine.getLoptica().getBrzinaLoptice());
				}
				else if (izn instanceof VatrenostLoptice || izn instanceof ProbojnostLoptice)
				{
					ocistiPanelIDodajSliku(loptica, engine.getLoptica().getSlika());
				}
				
				osveziGuiIznenadjenja();
			}
		});

		timerIznenadjenje.start();
	}

	public void ocistiPanelIDodajSliku(JPanel panel, String image)
	{
		panel.removeAll();
		if (image != null) 
			panel.add(new SlikaLabel(image));

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
		
		for (int i = 0; i < iznenadjenja.length; i++)
		{
			if (iznenadjenja[i] != null)
			{
				if (iznenadjenja[i].getIznenadjenje() != null && iznenadjenja[i].getIznenadjenje().isVidljivo())
				{
					iznenadjenja[i].setVisible(true);
					iznenadjenja[i].setBounds(iznenadjenja[i].getIznenadjenje().getX(), iznenadjenja[i].getIznenadjenje().getY(), 
							iznenadjenja[i].getIznenadjenje().getSirina(), iznenadjenja[i].getIznenadjenje().getVisina());
					iznenadjenja[i].getIznenadjenje().spustiSe();
				}
				else
				{
					iznenadjenja[i].setVisible(false);
				}
			}
		}
		
	}
	
	private void unistiPaneleIznenadjenja()
	{
		for (int i = 0; i < iznenadjenja.length; i++)
			if (iznenadjenja[i] != null && iznenadjenja[i].getIznenadjenje() != null 
				&& iznenadjenja[i].getIznenadjenje().isVidljivo())			
				iznenadjenja[i].getIznenadjenje().setVidljivo(false);;
	}
}
