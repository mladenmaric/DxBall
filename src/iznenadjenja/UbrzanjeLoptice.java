package iznenadjenja;

import engine.Engine;

public class UbrzanjeLoptice extends Iznenadjenje
{

	public UbrzanjeLoptice(Engine engine, int sirina, int visina)
	{
		super(engine, sirina, visina, "/UbrzanjeLoptice.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getLoptica().ubrzajSe();
	}

}
