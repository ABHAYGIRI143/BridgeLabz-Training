import java.util.Scanner;

public class VoteOrNot {
    public static void main(String[] args) {
        
        //create  a scanner object
        Scanner sc = new Scanner(System.in);

        //take age as input
        int age = sc.nextInt();

        //check either he/she is eligible for vote or not
        boolean check = age>=18 ? true : false;
        
        if(check) System.out.println("The person's age is "+age+" can vote");
        else System.out.println("The person's age is "+age+" can't vote");

        //close the scanner object
        sc.close();
    }
}
