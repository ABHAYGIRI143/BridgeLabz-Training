
import java.util.*;
public class TwoDArrayToOneDArray {

	public static void main(String[] args) {
		
		//create the scanner object
		Scanner sc = new Scanner(System.in);
		
		//input row and column for 2d array
		int row = sc.nextInt();
		int column = sc.nextInt();
		
		//initialize 2d array
		int arr[][] = new int[row][column];
	
		//take input in 2d array
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<column ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//initialize an array to store the elements of 2d array
		int arr2[] = new int[row*column];
		
		//store the 2d array element in 1d array
		for(int i=0 ;i<row*column; i++) {
			arr2[i] = arr[i/row][i%row];
		}
		
		//print the elements
		for(int i=0 ;i<row*column; i++) {
			System.out.println(arr2[i]);
		}
		
		//close the scanner object
		sc.close();
	}

}
