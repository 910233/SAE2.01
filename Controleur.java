public class Controleur 
{
	public static void main(String[] args)
	{
		Plateau plateau = new Plateau();
		Pioche pioche = new Pioche();
		
		System.out.println("Etat initial du Plateau");
		System.out.println(plateau);

		for(int i = 0;i < 15; i++)
		{
			String sRes = "";
			Jeton j = pioche.tirerJeton();
			sRes += String.format("%12s : ", j.toString());
			sRes += plateau.ajouterRessource(j);
		}

		System.out.println("Etat final du Plateau");
		System.out.println(plateau);
	}
}
