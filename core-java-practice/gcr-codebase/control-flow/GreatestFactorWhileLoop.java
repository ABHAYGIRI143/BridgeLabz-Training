import java.util.Scanner;

public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take number as input
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            
        }

        int greatestFactor = 1;
        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;  // Found the greatest factor, exit loop
            }
            counter--;
        }
        System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);
  
        // close the scanner object
        sc.close();
    }
}
