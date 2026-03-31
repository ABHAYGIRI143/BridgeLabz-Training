
import java.util.*;
public class SumOfNumbers {

	public static void main(String[] args) {
		
		//create the scanner object
		Scanner sc = new Scanner(System.in);
		
		int numbers[] = new int[10];
		
		int count=0;// count variable is to used track the no. of numbers
	
		//take user input until we get 0 or negative number
		while(true) {
			int n = sc.nextInt();
			
			if( n<=0 || count==10) break;
			
			numbers[count] = n;
			count++;
			
		}
		
		int sum = 0; //calculate the sum of the array;
		
		for(int i = 0; i<count ; i++) {
			sum+=numbers[i];
			System.out.println(numbers[i]);
		}
		
		System.out.println(sum);
		
		
		//close the scanner object
		sc.close();
		
	}

}
