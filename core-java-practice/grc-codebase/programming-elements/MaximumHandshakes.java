import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String args[]){
     
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int result = (numberOfStudents * (numberOfStudents - 1)) /2;
        System.out.println("The number  possible handshakes "+ result);
        sc.close();
    }
}
