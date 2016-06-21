package iznenadjenja;

import engine.Engine;

public class BonusZivot extends Iznenadjenje
{

	public BonusZivot(Engine engine)
	{
		super(engine, "/BonusZivot.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().setBrojZivota(super.getEngine().getBrojZivota() + 1);
	}

}
