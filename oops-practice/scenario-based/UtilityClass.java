
class Math2{
	
	static  int factorial(int number){
		int fact = 1;
		 
		if(number<0) {
			 System.out.println("Number Should be larger tha 0");
			 return -1 ;
		 }
		
		for(int i = 1; i<=number ; i++) {
			fact *= i;
		}
		
		return fact;
	}
	

	static  boolean prime(int number){
		 
		if(number<0) {
			 System.out.println("Number Should be larger tha 0");
			 return false ;
		 }
		
		if(number % 2==0 || number%3==0) {
			return false;
		}
		
		for(int i = 4; i*i<=number ; i++) {
		
			if(number%i ==0) return false;
		}
		
		return true;
	}
	
	 static int fibonacci(int number) {
		 
		 int a=0; // 1st number of fibonacci series
		 int b=1; // 1st number of fibonacci series
		 
		 while(number!=0) {
			 int temp =a+b;
			 a=b;
			 b=temp;
			 number--;
		 }
		 return b;
	 }
}

public class UtilityClass {
	public static void main(String args[]) {
		int fibo4 = Math2.fibonacci(4);
		System.out.println(fibo4);
		
		boolean prime13=Math2.prime(12);
		System.out.println(prime13);
		
	}
}
