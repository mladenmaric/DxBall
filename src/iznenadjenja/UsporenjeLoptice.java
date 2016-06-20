package iznenadjenja;

import engine.Engine;

public class UsporenjeLoptice extends Iznenadjenje
{

	public UsporenjeLoptice(Engine engine, int sirina, int visina)
	{
		super(engine, sirina, visina, "/UsporenjeLoptice.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getLoptica().usporiSe();
	}

}
