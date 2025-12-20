import java.util.Scanner;

public class PowerForLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take the two inputs (base, exponent) 
        int base = sc.nextInt();

        int exponent = sc.nextInt();

        if (exponent < 0) {
            System.out.println("Please enter a non-negative exponent.");
            
        }

        long result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println(base + " raised to the power of " + exponent + " = " + result);

        sc.close();
    }
}
