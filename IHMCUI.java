public class IHMCUI 
{
	Controleur ctrl;
	
	public IHMCUI(Controleur ctrl)
	{
		this.ctrl = ctrl;
		
		System.out.println("Etat initial du Plateau");
		this.afficherPlateau();
		System.out.println();

		System.out.println("Ajout des ressources à partir des jetons de la pioche");

		System.out.println();
		this.ajouterRessources();

		System.out.println("Etat final du Plateau");
		this.afficherPlateau();
		System.out.println();

		this.ctrl.getPlateau().score();
		this.afficherScore();
	}

	public void afficherPlateau()
	{
		System.out.println(this.ctrl.getPlateau());
	}

	public void ajouterRessources()
	{
		for(int i = 0; i < 15; i++)
		{
			String sRes = "";
			Jeton r = this.ctrl.tirerJeton();
			sRes += String.format("%-20s : ", r.toString());
			sRes += this.ctrl.ajouterRessource(r);
			System.out.println(sRes);
		}
		System.out.println();
	}

	public void afficherScore() 
	{
		int    score       = this.ctrl.getPlateau().getScore();
		String detailScore = this.ctrl.getPlateau().getDetailScore();
		
		System.out.println("Score : " + score + " points");
		System.out.println();
		System.out.println(detailScore);
		System.out.println();
	}
}
