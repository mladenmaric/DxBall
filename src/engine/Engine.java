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
import iznenadjenja.ProduzenjeDaske;
import iznenadjenja.SkracenjeDaske;
import iznenadjenja.SmanjenjeZivota;
import iznenadjenja.UbrzanjeLoptice;
import iznenadjenja.UsporenjeLoptice;
import loptica.Loptica;
import loptica.TipLoptice;

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
	private Iznenadjenje[] iznenadjenja;

	public Engine()
	{
		init();
	}
	
	public void postaviPocetneVrednosti()
	{
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				blokovi[i][j] = null;
		
		daska.setVisina(20);
		daska.setSirina(100);
		daska.setX(450);
		daska.setY(700);
		loptica.setX(500);
		loptica.setY(690);
		loptica.setUgaoKretanja(Math.PI/2);
		loptica.setTipLoptice(TipLoptice.NORMALNA);
		loptica.setBrzinaLoptice(15);
		loptica.setR(7);
	}

	public void init()
	{
		nivo = 1;
		brojZivota = 3;
		kraj = false;
		
		blokovi = new Blok[20][20];
		daska = new Daska();
		loptica = new Loptica();
		iznenadjenja = new Iznenadjenje[6];
		
		postaviNivo();
	}

	public void postaviNivo()
	{	
		postaviPocetneVrednosti();
		
		if (nivo == 1)
			postaviNivo1();
		else if (nivo == 2)
			postaviNivo2();
		else if (nivo == 3)
			postaviNivo3();
		else if (nivo == 4)
			postaviNivo4();
		else if (nivo == 5)
			postaviNivo5();
		else if (nivo == 6) 
			postaviNivo6();
		
		postaviIznenadjenja();
	}

	private void postaviIznenadjenja()
	{
		iznenadjenja[0] = new BonusZivot(this);
		iznenadjenja[1] = new ProduzenjeDaske(this);
		iznenadjenja[2] = new SkracenjeDaske(this);
		iznenadjenja[3] = new UbrzanjeLoptice(this);
		iznenadjenja[4] = new SmanjenjeZivota(this);
		iznenadjenja[5] = new UsporenjeLoptice(this);

		Random r = new Random();
		int br = 0;

		while (br < 6)
		{
			int i = r.nextInt(20);
			int j = r.nextInt(20);

			if (blokovi[i][j] != null && blokovi[i][j].getIznenadjenje() == null
					&& !(blokovi[i][j] instanceof NeprobojniBlok))
			{
				blokovi[i][j].setIznenadjenje(iznenadjenja[br]);
				iznenadjenja[br].setX(blokovi[i][j].getX());
				iznenadjenja[br].setY(blokovi[i][j].getY());
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
				else if (i == 14 && j >= 5 && j <= 14) 
					blokovi[i][j] = new NormalanBlok(i, j, "/TAMNOLJUBICASTA.png");
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
				else if (i == 18 && (j == 9 || j == 10))
					blokovi[i][j] = new EksplozivanBlok(i, j);
			}
	}

	private void postaviNivo3()
	{
		
	}

	private void postaviNivo4()
	{

	}

	private void postaviNivo5()
	{

	}

	private void postaviNivo6()
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

	private void unistiBlok(int i, int j)
	{
		if (!(blokovi[i][j] instanceof NeprobojniBlok))
			blokovi[i][j].unistiSe(blokovi);		
	}

//	public void odbijLopticuOdBloka()
//	{
//		boolean flag = false;
//
//		for (int i = 0; i < 20; i++)
//		{
//			for (int j = 0; j < 20; j++)
//			{
//				if (blokovi[i][j] != null && !blokovi[i][j].isUnisten())
//				{
//					if (loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
//							&& loptica.getX() >= blokovi[i][j].getX() + blokovi[i][j].getSirina()
//							&& loptica.getY() >= blokovi[i][j].getY() - loptica.getR()
//							&& loptica.getY() <= blokovi[i][j].getY() + blokovi[i][j].getVisina() + loptica.getR())
//					{
//						if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= 3 * Math.PI / 2)
//						{
//							if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
//								loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
//							else
//								loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());
//
//							unistiBlok(i, j);
//							flag = true;
//							break;
//						}
//					}
//					else if (loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
//							&& loptica.getX() <= blokovi[i][j].getX()
//							&& loptica.getY() >= blokovi[i][j].getY() - loptica.getR()
//							&& loptica.getY() <= blokovi[i][j].getY() + blokovi[i][j].getVisina() + loptica.getR())
//					{
//						if ((loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI / 2)
//								|| (loptica.getUgaoKretanja() >= 3 * Math.PI / 2
//										&& loptica.getUgaoKretanja() <= 2 * Math.PI))
//						{
//							if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI / 2)
//								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
//							else
//								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
//
//							unistiBlok(i, j);
//							flag = true;
//							break;
//						}
//					}
//					else if (loptica.getY() + loptica.getR() >= blokovi[i][j].getY()
//							&& loptica.getY() <= blokovi[i][j].getY()
//							&& loptica.getX() >= blokovi[i][j].getX() - loptica.getR()
//							&& loptica.getX() <= blokovi[i][j].getX() + blokovi[i][j].getSirina() + loptica.getR())
//					{
//						if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 2 * Math.PI)
//						{
//							if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 3 * Math.PI / 2)
//								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
//							else
//								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
//
//							unistiBlok(i, j);
//							flag = true;
//							break;
//						}
//					}
//					else if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
//							&& loptica.getY() >= blokovi[i][j].getY() + blokovi[i][j].getVisina()
//							&& loptica.getX() >= blokovi[i][j].getX() - loptica.getR()
//							&& loptica.getX() <= blokovi[i][j].getX() + blokovi[i][j].getSirina() + loptica.getR())
//					{
//						if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI)
//						{
//							if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
//								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
//							else
//								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
//
//							unistiBlok(i, j);
//							flag = true;
//							break;
//						}
//					}
//				}
//			}
//			if (flag) break;
//		}
//	}
	
	public void odbijLopticuOdBloka()
    {
        boolean flag=false;
       
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(blokovi[i][j]!=null && !blokovi[i][j].isUnisten())
                {
                    if(loptica.getUgaoKretanja()>=0 && loptica.getUgaoKretanja()<=Math.PI/2)
                    {
                        if(loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina()
                            && loptica.getX()+loptica.getR()>=blokovi[i][j].getX()
                            && loptica.getX()-loptica.getR()<=blokovi[i][j].getX()
                            && loptica.getY()+loptica.getR()>=blokovi[i][j].getY()+blokovi[i][j].getVisina())
                        {
                            if(blokovi[i][j].getX()-loptica.getX()>=loptica.getY()-blokovi[i][j].getY()-blokovi[i][j].getVisina())
                                loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
                            else
                                loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getX()>=blokovi[i][j].getX() &&
                                loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina() &&
                                loptica.getY()+loptica.getR()>=blokovi[i][j].getY()+blokovi[i][j].getVisina())
                        {
                            loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina() &&
                                loptica.getX()+loptica.getR()>=blokovi[i][j].getX() &&
                                loptica.getX()-loptica.getR()<=blokovi[i][j].getX() &&
                                loptica.getY()+loptica.getR()>=blokovi[i][j].getY())
                        {
                            loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                           
                    }
                    else if(loptica.getUgaoKretanja()>=Math.PI/2 && loptica.getUgaoKretanja()<=Math.PI)
                    {
                        if(loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina()
                                && loptica.getX()+loptica.getR()>=blokovi[i][j].getX()+blokovi[i][j].getSirina()
                                && loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina()
                                && loptica.getY()+loptica.getR()>=blokovi[i][j].getY()+blokovi[i][j].getVisina())
                        {
                            if(loptica.getX()-blokovi[i][j].getX()-blokovi[i][j].getSirina()>=loptica.getY()-blokovi[i][j].getY()-blokovi[i][j].getVisina())
                                loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
                            else
                                loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getX()+loptica.getR()>=blokovi[i][j].getX() &&
                                loptica.getX()+loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina() &&
                                loptica.getY()+loptica.getR()>=blokovi[i][j].getY()+blokovi[i][j].getVisina())
                        {
                            loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina() &&
                                loptica.getX()+loptica.getR()>=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getY()+loptica.getR()>=blokovi[i][j].getY())
                        {
                            loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                    }
                    else if(loptica.getUgaoKretanja()>=Math.PI && loptica.getUgaoKretanja()<=3*Math.PI/2)
                    {
                        if(loptica.getY()-loptica.getR()<=blokovi[i][j].getY()
                                && loptica.getX()+loptica.getR()>=blokovi[i][j].getX()+blokovi[i][j].getSirina()
                                && loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina()
                                && loptica.getY()+loptica.getR()>=blokovi[i][j].getY())
                        {
                            if(loptica.getX()-blokovi[i][j].getX()+blokovi[i][j].getSirina()>=loptica.getY()-blokovi[i][j].getY())
                                loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            else
                                loptica.setUgaoKretanja(3*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getX()+loptica.getR()>=blokovi[i][j].getX() &&
                                loptica.getX()+loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getY()-loptica.getR()<=blokovi[i][j].getY()&&
                                loptica.getY()+loptica.getR()>=blokovi[i][j].getY())
                        {
                            loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getY()-loptica.getR()>=blokovi[i][j].getY()&&
                                loptica.getX()+loptica.getR()>=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina())
                        {
                            loptica.setUgaoKretanja(3*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                    }
                    else if(loptica.getUgaoKretanja()>=3*Math.PI/2 && loptica.getUgaoKretanja()<=2*Math.PI)
                    {
                        if(loptica.getY()-loptica.getR()<=blokovi[i][j].getY()
                                && loptica.getX()+loptica.getR()>=blokovi[i][j].getX()
                                && loptica.getX()-loptica.getR()<=blokovi[i][j].getX()
                                && loptica.getY()+loptica.getR()>=blokovi[i][j].getY())
                        {
                            if(loptica.getX()-blokovi[i][j].getX()>=loptica.getY()-blokovi[i][j].getY())
                                loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            else
                                loptica.setUgaoKretanja(3*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getX()-loptica.getR()>=blokovi[i][j].getX() &&
                                loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() &&
                                loptica.getY()-loptica.getR()<=blokovi[i][j].getY()&&
                                loptica.getY()+loptica.getR()>=blokovi[i][j].getY())
                        {
                            loptica.setUgaoKretanja(2*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                        else if(loptica.getY()-loptica.getR()>=blokovi[i][j].getY()&&
                                loptica.getX()+loptica.getR()>=blokovi[i][j].getX()&&
                                loptica.getX()-loptica.getR()<=blokovi[i][j].getX()&&
                                loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina())
                        {
                            loptica.setUgaoKretanja(3*Math.PI - loptica.getUgaoKretanja());
                            unistiBlok(i, j);
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(flag) break;
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

	public boolean prihvatiIznenadjenje()
	{
		for (int i = 0; i < iznenadjenja.length; i++)
			if (iznenadjenja[i] != null && iznenadjenja[i].isVidljivo())
			{
				if (iznenadjenja[i].getY() <= daska.getY()
						&& iznenadjenja[i].getY() + iznenadjenja[i].getVisina() >= daska.getY()
						&& iznenadjenja[i].getX() + iznenadjenja[i].getSirina() >= daska.getX()
						&& iznenadjenja[i].getX() <= daska.getX() + daska.getSirina())
				{
					boolean flag = false;
					
					if (iznenadjenja[i] instanceof ProduzenjeDaske || iznenadjenja[i] instanceof SkracenjeDaske)
						flag = true;
					
					iznenadjenja[i].primeniIznenadjenje();
					iznenadjenja[i] = null;
					if (flag) return true;
				}
			}
		
		return false;
	}

	public void predjiNivo()
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
	} 

	public boolean isKraj()
	{
		if (brojZivota == 0)
			kraj = true;
		
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

	public Iznenadjenje[] getIznenadjenja()
	{
		return iznenadjenja;
	}

}