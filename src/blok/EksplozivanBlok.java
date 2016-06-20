package blok;

public class EksplozivanBlok extends Blok
{	
	public EksplozivanBlok(int x, int y, int sirina, int visina, BojaBloka boja, String pocetnaSlika)
	{
		super(x, y, sirina, visina, boja, pocetnaSlika);
	}

	public void unistiSe(int i, int j, Blok[][] blokovi)
	{
		setUnisten(true);
		if (getIznenadjenje() != null)
			getIznenadjenje().setVidljivo(true);
		
		// GORE
		if (i > 0 && blokovi[i - 1][j] != null && !blokovi[i - 1][j].isUnisten())
			blokovi[i - 1][j].unistiSe(i - 1, j, blokovi);
		
		// DOLE
		if (i < 19 && blokovi[i + 1][j] != null && !blokovi[i + 1][j].isUnisten())
			blokovi[i + 1][j].unistiSe(i + 1, j, blokovi);
		
		// LEVO
		if (j > 0 && blokovi[i][j - 1] != null && !blokovi[i][j - 1].isUnisten())
			blokovi[i][j - 1].unistiSe(i, j - 1, blokovi);
		
		// DESNO
		if (j < 19 && blokovi[i][j + 1] != null && !blokovi[i][j + 1].isUnisten())
			blokovi[i][j + 1].unistiSe(i, j + 1, blokovi);
		
		// GORE-LEVO
		if (i > 0 && j > 0 && blokovi[i - 1][j - 1] != null && !blokovi[i - 1][j - 1].isUnisten())
			blokovi[i - 1][j - 1].unistiSe(i - 1, j - 1, blokovi);
		
		// GORE-DESNO
		if (i > 0 && j < 19 && blokovi[i - 1][j + 1] != null && !blokovi[i - 1][j + 1].isUnisten())
			blokovi[i - 1][j + 1].unistiSe(i - 1, j + 1, blokovi);
		
		// DOLE-LEVO
		if (i < 19 && j > 0 && blokovi[i + 1][j - 1] != null && !blokovi[i + 1][j - 1].isUnisten())
			blokovi[i + 1][j - 1].unistiSe(i + 1, j - 1, blokovi);
		
		// DOLE-DESNO
		if (i < 19 && j < 19 && blokovi[i + 1][j + 1] != null && !blokovi[i + 1][j + 1].isUnisten())
			blokovi[i + 1][j + 1].unistiSe(i + 1, j + 1, blokovi);
		
	}

}
