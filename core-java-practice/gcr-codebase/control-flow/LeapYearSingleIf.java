import java.util.Scanner;

public class LeapYearSingleIf {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);
        
        //take year as input
        int year = sc.nextInt();
        
        if(year>=1582 && (year%400==0 || (year%4==0 && year%100!=0))){
            System.out.println("Year is a Leap Year");}
            
            else{
            System.out.println("Year is NOT a Leap Year");}

            //close the scanner object
            sc.close();
    }
}
