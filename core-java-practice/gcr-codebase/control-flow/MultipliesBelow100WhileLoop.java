import java.util.Scanner;

public class MultipliesBelow100WhileLoop {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take numbe as input
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
            
        }

        System.out.println("Multiples of " + number + " below 100:");

        int counter = 99;
        while (counter >= 1) {
            if (counter % number == 0) {
                System.out.print(counter + " ");
            }
            counter--;
        }

        //close the scanner object
        sc.close();
    }
}
