import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
       
        //create the scanner object
        Scanner sc = new Scanner(System.in);
        
        int num = 0;
       
        // Validate input
        while (num <= 0) {
            System.out.print("Enter a natural number (positive integer): ");
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num <= 0) {
                    System.out.println("Please enter a positive integer greater than 0.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                sc.next();
            }
        }
        // Print odd/even numbers
        for (int i = 1; i <= num; i++) {
            String res = (i % 2 == 0) ? "even" : "odd";
            System.out.println(i + " is an " + res + " number");
        }
        
        //close the scanner object
        sc.close();
    }
}