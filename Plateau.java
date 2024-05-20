import java.util.ArrayList;
import java.util.List;

public class Plateau
{
	private final static int NB_PIECE_MAX = 8;
	private int nbPiece;

	private int score;
	private String detailScore;

	private List<List<Epice>> tabEpice;
	private final static int NB_COL_TAB_EPICE = 5;
	private final static int NB_LIG_TAB_EPICE = 3;
	private int colTabEpice;

	public Plateau()
	{
		this.nbPiece = 0;
		this.tabEpice = new ArrayList<List<Epice>>();
		for(int i = 0; i < Plateau.NB_COL_TAB_EPICE; i++)
			this.tabEpice.add(new ArrayList<Epice>());
		this.colTabEpice = 0;
	}

	public int getScore() { return this.score; }
	public String getDetailScore() { return this.detailScore; }

	public boolean ajouterRessource(Jeton r)
	{
		boolean retour = false;
		
		if (r.getType() instanceof Epice)
		{
			Epice epice =  (Epice) r.getType();

			boolean boolMemeEpice = false;
			int i;
			for(i = 0; i < this.colTabEpice && !boolMemeEpice; i++)
			{
				if(this.tabEpice.get(i).size() > 0 &&
				   this.tabEpice.get(i).get(0).getCouleur().getSymbole().equals(epice.getCouleur().getSymbole())) 
					boolMemeEpice = true;
			}

			if(boolMemeEpice)
			{
				if (this.tabEpice.get(i-1).size() < Plateau.NB_LIG_TAB_EPICE)
				{
					this.tabEpice.get(i-1).add(epice);
					retour = true;
				}
			}
			else
			{
				if(this.colTabEpice < Plateau.NB_COL_TAB_EPICE)
				{
					this.tabEpice.get(this.colTabEpice++).add(epice);
					retour = true;
				}
			}
		}

		if (r.getType() instanceof Piece)
		{
			Piece piece =  (Piece) r.getType();

			if (this.nbPiece + piece.getValeur() <= Plateau.NB_PIECE_MAX)
			{
				this.nbPiece += piece.getValeur();
				retour = true;
			}
		}

		return retour;
	}

	public void score()
	{
		
	}

	public String toString()
	{
		String retour = "";
		String ligne  = "+-----+-----+-----+-----+-----+";
		String tmp = "";
		

		for(int i = 0; i < Plateau.NB_LIG_TAB_EPICE; i++)
		{
			tmp = ligne + "\n|";
			for(int j = 0; j < Plateau.NB_COL_TAB_EPICE; j++)
			{
				if (this.tabEpice.get(j).size() <= i) 
					tmp += "     |";
				else 
					tmp += " " + String.format("%3s", this.tabEpice.get(j).get(i).getLibCourt()) + " |";
			}
			retour = tmp + "\n" + retour;
		}
		retour += ligne + "\n";

		retour += "\n" + this.nbPiece + " pièce" + (this.nbPiece <= 1 ? "" : "s");

		return retour;
	}
}