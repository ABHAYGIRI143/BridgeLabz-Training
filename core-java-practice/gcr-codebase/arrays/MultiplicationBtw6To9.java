
import java.util.*;
public class MultiplicationBtw6To9 {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	
	//take input n (between 6 to 9)
	int n = sc.nextInt();
	
	int table[] = new int[10];
	

	//calculate the table
	for(int i = 0; i<10; i++) {
		table[i] = n*(i+1);
	}
	
	//show the result
	for(int i = 0; i<10; i++) {
		System.out.println(n+" * "+ (i+1) +" = "+table[i]);
	}
	
	
	//close the scanner object
	sc.close();
}
}
