
class Student{
	static String universityNameString="GLA Univeristy";
	static int totalStudents=0;
	String name;
	final int rollNumber;
	char grade;
	
	Student(String name, int rollNumber, char grade){
		this.name =  name;
		this.rollNumber = rollNumber;
		this.grade =  grade;
	}
	
	
	static void displayTotalStudents() {
		System.out.println("Total students : "+totalStudents);
		
	}
	
//	void displayDetails() {
//		System.out.println("Univeristy Name "+universityNameString+"Roll Number: "+rollNumber+"Name : "+name+"Grade :"+grade);
//	}
	
}

public class StudentManagementSystem {

	public static void main(String args) {
		Student st1 =  new Student("Abhay", 1, 'A');
		
		if(st1 instanceof Student) {
			System.out.println("st1 is instance of student class");
		}
		Student.displayTotalStudents();
//		st1.displayDetails();
	}
}
