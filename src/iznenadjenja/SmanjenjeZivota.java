package iznenadjenja;

import engine.Engine;

public class SmanjenjeZivota extends Iznenadjenje
{

	public SmanjenjeZivota(Engine engine)
	{
		super(engine, "/SmanjenjeZivota.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().setBrojZivota(super.getEngine().getBrojZivota() - 1);
		getEngine().postaviPocetneVrednosti();
	}

}
