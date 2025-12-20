import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        
        //Create scanner object for taking input
        Scanner sc = new Scanner(System.in);

        //Take three number as input
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int thirdNumber = sc.nextInt();

        //find the largest number among these three numbers
        if(firstNumber>secondNumber && firstNumber>thirdNumber){
            System.out.println("Is the first number the largest? True");
        }
       else if(firstNumber<secondNumber && secondNumber>thirdNumber){
            System.out.println("Is the second number the largest? True");
        }
        else{
             System.out.println("Is the third number the smallest? True");
        }

        //close the scanner object
        sc.close();
    }   
}
