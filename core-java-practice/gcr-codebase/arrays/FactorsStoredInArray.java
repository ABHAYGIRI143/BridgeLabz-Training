
import java.util.*;
public class FactorsStoredInArray {

	public static void main(String[] args) {
		
		  //create a scanner object
		  Scanner sc = new Scanner(System.in);
	        
	        //take a number as input
	        int number = sc.nextInt();
	        
	        //initialize an array to store factors
	        int factors[] = new int[number/2];
	        int index = 0;//for track the index
	        
	        if (number <= 0) {
	            System.out.println("Please enter a positive integer.");

	        }
	        
	     
	        for (int i = 1; i <= number; i++) {
	            if (number % i == 0) {
	             factors[index] = i;
	             index++;
	            }
	        }
	        
	        
	        //show the output
	        System.out.println("The factos of the number "+number +" are ");
	        for(int i=0 ; i<index ; i++) {
	        	System.out.println(factors[i]);;
	        }

	        //close the scanner object
	        sc.close();

	}

}
