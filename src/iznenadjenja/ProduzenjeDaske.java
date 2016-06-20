package iznenadjenja;

import engine.Engine;

public class ProduzenjeDaske extends Iznenadjenje
{

	public ProduzenjeDaske(Engine engine, int sirina, int visina)
	{
		super(engine, sirina, visina,"/ProduzenjeDaske.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getDaska().produziSe();
	}

}
