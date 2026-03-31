import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
     
         Scanner sc = new Scanner(System.in);

        //take a user input
        int number = sc.nextInt();
        int num = number;
        
        int factorial=1;   

        //check whether the input number is postive or negative
        if(number<0) System.out.println("Take only positive number aa input");

        else{
           for(;number!=1;number--){
            factorial*=number;
           }
        }

        System.out.println("The factorial of number "+num+" is "+factorial);

        //close the scanner object
        sc.close();
    }
}
