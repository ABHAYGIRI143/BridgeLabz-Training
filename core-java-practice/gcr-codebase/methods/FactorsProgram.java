import java.util.Scanner;

public class FactorsProgram {

    public static int[] getFactors(int n) {
        int count = 0;
        
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int index = 0;
        
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                factors[index++] = i;
        return factors;
    
    }
    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }
    public static long productOfFactors(int[] arr) {
        long product = 1;
        for (int x : arr) product *= x;
        return product;
    }
    public static double sumOfSquares(int[] arr) {
        double sum = 0;
        for (int x : arr) sum += Math.pow(x, 2);
        return sum;
    }
    public static void main(String[] args) {

        //Create Scanner object;
        Scanner sc = new Scanner(System.in);
        
        //Take input from user
        System.out.print("Enter a number: ");
        
        int n = sc.nextInt();
        int[] factors = getFactors(n);
        
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();
        
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    
 
        //Close Scanner Object
        sc.close();
    }
}
