package blok;

public class NeprobojniBlok extends Blok
{

	public NeprobojniBlok(int x, int y, int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		super(x, y, sirina, visina, boja, pocetnaSlika);
	}

	public void unistiSe(int i, int j, Blok[][] blokovi)
	{
		blokovi[i][j].setUnisten(true);
	}
	
	public void unistiSe(int i, int j, Blok[][] blokovi, boolean unisti)
	{
		if (unisti)
			unistiSe(i, j, blokovi);
	}

}
