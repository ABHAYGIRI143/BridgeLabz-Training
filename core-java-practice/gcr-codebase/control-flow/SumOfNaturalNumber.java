import java.util.Scanner;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        
        //Create a scanner object for input
        Scanner sc = new Scanner(System.in);

        //take a number as input
        int number = sc.nextInt();

        //check either it's natural number or not
        boolean check = number<0 ? true : false;

        //if it's not natural number
        if(check) System.out.println("The number "+number+" is not a natural number");

        //if it's a natural number then find the sum of n natural numbers
        else{
         int sumOfNNaturalNumbers = number*(number-1)/2;
         System.out.println("The sum of "+number+" natural numbers is "+sumOfNNaturalNumbers);
            
        }

        //close the scanner object 
        sc.close();
    }   
}
