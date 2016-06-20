package blok;

public class OkovaniBlok extends Blok
{
	
	public OkovaniBlok(int x, int y, int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		super(x, y, sirina, visina, boja, pocetnaSlika);
	}

	public void unistiSe(int i, int j, Blok[][] blokovi)
	{
		blokovi[i][j] = new NeprobojniBlok(super.getX(), super.getY(), super.getSirina(), super.getVisina(), super.getBoja(), "/NEPROBOJNI.png");

	}

}
