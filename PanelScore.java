import javax.swing.*;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;  


public class PanelScore extends JPanel
{
	private Controleur ctrl;
	
	private List<JLabel> lblScores;

	public PanelScore (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.lblScores = new LinkedList<JLabel>();

		// Création des composants
		int    score       = this.ctrl.getScore();
		String detailScore = this.ctrl.getDetailScore();
		Scanner sc         = new Scanner(detailScore);
		
		this.lblScores.add(new JLabel("Score : " + score + " points"));
		while(sc.hasNextLine())
		{
			String tmp = sc.nextLine();
			this.lblScores.add(new JLabel(tmp));
		}
		sc.close();

		
		// Positionnement des composants
		this.setLayout(new GridLayout(this.lblScores.size(), 1, 0, 0));
		System.out.println(detailScore);
		for(JLabel lbl : this.lblScores) this.add(lbl);
	}

	public void majScore() 
	{
		int    score       = this.ctrl.getScore();
		String detailScore = this.ctrl.getDetailScore();

		Scanner sc         = new Scanner(detailScore);

		this.lblScores.get(0).setText("Score : " + score + " points");
		for(int i = 1; sc.hasNextLine(); i++)
		{
			String tmp = sc.nextLine();
			this.lblScores.get(i).setText(tmp);
		}
		sc.close();
	}
}

