public class Plateau
{
	private final static int NB_PIECE_MAX = 8;
	private int     nbPiece;


	private Epice[][] pieces;

	public Plateau()
	{
		this.nbPiece = 0;
		this.pieces  = new Epice[3][5];
	}

	public boolean ajouterRessource(Jeton r)
	{
		

	}

	public String toString()
	{
		String retour = "";

		String ligne  = "+-----+-----+-----+-----+-----+";
		
		for(int i = 0; i < this.pieces.length; i++)
		{
			retour += ligne + "\n|";
			for(int j = 0; j < this.pieces[0].length; j++)
			{
				if (this.pieces[0] == null) retour += "     |";
				else                        retour += " " + String.format("%3s", this.pieces[i][j].getLibCourt()) + " |";
			}
		}

		return retour;
	}
}