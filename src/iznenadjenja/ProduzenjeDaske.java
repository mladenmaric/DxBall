package iznenadjenja;

import engine.Engine;

public class ProduzenjeDaske extends Iznenadjenje
{

	public ProduzenjeDaske(Engine engine)
	{
		super(engine, "/ProduzenjeDaske.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getDaska().produziSe();
	}

}
