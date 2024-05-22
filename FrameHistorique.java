import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameHistorique extends JFrame
{
	private Controleur ctrl;

	private PanelHistorique panelHistorique;

	public FrameHistorique(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelHistorique = new PanelHistorique(this.ctrl);

		// Positionnement des composants
		this.add(this.panelHistorique);

		this.addComponentListener( new GereFrame() );
	}

	public void majHistorique(Jeton r, boolean retour) { this.panelHistorique.majHistorique(r, retour); }

	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameHistorique.this.ctrl.deplacerLesFrames('H');
		}
	}
}
