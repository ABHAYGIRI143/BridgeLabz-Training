import java.util.Scanner;

public class LargestSecondLargestDigit {

    public static void main(String[] args) {

 
    	//create the scanner object
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Maximum digits allowed
        int maxDigit = 10;

        // Array to store digits of the number
        int[] digits = new int[maxDigit];

        // Index to track array position
        int index = 0;

        // store digits in an array
        while (number != 0) {

            // If array size reaches maxDigit, stop adding digits
            if (index == maxDigit) {
                break;
            }

            // Extract last digit
            int lastDigit = number % 10;

            // Store digit in array
            digits[index] = lastDigit;

            // Increase index
            index++;

            // Remove last digit from number
            number = number / 10;
        }

        // FIND LARGEST & SECOND LARGEST 
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        //print the output
        System.out.println("\nLargest Digit        : " + largest);
        System.out.println("Second Largest Digit : " + secondLargest);

        //close the scanner object
        sc.close();
    }
}
