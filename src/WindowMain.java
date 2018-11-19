import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WindowMain extends JFrame {

	PanalStock panAjout;
	PanalCompare panCom;
	panalHisto panHisto;
	PanalNDG panNdg;
	
	
	public WindowMain(){
		
		this.setTitle("TP IRDM");
	    this.setSize(1010,750);
	    this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		
		panAjout = new PanalStock();
		panAjout.setVisible(false);
		this.add(panAjout);
		panAjout.setBounds(305, 20, 700, 700);
		
		panCom = new PanalCompare();
		panCom.setVisible(false);
		this.add(panCom);
		panCom.setBounds(305, 20, 700, 700);
		
		panHisto = new panalHisto();
		panHisto.setVisible(false);
		this.add(panHisto);
		panHisto.setBounds(305, 20, 700, 700);
		
		panNdg = new PanalNDG();
		panNdg.setVisible(false);
		this.add(panNdg);
		panNdg.setBounds(305, 20, 700, 700);
		
		
		
		panalChoice pan2 = new panalChoice();
		this.add(pan2);
		pan2.setBounds(0, 20, 300, 700);
		
	/*	pan2.AjouteImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panCom.setVisible(false);
				panAjout.setVisible(true);
				panNdg.setVisible(false);
				panHisto.setVisible(false);
				
			}
		});*/
		
		pan2.Histogramme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panAjout.setVisible(false);
				panCom.setVisible(false);
				panNdg.setVisible(false);
				panHisto.setVisible(true);
				
			}
		});
		
		pan2.CompareImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panAjout.setVisible(false);
				panNdg.setVisible(false);
				panHisto.setVisible(false);
				panCom.setVisible(true);
			}
		});
		
		pan2.NiveuDeGris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panAjout.setVisible(false);
				panCom.setVisible(false);
				panHisto.setVisible(false);
				panNdg.setVisible(true);
				
			}
		});
	}
		
		
	
		
	
	public static void main(String[] args) {
		
		WindowMain win = new WindowMain();
		win.setVisible(true);
		

	}

}
