
import java.util.*;
public class MeanHeight {

	public static void main(String[] args) {		

		//create a scanner object
		Scanner sc = new Scanner(System.in);
	
		//initialize an array of size 11 to store the height of the players
		int heightOfPlayer[] = new int[11];
		
		//take height as input
		for(int i = 0; i<11 ;i++) {
			heightOfPlayer[i] = sc.nextInt();
		}
		
		int meanHeight = 0; //initialize meanHeight variable as zero
		
		//calculate mean height
		for(int i= 0; i<11 ; i++) {
			meanHeight += heightOfPlayer[i];
		}
		
		System.out.println("Mean of players height is "+meanHeight);
		
		
		//close the scanner object
		sc.close();
	
	}

}
