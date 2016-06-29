package blok;

public class OkovaniBlok extends Blok
{
	
	public OkovaniBlok(int i, int j)
	{
		super(i, j, "/OkovaniBlok.png");
	}

	public void unistiSe(Blok[][] blokovi, boolean flag)
	{
		int i = getI();
		int j = getJ();
		Blok.unistenoBlokova++;
		
		if (flag)
			setSlikaUnistenja("/SlikaUnistenja.gif");
		else
			blokovi[i][j] = new NeprobojniBlok(super.getI(), super.getJ());
	}

}
