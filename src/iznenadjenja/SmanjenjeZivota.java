package iznenadjenja;

import engine.Engine;

public class SmanjenjeZivota extends Iznenadjenje
{

	public SmanjenjeZivota(Engine engine, int sirina, int visina)
	{
		super(engine, sirina, visina, "/SmanjenjeZivota.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().setBrojZivota(super.getEngine().getBrojZivota() - 1);
	}

}
