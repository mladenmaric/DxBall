package iznenadjenja;

import engine.Engine;
import loptica.Loptica;
import loptica.VatrenaLoptica;

public class VatrenostLoptice extends Iznenadjenje
{

	public VatrenostLoptice(Engine engine)
	{
		super(engine, "/VatrenostLoptice.png");
	}

	public void primeniIznenadjenje()
	{
		Loptica loptica = new VatrenaLoptica(getEngine().getLoptica());
		getEngine().setLoptica(loptica);
	}

}
