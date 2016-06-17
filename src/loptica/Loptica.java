package loptica;

public class Loptica
{
	private int x;
	private int y;
	private int r;
	private double ugaoKretanja;
	private TipLoptice tipLoptice;
	
	public Loptica(int x, int y,int r,double ugaoKretanja, TipLoptice tipLoptice)
	{
		super();
		this.x = x;
		this.y = y;
		this.r=r;
		this.ugaoKretanja=ugaoKretanja;
		this.tipLoptice = tipLoptice;
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
}
