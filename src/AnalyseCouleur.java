import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.*;

  

public class AnalyseCouleur {
	
	ArrayList redList = new ArrayList();
	ArrayList bleuList = new ArrayList();
	ArrayList greenList = new ArrayList();
	
	int[] plageRouge  = new int[32];
	int[] plageBleu  = new int[32];
	int[] plageVert  = new int[32];
    int sommeHistoRouge = 0;
	int sommeHistoBleu = 0;
	int sommeHistoVert =0;
	 int  red = 0;
     int  vert = 0;
     int  bleu = 0;
     int r;
     int g;
     int b;
	
	
	
	public AnalyseCouleur(String s) {
		
		File image  = new File(s);
		
		 
		 for (int i = 0 ;i < plageRouge.length;i++){
			 plageRouge[i]=0;
		 }
		 for (int i = 0 ;i < plageBleu.length;i++){
			 plageBleu[i]=0;
		 }
		 for (int i = 0 ;i < plageVert.length;i++){
			 plageVert[i]=0;
		 }
			
			
			BufferedImage img = null;
			
			
				
				try {
					img = ImageIO.read(image);
					img = resize(img, 16, 16);
				
				
				
				
				for (int i = 0; i < img.getWidth(); i++) {
					for (int j = 0; j < img.getHeight(); j++) {
						Color c = new Color(img.getRGB(i, j));
						
						 int r = c.getRed()/8;
						tri(r, plageRouge);
						
						
						red=red+r;
						redList.add(""+r);
						 int b = c.getBlue()/8;
						tri(b,plageBleu);
						bleuList.add(""+b);
						bleu=bleu+b;
						int g = c.getGreen()/8;
						tri(g,plageVert);
						greenList.add(""+g);
						vert = g +vert;
						
						
					}
				}
				
				
			    int total = (red + bleu +vert);
				double perRed= (red)*100/total;

				float perBlue= (bleu)*100/total;
				float perGreen= (vert)*100/total;
				
				 for (int i = 0 ;i < plageRouge.length;i++){
					 //System.out.println("plage :"+i+ " ===== > nbrPixels (rouge) = "+plageRouge[i]+" nbrPixels (bleu) = "+plageBleu[i]+" nbrPixels (vert)= "+plageVert[i]);
					 sommeHistoRouge=sommeHistoRouge+plageRouge[i];
					 sommeHistoBleu=sommeHistoBleu+plageBleu[i];
					 sommeHistoVert=sommeHistoVert+plageVert[i];
					// System.out.println(red+"   "+bleu+"   "+vert);
				 }
				
				/*System.out.println("================pourcentage=====================");
				System.out.println("");
				System.out.println("red ="+perRed+"%      blue = "+perBlue+"%       green= "+perGreen+"%");
				System.out.println();*/
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
				
			       	
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
	


public void tri(int note ,int[]v){
		
		for (int i = 0; i < v.length; i++) {
	
			if (i==note){
				v[i]++;
				
			}
			}
		}


	
	
	public static void main(String[] args) {
		AnalyseCouleur t2 = new AnalyseCouleur("/home/moatassim/IRDMTP/goko.jpg");
		
	}


	
}