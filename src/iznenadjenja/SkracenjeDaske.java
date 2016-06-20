package iznenadjenja;

import engine.Engine;

public class SkracenjeDaske extends Iznenadjenje
{

	public SkracenjeDaske(Engine engine, int sirina, int visina)
	{
		super(engine, sirina, visina, "/SkracenjeDaske.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getDaska().skratiSe();
	}

}
