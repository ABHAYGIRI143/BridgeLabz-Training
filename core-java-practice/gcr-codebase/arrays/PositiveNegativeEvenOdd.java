import java.util.Scanner;

public class PositiveNegativeEvenOdd {

	public static void main(String[] args) {		// TODO Auto-generated method stub
		
		//create the scanner object
				Scanner sc = new Scanner(System.in);
				
				//take input ( n )
				int n = sc.nextInt();
				
				//initialize the array to store the numbers
				int nNumbers[] = new int[n];
				
				//take n number of numbers
				for(int i = 0 ; i<n ; i++) {
					nNumbers[i] = sc.nextInt();				
					}

	
	
				// number is positive, check for even or odd numbers 
				for( int i = 0 ; i<n ; i++) {
				
					if( nNumbers[i]>0 ) {
					
						if(	nNumbers[i]%2==0 ) {
							System.out.println("Even");
						}
						
						else {
							System.out.println("Odd");
						}
					}
					
					
					else if( nNumbers[i]==0 ) {
						System.out.println("Zero");
					}
					
					else {
						System.out.println("Negative");
					}
				}
				
				if(nNumbers[0]==nNumbers[n-1]) {
					System.out.println("Equal");
				}
				
				else if(nNumbers[0]>nNumbers[n-1]) {
					System.out.println("Greater");
				}


				else {
					System.out.println("Lesser");
				}
		
				//close the scanner object
				sc.close();
	}	
	
}