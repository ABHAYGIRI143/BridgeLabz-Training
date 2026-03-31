import java.util.Scanner;

public class NumberChecker {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        if (n1 == n2) return 0;
        return -1;
    }

    public static void main(String[] args) {
        //Create Scanner Obejct
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();

            if (isPositive(arr[i])) {
                if (isEven(arr[i]))
                    System.out.println(arr[i] + " is Positive and Even");
                else
                    System.out.println(arr[i] + " is Positive and Odd");
            } else {
                System.out.println(arr[i] + " is Negative");
            }
        }

        int result = compare(arr[0], arr[4]);

        if (result == 0){
            System.out.println("First and Last numbers are Equal");
        }
        
        else if (result == 1){
            System.out.println("First number is Greater than Last");
        }

        else{
            System.out.println("First number is Less than Last");
        }

        //Close Scanner Object
        sc.close();
    }
}
