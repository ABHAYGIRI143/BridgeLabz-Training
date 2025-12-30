
class Employee{
	String name;
	int id;
	int salary;
	
	public Employee(String name,int id,int salary) {
		
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	public void details() {
		System.out.println("Employee name is "+name+", his id is "+id +" and salary is "+salary);
	}
}

public class EmployeeDetails {
	public static void main(String args[]) {
		
		Employee e1= new Employee("Abhay", 1, 10000);
		e1.details();
	}
}
