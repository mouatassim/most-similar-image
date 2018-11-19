import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class panalChoice extends JPanel {
	
	//JButton AjouteImage = new JButton("Ajouter Image");
	JButton NiveuDeGris = new JButton("Niveau de gris");
	JButton Histogramme = new JButton("Histogramme");
	JButton CompareImage = new JButton("Comparer Image");

	public panalChoice() {
		
		this.setSize(300,300);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		/*AjouteImage.setBounds(20, 60, 260, 80);
		this.add(AjouteImage);
		*/
		NiveuDeGris.setBounds(20, 160, 260, 80);
		this.add(NiveuDeGris);
		
		Histogramme.setBounds(20, 260, 260, 80);
		this.add(Histogramme);
		
		CompareImage.setBounds(20, 360, 260, 80);
		this.add(CompareImage);
		
		/********************************/
		
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
