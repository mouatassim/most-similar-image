import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class gris extends JFrame {
 
	Traitement t;
	public gris(int T,String link) {
		
		String link2 = "/home/moatassim/IRDMTP/Textures/Textur"+0+".jpg";
	    t = new Traitement(link,link2,T);
		this.setTitle("Niveau de gris");
	    this.setSize(500,500);
	    this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
	    JPanel imgPane = new JPanel();
	    JButton btn = new JButton("Enregestrer La Photo");
	    JButton btn2 = new JButton("Texture");
	    imgPane.setSize(450,450);
	    JLabel background = new JLabel(new ImageIcon(((new ImageIcon(link2)).getImage()).getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
	    imgPane.add(background);
	    this.add(imgPane);
	    this.add(btn);
	    this.add(btn2);
	    btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File("/home/moatassim/IRDMTP/Images") ); 
				int retVal = jfc.showSaveDialog(null);
				if(retVal==JFileChooser.APPROVE_OPTION){
				    File f = jfc.getSelectedFile();
				    String test = f.getAbsolutePath()+".jpg";
				    
				   try {
					ImageIO.write(t.grey,"jpg",new File(test));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 }

				
			}
		});
			
			 
		}
	

	
	public static void main(String[] args) {
		
		gris gr = new gris(8,"/home/moatassim/IRDMTP/tiger.jpg");
		gr.setVisible(true);
		

	}

}
