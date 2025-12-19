import java.util.Scanner;

public class CountDigitsInAnInteger {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);
        
        //take a number as input
        int num= sc.nextInt();
        int c=0;

        while (num != 0){
            num=num/ 10;
            c++;
        }
        System.out.println("Number of digits: " + c);
    
        //close the scanner object
        sc.close();
    }
}

