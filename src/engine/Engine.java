package engine;

import java.util.Random;

import blok.Blok;
import blok.EksplozivanBlok;
import blok.NeprobojniBlok;
import blok.NormalanBlok;
import blok.OkovaniBlok;
import daska.Daska;
import iznenadjenja.BonusZivot;
import iznenadjenja.Iznenadjenje;
import iznenadjenja.ProbojnostLoptice;
import iznenadjenja.ProduzenjeDaske;
import iznenadjenja.SkracenjeDaske;
import iznenadjenja.SmanjenjeZivota;
import iznenadjenja.UbrzanjeLoptice;
import iznenadjenja.UsporenjeLoptice;
import iznenadjenja.VatrenostLoptice;
import loptica.Loptica;
import loptica.NormalnaLoptica;
import loptica.ProbijajucaLoptica;

public class Engine
{
	private Blok[][] blokovi;
	private Daska daska;
	private Loptica loptica;
	private static final int maxSirina = 1000;
	private static final int maxVisina = 741;
	private static final int minSirina = 0;
	private static final int minVisina = 0;
	private boolean kraj;
	private int nivo;
	private int brojZivota;
	private boolean pomeranjeLopticeSaDaskom;

	public Engine()
	{
		init();
	}

	public void init()
	{
		nivo = 1;
		brojZivota = 3;
		kraj = false;

		blokovi = new Blok[20][20];
		daska = new Daska();

		postaviNivo();
	}

	public void postaviNivo()
	{
		postaviPocetneVrednosti();

		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				blokovi[i][j] = null;

		if (nivo == 1)
			postaviNivo1();
		else if (nivo == 2)
			postaviNivo2();
		else if (nivo == 3)
			postaviNivo3();
		else if (nivo == 4)
			postaviNivo4();
		else if (nivo == 5) postaviNivo5();

		postaviIznenadjenja();
	}

	public void postaviPocetneVrednosti()
	{
		daska.setVisina(20);
		daska.setSirina(100);
		daska.setX(450);
		daska.setY(700);

		int r = 7;
		int x = daska.getX() + daska.getSirina() / 2;
		int y = daska.getY() - r;

		loptica = new NormalnaLoptica(x, y, 7, Math.PI / 2, 15);

		pomeranjeLopticeSaDaskom = true;
	}

