package iznenadjenja;

import engine.Engine;

public class SmanjenjeZivota extends Iznenadjenje
{

	public SmanjenjeZivota(Engine engine, int x, int y, int sirina, int visina)
	{
		super(engine, x, y, sirina, visina);
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().setBrojZivota(super.getEngine().getBrojZivota()-1);
	}

}
