import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int addition = firstNumber + secondNumber;
        int substract = firstNumber - secondNumber;
        int multiply = firstNumber * secondNumber;
        int divide = firstNumber / secondNumber;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+firstNumber+" and "+secondNumber+" is "+addition+" "+substract+" "+multiply+" "+divide );
        sc.close();
    }
}
