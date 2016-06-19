package iznenadjenja;

import engine.Engine;

public abstract class Iznenadjenje
{
	private Engine engine;
	private int x;
	private int y;
	private int sirina;
	private int visina;

	public Iznenadjenje(Engine engine, int x, int y, int sirina, int visina)
	{
		super();
		this.engine = engine;
		this.x = x;
		this.y = y;
		this.sirina = sirina;
		this.visina = visina;
	}

	public Engine getEngine()
	{
		return engine;
	}

	public abstract void primeniIznenadjenje();

	public void spustiSe()
	{
		x -= 10;
	}

	public void setEngine(Engine engine)
	{
		this.engine = engine;
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

}
