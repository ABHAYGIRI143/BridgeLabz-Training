import java.util.Scanner;

public class FizzBuzzUsingWhile {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        //take a number as input
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            
        }
        int i = 1;
        while(i<=n){
            if (i % 15 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
            i++;
        }

        //close the scanner object
        sc.close();
    }
}
