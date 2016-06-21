package blok;

public class NeprobojniBlok extends Blok
{

	public NeprobojniBlok(int i, int j)
	{
		super(i, j, "/NeprobojniBlok.png");
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
