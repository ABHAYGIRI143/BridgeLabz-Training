// Superclass Person
class Persons {
    String name;
    int age;

    Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Teacher
class Teacher extends Persons {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println(name + " is a Teacher who teaches " + subject + ".");
    }
}

// Subclass Student
class Students extends Persons {
    String grade;

    Students(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println(name + " is a Student in grade " + grade + ".");
    }
}

// Subclass Staff
class Staff extends Persons {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println(name + " is a Staff member in the " + department + " department.");
    }
}

// Main class
public class SchoolSystem {
    public static void main(String[] args) {

        Teacher t = new Teacher("Rohit", 35, "Mathematics");
        Students s = new Students("Anita", 16, "10th");
        Staff st = new Staff("Meera", 40, "Administration");

        t.showDetails();
        t.displayRole();

        System.out.println();

        s.showDetails();
        s.displayRole();

        System.out.println();

        st.showDetails();
        st.displayRole();
    }
}
