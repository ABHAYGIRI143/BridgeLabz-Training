import java.util.*;

class Flight {
    private String flightNo;
    private String source;
    private String destination;
    private int seats;

    public Flight(String flightNo, String source, String destination, int seats) {
        this.flightNo = flightNo;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    public String getFlightNo() { return flightNo; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getSeats() { return seats; }

    public void bookSeat() {
        if (seats > 0)
            seats--;
    }

    public boolean isAvailable() {
        return seats > 0;
    }
}


class Booking {
    private String passengerName;
    private String flightNo;

    public Booking(String passengerName, String flightNo) {
        this.passengerName = passengerName;
        this.flightNo = flightNo;
    }

    public void display() {
        System.out.println("Passenger: " + passengerName + " | Flight: " + flightNo);
    }
}




class FlightService {

    // Array for available flights
    private Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai", 3),
        new Flight("AI202", "Delhi", "Pune", 2),
        new Flight("AI303", "Mumbai", "Chennai", 4)
    };

    // List for bookings
    private List<Booking> bookings = new ArrayList<>();

    // SEARCH
    public void searchFlight(String src, String dest) {
        boolean found = false;
        for (Flight f : flights) {
            if (f.getSource().equalsIgnoreCase(src) &&
                f.getDestination().equalsIgnoreCase(dest)) {
                System.out.println("Flight: " + f.getFlightNo() +
                        " Seats: " + f.getSeats());
                found = true;
            }
        }
        if (!found)
            System.out.println("No flights found");
    }

    // BOOK
    public void bookFlight(String passenger, String flightNo) {
        for (Flight f : flights) {
            if (f.getFlightNo().equalsIgnoreCase(flightNo) && f.isAvailable()) {
                f.bookSeat();
                bookings.add(new Booking(passenger, flightNo));
                System.out.println("Booking Successful");
                return;
            }
        }
        System.out.println("Flight not available");
    }

    // DISPLAY BOOKINGS
    public void showBookings() {
        for (Booking b : bookings) {
            b.display();
        }
    }
}


public class FlightBookingSystem {

}

public class FlightBookingSystem {
    public static void main(String[] args) {

        FlightService service = new FlightService();

        service.searchFlight("Delhi", "Mumbai");

        service.bookFlight("Abhay", "AI101");
        service.bookFlight("Manas", "AI101");

        service.showBookings();

        service.searchFlight("Delhi", "Mumbai");
    }
}
