import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        
        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //take a number as input
        int number = sc.nextInt();

        //check whether the input number is natural number or not
        if(number<=0) System.out.println("Input number is not a natural number");

        else{
            for(int i=1 ; i<=number ; i++){
                if( i%2 == 0) System.out.println(i+" is a even number");
                else System.out.println(i+" is a odd number");
            }
        }

        //close the scanner object
        sc.close();
    }
}
