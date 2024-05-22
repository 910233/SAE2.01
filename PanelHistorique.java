import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHistorique extends JPanel
{
	private Controleur   ctrl;

	public PanelHistorique (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new JLabel(String.format("%-50s", "Historique : ")));
	}


	public void majHistorique(Jeton r, boolean retour) 
	{
		if(r != null)
			this.add(new JLabel(String.format("%-50s ", r.toString() + " : " + retour)));
		else
			this.add(new JLabel(String.format("%-50s", "La pioche est vide")));

		this.revalidate();
        this.repaint();
	}
}
