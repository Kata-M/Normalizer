import java.io.*;
import java.util.regex.*; 

class Normalizer
{ 
    // Your program begins with a call to main(). 
    // Prints "Hello, World" to the terminal window. 
    public static void main(String args[]){ 
        
 
        System.out.println("\n"); 

        //String fileName = "F-train146.txt";
        String fileName = "test.txt";

        // This will reference one line at a time
        String line = null;
        String allText = "";
        

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
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
            // Or we could just do this: 
            // ex.printStackTrace();
        }        

        //System.out.println(allText); 
        
    } 


    private static String RemoveDuplicates(String str) {
	   // String str = "aaabbbccc";
	    String outputString = new StringBuilder(str).reverse().toString();
		// outputString is now hiah
		//outputString = outputString.replaceAll("(.)(?=.*\\1)", "");
		//outputString = outputString.replaceAll("(o)(?=o+\\1)", "Ö");
      
        outputString = outputString.replaceAll("(?i)(a|e|i|o|u)(?i)(?=(a|e|i|o|u)+\\1)", "Ö");
        
		

		
		//(?i)a{3,}|(?i)e{3,}|(?i)i{3,}|(?i)o{3,}|(?i)u{3,}
	    //String filtered = str.replace(/[^\w\s]|(.)\1/gi, ""); 
	    return outputString; 
	}
} 
