public class Controleur 
{
	public static void main(String[] args)
	{
		Plateau plateau = new Plateau();
		Pioche pioche = new Pioche();
		
		System.out.println("Etat initial du Plateau");
		System.out.println(plateau);
		System.out.println();

		System.out.println("Ajout des ressources à partir des jetons de la pioche");

		System.out.println();
		for(int i = 0; i < 15; i++)
		{
			String sRes = "";
			Jeton j = pioche.tirerJeton();
			sRes += String.format("%-20s : ", j.toString());
			sRes += plateau.ajouterRessource(j);
			System.out.println(sRes);
		}
		System.out.println();

		System.out.println("Etat final du Plateau");
		System.out.println(plateau);

		plateau.score();
		System.out.println();
		System.out.println("Score : " + plateau.getScore() + " points");
		System.out.println();
		System.out.println(plateau.getDetailScore());
	}
}
