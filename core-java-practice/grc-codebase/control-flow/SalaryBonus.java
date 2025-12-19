import java.util.Scanner;

public class SalaryBonus {
    public static void main(String[] args) {
        
        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //take two inputs(salary , year of service)
        int salary = sc.nextInt(); // salary is in INR
        int yearOfService = sc.nextInt();

        //check if the year of service is greater than 5 year then give the bonus amount
        if(yearOfService>5){

         int bonusAmount=(salary*5)/100;   
         System.out.println("The bonus amount is "+ bonusAmount+" for salary "+salary);
        }

        else{
            System.out.println("Year of service msut be more than 5 years to get bonus amount");
        }

        //close the scanner object
        sc.close();
    }   
}
