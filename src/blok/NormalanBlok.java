package blok;

public class NormalanBlok extends Blok
{

	public NormalanBlok(int i, int j, String pocetnaSlika)
	{
		super(i, j, pocetnaSlika);
	}

	public void unistiSe(Blok[][] blokovi)
	{
		int i = getI();
		int j = getJ();
		
		blokovi[i][j].setUnisten(true);
		
		if (getIznenadjenje() != null)
			getIznenadjenje().setVidljivo(true);
	}
	
}
