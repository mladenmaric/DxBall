package blok;

public class NeprobojniBlok extends Blok
{

	public NeprobojniBlok(int i, int j)
	{
		super(i, j, "/NeprobojniBlok.png");
	}

	
	public void unistiSe(Blok[][] blokovi, boolean flag)
	{
		setUnisten(true);
		Blok.unistenoBlokova++;

		if (flag)
			setSlikaUnistenja("/SlikaUnistenja.gif");
		
		if (getIznenadjenje() != null)
			getIznenadjenje().setVidljivo(true);
	}

}
