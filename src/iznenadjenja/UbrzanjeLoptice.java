package iznenadjenja;

import engine.Engine;

public class UbrzanjeLoptice extends Iznenadjenje
{

	public UbrzanjeLoptice(Engine engine, int x, int y, int sirina, int visina)
	{
		super(engine, x, y, sirina, visina);
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getLoptica().ubrzajSe();
	}

}
