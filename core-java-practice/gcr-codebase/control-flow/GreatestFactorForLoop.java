import java.util.Scanner;

public class GreatestFactorForLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            
        }

        int greatestFactor = 1;

        // Start from number-1 and go down to 1
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;  // Found the greatest factor, exit loop
            }
        }

        System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);
    
    //close the scanner object
    sc.close();
    }
}
