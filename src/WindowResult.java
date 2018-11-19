import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WindowResult  extends JFrame {
			 
			AnalyseCouleur t;
			public WindowResult(String s) {
				
				
				 
				this.setTitle("L'image la plus similaire ");
			    this.setSize(500,500);
			    this.setLayout(new FlowLayout());
				this.setLocationRelativeTo(null);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				this.setResizable(false);
			    JPanel imgPane = new JPanel();
			    imgPane.setSize(450,450);
			    JLabel background = new JLabel(new ImageIcon(((new ImageIcon(s)).getImage()).getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			    imgPane.add(background);
			    this.add(imgPane);
			    
					
					 
				}
			
			public static void main(String[] args) {
				WindowResult r = new WindowResult("/home/moatassim/IRDMTP/chat.jpg");
				r.setVisible(true);
			}
			

	

}
