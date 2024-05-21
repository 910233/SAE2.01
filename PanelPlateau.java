import java.awt.*;

import javax.swing.*;
import java.util.List;


public class PanelPlateau extends JPanel
{
	private Controleur ctrl;
	private Image imgPlateau;

	public PanelPlateau (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.imgPlateau = getToolkit().getImage ( "./images/plateau.png" );
	}

	public void majPlateau()
	{
		int               nbPiece  = this.ctrl.getNbPiece();
		List<List<Epice>> tabEpice = this.ctrl.getTabEpice();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage ( this.imgPlateau, 0, 0, this );
	}

}