package blok;

public class OkovaniBlok extends Blok
{
	
	public OkovaniBlok(int i, int j)
	{
		super(i, j, "/OkovaniBlok.png");
	}

	public void unistiSe(Blok[][] blokovi)
	{
		int i = getI();
		int j = getJ();
		
		blokovi[i][j] = new NeprobojniBlok(super.getI(), super.getJ());
	}

}
