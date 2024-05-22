import java.awt.FlowLayout;
import java.awt.GridLayout;
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
		this.ctrl      = ctrl;
		this.lblScores = new LinkedList<JLabel>();

		// Création des composants
		this.btnTirerJeton = new JButton("Tirer Jeton");

		this.lblScores.add(new JLabel(String.format("%-50s", "Score : " + this.ctrl.getScore() + " points")));

		Scanner sc = new Scanner(this.ctrl.getDetailScore());
		while(sc.hasNextLine()) this.lblScores.add(new JLabel(String.format("%-50s", sc.nextLine())));
		sc.close();

		// Positionnement des composants
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(this.btnTirerJeton);
		for(JLabel lbl : this.lblScores) this.add(lbl);

		// Activation des Composants
		this.btnTirerJeton.addActionListener(this);
	}


	public void majScore() 
	{
		Scanner sc = new Scanner(this.ctrl.getDetailScore());

		this.lblScores.get(0).setText(String.format("%-50s", "Score : " + this.ctrl.getScore() + " points"));
		for(int i = 1; sc.hasNextLine(); i++)
			this.lblScores.get(i).setText(String.format("%-50s", sc.nextLine()));
		sc.close();
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
