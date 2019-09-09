import java.io.*;
import java.util.regex.*; 

class Normalizer
{ 

    public static void main(String args[]){ 

        //String fileName = "F-train146.txt";
        String fileName = "test.txt";
        String line = null;
        String allText = "";
        

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

        	   System.out.println(line);
   
        	   String str = RemoveDuplicates(line);
               StringBuilder sb = new StringBuilder(str);
               System.out.println(sb.reverse().toString());
        	

            	System.out.println("\n");
            	
                allText = allText.concat(line+" ");
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }        

        //System.out.println(allText); 
        
    } 


    private static String RemoveDuplicates(String str) {
	    String outputString = new StringBuilder(str).reverse().toString();
		//outputString = outputString.replaceAll("(.)(?=.*\\1)", "");    
        //remove dublicates, replace them with empty string
        outputString = outputString.replaceAll("(?i)(a|e|i|o|u)(?i)(?=(a|e|i|o|u)+\\1)", "");
	    return outputString; 
	}
} 
