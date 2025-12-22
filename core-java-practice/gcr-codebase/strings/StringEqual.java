
import java.util.*;
public class StringEqual {

	public static void main(String[] args) {
		
		//create the scanner object
		Scanner sc = new Scanner(System.in);
		
		//take two string as inputs
		String first = sc.next();
		String second = sc.next();

		boolean check = true; // initialize a boolean variable with value true 
		
		//firstly we have to check there sizes are equal or not
		if(first.length() != second.length()) {
			check=false;
		}
		
		//check either both strings are equal or not
		if(check) {
			for(int i = 0 ; i<first.length() ; i++ ) {
			
				if(first.charAt(i) != second.charAt(i) ) 
				{
					check = false;
				}
			}
		}

		boolean check2 = first.equals(second);
		System.out.println(check);
		System.out.println(check2);
	
		//close the scanner object
		sc.close();
	
	}
	
	
}
