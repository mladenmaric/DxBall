package gui;

import javax.swing.JPanel;

import iznenadjenja.Iznenadjenje;

public class PanelIznenadjenja extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Iznenadjenje iznenadjenje;
	
	public PanelIznenadjenja(Iznenadjenje iznenadjenje)
	{
		this.iznenadjenje = iznenadjenje;
	}

	public Iznenadjenje getIznenadjenje()
	{
		return iznenadjenje;
	}
	
	

}
