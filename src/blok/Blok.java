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
	private String slikaUnistenja;
	private boolean unisten;
	private Iznenadjenje iznenadjenje;
	static int unistenoBlokova = 0;

	public Blok(int i, int j, String pocetnaSlika)
	{
		this.i = i;
		this.j = j;
		this.pocetnaSlika = pocetnaSlika;
		this.slikaUnistenja = null;
		
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

	public String getSlikaUnistenja()
	{
		return slikaUnistenja;
	}

	public void setSlikaUnistenja(String slikaUnistenja)
	{
		this.slikaUnistenja = slikaUnistenja;
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
	
	public static int getUnistenoBlokova()
	{
		return unistenoBlokova;
	}

	public static void setUnistenoBlokova(int unistenoBlokova)
	{
		Blok.unistenoBlokova = unistenoBlokova;
	}

	public abstract void unistiSe(Blok[][] blokovi, boolean flag);

}
