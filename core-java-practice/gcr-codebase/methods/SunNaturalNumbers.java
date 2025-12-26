
import java.util.Scanner;

public class SumNaturalNumbers {

    public static int recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        //Create Scanner Object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int rec = recursiveSum(n);
        int formula = formulaSum(n);

        System.out.println("Recursive Sum = " + rec);
        System.out.println("Formula Sum   = " + formula);

        if (rec == formula)
            System.out.println("Both results are correct and equal.");
        else
            System.out.println("Results do not match.");
    
        //Close Scanner Object
        sc.close();
    }
}

