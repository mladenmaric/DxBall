package iznenadjenja;

import engine.Engine;

public class ProduzenjeDaske extends Iznenadjenje
{

	public ProduzenjeDaske(Engine engine, int x, int y, int sirina, int visina)
	{
		super(engine, x, y, sirina, visina);
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getDaska().produziSe();
	}

}
