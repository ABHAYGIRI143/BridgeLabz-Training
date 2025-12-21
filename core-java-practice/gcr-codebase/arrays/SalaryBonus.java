
import java.util.*;
public class SalaryBonus {

	public static void main(String[] args) {
		
		//create the scanner object 
		Scanner sc = new Scanner(System.in);

	        // Number of employees
	        int n = 10;

	        // Arrays to store salary and years of service
	        double[] salary = new double[n];
	        double[] yearsOfService = new double[n];

	        // Arrays to store bonus amount and new salary
	        double[] bonus = new double[n];
	        double[] newSalary = new double[n];

	        // Variables to store totals
	        double totalBonus = 0;
	        double totalOldSalary = 0;
	        double totalNewSalary = 0;

	    
	        //run a loop to take input from user
	        for (int i = 0; i < n; i++) {

	            System.out.println("\nEnter details for Employee " + (i + 1));

	            System.out.print("Enter Salary: ");
	            double sal = sc.nextDouble();

	            System.out.print("Enter Years of Service: ");
	            double yrs = sc.nextDouble();

	            // Validation: salary and service must be positive
	            if (sal <= 0 || yrs < 0) {
	                System.out.println("Invalid input! Salary must be positive and years of service cannot be negative.");
	                i--;
	                continue;
	            }

	            salary[i] = sal;
	            yearsOfService[i] = yrs;
	        }

	      
	        for (int i = 0; i < n; i++) {

	            // Calculate bonus based on years of service
	            if (yearsOfService[i] > 5) {
	                bonus[i] = salary[i] * 0.05; // 5% bonus
	            } else {
	                bonus[i] = salary[i] * 0.02; // 2% bonus
	            }

	            // Calculate new salary
	            newSalary[i] = salary[i] + bonus[i];

	            // Calculate totals
	            totalBonus += bonus[i];
	            totalOldSalary += salary[i];
	            totalNewSalary += newSalary[i];
	        }

	        
	        
	        //display the output
	        for (int i = 0; i < n; i++) {
	            System.out.println("Employee " + (i + 1));
	            System.out.println("Old Salary  : " + salary[i]);
	            System.out.println("Bonus       : " + bonus[i]);
	            System.out.println("New Salary  : " + newSalary[i]);
	          
	        }

	        System.out.println("Total Old Salary of all Employees : " + totalOldSalary);
	        System.out.println("Total Bonus Paid by Company       : " + totalBonus);
	        System.out.println("Total New Salary after Bonus      : " + totalNewSalary);

	        
	        //close the scanner object
	        sc.close();
	}

}
