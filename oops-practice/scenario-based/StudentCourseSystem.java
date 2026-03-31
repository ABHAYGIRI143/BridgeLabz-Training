import java.util.*;

// ================= Custom Exception =================
class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String msg) {
        super(msg);
    }
}

// ================= Abstraction =================
interface RegistrationService {
    void registerStudent(Student s);
    void enrollCourse(Student s, String course) throws CourseLimitExceededException;
    void dropCourse(Student s, String course);
}

// ================= Person (Base Class) =================
class Person {
    protected int id;
    protected String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Student =================
class Student extends Person {

    private List<String> courses = new ArrayList<>();
    private Map<String, Integer> grades = new HashMap<>();
    private static final int MAX_COURSES = 3;

    Student(int id, String name) {
        super(id, name);
    }

    // Encapsulation: controlled access
    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public void addCourse(String course) throws CourseLimitExceededException {
        if (courses.size() >= MAX_COURSES)
            throw new CourseLimitExceededException("Maximum 3 courses allowed!");

        courses.add(course);
    }

    public void dropCourse(String course) {
        courses.remove(course);
    }

    public void addGrade(String course, int grade) {
        grades.put(course, grade);
    }

    public void showGrades() {
        for (String c : grades.keySet()) {
            System.out.println(c + " : " + grades.get(c));
        }
    }
}

// ================= Registration System =================
class University implements RegistrationService {

    private List<Student> students = new ArrayList<>();

    public void registerStudent(Student s) {
        students.add(s);
        System.out.println("Student registered: " + s.name);
    }

    public void enrollCourse(Student s, String course)
            throws CourseLimitExceededException {
        s.addCourse(course);
        System.out.println("Enrolled in " + course);
    }

    public void dropCourse(Student s, String course) {
        s.dropCourse(course);
        System.out.println("Dropped " + course);
    }
}

// ================= Main =================
public class StudentCourseSystem {
    public static void main(String[] args) {

        University uni = new University();

        Student s1 = new Student(1, "Abhay");

        uni.registerStudent(s1);

        try {
            uni.enrollCourse(s1, "Java");
            uni.enrollCourse(s1, "DSA");
            uni.enrollCourse(s1, "Cloud");
            uni.enrollCourse(s1, "AI");   // Will throw exception
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        s1.addGrade("Java", 90);
        s1.addGrade("DSA", 85);

        System.out.println("\nGrades:");
        s1.showGrades();
    }
}
