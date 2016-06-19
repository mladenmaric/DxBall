package loptica;

public class Loptica
{
	private int x;
	private int y;
	private int r;
	private double ugaoKretanja;
	private TipLoptice tipLoptice;
	private int brzinaLoptice;

	public Loptica(int x, int y, int r, double ugaoKretanja, TipLoptice tipLoptice, int brzinaLoptice)
	{
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.ugaoKretanja = ugaoKretanja;
		this.tipLoptice = tipLoptice;
		this.brzinaLoptice = brzinaLoptice;
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

	public TipLoptice getTipLoptice()
	{
		return tipLoptice;
	}

	public void setTipLoptice(TipLoptice tipLoptice)
	{
		this.tipLoptice = tipLoptice;
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
		brzinaLoptice *= 2;
	}

	public void usporiSe()
	{
		brzinaLoptice /= 2;
	}
}
