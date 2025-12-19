import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        
        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //take a user input
        int number = sc.nextInt();
        int num = number;
        
        int factorial=1;   

        //check whether the input number is postive or negative
        if(number<0) System.out.println("Take only positive number aa input");

        else{
            while(number!=1){
                  factorial*=number;
                  number--;  
            }
        }

        System.out.println("The factorial of number "+num+" is "+factorial);

        //close the scanner object
        sc.close();
    }
}
