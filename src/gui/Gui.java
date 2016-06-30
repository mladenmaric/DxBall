package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
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
	private Engine engine;
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
	private JPanel slikeZivota;
	private JLabel skorBrojevi;
	private static int SIRINA;
	private static int VISINA;

	public Gui(String title)
	{
		super(title);
		init();
	}

	private void init()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        setMaximizedBounds(env.getMaximumWindowBounds());
        
        SIRINA = (int) env.getMaximumWindowBounds().getWidth();
        VISINA = (int) env.getMaximumWindowBounds().getHeight();
        
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        engine = new Engine(VISINA);
        
        contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		glavniPanel = new JLayeredPane();
		glavniPanel.setOpaque(true);
		glavniPanel.setBackground(Color.BLACK);
		glavniPanel.setBounds((SIRINA - 1000) / 2, 0, 1000, VISINA);
		contentPane.add(glavniPanel);

		panelLevo = new JPanel();
		panelLevo.setBackground(Color.BLACK);
		panelLevo.setBounds(0, 0, (SIRINA - 1000) / 2, VISINA);
		panelLevo.setLayout(null);
		contentPane.add(panelLevo);

		panelDesno = new JPanel();
		panelDesno.setBackground(Color.BLACK);
		panelDesno.setBounds((SIRINA - 1000) / 2 + 1000, 0, (SIRINA - 1000) / 2, VISINA);
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
		ocistiPanelIDodajSliku(daska, "/Daska" + engine.getDaska().getSirina() + ".png");
		glavniPanel.add(daska, 0);
		
		

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
		
		// LEVI DEO
		levaOgrada = new JPanel();
		levaOgrada.setBounds((SIRINA - 1000) / 2 - 20, 0, 20, VISINA);
		levaOgrada.setLayout(null);
		panelLevo.add(levaOgrada);
		
		JLabel l1 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/Levo.png"))
				.getImage().getScaledInstance(20, VISINA, Image.SCALE_SMOOTH)));
		l1.setOpaque(true);
		l1.setSize(20, VISINA);
		levaOgrada.add(l1);
		
		// TEKST SKOR
		JPanel skor = new JPanel();
		skor.setOpaque(false);
		skor.setBounds(SIRINA / 4 - 335, 10, 150, 50);
		panelLevo.add(skor);
		
		JLabel l3 = new JLabel(new ImageIcon(getClass().getResource("/Skor.png")));
		l3.setOpaque(false);
		l3.setSize(143, 40);
		skor.add(l3);
		
		// BROJ SKOR
		skorBrojevi = new JLabel("0");
		skorBrojevi.setOpaque(false);
		skorBrojevi.setBounds(20 + SIRINA / 4 - 335, 80, 150, 50);
		skorBrojevi.setForeground(Color.WHITE);
		skorBrojevi.setFont(new Font("Arial", Font.BOLD, 32));
		panelLevo.add(skorBrojevi);
		
		
		// DESNI DEO
		desnaOgrada = new JPanel();
		desnaOgrada.setBounds(0, 0, 20, VISINA);
		desnaOgrada.setLayout(null);
		panelDesno.add(desnaOgrada);
		
		JLabel l2 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/Desno.png"))
				.getImage().getScaledInstance(20, VISINA, Image.SCALE_SMOOTH)));
		l2.setOpaque(true);
		l2.setSize(20, VISINA);
		desnaOgrada.add(l2);
		
		// TEKST ZIVOTI
		JPanel zivoti = new JPanel();
		zivoti.setOpaque(false);
		zivoti.setBounds(20 + SIRINA / 4 - 335, 10, 150, 50);
		panelDesno.add(zivoti);
		
		JLabel l4 = new JLabel(new ImageIcon(getClass().getResource("/Zivoti.png")));
		//l4.setOpaque(false);
		l4.setSize(143, 40);
		zivoti.add(l4);
		
		// SLIKE ZIVOTI
		slikeZivota = new JPanel(null);
		slikeZivota.setOpaque(false);
		slikeZivota.setBounds(20 + SIRINA / 4 - 335, 80, 60, 400);
		panelDesno.add(slikeZivota);
		
		prikaziSlikeZivota();
		
		

	}
	
	private void prikaziSlikeZivota()
	{
		ocistiPanelIDodajSliku(slikeZivota, null);
		
		for (int i = 0; i < engine.getBrojZivota() - 1; i++)
		{
			JLabel l = new JLabel(new ImageIcon(getClass().getResource("/Zivot.png")));
			l.setBounds(10, i * 10, 20, 5);
			
			slikeZivota.add(l);
		
		}
	}
	
	private void prikaziSkor()
	{
		skorBrojevi.setText(engine.getBrojPoena() + "");
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
				engine.pomeriLopticu(7);
				prikaziSkor();

				if (engine.isKraj())
				{
					timerLoptica.stop();
					
					engine.setKraj(false);
					unistiPaneleIznenadjenja();
					
					
					osveziGuiBlokovi();
					osveziGuiIznenadjenja();
					
					
					engine.postaviPocetneVrednosti();
					prikaziSlikeZivota();
					
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
						int a = JOptionPane.showConfirmDialog(null, "Izgubili ste!\nDa li zelite novu igru?", "Kraj!", JOptionPane.YES_NO_OPTION);
						
						if (a == JOptionPane.YES_OPTION)
						{
							engine.init();
							unistiPaneleIznenadjenja();
							osveziGuiBlokovi();
							osveziGuiIznenadjenja();
							prikaziSlikeZivota();
							uzmiIznenadjenja();
							prikaziSkor();
						}
						else
							System.exit(0);
					}

				}

				if (engine.predjiNivo())
				{
					
					if (engine.isKrajIgre())
					{
						JOptionPane.showMessageDialog(null, "Presli ste igru! Cestitamo!");
						System.exit(0);
					}
					
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
					prikaziSlikeZivota();
					
					if (izn instanceof SmanjenjeZivota)
					{
						engine.postaviPocetneVrednosti();
						osveziGuiBlokovi();
						timerLoptica.stop();
						
						daska.setBounds(engine.getDaska().getX(), engine.getDaska().getY(), engine.getDaska().getSirina(),
								engine.getDaska().getVisina());
						ocistiPanelIDodajSliku(daska, "/Daska" + engine.getDaska().getSirina() + ".png");
						
						engine.getLoptica().setX(engine.getDaska().getX() + engine.getDaska().getSirina() / 2);	
						
						int x = engine.getLoptica().getX() - engine.getLoptica().getR();
						int y = engine.getLoptica().getY() - engine.getLoptica().getR();
						int precnik = engine.getLoptica().getR() * 2;

						loptica.setBounds(x, y, precnik, precnik);
						ocistiPanelIDodajSliku(loptica, engine.getLoptica().getSlika());
						
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
				if (engine.getBlok(i, j) != null)
				{
					if (engine.getBlok(i, j).getSlikaUnistenja() != null)
					{
						ocistiPanelIDodajSliku(blokovi[i][j], engine.getBlok(i, j).getSlikaUnistenja());
						engine.getBlok(i, j).setSlikaUnistenja(null);
					}
					else if (engine.getBlok(i, j).isUnisten())
						ocistiPanelIDodajSliku(blokovi[i][j], null);
					else
						ocistiPanelIDodajSliku(blokovi[i][j], engine.getBlok(i, j).getPocetnaSlika());
				}
				else ocistiPanelIDodajSliku(blokovi[i][j], null);
					
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
