package iznenadjenja;

import engine.Engine;

public class SkracenjeDaske extends Iznenadjenje
{

	public SkracenjeDaske(Engine engine, int x, int y, int sirina, int visina)
	{
		super(engine, x, y, sirina, visina);
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getDaska().skratiSe();
	}

}
