

class Employee {

    public int employeeID;
    protected String department;

   
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public getter for salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }
}


class Manager extends Employee {

   

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeID);   // public access
        System.out.println("Department: " + department);    // protected access
        System.out.println("Salary: ₹" + getSalary());      // private via method
      
    }
}


public class EmployeeRecords {

	public static void main(String[] args) {
		
	     Manager manager = new Manager(501,"IT",75000);

	        manager.displayDetails();

	        // Modify salary using public method
	        manager.setSalary(85000);
	        System.out.println("Updated Salary: ₹" + manager.getSalary());

	}

}
