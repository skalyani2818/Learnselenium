package Roughwork;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AscendingOrder {

	public static void main(String[] args) throws Exception {
		
		  //@ declaring the variables
		   String totSize;
		   int sizearray = 0;
		  BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		  System.out.println("Please enter the total size of the array you required");
		  totSize = br.readLine();
		  sizearray = Integer.parseInt(totSize);
		  int[] arrayunsort = new int[sizearray];
		 
		  System.out.println("Please inter the elements in the array");
		  for(int indx = 0; indx < sizearray; indx++)
		  {
			  int number = Integer.parseInt(br.readLine());
			  arrayunsort[indx] = number;
		  }
         //  @ showing the elements in the array
		  System.out.println( " The elements in the array are:");
		  for(int i : arrayunsort)
		  {
			  System.out.println( i);
		  }
		  
		  //@ sorting of the array elements
		  sortarray(arrayunsort);
	}

	public static void sortarray(int[] arrayunsort) {
		

	}
	}
