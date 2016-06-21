package blok;

public class EksplozivanBlok extends Blok
{	
	public EksplozivanBlok(int i, int j)
	{
		super(i, j, "/EksplozivanBlok.gif");
	}

	public void unistiSe(Blok[][] blokovi)
	{
		setUnisten(true);
		
		if (getIznenadjenje() != null)
			getIznenadjenje().setVidljivo(true);
		
		int i = getI();
		int j = getJ();
		
		// GORE
		if (i > 0 && blokovi[i - 1][j] != null && !blokovi[i - 1][j].isUnisten())
			blokovi[i - 1][j].unistiSe(blokovi);
		
		// DOLE
		if (i < 19 && blokovi[i + 1][j] != null && !blokovi[i + 1][j].isUnisten())
			blokovi[i + 1][j].unistiSe(blokovi);
		
		// LEVO
		if (j > 0 && blokovi[i][j - 1] != null && !blokovi[i][j - 1].isUnisten())
			blokovi[i][j - 1].unistiSe(blokovi);
		
		// DESNO
		if (j < 19 && blokovi[i][j + 1] != null && !blokovi[i][j + 1].isUnisten())
			blokovi[i][j + 1].unistiSe(blokovi);
		
		// GORE-LEVO
		if (i > 0 && j > 0 && blokovi[i - 1][j - 1] != null && !blokovi[i - 1][j - 1].isUnisten())
			blokovi[i - 1][j - 1].unistiSe(blokovi);
		
		// GORE-DESNO
		if (i > 0 && j < 19 && blokovi[i - 1][j + 1] != null && !blokovi[i - 1][j + 1].isUnisten())
			blokovi[i - 1][j + 1].unistiSe(blokovi);
		
		// DOLE-LEVO
		if (i < 19 && j > 0 && blokovi[i + 1][j - 1] != null && !blokovi[i + 1][j - 1].isUnisten())
			blokovi[i + 1][j - 1].unistiSe(blokovi);
		
		// DOLE-DESNO
		if (i < 19 && j < 19 && blokovi[i + 1][j + 1] != null && !blokovi[i + 1][j + 1].isUnisten())
			blokovi[i + 1][j + 1].unistiSe(blokovi);
		
	}

}
