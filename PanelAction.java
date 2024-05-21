import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelAction extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private JButton btnTirerJeton;

	public PanelAction (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.btnTirerJeton = new JButton("Tirer Jeton");
		this.add(this.btnTirerJeton);
		this.btnTirerJeton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btnTirerJeton)
		{
			this.ctrl.ajouterRessource(this.ctrl.tirerJeton());
			System.out.println("Tirer Jeton");
		}
	}

}
