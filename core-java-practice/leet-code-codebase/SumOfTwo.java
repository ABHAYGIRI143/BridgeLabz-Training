import java.util.Scanner;
public class SumOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first integer: ");
        int f = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int s = scanner.nextInt();
        
        int sum = f + s;
    
        System.out.println("sum " + sum);
        scanner.close();
        
    }
}