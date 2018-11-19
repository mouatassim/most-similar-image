
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.experimental.chart.plot.CombinedCategoryPlot;



 
public class PanalHisto extends JPanel {
	
 static AnalyseCouleur traitement;
	
     static String lien;
	
	
    public PanalHisto(String link) {
       
    	lien = link;
    	
    	
        this.setSize(200,200);
        this.setLayout(new FlowLayout());
        
        JPanel histoPane = new JPanel();
        histoPane.setSize(300,300);
        JFreeChart chart = createChart();
        ChartPanel ch = new ChartPanel(chart);
        histoPane.add(ch);  
        
    	JPanel imgPane = new JPanel();
    	imgPane.setSize(300,300);
    	JLabel background = new JLabel(new ImageIcon(((new ImageIcon(link)).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
      	imgPane.add(background);
        
        this.add(imgPane);
        this.add(histoPane);
        
        
        
    }

  
    
    
    public static CategoryDataset createDataset1() {
    	
    	
    	traitement = new AnalyseCouleur(lien);
    	
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        String series1 = "rouge";
        String series2 = "bleu";
        String series3 = "vert";
        
      
        
        int k = traitement.plageBleu.length;
        
         
         
         for (int i = 0; i < k; i++) {
         	result.addValue(traitement.plageRouge[i], series1, ""+i);
         
 		}
         
         for (int i = 0; i < k; i++) {
        	 result.addValue(traitement.plageBleu[i], series2, ""+i);
        	
		}
       
        for (int i = 0; i < k; i++) {
        	result.addValue(traitement.plageVert[i], series3, ""+i);
        	
		}
        
       
        return result;
    }


     
    private static JFreeChart createChart() {
    	
    	

        CategoryDataset dataset1 = createDataset1();
        NumberAxis rangeAxis1 = new NumberAxis("Value");
        rangeAxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
        renderer1.setBaseToolTipGenerator(
                new StandardCategoryToolTipGenerator());
        CategoryPlot subplot1 = new CategoryPlot(dataset1, null, rangeAxis1,
                renderer1);
        subplot1.setDomainGridlinesVisible(true);

     
        NumberAxis rangeAxis2 = new NumberAxis("Value");
        rangeAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer2 = new BarRenderer();
        renderer2.setBaseToolTipGenerator(
                new StandardCategoryToolTipGenerator());
   

        CategoryAxis domainAxis = new CategoryAxis("plage de couleur");
        CombinedCategoryPlot plot = new CombinedCategoryPlot(
                domainAxis, new NumberAxis("nombre de pixel"));
        plot.add(subplot1, 2);
    

        JFreeChart result = new JFreeChart(
                "Histogramme de couleurs RVB",
                new Font("SansSerif", Font.BOLD, 12), plot, true);
        return result;

    }
    
   
   
   
}
