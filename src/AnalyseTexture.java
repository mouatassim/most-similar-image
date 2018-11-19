import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class AnalyseTexture {
	
	private int [][]matriceCoOccurance1;
	private int [][]matriceCoOccurance90;
	private int [][]matriceCoOccurance45;
	private int [][]matriceCoOccurance135;
	private int[][] pic;

	private double energy;
	private double inertie;
	private double entropy;
	private double momntDifInv;
	
	
	
	

	public AnalyseTexture(int t,String s) {
		matriceCoOccurance1 = new int[t][t];
		matriceCoOccurance90 = new int[t][t];
		matriceCoOccurance45 = new int[t][t];
		matriceCoOccurance135 = new int[t][t];
		
		File image  = new File(s);
	
		BufferedImage img = null;
		
		int R = 256 / t;
		
		
		try {
			img = ImageIO.read(image);
			BufferedImage grey= new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_BGR);
			pic = new int[img.getWidth()][img.getHeight()];
		
			for (int i = 0; i < img.getWidth(); i++) {
				
				for (int j = 0; j < img.getHeight(); j++) {
					
					Color c = new Color(img.getRGB(i, j));
				    int r = c.getRed()/R;
					int b = c.getBlue()/R;
					int g = c.getGreen()/R;
				    int gr=(int) ((r*0.299)+(g*0.587)+(b*0.114));
					pic[i][j] = gr;
					
				}
				
			}
			
			
		}catch (Exception e2) {
		JOptionPane.showMessageDialog(null, "can't finde image");
		}
		

		initMatrice(matriceCoOccurance1, 0);
		initMatrice(matriceCoOccurance90, 0);
		initMatrice(matriceCoOccurance45, 0);
		initMatrice(matriceCoOccurance135, 0);
		
		matriceCoOccurance90=constCoOcur90(pic, matriceCoOccurance90);
		matriceCoOccurance1=constCoOcur1(pic, matriceCoOccurance1);
		matriceCoOccurance45=constCoOcur45(pic, matriceCoOccurance45);
		matriceCoOccurance135=constCoOcur135(pic, matriceCoOccurance135);
		
		setEnergy();
		setEntropy();
		setInertie();
		setMomntDifInv();
		/*
		afficheMatrice(pic);
		System.out.println("\nSort 1\n");
		
		afficheMatrice(matriceCoOccurance1);
		System.out.println("\nSort 90\n");
		
		afficheMatrice(matriceCoOccurance90);
		System.out.println("\nSort 45\n");
		
		afficheMatrice(matriceCoOccurance45);
		System.out.println("\nSort 135\n");
		
		afficheMatrice(matriceCoOccurance135);
		System.out.println("\n");
		
		// la partie 2.2
		
		System.out.println("\n");
		
		System.out.println("\n");
		System.out.println("L'energie de matrice de co-occurance est "+energy);
		System.out.println("L'inerti de matrice de co-occurance est "+inertie);
		System.out.println("L'entropy de matrice de co-occurance est "+entropy);
		System.out.println("Le moment differentiel inverse de matrice de co-occurance est "+momntDifInv);
		System.out.println("\n");
		*/
	}
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
	
	
	
	
	
	public int[][] getMatriceCoOccurance1() {
		return matriceCoOccurance1;
	}
	
	
	
	public int[][] getMatriceCoOccurance90() {
		return matriceCoOccurance90;
	}
	
	
	
	
	public int[][] getMatriceCoOccurance45() {
		return matriceCoOccurance45;
	}
	
	public int[][] getMatriceCoOccurance135() {
		return matriceCoOccurance135;
	}

	
	public int[][] getPic() {
		return pic;
	}
	
	
	public double getEnergy() {
		return energy;
	}

	public double getInertie() {
	 return inertie;
	}
	
	
	
	public double getEntropy() {
		return entropy;
	}
	
	
	
	public double getMomntDifInv() {
		return momntDifInv;
	}
	
	
	
	public void setEnergy() {
		double energy0=calcEnergy(getMatriceCoOccurance1());
		double energy90=calcEnergy(getMatriceCoOccurance90());
		double energy45=calcEnergy(getMatriceCoOccurance45());
		double energy135=calcEnergy(getMatriceCoOccurance135());
		energy = (energy0+energy45+energy90+energy135)/4;	
	}
	public void setInertie() {
		double inertie0= calcInertie(getMatriceCoOccurance1());
		double inertie90= calcInertie(getMatriceCoOccurance90());
		double inertie45= calcInertie(getMatriceCoOccurance45());
		double inertie135= calcInertie(getMatriceCoOccurance135());
		this.inertie= (inertie0+inertie90+inertie45+inertie135)/4;
	}
	public void setEntropy() {
		double entropy0 = calcEntropy(getMatriceCoOccurance1());
		double entropy90 = calcEntropy(getMatriceCoOccurance90());
		double entropy45 = calcEntropy(getMatriceCoOccurance45());
		double entropy135 = calcEntropy(getMatriceCoOccurance135());
		this.entropy = (entropy0+entropy135+entropy45+entropy90)/4;
	}
	public void setMomntDifInv() {

		double momntDifInv0 = calcDifInv(getMatriceCoOccurance1());
		double momntDifInv90 = calcDifInv(getMatriceCoOccurance90());
		double momntDifInv45 = calcDifInv(getMatriceCoOccurance45());
		double momntDifInv135 = calcDifInv(getMatriceCoOccurance135());
		this.momntDifInv = (momntDifInv0+momntDifInv135+momntDifInv45+momntDifInv90)/4;
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



private double calcEnergy(int[][] constCoOcur) {
	double temp = 0;
	for (int i = 0; i < constCoOcur.length; i++) {
		for (int j = 0; j < constCoOcur[0].length; j++) {
			temp += Math.pow(constCoOcur[i][j], 2);
		}
	}
	return temp;
}

private double calcEntropy(int[][] constCoOcur) {
	double temp = 0;
	for (int i = 0; i < constCoOcur.length; i++) {
		for (int j = 0; j < constCoOcur[0].length; j++) {
			if (constCoOcur[i][j] != 0) {
				temp += (constCoOcur[i][j] * Math.log10(constCoOcur[i][j])) * -1;
			}
		}
	}
	return temp;
}
 
private double calcInertie(int[][] constCoOcur) {
	double temp = 0;
	for (int i = 0; i < constCoOcur.length; i++) {
		for (int j = 0; j < constCoOcur[0].length; j++) {
			temp += (constCoOcur[i][j] * (Math.pow(i-j, 2)));
		}
	}
	return temp;
}
	
private double calcDifInv(int[][] constCoOcur) {
	double temp = 0;
	for (int i = 0; i < constCoOcur.length; i++) {
		for (int j = 0; j < constCoOcur[0].length; j++) {
		temp += (1/(1+(constCoOcur[i][j] * (Math.pow(i-j, 2)))));
		}
	}
	return temp;
}
	
	
	
	
	public static void main(String[] args) {
		
		AnalyseTexture img1 = new AnalyseTexture(8,"/home/moatassim/IRDMTP/chat.jpg");
		AnalyseTexture img2 = new AnalyseTexture(8,"/home/moatassim/IRDMTP/chat.jpg");
		
		 double distEnergy;
 		distEnergy= Math.abs((img1.getEnergy() - img2.getEnergy())/img1.getEnergy());
 		System.out.println(distEnergy);
 		
 		
 		double distInertie;
 		distInertie= Math.abs((img1.getInertie() - img2.getInertie())/img1.getInertie());
 		System.out.println(distInertie);
 		
 		double distEntropy;
 		distEntropy= Math.abs((img1.getEntropy() - img2.getEntropy())/img1.getEntropy());
 		System.out.println(distEntropy);
 		
 		double distMonmndif;
 		distMonmndif= Math.abs((img1.getMomntDifInv() - img2.getMomntDifInv())/img1.getMomntDifInv());
 		System.out.println(distMonmndif);
 		
 		double distTot = (distEnergy+distEntropy+distInertie+distMonmndif)/4;
 		System.out.println(distTot);
		
		
		

	}

}
