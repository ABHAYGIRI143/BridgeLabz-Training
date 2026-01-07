import java.util.ArrayList;
import java.util.List;

// ================= Custom Exception =================
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

// ================= Interface =================
interface FareCalculator {
    double calculateFare(double distance);
}

// ================= User Class =================
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ================= Driver Class =================
class Driver {
    private int driverId;
    private String name;
    private boolean available;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignDriver() {
        this.available = false;
    }

    public void releaseDriver() {
        this.available = true;
    }

    public String getName() {
        return name;
    }
}

// ================= Fare Implementations =================
class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// ================= Ride Class =================
class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance, FareCalculator fareCalculator) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fareCalculator.calculateFare(distance);
    }

    public double getFare() {
        return fare;
    }

    public String getRideDetails() {
        return "User: " + user.getName() +
               ", Driver: " + driver.getName() +
               ", Distance: " + distance +
               " km, Fare: ₹" + fare;
    }
}

// ================= Ride Management System =================
public class CabBookingSystem {

    private static List<Driver> drivers = new ArrayList<>();
    private static List<Ride> rideHistory = new ArrayList<>();

    // Assign available driver
    private static Driver assignDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.assignDriver();
                return d;
            }
        }
        throw new NoDriverAvailableException("No drivers available right now.");
    }

    // Book Ride
    public static void bookRide(User user, double distance, boolean isPeak)
            throws NoDriverAvailableException {

        Driver driver = assignDriver();

        FareCalculator fareCalculator;
        if (isPeak) {
            fareCalculator = new PeakFare();   // Polymorphism
        } else {
            fareCalculator = new NormalFare(); // Polymorphism
        }

        Ride ride = new Ride(user, driver, distance, fareCalculator);
        rideHistory.add(ride);

        System.out.println("Ride Booked Successfully!");
        System.out.println(ride.getRideDetails());
    }

    // View Ride History
    public static void viewRideHistory() {
        System.out.println("\n--- Ride History ---");
        for (Ride r : rideHistory) {
            System.out.println(r.getRideDetails());
        }
    }

    // ================= Main =================
    public static void main(String[] args) {

        // Adding drivers (CREATE)
        drivers.add(new Driver(1, "Amit"));
        drivers.add(new Driver(2, "Rahul"));

        User user1 = new User(101, "Abhay");
        User user2 = new User(102, "Rohit");

        try {
            bookRide(user1, 12, false); // Normal pricing
            bookRide(user2, 8, true);   // Peak pricing
        } catch (NoDriverAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // READ
        viewRideHistory();
    }
}
