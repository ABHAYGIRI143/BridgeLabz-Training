import java.util.*;
public class SwitchCalc {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);
        
        //take two number as input
        double firstNumber = sc.nextDouble();
        double secondNumber = sc.nextDouble();
        
        //take a opertaion as input
        String operation = sc.next();
        
        switch (operation){
            case "+":
                System.out.println("Result = " + (firstNumber+secondNumber));
                break;
            case "-":
                System.out.println("Result = " + (firstNumber-secondNumber));
                break;
            case "*":
                System.out.println("Result = " + (firstNumber*secondNumber));
                break;
            case "/":
                System.out.println("Result = " + (firstNumber/secondNumber));
                break;
            default:
                System.out.println("Invalid Operator");
        }
    //clsoe the scanner object
    sc.close();    
    }
}
