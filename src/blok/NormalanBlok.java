package blok;

public class NormalanBlok extends Blok
{

	public NormalanBlok(int i, int j, String pocetnaSlika)
	{
		super(i, j, pocetnaSlika);
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
