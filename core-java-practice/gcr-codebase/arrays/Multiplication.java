
import java.util.*;
public class Multiplication {

	public static void main(String[] args) {
		
		//create scanner object
		Scanner sc = new Scanner(System.in);
		
		//take a input n 
		int n =  sc.nextInt();
		
		//initialize the array table to store the multiplication
		int table[] = new int[10];	
		
		
		//logic for storing the table
		for(int i = 0; i < 10 ; i++) {
			table[i] = n*(i+1);
		}
		
		for(int i = 0; i<10 ; i++) {
			System.out.println(n+" * "+ (i+1) +" = "+table[i]);
		}
		
		
		//close scanner object
		sc.close();
	}

}
