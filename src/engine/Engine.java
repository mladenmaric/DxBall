package engine;

import blok.Blok;
import blok.BojaBloka;
import blok.EksplozivanBlok;
import blok.NormalanBlok;
import daska.Daska;
import loptica.Loptica;
import loptica.TipLoptice;

public class Engine
{
	private Blok[][] blokovi;
	private Daska daska;
	private Loptica loptica;
	private int maxSirina = 1183;
	private int maxDuzina = 750;
	private int minSirina = 183;
	private int minDuzina = 0;
	private boolean kraj;
	private int nivo;
	private int brojZivota;

	public Engine()
	{
		init();
	}

	private void init()
	{
		blokovi = new Blok[20][20];
		daska = new Daska(100, 650, 100, 20);
		loptica = new Loptica(510, 510, 10, Math.PI / 3, TipLoptice.NORMALNA, 10);
		kraj = false;
		nivo++;
		brojZivota=3;

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
	}

	private void postaviNivo1()
	{
		for (int i = 5; i < 15; i++)
			for (int j = 0; j < 20; j++)
			{
				if (i == 5 && j >= 5 && j <= 14)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.CRVENA, "/CRVENA.png");
				else if (i == 6 && j >= 2 && j <= 17)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.ROZE, "/ROZE.png");
				else if (i == 7 && j >= 1 && j <= 18)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.LJUBICASTA,
							"/LJUBICASTA.png");
				else if (i == 8)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.TAMNOLJUBICASTA,
							"/TAMNOLJUBICASTA.png");
				else if (i == 9)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.LJUBICASTA,
							"/LJUBICASTA.png");
				else if (i == 10)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.ROZE, "/ROZE.png");
				else if (i == 11)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.CRVENA, "/CRVENA.png");
				else if (i == 12 && j >= 1 && j <= 18)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.ROZE, "/ROZE.png");
				else if (i == 13 && j >= 2 && j <= 17)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.LJUBICASTA,
							"/LJUBICASTA.png");
				else if (i == 14 && j >= 5 && j <= 14)
					blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30, BojaBloka.TAMNOLJUBICASTA,
							"/TAMNOLJUBICASTA.png");
			}

		for (int i = 0; i < 3; i++)
			blokovi[i + 6][2 - i] = new EksplozivanBlok(183 + 50 * (2 - i), 30 * (i + 6), 50, 30, BojaBloka.ZUTA,
					"/ZUTA.png");

		for (int i = 0; i < 7; i++)
			blokovi[i + 5][7 - i] = new EksplozivanBlok(183 + 50 * (7 - i), 30 * (i + 5), 50, 30, BojaBloka.ZUTA,
					"/ZUTA.png");

		for (int i = 0; i < 9; i++)
			blokovi[i + 5][11 - i] = new EksplozivanBlok(183 + 50 * (11 - i), 30 * (i + 5), 50, 30, BojaBloka.ZUTA,
					"/ZUTA.png");

		for (int i = 0; i < 9; i++)
			blokovi[i + 6][14 - i] = new EksplozivanBlok(183 + 50 * (14 - i), 30 * (i + 6), 50, 30, BojaBloka.ZUTA,
					"/ZUTA.png");

		for (int i = 0; i < 8; i++)
			blokovi[i + 7][17 - i] = new EksplozivanBlok(183 + 50 * (17 - i), 30 * (i + 7), 50, 30, BojaBloka.ZUTA,
					"/ZUTA.png");

		for (int i = 0; i < 6; i++)
			blokovi[i + 9][19 - i] = new EksplozivanBlok(183 + 50 * (19 - i), 30 * (i + 9), 50, 30, BojaBloka.ZUTA,
					"/ZUTA.png");
	}

	private void postaviNivo2()
	{
		// for(int i=2;i<19;i++)
		// for(int j=0;j<20;j++)
		// {
		// if(i==2 && (j==4 || j==5 || j==14 || j==15)
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==3 && (j==2 || j==6 || j==13 || j==17)
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==3 && (j==3 || j==16))
		// blokovi[i][j]//ljubicasti okovani
		// else if(i==4 && (j==1 || j==7 || j==12 || j==18))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==4 && (j==2 || j==4 || j==5 || j==17 || j==15 || j==14))
		// blokovi[i][j]//ljubicasti okovani
		// else if(i==4 && (j==3 || j==16))
		// blokovi[i][j]//tamnoljubicasti
		// else if(i==5 && (j==0 || j==19))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==5 && (j==6 || j==13))
		// blokovi[i][j]//ljubicasti okovani
		// else if(i==5 && j!=7 && j!=12)
		// blokovi[i][j]//tamnoljubicasti
		// else if(i==6 && (j==5 || j==14))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==6 && (j==6 || j==13))
		// blokovi[i][j]//tamnoljubicasti
		// else if(i==6 && (j==7 || j==12))
		// blokovi[i][j]//ljubicasti okovani
		// else if(i==6 && j!=8 && j!=11)
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.PLAVA, "/PLAVA.png");
		// else if(i==7 && (j==5 || j==14))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.PLAVA, "/PLAVA.png");
		// else if(i==7 && (j==6 || j==13))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==7 && (j==7 || j==12))
		// blokovi[i][j]//tamnoljubicasti
		// else if(i==7 && (j==8 || j==11))
		// blokovi[i][j]//ljubicasti okovani
		// else if(i==7 && j!=9 && j!=10)
		// blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==8 && (j==0 || j==1 || j==18 || j==19))
		// blokovi[i][j]//zuti neprobojni
		// else if(i==8 && (j==2 || j==3 || j==7 || j==12 || j==16 || j==17))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==8 && (j==4 || j==5 || j==14 || j==15))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==8 && (j==6 || j==13))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.PLAVA, "/PLAVA.png");
		// else if(i==8 && (j==8 || j==11))
		// blokovi[i][j]//tamnoljubicasti
		// else if(i==8 && (j==9 || j==10))
		// blokovi[i][j]//ljubicasti okovani
		// else if(i==9 && (j==0 || j==4 || j==8 || j==11 || j==15 || j==19))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==9 && (j==1 || j==18))
		// blokovi[i][j]//narandzasti
		// else if(i==9 && (j==2 || j==3 || j==16 || j==17))
		// blokovi[i][j]//zuti neprobojni
		// else if(i==9 && (j==5 || j==6 || j==13 || j==14))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==9 && (j==7 || j==12))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.PLAVA, "/PLAVA.png");
		// else if(i==9 && (j==9 || j==10))
		// blokovi[i][j]//tamnoljubicasti
		// else if(i==10 && (j==0 || j== 19))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==10 && (j==1 || j==5 || j==9 || j==10 || j==14 || j==18))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==10 && (j==2 || j==3 || j==16 || j==17))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==10 && (j==4 || j==15))
		// blokovi[i][j]=//zuti neprobijijajuci
		// else if(i==10 && (j==6 || j==7 || j==12 || j==13))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==10 && (j==8 || j==11))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.PLAVA, "/PLAVA.png");
		// else if(i==11 && (j==1 || j==18))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==11 && (j==2 || j==6 || j==13 || j==17))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==11 && (j==3 || j==4 || j==15 || j==16))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==11 && (j==5 || j==14))
		// blokovi[i][j]=//zuti neprobijijajuci
		// else if(i==11 && (j==7 || j==8 || j==11 || j==12))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==11 && (j==9 || j==10))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.PLAVA, "/PLAVA.png");
		// else if(i==12 && (j==2 || j==17))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==12 && (j==3 || j==7 || j==12 || j==16))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==12 && (j==4 || j==5 || j==14 || j==15))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==12 && (j==6 || j==13))
		// blokovi[i][j]=//zuti neprobijijajuci
		// else if(i==12 && (j==8 || j==9 || || j==10 || j==11))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==13 && (j==3 || j==16))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==13 && (j==4 || j==8 || j== 11 || j==15))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==13 && (j==5 || j==6 || j==13 || j==14))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==13 && (j==7 || j==12))
		// blokovi[i][j]=//zuti neprobijijajuci
		// else if(i==13 && (j==9 || j==10))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.ZELENA, "/ZELENA.png");
		// else if(i==14 && (j==4 || j==15))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==14 && (j==5 || j==9 || j==10 || j==14))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==14 && (j==6 || j==7 || j==12 || j==13))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==14 && (j==8 || j==11)
		// blokovi[i][j]=//zuti neprobijijajuci
		// else if(i==15 && (j==5 || j==14))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==15 && (j==6 || j==13))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==15 && (j==7 || j==8 || j==11 || j==12))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==15 && (j==9 || j==10))
		// blokovi[i][j]=//zuti neprobijijajuci
		// else if(i==16 && (j==6 || j==13))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==16 && (j==7 || j==12))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==16 && (j==8 || j==9 || j==10 || j==11))
		// blokovi[i][j]=new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.NARANDZASTA, "/NARANDZASTA.png");
		// else if(i==17 && (j==7 || j==12 || j==9 || j==10))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==17 && (j==8 || j==11))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// else if(i==18 && (j==8 || j==11))
		// blokovi[i][j]= new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,
		// BojaBloka.CRVENA, "/CRVENA.png");
		// else if(i==18 && (j==9 || j==10))
		// blokovi[i][j] = new EksplozivanBlok(183 + 50 * i, 30 * j, 50, 30,
		// BojaBloka.ZUTA, "/ZUTA.png");
		// }
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
		else if (loptica.getY() + loptica.getR() >= maxDuzina)
		{
			kraj = true;
		}
		else if (loptica.getY() - loptica.getR() <= minDuzina)
		{
			if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI)
			{
				loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
				loptica.setY(minDuzina + 1);
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
				loptica.setUgaoKretanja(Math.PI / 2 - p / 37);
				// loptica.setY(daska.getY());
				// System.out.println(loptica.getUgaoKretanja());
			}
		}
		// else if(loptica.getY() + loptica.getR() >= daska.getY())
		// kraj=true;
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
					if (loptica.getX() - loptica.getR() <= blokovi[i][j].getX() + blokovi[i][j].getSirina()
							&& loptica.getX() >= blokovi[i][j].getX() + blokovi[i][j].getSirina()
							&& loptica.getY() >= blokovi[i][j].getY() - loptica.getR()
							&& loptica.getY() <= blokovi[i][j].getY() + blokovi[i][j].getVisina() + loptica.getR())
					{
						if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= 3 * Math.PI / 2)
						{
							if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
								loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
							else
								loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());

							blokovi[i][j].unistiSe(i, j, blokovi);
							flag = true;
							//System.out.println("uslo1" + "  " + loptica.getUgaoKretanja());
							break;
						}
					}
					else if (loptica.getX() + loptica.getR() >= blokovi[i][j].getX()
							&& loptica.getX() <= blokovi[i][j].getX()
							&& loptica.getY() >= blokovi[i][j].getY() - loptica.getR()
							&& loptica.getY() <= blokovi[i][j].getY() + blokovi[i][j].getVisina() + loptica.getR())
					{
						if ((loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
								|| (loptica.getUgaoKretanja() >= 3 * Math.PI / 2
										&& loptica.getUgaoKretanja() <= 2 * Math.PI))
						{
							if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI / 2)
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
							else
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							blokovi[i][j].unistiSe(i, j, blokovi);
							flag = true;
							//System.out.println("uslo3" + "  " + loptica.getUgaoKretanja());
							break;
						}
					}
					else if (loptica.getY() + loptica.getR() >= blokovi[i][j].getY()
							&& loptica.getY() <= blokovi[i][j].getY()
							&& loptica.getX() >= blokovi[i][j].getX() - loptica.getR()
							&& loptica.getX() <= blokovi[i][j].getX() + blokovi[i][j].getSirina() + loptica.getR())
					{
						if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 2 * Math.PI)
						{
							if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 3 * Math.PI / 2)
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
							else
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							blokovi[i][j].unistiSe(i, j, blokovi);
							flag = true;
							//System.out.println("uslo4" + "  " + loptica.getUgaoKretanja());
							break;
						}
					}
					else if (loptica.getY() - loptica.getR() <= blokovi[i][j].getY() + blokovi[i][j].getVisina()
							&& loptica.getY() >= blokovi[i][j].getY() + blokovi[i][j].getVisina()
							&& loptica.getX() >= blokovi[i][j].getX() - loptica.getR()
							&& loptica.getX() <= blokovi[i][j].getX() + blokovi[i][j].getSirina() + loptica.getR())
					{
						if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI)
						{
							if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
							else
								loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());

							blokovi[i][j].unistiSe(i, j, blokovi);
							flag = true;
							//System.out.println("uslo2" + "  " + loptica.getUgaoKretanja());
							break;
						}
					}
				}
			}
			if (flag)
				break;
		}
	}

	public void pomeriLopticu(double duzina)
	{
		int x = (int) (Math.cos(loptica.getUgaoKretanja()) * duzina);
		int y = (int) (Math.sin(loptica.getUgaoKretanja()) * duzina);

		loptica.setY(loptica.getY() - y);
		loptica.setX(loptica.getX() + x);

		odbijLopticuOdDaske();
		odbijLopticuOdBloka();
		odbijLopticuOdZida();
	}

	public void proveriDaLiJeKraj()
	{
		boolean flag = true;

		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (blokovi[i][j] != null && !blokovi[i][j].isUnisten())
					flag = false;

		kraj = flag;
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

	public int getMaxSirina()
	{
		return maxSirina;
	}

	public void setMaxSirina(int maxSirina)
	{
		this.maxSirina = maxSirina;
	}

	public int getMaxDuzina()
	{
		return maxDuzina;
	}

	public void setMaxDuzina(int maxDuzina)
	{
		this.maxDuzina = maxDuzina;
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
}