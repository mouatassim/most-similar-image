import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.*;

  

public class Traitement {
	
	ArrayList redList = new ArrayList();
	ArrayList bleuList = new ArrayList();
	ArrayList greenList = new ArrayList();
	
	int [][]matriceCoOccurance1 = new int[8][8];
	int [][]matriceCoOccurance90 = new int[8][8];
	int [][]matriceCoOccurance45 = new int[8][8];
	int [][]matriceCoOccurance135 = new int[8][8];
	int[][] pic;
	
	static BufferedImage grey;

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
	
	
	
	public Traitement(String s, String s1,int T) {
		
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
					img = resize(img, 300, 300);
					grey= new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_BGR);
				
				    
				
				for (int i = 0; i < img.getWidth(); i++) {
					for (int j = 0; j < img.getHeight(); j++) {
						Color c = new Color(img.getRGB(i, j));
						
						 int r = c.getRed();
					
						
						
						red=red+r;
						redList.add(""+r);
						 int b = c.getBlue();
					
						bleuList.add(""+b);
						bleu=bleu+b;
						int g = c.getGreen();
						
						greenList.add(""+g);
						vert = g +vert;
						
						 int gr=(int) ((r*0.299)+(g*0.587)+(b*0.114));
						 int nvGris=gr/T;
							Color gColor = new Color(nvGris,nvGris,nvGris);
							grey.setRGB(i, j, gColor.getRGB());
							//pic[i][j] = nvGris;
						
						
					}
				}
				
				ImageIO.write(grey, "jpg", new File(s1));
			    int total = (red + bleu +vert);
				

				
				
				
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
	}
	
void initMatrice(int[][] matrice,int valInit){
		
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[0].length; j++) {
				matrice[i][j]=valInit;
			}
			
		}
		
	}
	
	void afficheMatrice(int[][] matrice){

		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[0].length; j++) {
				System.out.print(matrice[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	int[][] constCoOcur90(int[][] matrice ,int[][] matricecoOcur1){

		for (int i = 0; i < matrice.length-1; i++) {
			for (int j = 0; j < matrice[0].length; j++) {
				matricecoOcur1[matrice[i][j]][matrice[i+1][j]]=matricecoOcur1[matrice[i][j]][matrice[i+1][j]]+1;
			}
							
		}
		for (int i = matrice.length-1; i > 0; i--) {
			for (int j = matrice[0].length-1; j >= 0; j--) {
				matricecoOcur1[matrice[i][j]][matrice[i-1][j]]=matricecoOcur1[matrice[i][j]][matrice[i-1][j]]+1;
				
			}
			
		}
		return matricecoOcur1;
}

int[][] constCoOcur1(int[][] matrice ,int[][] matricecoOcur1){

	for (int i = 0; i < matrice.length; i++) {
		for (int j = 0; j < matrice[0].length-1; j++) {
			matricecoOcur1[matrice[i][j]][matrice[i][j+1]]=matricecoOcur1[matrice[i][j]][matrice[i][j+1]]+1;
		}
						
	}
	for (int i = matrice.length-1; i >=0; i--) {
		for (int j = matrice[0].length-1; j > 0; j--) {
			matricecoOcur1[matrice[i][j]][matrice[i][j-1]]=matricecoOcur1[matrice[i][j]][matrice[i][j-1]]+1;
			
		}
		
	}
	return matricecoOcur1;
}


int[][] constCoOcur45(int[][] matrice ,int[][] matricecoOcur45){

	for (int i = 0; i < matrice.length-1; i++) {
		for (int j = 1; j < matrice[0].length; j++) {
			matricecoOcur45[matrice[i][j]][matrice[i+1][j-1]]=matricecoOcur45[matrice[i][j]][matrice[i+1][j-1]]+1;
		}
						
	}
	for (int i = matrice.length-1; i >0; i--) {
		for (int j = 0; j <  matrice[0].length-1; j++) {
			matricecoOcur45[matrice[i][j]][matrice[i-1][j+1]]=matricecoOcur45[matrice[i][j]][matrice[i-1][j+1]]+1;
			
		}
		
	}
	return matricecoOcur45;
}


int[][] constCoOcur135(int[][] matrice ,int[][] matricecoOcur135){

	for (int i = 0; i < matrice.length-1; i++) {
		for (int j = 0 ; j < matrice[0].length-1; j++) {
			matricecoOcur135[matrice[i][j]][matrice[i+1][j+1]]=matricecoOcur135[matrice[i][j]][matrice[i+1][j+1]]+1;
		}
						
	}
	for (int i = matrice.length-1; i >0; i--) {
		for (int j = matrice[0].length-1; j > 0; j--) {
			matricecoOcur135[matrice[i][j]][matrice[i-1][j-1]]=matricecoOcur135[matrice[i][j]][matrice[i-1][j-1]]+1;
			
		}
		
	}
	return matricecoOcur135;
}	
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
	

		
		
	
	
	public static void main(String[] args) {
		//Traitement t = new Traitement("/home/moatassim/IRDMTP/goko.jpg","/home/moatassim/IRDMTP/Textur.jpg");
	}


	
}
