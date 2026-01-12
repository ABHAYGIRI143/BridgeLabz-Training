import java.util.*;

// ================= Custom Exception =================
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) {
        super(msg);
    }
}

// ================= Fare Calculator Interface =================
interface FareCalculator {
    double calculateFare(double distance);
}

// Normal pricing
class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;   // ₹10 per km
    }
}

// Peak hour pricing
class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;   // ₹15 per km
    }
}

// ================= User =================
class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Driver =================
class Driver {
    int id;
    String name;
    boolean available = true;

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Ride =================
class Ride {
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(User user, Driver driver, double distance, FareCalculator fareCalculator) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fareCalculator.calculateFare(distance);
    }

    void showRide() {
        System.out.println("User: " + user.name);
        System.out.println("Driver: " + driver.name);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: ₹" + fare);
    }
}

// ================= Cab Service =================
class CabService {

    List<Driver> drivers = new ArrayList<>();
    List<Ride> rideHistory = new ArrayList<>();

    void addDriver(Driver d) {
        drivers.add(d);
    }

    Ride bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {

        for (Driver d : drivers) {
            if (d.available) {
                d.available = false;
                Ride ride = new Ride(user, d, distance, fareCalculator);
                rideHistory.add(ride);
                System.out.println("Ride booked successfully!");
                return ride;
            }
        }
        throw new NoDriverAvailableException("No drivers available right now!");
    }

    void showRideHistory() {
        for (Ride r : rideHistory) {
            System.out.println("------------------");
            r.showRide();
        }
    }
}

// ================= Main =================
public class CabBookingSystem {
    public static void main(String[] args) {

        CabService cabService = new CabService();

        cabService.addDriver(new Driver(1, "Rohit"));
        cabService.addDriver(new Driver(2, "Amit"));

        User user1 = new User(101, "Abhay");

        try {
            Ride r1 = cabService.bookRide(user1, 12, new PeakFare());
            r1.showRide();
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nRide History:");
        cabService.showRideHistory();
    }
}
