package daska;

import java.awt.MouseInfo;

public class Daska
{
	private int x;
	private int y;
	private int sirina;
	private int visina;

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

	public void pomeriSe()
	{
		int p = MouseInfo.getPointerInfo().getLocation().x - 183 - sirina / 2;
		
		if (p < 0)
			this.x = 0;
		else if (p + sirina > 1000)
			this.x = 1000 - sirina;
		else
			this.x = p;
	}

	public void produziSe()
	{
		this.sirina *= 2;
	}

	public void skratiSe()
	{
		this.sirina /= 2;
	}
}
