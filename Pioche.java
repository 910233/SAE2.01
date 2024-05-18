import java.util.ArrayList;
import java.util.List;

public class Pioche
{
	private List<Jeton> jetons;

	public Pioche()
	{
		this.jetons = new ArrayList<Jeton>();
	}

	public Jeton tirerJeton()
	{
		Jeton jeton = jetons.get(0);
		jetons.remove(0);

		return jeton;
	}

	private void initPioche()
	{
		//jetons.add(new Jeton());
	}
}