import java.util.Scanner;

public class CalculateSI {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int principal = sc.nextInt();// Principle amount is in INR
        int rate = sc.nextInt();//Rate is in percentage
        int time = sc.nextInt();//Time is in years;
        int simpleIntrest = (principal*rate*time)/100;
        System.out.println("Simple intrest for principal "+principal+" rate "+ rate+" time "+time+" is "+simpleIntrest);
        sc.close();
    }
}
