import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id +
                ", Name=" + name +
                ", Department=" + department +
                ", Salary=" + salary + "]";
    }
}


public class EmployeeSerializationDemo {

    public static void main(String[] args) {

        String fileName = "employees.dat";

        // Create employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit", "IT", 55000));
        employees.add(new Employee(102, "Neha", "HR", 48000));
        employees.add(new Employee(103, "Rahul", "Finance", 60000));

        // 🔹 Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employee list serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔹 Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Employee> empList =
                    (List<Employee>) ois.readObject();

            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : empList) {
                System.out.println(emp);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
