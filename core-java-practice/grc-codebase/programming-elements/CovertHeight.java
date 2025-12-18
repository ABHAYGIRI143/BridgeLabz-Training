import java.util.Scanner;

public class CovertHeight {
    public static void main(String args[]){
        // 1 foot = 12 inches and 1 inch = 2.54 cm
        Scanner sc=new Scanner(System.in);
        int height=sc.nextInt();// input height in centmeters
        double heightInInches=height/2.5;
        double heightInFeet=heightInInches/12;
        System.out.println("Your Height in cm is "+height+" while in feet is "+heightInFeet+" and inches is "+heightInInches );
        sc.close();
    }
}
