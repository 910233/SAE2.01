public class Plateau
{
	private final static int NB_PIECE_MAX = 15;
	
	private int     nbPiece;
	private Epice[] pieces;

	public Plateau()
	{
		this.nbPiece = 0;
		this.pieces  = new Epice[this.NB_PIECE_MAX];
	}

	public boolean ajouterRessource(Jeton r)
	{
		if(this.nbPiece >= this.NB_PIECE_MAX) return false;

		this.pieces[this.nbPiece++] = r.getType();
		return true;
	}

	public String toString()
	{
		String retour = "";

		String ligne  = "\n+----+----+----+----+----+\n" 
		
		for(int i = 0; i < this.NB_PIECE_MAX; i++)
		{
			if(i % 5 == 0) retour += ligne;

			if (this.pieces[0] == null) retour += "|     |";
			else                        retour += "| " + String.format("%3s", this.pieces[0].getLibCourt()) + " |";
		}

		return retour;
	}
}