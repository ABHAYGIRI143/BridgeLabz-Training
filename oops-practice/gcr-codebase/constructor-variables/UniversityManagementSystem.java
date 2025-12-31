

class Student{
	public int rollNumber;
	protected String name;
	private double CGPA;
	
	 Student(int rollNumber, String name, double CGPA) {
	        this.rollNumber = rollNumber;
	        this.name = name;
	        this.CGPA= CGPA;
	    }
	
	
	public void getCGPA() {
		System.out.println("Current CGPA is "+CGPA);
	}
	
	public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA!");
        }
    }
	
	
}

class PostgraduateStudent extends Student {

   

    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
        
    }

    // Using protected member 'name'
    void displayDetails() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name); // protected member access
        getCGPA(); // private via public method
        
    }
}


public class UniversityManagementSystem {
	public static void main(String args[]) {
	
		PostgraduateStudent pg = new PostgraduateStudent(
                101, "Abhay", 8.5);

        pg.displayDetails();

        // Modifying CGPA using public method
        pg.setCGPA(9.2);
       pg.getCGPA();
	}
}
