package Roughwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringReverse {

	public static void main(String[] args) throws IOException 
{
       String rev1 = "";
       InputStreamReader ip = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(ip);
       System.out.println("Enter the string to reverse");
       String s = br.readLine();
       if(s.length()!=0){
    	   for(int rev = s.length()-1; rev>=0 ; rev--){
    		    rev1 = rev1 + s.charAt(rev);  
    	   }
       }
	   
		System.out.println( " The reverse of the string:  " + rev1);
}
}
