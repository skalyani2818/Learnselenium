package Roughwork;

public class Accessmodifiertesting extends Accessmodifier{

	public static void main(String[] args) {
		
		 int a =10;
		 int b = 20;
		 int c = 80;
		
		 Accessmodifiertesting ac = new Accessmodifiertesting();
		 ac.getmethod1();
		 int sum = ac.sum4(a,b);
		 int d = ac.sum2(a,b,c);
		 System.out.println(sum);
		 System.out.println(d);
		 int df = ac.sum1(a, b, c);
		 System.out.println("......" + df);
	}

		
	  public void getmethod1()
	   {
	   
			System.out.println("i am in the get Accessmodifiertesting method");
	   }
	 	
      private int sum4(int a , int b){
    	System.out.println("I am in the Accessmodifiertestingtesting sum4");
		return a+b;
    	  
      }
      
      protected int sum2(int a , int b ,int c){
    	  System.out.println("I am in the Accessmodifiertestingtesting sum2");
  		return a+b+c;
      	  
        }

	}

	


