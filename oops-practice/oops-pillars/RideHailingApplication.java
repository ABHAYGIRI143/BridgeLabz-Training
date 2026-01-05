
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}


abstract class Vehicle implements GPS {

    // Encapsulation (private fields)
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;   // protected so subclasses can use it

    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per KM: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    // GPS interface methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}


class Car extends Vehicle {

    public Car(String vehicleId, String driverName) {
        super(vehicleId, driverName, 15.0); // Car rate
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}


class Bike extends Vehicle {

    public Bike(String vehicleId, String driverName) {
        super(vehicleId, driverName, 8.0); // Bike rate
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}

class Auto extends Vehicle {

    public Auto(String vehicleId, String driverName) {
        super(vehicleId, driverName, 12.0); // Auto rate
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 20; // base charge
    }
}

class RideService {

    // Polymorphic method
    public static void calculateRideFare(Vehicle vehicle, double distance) {
        System.out.println("\n--- Ride Details ---");
        vehicle.getVehicleDetails();
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + vehicle.calculateFare(distance));
    }
}


public class RideHailingApplication{

    public static void main(String[] args) {

        Vehicle car = new Car("CAR101", "Rahul");
        Vehicle bike = new Bike("BIKE202", "Amit");
        Vehicle auto = new Auto("AUTO303", "Suresh");

        car.updateLocation("MG Road");
        bike.updateLocation("Station");
        auto.updateLocation("Bus Stand");

        RideService.calculateRideFare(car, 10);
        RideService.calculateRideFare(bike, 10);
        RideService.calculateRideFare(auto, 10);
    }
}


