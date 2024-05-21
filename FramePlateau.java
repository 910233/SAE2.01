import java.awt.BorderLayout;
import javax.swing.*;


public class FramePlateau extends JFrame
{
	private Controleur   ctrl;
	private PanelPlateau panelPlateau;
	private PanelAction  panelAction;
	private PanelScore   panelScore;

	public FramePlateau(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 900, 600 );
		//this.setResizable(false);

		// Création des composants
		this.panelPlateau = new PanelPlateau (this.ctrl);
		this.panelAction  = new PanelAction  (this.ctrl);
		this.panelScore   = new PanelScore   (this.ctrl);

		// Positionnement des composants
		this.add ( this.panelPlateau, BorderLayout.CENTER );
		this.add ( this.panelAction,  BorderLayout.WEST   );
		this.add ( this.panelScore,   BorderLayout.EAST   );
		

		this.setVisible ( true );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void majPlateau () { this.panelPlateau.majPlateau(); }

	public void majScore   () { this.panelScore.majScore(); }
}