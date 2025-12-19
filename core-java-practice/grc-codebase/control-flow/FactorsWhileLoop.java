import java.util.Scanner;

public class FactorsWhileLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);
        
        //take the number as input
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Please enter a positive integer.");
        }

        System.out.println("Factors of " + num + " are:");
        
        int ctr = 1;
        while (ctr <= num) {
            if (num % ctr == 0) {
                System.out.print(ctr + " ");
            }
            ctr++;
        }

        //close the scanner object
        sc.close();
    }
}
