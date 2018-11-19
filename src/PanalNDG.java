import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PanalNDG extends JPanel {
	static String link1;
	static String link2;
	
	
	   
	
	 JButton image1 ;
	 String nv[] ={"1","8","16","24","32"}; 
	 JComboBox Textu;
	 JLabel l1;
	
	
	JButton blog = new JButton(new ImageIcon(((new ImageIcon("/home/moatassim/IRDMTP/button.png")).getImage()).getScaledInstance(220, 90, java.awt.Image.SCALE_SMOOTH)));
	
	 public PanalNDG(){
		
		int i=700;
		int j=700;
		this.setSize(j,i);
		this.setLayout(null);
		
		
		/********************************/
		
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		Textu = new JComboBox(nv);
		
		image1= new JButton("choisé une image");
		
		
		
		
		blog.setBounds(165,500, 340, 120);
		blog.setBackground(Color.WHITE);
		blog.setBorderPainted(false);
		
		
		Textu.setBounds(230,50, 200, 35);
		image1.setBounds(230,170, 200, 35);
		
		  
		 l1 = new JLabel();
		 l1.setBounds(210,250, 240, 240);
		 
		
		
		
		this.add(image1);
		this.add(Textu);
		this.add(blog);
		this.add(l1);
		
		
		image1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 JFileChooser fileChooser = new JFileChooser(); 
			       fileChooser.setCurrentDirectory(new File("/home/moatassim/IRDMTP/") ); 
			       String[] values={"image","jpg","png","gif", "ico" };
			       FileNameExtensionFilter filter = new FileNameExtensionFilter(null,values);  
			       fileChooser.addChoosableFileFilter(filter);
			       int result = fileChooser.showSaveDialog(null);
			       
			       if(result == JFileChooser.APPROVE_OPTION) 
			        { 
			            File selectedfile = fileChooser.getSelectedFile(); 
			            link1 = selectedfile.getAbsolutePath();
			            ImageIcon matof = new ImageIcon (link1);
			            Image tof = matof.getImage(); 
			            Image nouvelletof = tof.getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_SMOOTH);
			            ImageIcon dernieretof = new ImageIcon(nouvelletof);
			            l1.setIcon(dernieretof);
			}
			}});
		
		blog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				gris gr = new gris(Integer.parseInt((Textu.getSelectedItem().toString())), link1);
				gr.setVisible(true);
			}
		});
		
		
	}
	
	
	

	

}
