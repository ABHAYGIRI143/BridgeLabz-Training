import java.util.Scanner;

public class PowerWhileLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take two inputs(base, exponent)
        int base = sc.nextInt();

        int exponent = sc.nextInt();

        if (exponent < 0) {
            System.out.println("Please enter a non-negative exponent.");
        }

        long result = 1;
        int counter = 0;

        while (counter < exponent) {
            result *= base;
            counter++;
        }

        System.out.println(base + " raised to the power of " + exponent + " = " + result);
    
        //close the scanner object
        sc.close();
    }
}