	private void postaviIznenadjenja()
	{
		Random r = new Random();
		int br = 0;

		while (br < nivo + 3)
		{
			int i = r.nextInt(20);
			int j = r.nextInt(20);
			int br2 = r.nextInt(8);

			if (blokovi[i][j] != null && blokovi[i][j].getIznenadjenje() == null
					&& !(blokovi[i][j] instanceof NeprobojniBlok))
			{
				switch (br2)
				{
				case 0:
					blokovi[i][j].setIznenadjenje(new BonusZivot(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 1:
					blokovi[i][j].setIznenadjenje(new ProbojnostLoptice(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 2:
					blokovi[i][j].setIznenadjenje(new ProduzenjeDaske(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 3:
					blokovi[i][j].setIznenadjenje(new SkracenjeDaske(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 4:
					blokovi[i][j].setIznenadjenje(new SmanjenjeZivota(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 5:
					blokovi[i][j].setIznenadjenje(new UbrzanjeLoptice(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 6:
					blokovi[i][j].setIznenadjenje(new UsporenjeLoptice(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				case 7:
					blokovi[i][j].setIznenadjenje(new VatrenostLoptice(this));
					blokovi[i][j].getIznenadjenje().setX(blokovi[i][j].getX());
					blokovi[i][j].getIznenadjenje().setY(blokovi[i][j].getY());
					break;

				default:
					break;
				}

				br++;
			}
		}

	}

	private void postaviNivo1()
	{
		for (int i = 5; i < 15; i++)
			for (int j = 0; j < 20; j++)
			{
				if (i == 5 && j >= 5 && j <= 14)
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 6 && j >= 2 && j <= 17)
					blokovi[i][j] = new NormalanBlok(i, j, "/ROZE.png");
				else if (i == 7 && j >= 1 && j <= 18)
					blokovi[i][j] = new NormalanBlok(i, j, "/LJUBICASTA.png");
				else if (i == 8)
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 9)
					blokovi[i][j] = new NormalanBlok(i, j, "/LJUBICASTA.png");
				else if (i == 10)
					blokovi[i][j] = new NormalanBlok(i, j, "/ROZE.png");
				else if (i == 11)
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 12 && j >= 1 && j <= 18)
					blokovi[i][j] = new NormalanBlok(i, j, "/ROZE.png");
				else if (i == 13 && j >= 2 && j <= 17)
					blokovi[i][j] = new NormalanBlok(i, j, "/LJUBICASTA.png");
				else if (i == 14 && j >= 5 && j <= 14) blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
			}

		for (int i = 0; i < 3; i++)
			blokovi[i + 6][2 - i] = new EksplozivanBlok(i + 6, 2 - i);

		for (int i = 0; i < 7; i++)
			blokovi[i + 5][7 - i] = new EksplozivanBlok(i + 5, 7 - i);

		for (int i = 0; i < 9; i++)
			blokovi[i + 5][11 - i] = new EksplozivanBlok(i + 5, 11 - i);

		for (int i = 0; i < 9; i++)
			blokovi[i + 6][14 - i] = new EksplozivanBlok(i + 6, 14 - i);

		for (int i = 0; i < 8; i++)
			blokovi[i + 7][17 - i] = new EksplozivanBlok(i + 7, 17 - i);

		for (int i = 0; i < 6; i++)
			blokovi[i + 9][19 - i] = new EksplozivanBlok(i + 9, 19 - i);
	}

	private void postaviNivo2()
	{
		for (int i = 2; i < 19; i++)
			for (int j = 0; j < 20; j++)
			{
				if (i == 2 && (j == 4 || j == 5 || j == 14 || j == 15))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 3 && (j == 2 || j == 6 || j == 13 || j == 17))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 3 && (j == 3 || j == 16))
					blokovi[i][j] = new OkovaniBlok(i, j);
				else if (i == 4 && (j == 1 || j == 7 || j == 12 || j == 18))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 4 && (j == 2 || j == 4 || j == 5 || j == 17 || j == 15 || j == 14))
					blokovi[i][j] = new OkovaniBlok(i, j);
				else if (i == 4 && (j == 3 || j == 16))
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 5 && (j == 0 || j == 19))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 5 && (j == 6 || j == 13))
					blokovi[i][j] = new OkovaniBlok(i, j);
				else if (i == 5 && j != 7 && j != 12)
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 6 && (j == 5 || j == 14))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 6 && (j == 6 || j == 13))
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 6 && (j == 7 || j == 12))
					blokovi[i][j] = new OkovaniBlok(i, j);
				else if (i == 6 && j != 8 && j != 11)
					blokovi[i][j] = new NormalanBlok(i, j, "/PLAVA.png");
				else if (i == 7 && (j == 5 || j == 14))
					blokovi[i][j] = new NormalanBlok(i, j, "/PLAVA.png");
				else if (i == 7 && (j == 6 || j == 13))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 7 && (j == 7 || j == 12))
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 7 && (j == 8 || j == 11))
					blokovi[i][j] = new OkovaniBlok(i, j);
				else if (i == 7 && j != 9 && j != 10)
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 8 && (j == 0 || j == 1 || j == 18 || j == 19))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 8 && (j == 2 || j == 3 || j == 7 || j == 12 || j == 16 || j == 17))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 8 && (j == 4 || j == 5 || j == 14 || j == 15))
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 8 && (j == 6 || j == 13))
					blokovi[i][j] = new NormalanBlok(i, j, "/PLAVA.png");
				else if (i == 8 && (j == 8 || j == 11))
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 8 && (j == 9 || j == 10))
					blokovi[i][j] = new OkovaniBlok(i, j);
				else if (i == 9 && (j == 0 || j == 4 || j == 8 || j == 11 || j == 15 || j == 19))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 9 && (j == 1 || j == 18))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 9 && (j == 2 || j == 3 || j == 16 || j == 17))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 9 && (j == 5 || j == 6 || j == 13 || j == 14))
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 9 && (j == 7 || j == 12))
					blokovi[i][j] = new NormalanBlok(i, j, "/PLAVA.png");
				else if (i == 9 && (j == 9 || j == 10))
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
				else if (i == 10 && (j == 0 || j == 19))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 10 && (j == 1 || j == 5 || j == 9 || j == 10 || j == 14 || j == 18))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 10 && (j == 2 || j == 3 || j == 16 || j == 17))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 10 && (j == 4 || j == 15))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 10 && (j == 6 || j == 7 || j == 12 || j == 13))
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 10 && (j == 8 || j == 11))
					blokovi[i][j] = new NormalanBlok(i, j, "/PLAVA.png");
				else if (i == 11 && (j == 1 || j == 18))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 11 && (j == 2 || j == 6 || j == 13 || j == 17))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 11 && (j == 3 || j == 4 || j == 15 || j == 16))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 11 && (j == 5 || j == 14))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 11 && (j == 7 || j == 8 || j == 11 || j == 12))
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 11 && (j == 9 || j == 10))
					blokovi[i][j] = new NormalanBlok(i, j, "/PLAVA.png");
				else if (i == 12 && (j == 2 || j == 17))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 12 && (j == 3 || j == 7 || j == 12 || j == 16))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 12 && (j == 4 || j == 5 || j == 14 || j == 15))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 12 && (j == 6 || j == 13))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 12 && (j == 8 || j == 9 || j == 10 || j == 11))
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 13 && (j == 3 || j == 16))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 13 && (j == 4 || j == 8 || j == 11 || j == 15))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 13 && (j == 5 || j == 6 || j == 13 || j == 14))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 13 && (j == 7 || j == 12))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 13 && (j == 9 || j == 10))
					blokovi[i][j] = new NormalanBlok(i, j, "/ZELENA.png");
				else if (i == 14 && (j == 4 || j == 15))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 14 && (j == 5 || j == 9 || j == 10 || j == 14))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 14 && (j == 6 || j == 7 || j == 12 || j == 13))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 14 && (j == 8 || j == 11))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 15 && (j == 5 || j == 14))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 15 && (j == 6 || j == 13))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 15 && (j == 7 || j == 8 || j == 11 || j == 12))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 15 && (j == 9 || j == 10))
					blokovi[i][j] = new NeprobojniBlok(i, j);
				else if (i == 16 && (j == 6 || j == 13))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 16 && (j == 7 || j == 12))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 16 && (j == 8 || j == 9 || j == 10 || j == 11))
					blokovi[i][j] = new NormalanBlok(i, j, "/NARANDZASTA.png");
				else if (i == 17 && (j == 7 || j == 12 || j == 9 || j == 10))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 17 && (j == 8 || j == 11))
					blokovi[i][j] = new EksplozivanBlok(i, j);
				else if (i == 18 && (j == 8 || j == 11))
					blokovi[i][j] = new NormalanBlok(i, j, "/CRVENA.png");
				else if (i == 18 && (j == 9 || j == 10)) blokovi[i][j] = new EksplozivanBlok(i, j);
			}
	}

	private void postaviNivo3()
	{
		for(int j=4;j<16;j++)
		{
			blokovi[3][j]=new NormalanBlok(3, j, "/ROZE.png");
			blokovi[15][j]=new NormalanBlok(15, j, "/ROZE.png");
			blokovi[5][j]=new NormalanBlok(5, j, "/LJUBICASTA.png");
			blokovi[9][j]=new NormalanBlok(9, j, "/LJUBICASTA.png");
			blokovi[13][j]=new NormalanBlok(13, j, "/LJUBICASTA.png");
			blokovi[6][j]=new NormalanBlok(6, j, "/CRNA.png");
			blokovi[12][j]=new NormalanBlok(12, j, "/CRNA.png");
			blokovi[7][j]=new NormalanBlok(7, j, "/PLAVA.png");
			blokovi[11][j]=new NormalanBlok(11, j, "/PLAVA.png");
		}
		
		for(int i=0;i<3;i++)
		{
			blokovi[i+3][3-i]= new NormalanBlok(i+3, 3-i, "/PLAVA.png");
			blokovi[i+3][16+i]= new NormalanBlok(i+3, 16+i, "/PLAVA.png");
			blokovi[i+13][i+1]= new NormalanBlok(i+13,i+1, "/PLAVA.png");
			blokovi[15-i][16+i]= new NormalanBlok(15-i, 16+i, "/PLAVA.png");
			
			blokovi[i+4][3-i]=new NormalanBlok(i+4,3-i , "/ROZE.png");
			blokovi[i+4][16+i]=new NormalanBlok(i+4,16+i , "/ROZE.png");
			blokovi[i+12][i+1]=new NormalanBlok(i+12,i+1 , "/ROZE.png");
			blokovi[14-i][16+i]=new NormalanBlok(14-i,16+i , "/ROZE.png");
			
			blokovi[i+6][3-i]=new NormalanBlok(i+6,3-i , "/LJUBICASTA.png");
			blokovi[i+6][16+i]=new NormalanBlok(i+6,16+i , "/LJUBICASTA.png");
			blokovi[i+10][i+1]=new NormalanBlok(i+10,i+1 , "/LJUBICASTA.png");
			blokovi[12-i][16+i]=new NormalanBlok(12-i,16+i , "/LJUBICASTA.png");
		}
		
		blokovi[9][2]=new NormalanBlok(9, 2, "/LJUBICASTA.png");
		blokovi[9][17]=new NormalanBlok(9, 17, "/LJUBICASTA.png");
		
		blokovi[7][3]=new NormalanBlok(7,13 , "/PLAVA.png");
		blokovi[7][16]=new NormalanBlok(7,16 , "/PLAVA.png");
		blokovi[11][3]=new NormalanBlok(11,3 , "/PLAVA.png");
		blokovi[11][16]=new NormalanBlok(11,16 , "/PLAVA.png");
		blokovi[8][3]=new NormalanBlok(8,3 , "/CRNA.png");
		blokovi[8][16]=new NormalanBlok(8,16 , "/CRNA.png");
		blokovi[10][3]=new NormalanBlok(10,3 , "/CRNA.png");
		blokovi[10][16]=new NormalanBlok(10,16 , "/CRNA.png");
		blokovi[9][3]=new NormalanBlok(9,3 , "/LJUBICASTA.png");
		blokovi[9][16]=new NormalanBlok(9,16 , "/LJUBICASTA.png");
	}

	private void postaviNivo4()
	{
		for(int i=2;i<7;i++)
		{
			blokovi[i][2]=new NormalanBlok(i,2, "/SVETLOPLAVA.png");
			blokovi[i][17]=new NormalanBlok(i,17, "/SVETLOPLAVA.png");
			blokovi[i+11][2]=new NormalanBlok(i+11,17, "/ROZE.png");
			blokovi[i+11][17]=new NormalanBlok(i+11,17, "/ROZE.png");
		}
		
		for(int j=3;j<7;j++)
		{
			blokovi[8][j]=new NormalanBlok(8,j, "/SVETLOPLAVA.png");
			blokovi[8][j+10]=new NormalanBlok(8,j+10, "/SVETLOPLAVA.png");
			blokovi[13][j]=new NormalanBlok(13,j, "/ROZE.png");
			blokovi[13][j+10]=new NormalanBlok(13,j+10, "/ROZE.png");
		}
		
		for(int i=2;i<7;i++)
			for(int j=8;j<12;j++)
			{
				blokovi[i][j]=new NormalanBlok(i, j, "/LJUBICASTA.png");
				blokovi[i+7][j]=new NormalanBlok(i, j, "/LJUBICASTA.png");
			}
		
		for(int i=0;i<3;i++)
		{
			blokovi[i+4][7]=new NormalanBlok(i, 7, "/LJUBICASTA.png");
			blokovi[i+4][12]=new NormalanBlok(i, 12, "/LJUBICASTA.png");
			blokovi[i+15][7]=new NormalanBlok(i, 7, "/LJUBICASTA.png");
			blokovi[i+15][12]=new NormalanBlok(i, 12, "/LJUBICASTA.png");
		}
		
		blokovi[5][6]=new NormalanBlok(5, 6, "/LJUBICASTA.png");
		blokovi[5][13]=new NormalanBlok(5, 13, "/LJUBICASTA.png");
		blokovi[16][6]=new NormalanBlok(16, 6, "/LJUBICASTA.png");
		blokovi[16][13]=new NormalanBlok(16, 13, "/LJUBICASTA.png");
		
		for(int i=0;i<4;i++)
		{
			blokovi[i+8][2]=new EksplozivanBlok(i+8, 2);
			blokovi[i+8][17]=new EksplozivanBlok(i+8, 2);
		}
		
		for(int i=9;i<11;i++)
			for(int j=3;j<7;j++)
			{
				blokovi[i][j]=new EksplozivanBlok(i, j);
				blokovi[i][j+10]=new EksplozivanBlok(i, j+10);
			}
		
		for(int j=8;j<14;j++)
		{
			blokovi[7][j]=new NormalanBlok(7, j, "/SVETLOZELENA.png");
			blokovi[12][j]=new NormalanBlok(12, j, "/SVETLOZELENA.png");
		}
		
		for(int i=8;i<12;i++)
		{
			blokovi[i][8]=new NormalanBlok(i, 8, "/SVETLOZELENA.png");
			blokovi[i][13]=new NormalanBlok(i, 13, "/SVETLOZELENA.png");
		}
		
		for(int j=9;j<13;j++)
			blokovi[8][j]=new NormalanBlok(8, j, "/PLAVA.png");
		
		blokovi[9][9]=new NormalanBlok(9, 9, "/PLAVA.png");
		blokovi[9][12]=new NormalanBlok(9, 12, "/PLAVA.png");
		blokovi[12][9]=new NormalanBlok(12, 9, "/PLAVA.png");
		blokovi[12][12]=new NormalanBlok(12, 12, "/PLAVA.png");
		
		blokovi[9][10]=new OkovaniBlok(9, 10);
		blokovi[9][11]=new OkovaniBlok(9, 11);
		blokovi[10][9]=new OkovaniBlok(10, 9);
		blokovi[10][12]=new OkovaniBlok(10, 12);
		blokovi[11][10]=new OkovaniBlok(11, 10);
		blokovi[11][11]=new OkovaniBlok(11, 11);
		
		blokovi[10][10]=new NeprobojniBlok(10, 10);
		blokovi[10][11]=new NeprobojniBlok(10, 11);
	}

	private void postaviNivo5()
	{

	}

	public void odbijLopticuOdZida()
	{
		if (loptica.getX() - loptica.getR() <= minSirina)
		{
			if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
				loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
			else
				loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());

		}
		else if (loptica.getX() + loptica.getR() >= maxSirina)
		{
			if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI / 2)
				loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
			else
				loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());
		}
		else if (loptica.getY() + loptica.getR() >= maxVisina)
		{
			brojZivota--;
			kraj = true;
		}
		else if (loptica.getY() - loptica.getR() <= minVisina)
		{
			if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI)
			{
				loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
				loptica.setY(minVisina + 1);
			}

		}
	}

	public void odbijLopticuOdDaske()
	{
		if (loptica.getY() + loptica.getR() >= daska.getY() && loptica.getY() <= daska.getY()
				&& loptica.getX() >= daska.getX() && loptica.getX() <= daska.getX() + daska.getSirina())
		{
			if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 2 * Math.PI)
			{
				double p = loptica.getX() - daska.getX() - daska.getSirina() / 2;
				loptica.setUgaoKretanja(Math.PI / 2 - (p / 37) * 100 / daska.getSirina());
			}
		}
	}

	public void odbijLopticuOdBloka()
	{
		boolean flag = false;

		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (blokovi[i][j] != null && !blokovi[i][j].isUnisten())
				{
					if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI / 2)
					{
						if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY() + blokovi[i][j].getVisina())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
							{
								if (blokovi[i][j].getX() - loptica.getX() >= loptica.getY() - blokovi[i][j].getY()
										- blokovi[i][j].getVisina())
									loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
								else
									loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
							}

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getX() >= blokovi[i][j].getX()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY() + blokovi[i][j].getVisina())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}

					}
					else if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
					{
						if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY() + blokovi[i][j].getVisina())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
							{
								if (loptica.getX() - blokovi[i][j].getX() - blokovi[i][j].getSirina() >= loptica.getY()
										- blokovi[i][j].getY() - blokovi[i][j].getVisina())
									loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
								else
									loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
							}

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() + loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY() + blokovi[i][j].getVisina())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
					}
					else if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 3 * Math.PI / 2)
					{
						if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
							{
								if (loptica.getX() - blokovi[i][j].getX()
										- blokovi[i][j].getSirina() >= blokovi[i][j].getY() - loptica.getY())
									loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
								else
									loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());
							}

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() + loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() - loptica.getR() <= blokovi[i][j].getY()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getY() - loptica.getR() >= blokovi[i][j].getY()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
					}
					else if (loptica.getUgaoKretanja() >= 3 * Math.PI / 2 && loptica.getUgaoKretanja() <= 2 * Math.PI)
					{
						if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
							{
								if (loptica.getX() - blokovi[i][j].getX() >= loptica.getY() - blokovi[i][j].getY())
									loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
								else
									loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());
							}

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getX() - loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
								&& loptica.getY() - loptica.getR() <= blokovi[i][j].getY()
								&& loptica.getY() + loptica.getR() >= blokovi[i][j].getY())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
						else if (loptica.getY() - loptica.getR() >= blokovi[i][j].getY()
								&& loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
								&& loptica.getX() - loptica.getR() <= blokovi[i][j].getX()
								&& loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina())
						{
							if (!(loptica instanceof ProbijajucaLoptica))
								loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());

							loptica.unistiPolje(i, j, blokovi);
							flag = true;
							break;
						}
					}
				}
			}
			if (flag) break;
		}
	}

	public void pomeriLopticu(double duzina)
	{
		int x = (int) Math.round((Math.cos(loptica.getUgaoKretanja()) * duzina));
		int y = (int) Math.round((Math.sin(loptica.getUgaoKretanja()) * duzina));

		loptica.setY(loptica.getY() - y);
		loptica.setX(loptica.getX() + x);

		odbijLopticuOdDaske();
		odbijLopticuOdBloka();
		odbijLopticuOdZida();
	}

	public Iznenadjenje prihvatiIznenadjenje()
	{
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (blokovi[i][j] != null && blokovi[i][j].getIznenadjenje() != null
						&& blokovi[i][j].getIznenadjenje().isVidljivo())
				{
					if (blokovi[i][j].getIznenadjenje().getY() <= daska.getY()
							&& blokovi[i][j].getIznenadjenje().getY()
									+ blokovi[i][j].getIznenadjenje().getVisina() >= daska.getY()
							&& blokovi[i][j].getIznenadjenje().getX()
									+ blokovi[i][j].getIznenadjenje().getSirina() >= daska.getX()
							&& blokovi[i][j].getIznenadjenje().getX() <= daska.getX() + daska.getSirina())
					{
						Iznenadjenje izn = blokovi[i][j].getIznenadjenje();
						blokovi[i][j].getIznenadjenje().primeniIznenadjenje();
						blokovi[i][j].getIznenadjenje().setVidljivo(false);
						blokovi[i][j].setIznenadjenje(null);

						return izn;
					}
				}

		return null;
	}

	public boolean predjiNivo()
	{
		boolean flag = true;

		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (blokovi[i][j] != null && !blokovi[i][j].isUnisten() && !(blokovi[i][j] instanceof NeprobojniBlok))
					flag = false;

		if (flag)
		{
			nivo++;
			postaviNivo();
		}

		return flag;
	}

	public boolean isKraj()
	{
		return kraj;
	}

	public void setKraj(boolean kraj)
	{
		this.kraj = kraj;
	}

	public Daska getDaska()
	{
		return daska;
	}

	public void setDaska(Daska daska)
	{
		this.daska = daska;
	}

	public Loptica getLoptica()
	{
		return loptica;
	}

	public void setLoptica(Loptica loptica)
	{
		this.loptica = loptica;
	}

	public Blok getBlok(int i, int j)
	{
		return blokovi[i][j];
	}

	public void setBlok(int i, int j, Blok blok)
	{
		blokovi[i][j] = blok;
	}

	public int getNivo()
	{
		return nivo;
	}

	public void setNivo(int nivo)
	{
		this.nivo = nivo;
	}

	public int getBrojZivota()
	{
		return brojZivota;
	}

	public void setBrojZivota(int brojZivota)
	{
		this.brojZivota = brojZivota;
	}

	public boolean isPomeranjeLopticeSaDaskom()
	{
		return pomeranjeLopticeSaDaskom;
	}

	public void setPomeranjeLopticeSaDaskom(boolean pomeranjeLopticeSaDaskom)
	{
		this.pomeranjeLopticeSaDaskom = pomeranjeLopticeSaDaskom;
	}

	public static int getMaxsirina()
	{
		return maxSirina;
	}

	public static int getMaxvisina()
	{
		return maxVisina;
	}

	public static int getMinsirina()
	{
		return minSirina;
	}

	public static int getMinvisina()
	{
		return minVisina;
	}
}