import java.awt.Color;

public enum Couleur
{
	BLANC(255,255,255),
	JAUNE(255,255,0),
	ROUGE(255,0,0),
	ORANGE(255,127,0),
	VIOLET(127,0,255),
	BRUN(91,60,17),
	VERT(0,255,0),
	NOIR(0,0,0);

	private int r;
	private int v;
	private int b;

	private Couleur(int r, int v, int b) 
	{
		this.r = r;
		this.v = v;
		this.b = b;
	}

	public Color getColor(){ return new Color(this.r,this.v,this.b); }

	public String getSymbole() { return this.name(); }

	public static int getNbCouleur(){ return Couleur.values().length;}

	public static Couleur valueOf(int ordinal)
	{
		Couleur[] values = Couleur.values();
		return values[ordinal];
	}
	public static void main(String[] args) {

		System.out.println(Couleur.BLANC.getColor());
		System.out.println(Couleur.BLANC.getSymbole());

		System.out.println(Couleur.VIOLET.getColor());
		System.out.println(Couleur.VIOLET.getSymbole());

		System.out.println(Couleur.valueOf(0));
		System.out.println(Couleur.valueOf(1));
		System.out.println(Couleur.valueOf(7));
		System.out.println(Couleur.getNbCouleur());
	}
}