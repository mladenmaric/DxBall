package engine;

import blok.Blok;
import blok.BojaBloka;
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

	public Engine()
	{
		init();
	}

	private void init()
	{
		blokovi = new Blok[20][20];
		daska = new Daska(100, 650, 100, 20);
		loptica = new Loptica(510, 510, 10, Math.PI / 3, TipLoptice.NORMALNA);
		kraj = false;

		 for (int i = 5; i < 15; i++)
		 for (int j = 0; j < 20; j++)
			 blokovi[i][j] = new NormalanBlok(183 + 50 * j, 30 * i, 50, 30,BojaBloka.PLAVA, "/PLAVA.png");
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
				loptica.setY(minDuzina+1);
			}

		}
	}

	public void odbijLopticuOdDaske()
	{
		if (loptica.getY() + loptica.getR() >= daska.getY() && loptica.getY()<=daska.getY() && loptica.getX() >= daska.getX()
				&& loptica.getX() <= daska.getX() + daska.getSirina())
		{
			if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 2 * Math.PI)
			{
				double p = loptica.getX() - daska.getX() - daska.getSirina() / 2;
				loptica.setUgaoKretanja(Math.PI / 2 - p / 37);
				//loptica.setY(daska.getY());
				System.out.println(loptica.getUgaoKretanja());
			}
		}
		// else if(loptica.getY() + loptica.getR() >= daska.getY())
		// kraj=true;
	}

	public void odbijLopticuOdBloka()
	{
		int flag=0;
		
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (blokovi[i][j] != null && !blokovi[i][j].isUnisten())
				{
					if (loptica.getX()-loptica.getR()<=blokovi[i][j].getX()+blokovi[i][j].getSirina() && loptica.getX()>=blokovi[i][j].getX()+blokovi[i][j].getSirina() && loptica.getY()>=blokovi[i][j].getY() && loptica.getY()<=blokovi[i][j].getY()+blokovi[i][j].getVisina())
					{
						if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
							loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());
						blokovi[i][j].unistiSe();
						flag=1;
						System.out.println("uslo1"+"  "+loptica.getUgaoKretanja());
						break;
					} 
					else if (loptica.getY()-loptica.getR()<=blokovi[i][j].getY()+blokovi[i][j].getVisina() && loptica.getY()>=blokovi[i][j].getY()+blokovi[i][j].getVisina() && loptica.getX()>=blokovi[i][j].getX() && loptica.getX()<=blokovi[i][j].getX()+blokovi[i][j].getSirina())
					{
						if (loptica.getUgaoKretanja() >= Math.PI / 2 && loptica.getUgaoKretanja() <= Math.PI)
							loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
						blokovi[i][j].unistiSe();
						flag=1;
						System.out.println("uslo2"+"  "+loptica.getUgaoKretanja());
						break;
					} 
					else if (loptica.getX()+loptica.getR()>=blokovi[i][j].getX() && loptica.getX()<=blokovi[i][j].getX() && loptica.getY()>=blokovi[i][j].getY() && loptica.getY()<=blokovi[i][j].getY()+blokovi[i][j].getVisina())
					{
						if (loptica.getUgaoKretanja() >= 0 && loptica.getUgaoKretanja() <= Math.PI / 2)
							loptica.setUgaoKretanja(Math.PI - loptica.getUgaoKretanja());
						else if (loptica.getUgaoKretanja() >= 3 * Math.PI / 2 && loptica.getUgaoKretanja() <= 2 * Math.PI)
							loptica.setUgaoKretanja(3 * Math.PI - loptica.getUgaoKretanja());
						blokovi[i][j].unistiSe();
						flag=1;
						System.out.println("uslo3"+"  "+loptica.getUgaoKretanja());
						break;
					} 
					else if (loptica.getY()+loptica.getR()>=blokovi[i][j].getY() && loptica.getY()<=blokovi[i][j].getY() && loptica.getX()>=blokovi[i][j].getX() && loptica.getX()<=blokovi[i][j].getX()+blokovi[i][j].getSirina())
					{
						if (loptica.getUgaoKretanja() >= Math.PI && loptica.getUgaoKretanja() <= 3 * Math.PI / 2)
							loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(2 * Math.PI - loptica.getUgaoKretanja());
						blokovi[i][j].unistiSe();
						flag=1;
						System.out.println("uslo4"+"  "+loptica.getUgaoKretanja());
						break;
					}
				}
			}
			if(flag==1)
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
	
	public void setBlok(int i, int j,Blok blok)
	{
		blokovi[i][j]=blok;
	}
}