

class Student{
	String name;
	String rollNumber;
	int[] marks;
	
	Student(String name, String rollNumber, int ...marks){
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks = marks;	
	}
	
	public String calculateGrade() {
		int marksSum=0;
		for(int mark:marks) {
			marksSum+=mark;
		}
		
		int average = marksSum/marks.length;
		
		if(average>=90) {
			return "O";
		}
		
		else if(average>=80) {
			return "A+";
		}
		
		else if(average>=70) {
			return "A";
		}
		
		else if(average>=60) {
			return "B+";
		}
		
		else if(average>=60) {
			return "B";
		}
		
		else if(average>=50) {
			return "C";
		}
		
		return "F";
	}
	
	public void displayDetails() {
		System.out.println("Student Name :"+name +"\nStudent Roll number "+rollNumber);
		System.out.println("Studenet marks : ");
		for(int mark:marks) {
			System.out.println(mark);
		}
		System.out.println("Grade "+calculateGrade());
	}
			

}

public class StudentReport {

	public static void main(String[] args) {
		Student sd1 = new Student("Abhay Giri", "H11", 24,57,49,96);
		sd1.displayDetails();
	}

}
