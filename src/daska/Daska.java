package daska;

import java.awt.MouseInfo;

public class Daska
{
	private int x;
	private int y;
	private int sirina;
	private int duzina;

	public Daska(int x, int y, int sirina, int duzina)
	{
		super();
		this.x = x;
		this.y = y;
		this.sirina = sirina;
		this.duzina = duzina;
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

	public int getDuzina()
	{
		return duzina;
	}

	public void setDuzina(int duzina)
	{
		this.duzina = duzina;
	}

	public void pomeriSe()
	{
		this.x = MouseInfo.getPointerInfo().getLocation().x - sirina / 2;
	}

	public void produziSe()
	{
		this.duzina *= 2;
	}

	public void skratiSe()
	{
		this.duzina /= 2;
	}
}
