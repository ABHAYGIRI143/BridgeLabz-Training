import java.util.*;

// ================= Custom Exception =================
class AppointmentNotAvailableException extends Exception {
    public AppointmentNotAvailableException(String msg) {
        super(msg);
    }
}

// ================= Abstraction =================
interface HospitalService {
    void addPatient(Patient p);
    void addDoctor(Doctor d);
    void bookAppointment(int doctorId, Patient p) throws AppointmentNotAvailableException;
}

// ================= Person (Base Class) =================
abstract class Person {
    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Patient =================
class Patient extends Person {
    List<String> medicalHistory = new ArrayList<>();

    Patient(int id, String name) {
        super(id, name);
    }

    void addRecord(String record) {
        medicalHistory.add(record);
    }

    void showHistory() {
        System.out.println("Medical History of " + name);
        for (String r : medicalHistory) {
            System.out.println(r);
        }
    }
}

// ================= Doctor =================
class Doctor extends Person {
    double baseFee;

    Doctor(int id, String name, double baseFee) {
        super(id, name);
        this.baseFee = baseFee;
    }

    // Polymorphism
    double calculateFee() {
        return baseFee;
    }
}

// Specialist doctor
class SpecialistDoctor extends Doctor {
    SpecialistDoctor(int id, String name, double baseFee) {
        super(id, name, baseFee);
    }

    @Override
    double calculateFee() {
        return baseFee + 500;   // extra specialist charge
    }
}

// ================= Appointment =================
class Appointment {
    Doctor doctor;
    Patient patient;

    Appointment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    void showBill() {
        System.out.println("Doctor: " + doctor.name);
        System.out.println("Patient: " + patient.name);
        System.out.println("Consultation Fee: ₹" + doctor.calculateFee());
    }
}

// ================= Hospital =================
class Hospital implements HospitalService {

    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();

    // Add patient
    public void addPatient(Patient p) {
        patients.add(p);
    }

    // Add doctor
    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    // Book appointment
    public void bookAppointment(int doctorId, Patient p)
            throws AppointmentNotAvailableException {

        for (Doctor d : doctors) {
            if (d.id == doctorId) {
                Appointment a = new Appointment(d, p);
                appointments.add(a);
                System.out.println("Appointment booked with Dr. " + d.name);
                a.showBill();
                return;
            }
        }
        throw new AppointmentNotAvailableException("Doctor not available!");
    }
}

// ================= Main =================
public class HospitalSystem {
    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        Patient p1 = new Patient(1, "Abhay");
        p1.addRecord("Fever - Jan 2025");

        Doctor d1 = new Doctor(101, "Dr. Sharma", 500);
        Doctor d2 = new SpecialistDoctor(102, "Dr. Mehta", 500);

        hospital.addPatient(p1);
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        try {
            hospital.bookAppointment(102, p1);   // specialist
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        p1.showHistory();
    }
}
