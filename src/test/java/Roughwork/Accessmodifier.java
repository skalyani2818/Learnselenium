package Roughwork;

public class Accessmodifier {

	public static void main(String[] args) {
		
		 int a =10;
		 int b = 20;
		 int c = 40;
		
		 Accessmodifier ac = new Accessmodifier();
		 ac.getmethod();
		 int sum = ac.sumaccess(a,b);
		 int d = ac.sum1(a,b,c);
		 System.out.println(sum);
		 System.out.println(d);
	}

		
	  public void getmethod()
	   {
	   
			System.out.println("i am in the get method");
	   }
	 	
      private int sumaccess(int a , int b){
    	
		return a+b;
    	  
      }
      
      protected int sum1(int a , int b ,int c){
      	
  		return a+b+c;
      	  
        }

	}

	


