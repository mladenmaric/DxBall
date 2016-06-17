package blok;

public class NormalanBlok extends Blok
{

	public NormalanBlok(int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		super(sirina, visina, boja, pocetnaSlika);
	}

	public void unistiSe()
	{
		setUnisten(true);
	}
	
	
	
}
