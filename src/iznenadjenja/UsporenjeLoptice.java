package iznenadjenja;

import engine.Engine;

public class UsporenjeLoptice extends Iznenadjenje
{

	public UsporenjeLoptice(Engine engine, int x, int y, int sirina, int visina)
	{
		super(engine, x, y, sirina, visina);
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getLoptica().usporiSe();
	}

}
