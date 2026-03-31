import java.util.Scanner;

public class FactorsForLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);
        
        //take a number as input
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");

        }
        System.out.println("Factors of " + number + " are:");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }

        //close the scanner object
        sc.close();
    }
}