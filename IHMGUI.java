import java.awt.Point;

import javax.swing.JFrame;

public class IHMGUI 
{	
	private FramePlateau framePlateau;
	private FrameJoueur  frameJoueur;

	private int h, lPlateau, lJoueur;
	
	public IHMGUI(Controleur ctrl)
	{		
		this.framePlateau = new FramePlateau (ctrl);
		this.frameJoueur  = new FrameJoueur  (ctrl);

		h        = 600;
		lPlateau = 895;
		lJoueur  = 100;

		this.framePlateau.setTitle    ("Plateau");
		this.framePlateau.setSize     ( lPlateau, h );
		this.framePlateau.setLocation ( 20, 20 );
		this.framePlateau.setResizable(false);
		this.framePlateau.setVisible  ( true );
		this.framePlateau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.framePlateau.setTitle    ("Joueur");
		this.frameJoueur.setSize      ( lJoueur, h );
		this.frameJoueur.setLocation  ( 20 + lPlateau, 20);
		this.frameJoueur.setResizable (false);
		this.frameJoueur.setVisible   ( true );
		this.frameJoueur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void majPlateau () { this.framePlateau.majPlateau(); }
	public void majScore   () { this.frameJoueur.majScore();    }

	public void deplacerLesFrames ( char orig )
	{
		Point p;

		if ( orig == 'P' && this.framePlateau != null && this.frameJoueur != null )
		{
			p = this.framePlateau.getLocation();
			this.frameJoueur.setLocation ( p.x + lPlateau, p.y  );
		}

		if ( orig == 'J' && this.framePlateau != null && this.frameJoueur != null )
		{
			p = this.frameJoueur.getLocation();
			this.framePlateau.setLocation ( p.x - lPlateau, p.y  );
		}
	}

}
