
import java.util.*;

interface IRentable {
    double calculateRent(int days);
}


abstract class Vehicle implements IRentable {
    protected int vehicleId;
    protected String brand;
    protected double ratePerDay;
    protected boolean isAvailable = true;

    public Vehicle(int vehicleId, String brand, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.ratePerDay = ratePerDay;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnVehicle() {
        isAvailable = true;
    }

    public abstract void display();
}



class Car extends Vehicle {

    public Car(int id, String brand, double rate) {
        super(id, brand, rate);
    }

    public double calculateRent(int days) {
        return (ratePerDay * days) + 500;   // insurance
    }

    public void display() {
        System.out.println("Car -> ID: " + vehicleId + " Brand: " + brand + 
                           " Rate: " + ratePerDay + " Available: " + isAvailable);
    }
}


class Truck extends Vehicle {

    public Truck(int id, String brand, double rate) {
        super(id, brand, rate);
    }

    public double calculateRent(int days) {
        return (ratePerDay * days) + 1000;   // heavy duty charge
    }

    public void display() {
        System.out.println("Truck -> ID: " + vehicleId + " Brand: " + brand + 
                           " Rate: " + ratePerDay + " Available: " + isAvailable);
    }
}


class RentalService {
    private List<Vehicle> vehicles = new ArrayList<>();

    // CREATE
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        System.out.println("Vehicle added");
    }

    // READ
    public void showVehicles() {
        for (Vehicle v : vehicles) {
            v.display();
        }
    }

    // SEARCH
    public Vehicle findVehicle(int id) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id)
                return v;
        }
        return null;
    }

    // DELETE
    public void deleteVehicle(int id) {
        vehicles.removeIf(v -> v.getVehicleId() == id);
        System.out.println("Vehicle removed");
    }

    // RENT
    public void rentVehicle(int id, int days) {
        Vehicle v = findVehicle(id);
        if (v != null && v.isAvailable()) {
            v.rent();
            System.out.println("Rent: " + v.calculateRent(days));
        } else {
            System.out.println("Vehicle not available");
        }
    }
}


public class VechileRentalApp {
    public static void main(String[] args) {

        RentalService service = new RentalService();

        service.addVehicle(new Bike(1, "Honda", 300));
        service.addVehicle(new Car(2, "Toyota", 1000));
        service.addVehicle(new Truck(3, "Tata", 2000));

        service.showVehicles();

        service.rentVehicle(2, 3);  // Car for 3 days

        service.showVehicles();

        service.deleteVehicle(1);

        service.showVehicles();
    }
}
