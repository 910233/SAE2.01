import java.awt.Point;

import javax.swing.JFrame;

public class IHMGUI 
{	

	private static final int HAUTEUR            = 600;
	private static final int LARGEUR_PLATEAU    = 895;
	private static final int LARGEUR_JOUEUR     = 250;
	private static final int LARGEUR_HISTORIQUE = 250;

	private FramePlateau    framePlateau;
	private FrameJoueur     frameJoueur;
	private FrameHistorique frameHistorique;
	
	public IHMGUI(Controleur ctrl)
	{		
		this.framePlateau    = new FramePlateau (ctrl);
		this.frameJoueur     = new FrameJoueur  (ctrl);
		this.frameHistorique = new FrameHistorique(ctrl);

		this.frameHistorique.setTitle    ("Historique");
		this.frameHistorique.setSize     ( IHMGUI.LARGEUR_HISTORIQUE, IHMGUI.HAUTEUR );
		this.frameHistorique.setLocation ( 20, 20 );
		this.frameHistorique.setResizable(false);
		this.frameHistorique.setVisible  ( true );
		this.frameHistorique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.framePlateau.setTitle    ("Plateau");
		this.framePlateau.setSize     ( IHMGUI.LARGEUR_PLATEAU, IHMGUI.HAUTEUR );
		this.framePlateau.setLocation ( IHMGUI.LARGEUR_HISTORIQUE + 20, 20 );
		this.framePlateau.setResizable(false);
		this.framePlateau.setVisible  ( true );
		this.framePlateau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frameJoueur.setTitle    ("Joueur");
		this.frameJoueur.setSize      ( IHMGUI.LARGEUR_JOUEUR, IHMGUI.HAUTEUR );
		this.frameJoueur.setLocation  ( IHMGUI.LARGEUR_HISTORIQUE + IHMGUI.LARGEUR_PLATEAU + 20, 20);
		this.frameJoueur.setResizable (false);
		this.frameJoueur.setVisible   ( true );
		this.frameJoueur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void majPlateau () { this.framePlateau.majPlateau(); }
	public void majScore   () { this.frameJoueur.majScore();    }
	public void majHistorique (Jeton r, boolean retour) 
	{
		 this.frameHistorique.majHistorique(r, retour);
	}

	public void deplacerLesFrames ( char orig )
	{
		if(   this.framePlateau     != null 
		    && this.frameJoueur     != null 
			&& this.frameHistorique != null)
		{
			Point p;
			if ( orig == 'P')
			{
				p = this.framePlateau.getLocation();
				this.frameJoueur.setLocation    (p.x + IHMGUI.LARGEUR_PLATEAU, p.y);
				this.frameHistorique.setLocation(p.x - IHMGUI.LARGEUR_HISTORIQUE, p.y);
			}
			if ( orig == 'J')
			{
				p = this.frameJoueur.getLocation ();
				this.framePlateau.setLocation    (p.x - IHMGUI.LARGEUR_PLATEAU, p.y);
				this.frameHistorique.setLocation (p.x - IHMGUI.LARGEUR_PLATEAU - IHMGUI.LARGEUR_HISTORIQUE, p.y);
			}
			if ( orig == 'H')
			{
				p = this.frameHistorique.getLocation();
				this.framePlateau.setLocation (p.x + IHMGUI.LARGEUR_HISTORIQUE, p.y);
				this.frameJoueur.setLocation  (p.x + IHMGUI.LARGEUR_HISTORIQUE + IHMGUI.LARGEUR_PLATEAU, p.y);
				
			}
		}
	}

}
