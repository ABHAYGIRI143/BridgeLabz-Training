

class Employee{
	static String companyName="Capgemini";
	static int totalCompanyEmployees=0;
	String name;
	final int id;
	String designation;
	
	public Employee(String name,int id,String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		totalCompanyEmployees++;
	}
	
	static void displayTotalEmployees() {
		System.out.println("Total Employees are " +totalCompanyEmployees );
	}
	
	 void displayEmployeesDetails() {
		System.out.println("Company Name : "+companyName+"\nEmployee Name : "+name+"\nEmployee Id: "+id+"\nDesignation :"+designation);
	}
	
}

public class EmployeeManagementSystem {

	public static void main(String args) {
		Employee e1 = new Employee("Abhay", 1, "Software Devloper");
		
		if(e1 instanceof Employee) {
			System.out.println("e1 is instance of Employee");
		}
		
		Employee.displayTotalEmployees();
		
		e1.displayEmployeesDetails();
		
		Employee e2 = new Employee("Manas", 02, "Associate Devloper");
		Employee.displayTotalEmployees();
	}
}
