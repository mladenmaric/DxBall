package iznenadjenja;

import engine.Engine;

public class UsporenjeLoptice extends Iznenadjenje
{

	public UsporenjeLoptice(Engine engine)
	{
		super(engine, "/UsporenjeLoptice.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getLoptica().usporiSe();
	}

}
