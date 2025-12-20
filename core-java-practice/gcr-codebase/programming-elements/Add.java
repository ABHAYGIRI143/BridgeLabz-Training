import java.util.*;

public class Add {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int sumOfTwoNumbers=firstNumber+secondNumber;
        System.out.println(sumOfTwoNumbers);
        sc.close();
    }
}
