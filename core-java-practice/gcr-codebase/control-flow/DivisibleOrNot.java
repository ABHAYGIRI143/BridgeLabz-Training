import java.util.Scanner;

class DivisibleOrNot{
    public static void main(String[] args) {
        
        //Create a scanner Object
        Scanner sc = new Scanner(System.in);

        //Get input value for number
        int number = sc.nextInt();

        //Check that the number is divisible by 5 or not
        boolean check = number%5==0? true:false;
        
        System.out.println("Is the nunber "+number+" divisible by 5? "+check);
        
        //close the scanner object
        sc.close();
    }
}