package blok;

public class NormalanBlok extends Blok
{

	public NormalanBlok(int x, int y, int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		super(x, y, sirina, visina, boja, pocetnaSlika);
	}

	public void unistiSe()
	{
		setUnisten(true);
	}
	
	
	
}
