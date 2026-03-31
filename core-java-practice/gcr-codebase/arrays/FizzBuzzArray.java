
import java.util.*;
public class FizzBuzzArray {

	public static void main(String[] args) {	
		
		 //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take the number as input
        int n = sc.nextInt();

        //initialize an array to store the output
        String result[] = new String[n];
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        }

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
            	result[i-1]="fizzbuzz";
            }
            
            else if (i % 3 == 0) {
            	result[i-1]="fizz";
            }
           
            else if (i % 5 == 0) {
            	result[i-1]= "buzz";
            }
            
            else {
            	result[i-1]=""+i;
            };
        };
		
        //print the output
        for(int i=1; i<=n ;i++) {
        	System.out.println(i+" "+result[i-1]);
        }
		
		//close the scanner object
		sc.close();
	}

}
