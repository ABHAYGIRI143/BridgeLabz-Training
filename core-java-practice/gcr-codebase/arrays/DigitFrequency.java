import java.util.Scanner;

public class DigitFrequency {

    public static void main(String[] args) {


    	//create the scanner object
    	Scanner sc = new Scanner(System.in);

        // take number as input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // count digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // Array to store digits of the number
        int[] digits = new int[count];

        //STORE DIGITS 
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10; // extract last digit
            temp = temp / 10;
        }

        //FREQUENCY ARRAY 
        int[] frequency = new int[10];

        // Count frequency of each digit
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // display the output
        System.out.println("\nDigit Frequency:");

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }

        
        //close the scanner object
        sc.close();
    }
}
