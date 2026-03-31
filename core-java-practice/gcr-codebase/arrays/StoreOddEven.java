
import java.util.*;
public class StoreOddEven {

	public static void main(String[] args) {		// TODO Auto-generated method stub

		//create the scanner object
		Scanner sc = new Scanner(System.in);

		//take user input
		int n = sc.nextInt();
		
		//initialize array to store even and odd number btw 1 to n(user input)
		int even[] = new int[n/2+1];
		int odd[] = new int[n/2+1];
		
		//initialize two variable to track the even odd index
		int trackEven=0;
		int trackOdd=0;
		//store the number in an respected array
		for(int i=1 ; i<n ; i++) {
	
			if(i%2==0) {
				even[trackEven] = i;
				trackEven++;
			}
			
			else {
				odd[trackOdd] = i;
				trackOdd++;
			}
		}
		
		//Even number btw 1 and n
		System.out.println("Even numbers");
		
		for(int i=0 ; i<n/2+1  ; i++) {
			
			if(even[i]!=0) {
			System.out.println(even[i]);
		}
			
		}
		
		//Odd numbers btw 1 and n
		System.out.println("Even numbers");
		
		for(int i=0 ; i<n/2+1  ; i++) {
			if(odd[i]!=0) {
			System.out.println(odd[i]);
		}
		}
		
		//close the scanner object
		sc.close();

	}

}
