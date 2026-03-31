
import java.util.Scanner;

public class FactorialUsingRecursion {
    
   
    //recursive method to calculate factorial
    public static long factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
    
    //method to display result
    public static void displayResult(int num, long result) {

        System.out.println("Factorial of " + num + " is: " + result);
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        long result = factorial(number);
        displayResult(number, result);
    
        //Close Scanner Object
        sc.close();
    }
}

