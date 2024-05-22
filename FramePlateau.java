import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;


public class FramePlateau extends JFrame
{
	private Controleur   ctrl;
	private PanelPlateau panelPlateau;

	public FramePlateau(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelPlateau = new PanelPlateau (this.ctrl);

		// Positionnement des composants
		this.add ( this.panelPlateau, BorderLayout.CENTER );

		this.addComponentListener( new GereFrame() );
	}

	public void majPlateau () { this.panelPlateau.majPlateau(); }

	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FramePlateau.this.ctrl.deplacerLesFrames('P');
		}
	}
}