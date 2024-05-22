import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameJoueur extends JFrame
{
	private Controleur ctrl;

	private PanelJoueur panelJoueur;

	public FrameJoueur(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelJoueur = new PanelJoueur(this.ctrl);

		// Positionnement des composants
		this.add(this.panelJoueur);

		this.addComponentListener( new GereFrame() );
	}

	public void majScore() { this.panelJoueur.majScore(); }

	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameJoueur.this.ctrl.deplacerLesFrames('J');
		}
	}
}
