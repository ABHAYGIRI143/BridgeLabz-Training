import java.util.Scanner;

public class AddTwoNumber {
    public static void main(String args[]){
      
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int sumOfBothNumbers = firstNumber+secondNumber;
        System.out.println( sumOfBothNumbers );
        sc.close();
    }
}
