
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {

    // Encapsulated fields
    private int patientId;
    private String name;
    private int age;

    // Sensitive data (protected via encapsulation)
    private String diagnosis;
    private StringBuilder medicalHistory;

    // Constructor
    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = new StringBuilder();
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Encapsulated access to sensitive data
    protected String getDiagnosis() {
        return diagnosis;
    }

    // MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        System.out.println(medicalHistory.length() == 0 ? "No records available" : medicalHistory);
    }
}


class InPatient extends Patient {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int patientId, String name, int age, String diagnosis,
                     int daysAdmitted, double dailyCharge) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }
}


class OutPatient extends Patient {

    private double consultationFee;

    public OutPatient(int patientId, String name, int age, String diagnosis,
                      double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}


class HospitalService {

    // Polymorphic method
    public static void displayBill(Patient patient) {
        System.out.println("\n--- Patient Billing Details ---");
        patient.getPatientDetails();
        System.out.println("Total Bill: ₹" + patient.calculateBill());
    }
}


public class HospitalManagementApp {

    public static void main(String[] args) {

        Patient inpatient = new InPatient(
                101, "Rahul", 35, "Pneumonia", 5, 2500
        );

        Patient outpatient = new OutPatient(
                102, "Anita", 28, "Fever", 600
        );

        inpatient.addRecord("Admitted to ICU");
        inpatient.addRecord("Given antibiotics");

        outpatient.addRecord("Consultation completed");
        outpatient.addRecord("Prescribed medicines");

        HospitalService.displayBill(inpatient);
        inpatient.viewRecords();

        HospitalService.displayBill(outpatient);
        outpatient.viewRecords();
    }
}


