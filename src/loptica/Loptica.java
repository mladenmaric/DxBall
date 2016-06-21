package loptica;

import blok.Blok;

public abstract class Loptica
{
	private int x;
	private int y;
	private int r;
	private double ugaoKretanja;
	private int brzinaLoptice;
	private String slika;

	public Loptica(int x, int y, int r, double ugaoKretanja, int brzinaLoptice, String slika)
	{
		this.x = x;
		this.y = y;
		this.r = r;
		this.ugaoKretanja = ugaoKretanja;
		this.brzinaLoptice = brzinaLoptice;
		this.slika = slika;
	}
	
	public Loptica(Loptica loptica, String slika)
	{
		this.x = loptica.getX();
		this.y = loptica.getY();
		this.r = loptica.getR();
		this.ugaoKretanja = loptica.ugaoKretanja;
		this.brzinaLoptice = loptica.brzinaLoptice;
		this.slika = slika;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getR()
	{
		return r;
	}

	public void setR(int r)
	{
		this.r = r;
	}

	public double getUgaoKretanja()
	{
		return ugaoKretanja;
	}

	public void setUgaoKretanja(double ugaoKretanja)
	{
		this.ugaoKretanja = ugaoKretanja;
	}

	public int getBrzinaLoptice()
	{
		return brzinaLoptice;
	}

	public void setBrzinaLoptice(int brzinaLoptice)
	{
		this.brzinaLoptice = brzinaLoptice;
	}

	public void ubrzajSe()
	{
		brzinaLoptice /= 2;
	}

	public void usporiSe()
	{
		brzinaLoptice *= 2;
	}

	public String getSlika()
	{
		return slika;
	}

	public abstract void unistiPolje(int i, int j, Blok[][] blokovi);
}
