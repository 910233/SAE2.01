import java.util.List;

public class Controleur 
{	
	private IHMGUI  ihm;
	private Plateau metier;

	private Pioche  pioche;
	
	public Controleur ()
	{
		this.pioche = new Pioche  ();

		this.metier = new Plateau ();
		this.ihm    = new IHMGUI  (this);
	}

	public int    getScore       () { return this.metier.getScore();            }
	public String getDetailScore () { return this.metier.getDetailScore();      }
	public int    getNbPiece     () { return this.metier.getNbPiece();          }
	public List<List<Epice>> getTabEpice () { return this.metier.getTabEpice(); }

	
	public void majTout ()
	{
		this.majPlateau();
		this.score();
		this.majScore();
	}
	public void majPlateau() { this.ihm.majPlateau(); }
	public void majScore  () { this.ihm.majScore();   }


	public void score     () { this.metier.score();   }

	public String afficherPlateau () { return this.metier.toString(); }

	public Jeton tirerJeton () 
	{
		return this.pioche.tirerJeton();
	}

	public boolean ajouterRessource (Jeton r)
	{
		boolean retour = this.metier.ajouterRessource(r);
		this.majTout();
		return retour;
	}
	public static void main (String[] args) { new Controleur(); }

	public void deplacerLesFrames(char orig) { if(this.ihm != null) this.ihm.deplacerLesFrames(orig); }
}
