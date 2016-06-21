package iznenadjenja;

import engine.Engine;

public class SkracenjeDaske extends Iznenadjenje
{

	public SkracenjeDaske(Engine engine)
	{
		super(engine, "/SkracenjeDaske.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getDaska().skratiSe();
	}

}
