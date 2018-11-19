import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;




public class testpar {
	

	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	        	System.out.println(fileEntry.getName());
	        }
	    }
	}

	

	public static void main(String[] args) {
		final File folder = new File("/home/moatassim/IRDMTP");
		listFilesForFolder(folder);
		try (BufferedReader br = new BufferedReader(new FileReader("/home/moatassim/IRDMTP/test.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		      System.out.println(Integer.parseInt(line)+1);
		    }
		}catch(Exception e){
			
		}

	}

}
