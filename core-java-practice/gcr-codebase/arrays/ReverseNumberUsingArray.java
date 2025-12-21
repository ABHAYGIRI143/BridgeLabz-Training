import java.util.Scanner;

public class ReverseNumberUsingArray {

    public static void main(String[] args) {

        //create the scanner object
    	Scanner sc = new Scanner(System.in);
    	
        //take a number as input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        //COUNT DIGITS 
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // Array to store digits of the number
        int[] digits = new int[count];

        //store digits
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10; // extract last digit
            temp = temp / 10;
        }

        //reverse array 
        int[] reverseDigits = new int[count];
        int index = 0;

        for (int i = count - 1; i >= 0; i--) {
            reverseDigits[index] = digits[i];
            index++;
        }

        //print output
        System.out.print("\nReversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverseDigits[i]);
        }

        //close the scanner object
        sc.close();
    }
}
