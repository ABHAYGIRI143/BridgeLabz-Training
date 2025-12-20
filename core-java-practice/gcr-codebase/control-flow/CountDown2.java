import java.util.Scanner;

public class CountDown2 {
    public static void main(String[] args) {
        
        //Create a scanner object
        Scanner sc = new Scanner(System.in);

        //take a number as input
        int number = sc.nextInt();

        for(;number!=0;number--){
            System.out.println("Count down "+number);
        }

        //close the Scanner object
        sc.close();
    }
}
