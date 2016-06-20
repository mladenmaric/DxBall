package blok;

public class NeprobojniBlok extends Blok
{

	public NeprobojniBlok(int x, int y, int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		super(x, y, sirina, visina, boja, pocetnaSlika);
	}

	// poziva se kad se desi eksplozija
	public void unistiSe(int i, int j, Blok[][] blokovi)
	{
		blokovi[i][j].setUnisten(true);
		if (getIznenadjenje() != null)
			getIznenadjenje().setVidljivo(true);
	}
	
	// poziva se kad loptica udari u ovaj blok sa: unisti = false
	public void unistiSe(int i, int j, Blok[][] blokovi, boolean unisti)
	{
		if (unisti)
			unistiSe(i, j, blokovi);
	}

}
