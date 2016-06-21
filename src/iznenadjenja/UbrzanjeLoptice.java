package iznenadjenja;

import engine.Engine;

public class UbrzanjeLoptice extends Iznenadjenje
{

	public UbrzanjeLoptice(Engine engine)
	{
		super(engine, "/UbrzanjeLoptice.png");
	}

	public void primeniIznenadjenje()
	{
		super.getEngine().getLoptica().ubrzajSe();
	}

}
