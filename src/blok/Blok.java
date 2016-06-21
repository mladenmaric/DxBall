package blok;

import iznenadjenja.Iznenadjenje;

public abstract class Blok
{
	private int i;
	private int j;
	private int x; // GORE_LEVO (X)
	private int y; // GORE_LEVO (Y)
	private static final int sirina = 50;
	private static final int visina = 25;
	private String pocetnaSlika;
	private boolean unisten;
	private Iznenadjenje iznenadjenje;

	public Blok(int i, int j, String pocetnaSlika)
	{
		this.i = i;
		this.j = j;
		this.pocetnaSlika = pocetnaSlika;
		
		x = 50 * j;
		y = 25 * i;
		unisten = false;
		iznenadjenje = null;
	}

	public int getI()
	{
		return i;
	}

	public int getJ()
	{
		return j;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getSirina()
	{
		return sirina;
	}

	public int getVisina()
	{
		return visina;
	}

	public String getPocetnaSlika()
	{
		return pocetnaSlika;
	}

	public void setPocetnaSlika(String pocetnaSlika)
	{
		this.pocetnaSlika = pocetnaSlika;
	}

	public boolean isUnisten()
	{
		return unisten;
	}

	public void setUnisten(boolean unisten)
	{
		this.unisten = unisten;
	}
	
	public Iznenadjenje getIznenadjenje()
	{
		return iznenadjenje;
	}

	public void setIznenadjenje(Iznenadjenje iznenadjenje)
	{
		this.iznenadjenje = iznenadjenje;
	}

	public abstract void unistiSe(Blok[][] blokovi);

}
