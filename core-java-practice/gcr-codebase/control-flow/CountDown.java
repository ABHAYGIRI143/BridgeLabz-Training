import java.util.Scanner;

public class CountDown {
    public static void main(String[] args) {
        
        //Create a scanner object 
        Scanner sc = new Scanner(System.in);

        //Take a number 
        int number = sc.nextInt();

        //count down the number until we get 1
        while(number!=0){
            System.out.println("Count Down "+number);
            number--;
        }

        //close the scanner object
        sc.close();
    }
}
