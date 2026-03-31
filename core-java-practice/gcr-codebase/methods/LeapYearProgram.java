
import java.util.Scanner;

public class LeapYearProgram {

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;

        boolean a = (year % 4 == 0 && year % 100 != 0);
        boolean b = (year % 400 == 0);

        return a || b;
    }

    public static void main(String[] args) {
        
        //Create Scanner Objcet
        Scanner sc = new Scanner(System.in);

        //Take User Input
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (isLeapYear(year)){
            System.out.println("Leap Year");
        }
        else
            System.out.println("Not a Leap Year");
    
        //Close Scanner Object
        sc.close();
    }
}

