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
	private int maxSirina;
	private int maxDuzina;

	public Engine()
	{
		init();
	}

	private void init()
	{
		blokovi = new Blok[20][20];
		daska = new Daska(100, 500, 100, 20);
		loptica = new Loptica(150, 495, 10, Math.PI/2, TipLoptice.NORMALNA);

		for (int i = 5; i < 15; i++)
			for (int j = 0; j < 20; j++)
				blokovi[i][j] = new NormalanBlok(50, 20, BojaBloka.PLAVA, "plava");
	}

	public void odbijLopticuOdZida()
	{
		if(loptica.getX()-loptica.getR()==0)
		{
			if(loptica.getUgaoKretanja()>=Math.PI/2 && loptica.getUgaoKretanja()<=Math.PI)
				loptica.setUgaoKretanja(Math.PI-loptica.getUgaoKretanja());
			else
				loptica.setUgaoKretanja(3*Math.PI-loptica.getUgaoKretanja());
			
		}
		else if(loptica.getX()+loptica.getR()==maxSirina)
		{
			if(loptica.getUgaoKretanja()>=0 && loptica.getUgaoKretanja()<=Math.PI/2)
				loptica.setUgaoKretanja(Math.PI-loptica.getUgaoKretanja());
			else
				loptica.setUgaoKretanja(3*Math.PI-loptica.getUgaoKretanja());
		}
		else if(loptica.getY()+loptica.getR()==maxDuzina)
		{
			//Da li ovde zavrsiti igru?
		}
		else if(loptica.getY()-loptica.getR()==0)
		{
			if(loptica.getUgaoKretanja()>=Math.PI/2 && loptica.getUgaoKretanja()<=Math.PI)
				loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
			else
				loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
		}
	}
	
	public void odbijLopticuOdDaske()
	{
		if(loptica.getY()+loptica.getR()==daska.getY())
		{
			if(loptica.getUgaoKretanja()>=(3/2)*Math.PI && loptica.getUgaoKretanja()<=2*Math.PI)
				loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
			else
				loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
		}
	}
	
	public void odbijLopticuOdBloka()
	{
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++)
			{
				if(blokovi[i][j]!=null && blokovi[i][j].isUnisten()!=true)
				{
					if(loptica.getX()-loptica.getR()==blokovi[i][j].getX()+blokovi[i][j].getSirina())
					{
						if(loptica.getUgaoKretanja()>=Math.PI/2 && loptica.getUgaoKretanja()<=Math.PI)
							loptica.setUgaoKretanja(Math.PI-loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(3*Math.PI-loptica.getUgaoKretanja());
					}
					else if(loptica.getY()-loptica.getR()==blokovi[i][j].getY()+blokovi[i][j].getVisina())
					{
						if(loptica.getUgaoKretanja()>=Math.PI/2 && loptica.getUgaoKretanja()<=Math.PI)
							loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
					}
					else if(loptica.getX()+loptica.getR()==blokovi[i][j].getX())
					{
						if(loptica.getUgaoKretanja()>=0 && loptica.getUgaoKretanja()<=Math.PI/2)
							loptica.setUgaoKretanja(Math.PI-loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(3*Math.PI-loptica.getUgaoKretanja());
					}
					else if(loptica.getY()+loptica.getR()==blokovi[i][j].getY())
					{
						if(loptica.getUgaoKretanja()>=Math.PI && loptica.getUgaoKretanja()<=3*Math.PI/2)
							loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
						else
							loptica.setUgaoKretanja(2*Math.PI-loptica.getUgaoKretanja());
					}
				}
			}
	}
	
	public void pomeriLopticu(int vreme,int brzina)
	{
		int duzina=vreme*brzina;
		int x=(int) (Math.sin(loptica.getUgaoKretanja())*duzina);
		int y=(int) (Math.cos(loptica.getUgaoKretanja())*duzina);
		
		loptica.setX(x);
		loptica.setY(y);
		
		odbijLopticuOdBloka();
		odbijLopticuOdDaske();
		odbijLopticuOdZida();
	}
}
