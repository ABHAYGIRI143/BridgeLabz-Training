import java.util.Scanner;

public class MultipliesBelow100ForLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take number as input
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
            
        }

        System.out.println("Multiples of " + number + " below 100:");

        // Loop backward from 99 to 1
        for (int i = 99; i >= 1; i--) {
            if (i % number == 0) {  // Check if i is divisible by number
                System.out.print(i + " ");
            }
        }

        //close the scannner object
        sc.close();
    }

}