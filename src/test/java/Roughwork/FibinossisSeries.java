package Roughwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FibinossisSeries {

	public static void main(String[] args) throws Exception , NumberFormatException {
		
		ArrayList<Integer> fibinosis = new ArrayList<Integer>();
		int numbers;
		String str2;
		InputStreamReader ip = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ip);
		System.out.println("enter the numbers with comma seperated and click enter key, if want to exist  enter 'x'");
	    String str = br.readLine();
	    StringTokenizer str1 = new StringTokenizer(str , ",");
	    while(str1.hasMoreTokens()){
	    	str2 = str1.nextToken();
	    	if((str2.equalsIgnoreCase("X"))){
	    	System.out.println("we  are to exit");
	    	break;
	    }
	    	numbers= Integer.parseInt(str2);
			fibinosis.add(numbers);
	    }
		if(fibinosis.size()== 0){
			System.out.println(" Sorry : No fibinosis for the series");
		}else {
			System.out.println("The size of the fibinossis array: " + fibinosis.size() + "\n" );
			System.out.println("before fibinossies series");
			for(int i:fibinosis){
				System.out.println(i);
			}
		}
		System.out.println("\n");
		fibbi(fibinosis);
	    }
	  
 // @ Method for fibinosis
	private static void fibbi(ArrayList<Integer> fibinosis) {
		int f = 0;;
		for(int indx = 0; indx<fibinosis.size();indx++)
		{
			if((fibinosis.size()!= 0)&& (fibinosis.size()== 1)){
				System.out.println("The fibinosis series" + fibinosis.get(indx));
			}else{
				 System.out.println("Upto the entered numbers from starting the calculated fibinossis series");
				 do{
					 f = f + fibinosis.get(indx);
					 System.out.println(f);
					 indx = indx+1; 
				 }while(indx<fibinosis.size());
				}
		}
	}

}

