import java.util.ArrayList;

class Student {
    private String name;
    private int rollNo;
    Student next;   // Linked List reference

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.next = null;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
}

class StudentManagement {

    private Student head = null;

    // ADD (Insert at end)
    void add(Student student) {

        if (head == null) {
            head = student;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = student;
    }

    // DELETE by roll number
    void delete(int rollNo) {

        if (head == null) {
            System.out.println("There is no student present");
            return;
        }

        // If head node is to be deleted
        if (head.getRollNo() == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully");
            return;
        }

        Student prev = head;
        Student curr = head.next;

        while (curr != null) {
            if (curr.getRollNo() == rollNo) {
                prev.next = curr.next;
                System.out.println("Student deleted successfully");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Student not found");
    }

    // SEARCH
    void search(int rollNo) {

        if (head == null) {
            System.out.println("There is no student present");
            return;
        }

        Student temp = head;
        while (temp != null) {
            if (temp.getRollNo() == rollNo) {
                System.out.println("Student Name: " +
                        temp.getName() + " Roll No: " + temp.getRollNo());
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // DISPLAY all students
    void display() {

        if (head == null) {
            System.out.println("There is no student present");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Student Name: " +
                    temp.getName() + " Roll No: " + temp.getRollNo());
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {

        StudentManagement sm = new StudentManagement();

        sm.add(new Student("Abhay", 1));
        sm.add(new Student("Manas", 2));
        sm.add(new Student("Divyansh", 3));
        sm.add(new Student("Kapil", 4));

        System.out.println("\n--- All Students ---");
        sm.display();

        System.out.println("\n--- Search Student ---");
        sm.search(3);

        System.out.println("\n--- Delete Student ---");
        sm.delete(2);

        System.out.println("\n--- Final List ---");
        sm.display();
    }
}
