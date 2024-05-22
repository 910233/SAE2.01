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

		this.score = 0;
		this.detailScore = "";
		this.score();
	}

	public int               getScore       () { return this.score;       }
	public String            getDetailScore () { return this.detailScore; }
	public int               getNbPiece     () { return this.nbPiece;     }
	public List<List<Epice>> getTabEpice    () { return this.tabEpice;    }

	public boolean ajouterRessource(Jeton r)
	{
		if (r == null) return false;
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

			if(boolMemeEpice && this.tabEpice.get(i-1).size() < Plateau.NB_LIG_TAB_EPICE)
			{
				this.tabEpice.get(i-1).add(epice);
				retour = true;
			}
			else if(this.colTabEpice < Plateau.NB_COL_TAB_EPICE)
			{
				this.tabEpice.get(this.colTabEpice++).add(epice);
				retour = true;
			}

			if(retour) this.triTabEpice();
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

	// tri a bulle
	public void triTabEpice()
	{
		for(int i = this.tabEpice.size()-1; i > 0; i--)
		{
			for(int j = i; j > this.tabEpice.size()-1-i; j--)
			{
				if(this.tabEpice.get(j).size() >= this.tabEpice.get(j-1).size())
				{
					List<Epice> tmp = this.tabEpice.get(j-1);
					this.tabEpice.set(j-1, this.tabEpice.get(j));
					this.tabEpice.set(j,   tmp);
				}
			}
		}
	}

	public void score()
	{
		String detailScore = "Detail :\n";
		int score = 0;

		// Pieces
		score = this.nbPiece * this.nbPiece;
		detailScore +=   String.format("%-12s : " , " Pièces ")
		               + score + " pt\n";
		this.score = score;
		
		// Colonnes
		for(int i = 0; i < this.tabEpice.size(); i++)
		{
			switch (this.tabEpice.get(i).size()) 
			{
				case 2  -> score = 2;	
				case 3  -> score = 10;
				default -> score = 0;
			}
			detailScore +=   String.format("%-12s : " , " Colonne " + (i+1) )
			               + score + " pt\n";
			this.score += score;
		}

		// Lignes
		int nbCaseRemplies;
		for(int i = 0; i < Plateau.NB_LIG_TAB_EPICE; i++)
		{
			nbCaseRemplies = 0;
			for(int j = 0; j < Plateau.NB_COL_TAB_EPICE; j++)
			{
				if(this.tabEpice.get(j).size() > i) nbCaseRemplies++;
			}

			switch (nbCaseRemplies) 
			{
				case 2  -> score = 2;	
				case 3  -> score = 5;
				case 4  -> score = 9;
				case 5  -> score = 14;
				default -> score = 0;
			}
			detailScore +=   String.format("%-12s : " , " Ligne   " + (i+1) )
			               + score + " pt\n";
			this.score += score;
		}

		this.detailScore = detailScore;
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