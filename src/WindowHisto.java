import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;


public class WindowHisto extends JFrame {

	
	
	public WindowHisto(String s) {
		
		
		PanalHisto photo1 = new PanalHisto(s);
		
		AnalyseCouleur t1 = new AnalyseCouleur(s);
		
		
      
		this.setTitle("Histogramme");
		this.setSize(950,500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.add(photo1);
		
		
        
       
     
	}
	
	public static void main(String[] args) {
	 WindowHisto fn = new WindowHisto("/home/moatassim/IRDMTP/goko.jpg");
	 fn.setVisible(true);
	 }
	

	
}
