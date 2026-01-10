
import java.util.*;

interface IPayable {
    double calculateBill();
}


class Doctor {
    private int doctorId;
    private String name;
    private String specialization;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}


abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private Doctor doctor;

    public Patient(int patientId, String name, int age, Doctor doctor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    // Encapsulation (getters)
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public Doctor getDoctor() { return doctor; }

    // Polymorphism
    public abstract void displayInfo();
}


class InPatient extends Patient implements IPayable {

    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(int id, String name, int age, Doctor doctor,
                     int days, double roomCharge) {
        super(id, name, age, doctor);
        this.daysAdmitted = days;
        this.roomChargePerDay = roomCharge;
    }

    public double calculateBill() {
        return daysAdmitted * roomChargePerDay;
    }

    public void displayInfo() {
        System.out.println("InPatient: " + getName() +
                " | Doctor: " + getDoctor().getName() +
                " | Bill: " + calculateBill());
    }
}


class OutPatient extends Patient implements IPayable {

    private double consultationFee;

    public OutPatient(int id, String name, int age, Doctor doctor,
                      double fee) {
        super(id, name, age, doctor);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void displayInfo() {
        System.out.println("OutPatient: " + getName() +
                " | Doctor: " + getDoctor().getName() +
                " | Bill: " + calculateBill());
    }
}


class Hospital {
    private List<Patient> patients = new ArrayList<>();

    // CREATE
    public void addPatient(Patient p) {
        patients.add(p);
        System.out.println("Patient Added");
    }

    // READ
    public void displayAll() {
        for (Patient p : patients) {
            p.displayInfo();   // Polymorphism
        }
    }

    // SEARCH
    public void search(int id) {
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                p.displayInfo();
                return;
            }
        }
        System.out.println("Patient not found");
    }

    // DELETE
    public void delete(int id) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            if (it.next().getPatientId() == id) {
                it.remove();
                System.out.println("Patient removed");
                return;
            }
        }
        System.out.println("Patient not found");
    }
}



public class HospitalManagementSystem {
    public static void main(String[] args) {

        Doctor d1 = new Doctor(1, "Dr. Sharma", "Cardiology");
        Doctor d2 = new Doctor(2, "Dr. Mehta", "General");

        Hospital h = new Hospital();

        Patient p1 = new InPatient(101, "Abhay", 22, d1, 5, 2000);
        Patient p2 = new OutPatient(102, "Manas", 20, d2, 500);

        h.addPatient(p1);
        h.addPatient(p2);

        h.displayAll();

        h.search(101);

        h.delete(102);

        h.displayAll();
    }
}
