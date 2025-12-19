import java.util.Scanner;

public class CheckPositiveNegativeZero {
    public static void main(String[] args) {
        
        //create a scanner object 
        Scanner sc = new Scanner(System.in);

        //take a number as input
        int number = sc.nextInt();

        //check either it's positive negatuve or zero
        if(number<0) System.out.println("Negative");
        else if(number==0) System.out.println("Zero");
        else System.out.println("Positive");

        //close the scanner object
        sc.close();
    }   
}
