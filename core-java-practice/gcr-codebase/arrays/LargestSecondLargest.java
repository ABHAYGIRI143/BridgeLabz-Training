import java.util.Scanner;

public class LargestSecondLargest {

    public static void main(String[] args) {

    	//create the scanner object
    	Scanner sc = new Scanner(System.in);


        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initial maximum size of array
        int maxDigit = 10;

        // Array to store digits
        int[] digits = new int[maxDigit];

        // Index to track number of stored digits
        int index = 0;

        // store digits in an array
        while (number != 0) {

            // If array is full, increase size by 10
            if (index == maxDigit) {

                // Increase maxDigit by 10
                maxDigit = maxDigit + 10;

                // Create a temporary array with new size
                int[] temp = new int[maxDigit];

                // Copy old digits into temp array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign temp array to digits array
                digits = temp;
            }

            // Extract last digit
            int lastDigit = number % 10;

            // Store digit
            digits[index] = lastDigit;
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

        //print output
        System.out.println("\nLargest Digit        : " + largest);
        System.out.println("Second Largest Digit : " + secondLargest);

        //close the scanner object
        sc.close();
    }
}
