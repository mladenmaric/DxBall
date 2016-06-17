package blok;

public abstract class Blok
{
	private int sirina;
	private int visina;
	private int x;
	private int y;
	private BojaBloka boja;
	private String pocetnaSlika;
	private boolean unisten;
	
	public Blok(int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		this.sirina = sirina;
		this.visina = visina;
		this.boja = boja;
		this.pocetnaSlika = pocetnaSlika;
		unisten = false;
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

	public int getSirina()
	{
		return sirina;
	}

	public void setSirina(int sirina)
	{
		this.sirina = sirina;
	}

	public int getVisina()
	{
		return visina;
	}

	public void setVisina(int visina)
	{
		this.visina = visina;
	}

	public BojaBloka getBoja()
	{
		return boja;
	}

	public void setBoja(BojaBloka boja)
	{
		this.boja = boja;
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

	public abstract void unistiSe();
	
}
