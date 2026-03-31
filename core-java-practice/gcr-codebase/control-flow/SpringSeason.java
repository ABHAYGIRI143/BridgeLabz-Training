import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        
        //create a scanner object
        Scanner sc = new Scanner(System.in);
         
        //take two inputs (month , day)
        String month = sc.next();
        int day = sc.nextInt();

        //check either it's a spring season or not
        if((month.equals("March") && day>19 )|| month.equals("April") || month.equals("May") || (month.equals("June") && day<21) ){
            System.out.println("Its a spring season");
        }
        else{
            System.out.println("Not a spring season");
        }

        //close the scanner object
        sc.close();
    }
}
