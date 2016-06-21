package iznenadjenja;

import engine.Engine;
import loptica.Loptica;
import loptica.ProbijajucaLoptica;

public class ProbojnostLoptice extends Iznenadjenje
{

	public ProbojnostLoptice(Engine engine)
	{
		super(engine, "/ProbojnostLoptice.png");
	}

	public void primeniIznenadjenje()
	{
		Loptica loptica = new ProbijajucaLoptica(getEngine().getLoptica());
		getEngine().setLoptica(loptica);
	}

}
