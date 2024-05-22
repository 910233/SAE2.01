import java.awt.*;

import javax.swing.*;


public class PanelPlateau extends JPanel
{
	private Controleur ctrl;
	private Image imgPlateau;

	public PanelPlateau (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.imgPlateau = getToolkit().getImage ( "./images/plateau.png" );
	}

	public void majPlateau()
    {
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage ( this.imgPlateau, 0, 0, this );

        for(int i = 0; i < this.ctrl.getTabEpice().size();i++)
        {
            for(int j = 0 ; j < this.ctrl.getTabEpice().get(i).size(); j++)
            {
                String s = this.ctrl.getTabEpice().get(i).get(j).name().toLowerCase() + ".png";
                Image imageEpice = getToolkit().getImage ("./images/"+s);
                g2.drawImage(imageEpice, 80 + i * 160, 260 - j * 120, this);
            }
        }

        for(int i = 0; i < this.ctrl.getNbPiece(); i ++)
        {
            Image imageB = getToolkit().getImage ("./images/bronze.png");
            g2.drawImage(imageB, 77 + i * 85,400,this);
        }

    }

}