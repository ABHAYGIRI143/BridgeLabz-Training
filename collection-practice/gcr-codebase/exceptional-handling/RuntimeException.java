import java.util.InputMismatchException;
import java.util.Scanner;

public class RuntimeException {
	public static void main(String args[]) {
		
		//Create Scanner Object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number");
		try {
			int n = sc.nextInt();
			int n2= sc.nextInt();
			
			int result = n/n2;
			System.out.println("Result is"+result);
		}
		
		catch (InputMismatchException e) {
			System.out.println("Kindly enter only integer value");
		}
		
		catch (ArithmeticException e) {
			System.out.println("A number can't be divided by zero");
		}
		
	}
}
