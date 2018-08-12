
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;  
import java.util.*;

class demo {

        
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);
	   
        FileOutputStream fOut= new FileOutputStream("temp_mon.txt");    ///   output file were data is stored
		ArrayList<String> al=new ArrayList<String>();
		try {
           FileInputStream fis = new FileInputStream("temp.txt");    ///   input file were data is fed
           BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
          
            System.out.println("Reading File line by line using BufferedReader");
          
            String line = reader.readLine();
			String moun="";
			//int line
            while(line != null){
				
				if(line.contains(".json")){
					String temp1=line.substring(line.indexOf("\\segments\\seg")+10,line.indexOf(".sm\\"));
					   if(temp1.equals(moun)){
						   temp1="";
					   }
					   else{
						   moun=temp1;
					   }
					   line=temp1+"\t"+line.substring(line.indexOf(".sm\\")+4,line.indexOf(".json"))+"\n";
						fOut.write(line.getBytes());
				}
                line = reader.readLine();
			
            }   
				
          
        }catch(Exception e){System.out.println(e);}    
    }
}
