import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        
        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //take a number as input btw 6 to 9
        int number=sc.nextInt();

        for(int i=1;i<=10;i++){
            System.out.println(number+" * "+ i+" = "+number*i);
        }

        //close the scanner object
        sc.close();
    }
}
