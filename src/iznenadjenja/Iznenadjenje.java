package iznenadjenja;

import engine.Engine;

public abstract class Iznenadjenje
{
	private Engine engine;
	private int x;
	private int y;
	private static final int sirina = 50;
	private static final int visina = 50;
	private boolean vidljivo;
	private String slika;

	public Iznenadjenje(Engine engine, String slika)
	{
		this.engine = engine;
		this.slika = slika;
		
		vidljivo = false;
	}

	public Engine getEngine()
	{
		return engine;
	}

	public abstract void primeniIznenadjenje();

	public void spustiSe()
	{
		y += 10;
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

	public int getVisina()
	{
		return visina;
	}

	public boolean isVidljivo()
	{
		return vidljivo;
	}

	public void setVidljivo(boolean vidljivo)
	{
		this.vidljivo = vidljivo;
	}

	public String getSlika()
	{
		return slika;
	}

	public void setSlika(String slika)
	{
		this.slika = slika;
	}
	
	
}
