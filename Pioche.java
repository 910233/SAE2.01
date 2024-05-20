import java.util.ArrayList;
import java.util.List;

public class Pioche
{	
	private List<Jeton> jetons;

	public Pioche()
	{
		this.jetons = new ArrayList<Jeton>();
		this.initPioche();
	}

	public Jeton tirerJeton()
	{
		Jeton jeton = jetons.get(0);
		jetons.remove(0);

		return jeton;
	}

	private void initPioche()
	{
		this.jetons.add(new Jeton(Epice.POIVRE   ));
		this.jetons.add(new Jeton(Epice.SUMAC    ));
		this.jetons.add(new Jeton(Epice.CURCUMA  ));
		this.jetons.add(new Jeton(Epice.CARDAMONE));
		this.jetons.add(new Jeton(Piece.OR       ));
		this.jetons.add(new Jeton(Epice.SAFRAN   ));
		this.jetons.add(new Jeton(Epice.SESAME   ));
		this.jetons.add(new Jeton(Epice.POIVRE   ));
		this.jetons.add(new Jeton(Piece.ARGENT   ));
		this.jetons.add(new Jeton(Piece.ARGENT   ));
		this.jetons.add(new Jeton(Epice.PAPRIKA  ));
		this.jetons.add(new Jeton(Epice.SESAME   ));
		this.jetons.add(new Jeton(Epice.SAFRAN   ));
		this.jetons.add(new Jeton(Epice.SAFRAN   ));
		this.jetons.add(new Jeton(Epice.SAFRAN   ));
		this.jetons.add(new Jeton(Epice.CANNELLE ));
	}
}