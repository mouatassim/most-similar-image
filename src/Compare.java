import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class Compare {

	/**
	 * @param args
	 */
	

	static double [] distancesT;
	static double [] distancesC;
	String imgSimilair;
	static String [] imgs;
	
	double distRouge=0.000,distBleu=0.000,distVert=0.000;
	double resultatTotalBast,resultatTotalMakam,distance;
	double distanceTot;
	
	public Compare(String s) {
		
		AnalyseCouleur tr1 = new AnalyseCouleur(s);
		
		
		
		AnalyseCouleur tr2;
		AnalyseTexture img2 ;
		AnalyseTexture img1 = new AnalyseTexture(16,s);
		String link2;
		
		Query q = new Query();
		Query c = new Query();
		c.slecting("select count(*) from imageInfo;");
		try{
			while(c.rs.next()){
				
				distancesT = new double[c.rs.getInt(1)];
				distancesC = new double[c.rs.getInt(1)];
			    imgs = new String[c.rs.getInt(1)];
		
			}
		}catch(Exception e){
			
		}
		q.slecting("select * from imageInfo;");
		
		int k = 0;

        try {
            while(q.rs.next()){
            	
                
                link2=q.rs.getString(2);
                img2=new AnalyseTexture(16, link2);
                tr2= new AnalyseCouleur(link2);
                
                for (int i = 0; i < tr1.greenList.size(); i++) {
     	    	   distVert=distVert + Math.abs(Integer.parseInt(tr1.greenList.get(i).toString())-Integer.parseInt(tr2.greenList.get(i).toString()));
     		}
     	       
     	       System.out.println(distVert);
     	       
     	       
     	       for (int i = 0; i < tr1.bleuList.size(); i++) {
     	    	   distBleu=distBleu + Math.abs(Integer.parseInt(tr1.bleuList.get(i).toString())-Integer.parseInt(tr2.bleuList.get(i).toString()));
     		}
     	       
     	       System.out.println(distBleu);
     	       
     	       
     	       
     	       for (int i = 0; i < tr1.redList.size(); i++) {
     	    	   distRouge=distRouge + Math.abs(Integer.parseInt(tr1.redList.get(i).toString())-Integer.parseInt(tr2.redList.get(i).toString()));
     		}
     	       
     	     //  System.out.println(distRouge);
     	       resultatTotalBast=distBleu+distRouge+distVert;
     	        distBleu =0;
     	        distRouge = 0;
     	        distVert = 0;

     	      
    
     	       resultatTotalMakam=tr1.bleu+tr1.red+tr1.vert;
     	       
     	       distance=resultatTotalBast/resultatTotalMakam;
     	       
                
                imgs[k]=link2;
                distancesC[k]=distance;
                
                double distEnergy;
        		distEnergy= Math.abs((img1.getEnergy() - q.rs.getDouble(3))/img1.getEnergy());
        		
        		
        		double distInertie;
        		distInertie= Math.abs((img1.getInertie() - q.rs.getDouble(4))/img1.getInertie());
        		
        		
        		double distEntropy;
        		distEntropy= Math.abs((img1.getEntropy() - q.rs.getDouble(5))/img1.getEntropy());
        		
        		
        		double distMonmndif;
        		distMonmndif= Math.abs((img1.getMomntDifInv() - q.rs.getDouble(6))/img1.getMomntDifInv());
        		
        		
        		double distance2 = (distEnergy+distEntropy+distInertie+distMonmndif)/4;
         		
         		
         		distancesT[k]=distance2;
         		
         		double poids = 0.5;
         		
         		distanceTot = poids*distance + (1-poids)*distance2;
         		
         		System.out.println("la distance total ="+distanceTot);
         		
         		k++;
         		
            }
        } catch (Exception e) {
            System.out.println("Error!! ");
        }
		
	    String imgSimilair1=imgs[0];
		double distMin= distancesT[0];
        for (int j = 1; j < imgs.length; j++) {
			
        	if (distMin > distancesT[j]){
        		
        		distMin=distancesT[j];
        		imgSimilair1=imgs[j];
        		
        	}
			
			
		}
		
        setImgSimilair(imgSimilair1);
        System.out.println("the goal is to get "+getImgSimilair());

	}
	
	public void setImgSimilair(String imgSimilair) {
		this.imgSimilair = imgSimilair;
		
	}
	
	public String getImgSimilair() {
		return imgSimilair;
	}


}
