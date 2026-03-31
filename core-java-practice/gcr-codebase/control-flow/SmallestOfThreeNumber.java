import java.util.Scanner;

public class SmallestOfThreeNumber {
    public static void main(String[] args) {
        
        //Create a scanner object for taking input
        Scanner sc = new Scanner(System.in);

        //Take three number as input
        int firstNumber = sc.nextInt(); 
        int secondNumber = sc.nextInt(); 
        int thirdNumber = sc.nextInt();
        
        //Check  first number is  smallest among three numbers or not
        if(firstNumber<secondNumber && firstNumber<thirdNumber){
            System.out.println("Is the first number the smallest? true");
        }
        else{
           System.out.println("Is the first number the smallest? false");
        }

        //close the scanner object
        sc.close();;
    }
}
