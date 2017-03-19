//this does blah
import java.io.*;

public class DNAproject
{
    public static void main (String [] args)
    {
    	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println ("Hello, welcome to laugh checker. Please enter your file name with the DNA");
        String fileName = null;
        try
        {
        	 fileName=br.readLine();
        	 System.out.println (fileName);
            
        }
        catch (IOException E)
        {
        }
//        File file = new File (System.getProperty("uder.dir"))
        String DNA = null;
        try
        {
        	System.out.println ("Hi");
            DNA=readFileAsString(fileName);
            System.out.println ("Hi");
        }
        catch (IOException E)
        {
        }
        System.out.println (DNA);

        int count=0;

        System.out.println (DNA.length());
        for (int index=0; index<DNA.length()-7; index++)
        {
            System.out.println (DNA.substring (index, index+7));
            System.out.println (DNA.substring (index, index+7).equals("GATTACA"));
            if (DNA.substring (index, index+7).equals("GATTACA"))
            {
                count++;
            }
            System.out.println (count); 
        }

        System.out.println (count);   
    }

     static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }

}

