import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentDataStream {

    public static void main(String[] args) {

        String fileName = "student.dat";

        // 🔹 Writing primitive data to file
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            int rollNo = 101;
            String name = "Abhay";
            double gpa = 8.75;

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔹 Reading primitive data from file
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
