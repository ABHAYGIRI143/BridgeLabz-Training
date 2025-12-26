import java.util.*;

public class FactorsAndOperation {

	public static void main(String[] args) {
	
		//Create Scanner object
		Scanner sc = new Scanner(System.in);
		
		//Get a user input(number)
		int number = sc.nextInt();
		
		int factorArray []	= factor(number);
		int greatestfactor = greatest(factorArray);
		int factorsSum = sumFactor(factorArray); 
		int factorsMultiplication= multiplicationOfFactor(factorArray); 
		int factorsCube= multiplicationOCubeOffFactor(factorArray); 
		
		
		System.out.println("factors for number "+number +" are "+Arrays.toString(factorArray));
		System.out.println("Greatest factor for number "+number +" is "+greatestfactor);	
		System.out.println("The sum of the factors is "+ factorsSum);
		System.out.println("The multiplication of the factors is "+ factorsMultiplication);
		System.out.println("The multiplication of cube the factors is "+ factorsCube);
	
		//close the scanner object
		sc.close();
	}
	
	
	public static int[] factor(int num) {

		int  arr[] = new int[num/2];
		int index=0;
		 for (int i = 1; i <= num; i++) {
	            if (num % i == 0) {
	               arr[index++] = i;
	            }
	        }

		 return arr;
 	}
	
	public static int greatest(int factors[]) {
		
		int max = Integer.MIN_VALUE;
		
		for(int num:factors) {
			if(num>max) max=num;
		}
		
		return max;
	}

	
	public static int sumFactor(int factors[]) {
		
		int sum =0;
		for(int factor : factors) {
			
			sum+=factor;
		}
		
		return sum;
	}
	
	public static int  multiplicationOCubeOffFactor(int factors[]) {
		
		int multiply =1;
		for(int factor : factors) {
			
			multiply*=Math.pow(factor,3);
		}
		
		return multiply;
	}
	
	public static int multiplicationOfFactor(int factors[]) {
		
		int multiply =1;
		for(int factor : factors) {
			
			multiply*=factor;
		}
		
		return multiply;
	}
}
