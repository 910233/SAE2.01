import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJoueur extends JPanel implements ActionListener
{
	private Controleur   ctrl;

	private JButton btnTirerJeton;
	private List<JLabel> lblScores;

	public PanelJoueur (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.lblScores = new LinkedList<JLabel>();

		
		// Création des composants
		this.btnTirerJeton = new JButton("Tirer Jeton");

		this.lblScores.add(new JLabel("Score : "));
		this.lblScores.add(new JLabel(this.ctrl.getScore() + " points"));

		Scanner sc  = new Scanner(this.ctrl.getDetailScore());
		// "Detail : "
		this.lblScores.add(new JLabel(sc.nextLine()));
		this.lblScores.add(new JLabel(" "));

		while(sc.hasNextLine()) this.lblScores.add(new JLabel(sc.nextLine()));
		sc.close();

		// Positionnement des composants
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(this.btnTirerJeton);

		for(JLabel lbl : this.lblScores) this.add(lbl);


		this.btnTirerJeton.addActionListener(this);
	}


	public void majScore() 
	{
		return;
		
		/* 
		int    score       = this.ctrl.getScore();
		String detailScore = this.ctrl.getDetailScore();

		Scanner sc         = new Scanner(detailScore);

		this.lblScores.get(0).setText("Score : " + score + " points");

		for(int i = 2; sc.hasNextLine(); i+=2)
		{
			String tmp = sc.nextLine();
			this.lblScores.get(i).setText(tmp);
		}
		sc.close();
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btnTirerJeton)
		{
			this.ctrl.ajouterRessource(this.ctrl.tirerJeton());
		}
	}
}
