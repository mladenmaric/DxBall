package loptica;

import blok.Blok;
import blok.NeprobojniBlok;

public class NormalnaLoptica extends Loptica
{
	
	
	public NormalnaLoptica(int x, int y, int r, double ugaoKretanja, int brzinaLoptice)
	{
		super(x, y, r, ugaoKretanja, brzinaLoptice, "/Loptica.png");
	}

	public void unistiPolje(int i, int j, Blok[][] blokovi)
	{
		if (!(blokovi[i][j] instanceof NeprobojniBlok)) 
			blokovi[i][j].unistiSe(blokovi);
	}

}
