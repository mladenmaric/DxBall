package loptica;

import blok.Blok;

public class ProbijajucaLoptica extends Loptica
{

	public ProbijajucaLoptica(Loptica loptica)
	{
		super(loptica, "/Loptica.png");
	}

	public void unistiPolje(int i, int j, Blok[][] blokovi)
	{
		blokovi[i][j].unistiSe(blokovi, false);
	}

}
