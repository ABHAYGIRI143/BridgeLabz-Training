import java.util.Scanner;

public class CalculateQuotientRemainder {
    public static void main(String args[]){
      
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int quotient = firstNumber/secondNumber;
        int remainder = firstNumber%secondNumber;
        System.out.println("The Quotient is "+quotient+" ad the Remainder is "+remainder);
        sc.close();
    }
}
