import java.util.*;

// ============== Custom Exception =================
class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String msg) {
        super(msg);
    }
}

// ============== Pricing Strategy (Interface) =================
interface PricingStrategy {
    double calculatePrice(double basePrice, int days);
}

// Seasonal pricing (Polymorphism)
class NormalSeasonPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days;
    }
}

class FestivalSeasonPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days * 1.5;   // 50% higher price
    }
}

// ============== Room (Base Class) =================
abstract class Room {
    int roomNo;
    double basePrice;
    boolean isBooked = false;

    Room(int roomNo, double basePrice) {
        this.roomNo = roomNo;
        this.basePrice = basePrice;
    }

    abstract String getType();
}

// Inheritance
class StandardRoom extends Room {
    StandardRoom(int no) {
        super(no, 2000);
    }

    String getType() {
        return "Standard Room";
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int no) {
        super(no, 4000);
    }

    String getType() {
        return "Deluxe Room";
    }
}

// ============== Guest =================
class Guest {
    String name;

    Guest(String name) {
        this.name = name;
    }
}

// ============== Reservation =================
class Reservation {
    Guest guest;
    Room room;
    int days;
    double bill;

    Reservation(Guest guest, Room room, int days, double bill) {
        this.guest = guest;
        this.room = room;
        this.days = days;
        this.bill = bill;
    }

    void showInvoice() {
        System.out.println("\n----- Hotel Invoice -----");
        System.out.println("Guest: " + guest.name);
        System.out.println("Room: " + room.getType());
        System.out.println("Room No: " + room.roomNo);
        System.out.println("Days: " + days);
        System.out.println("Total Bill: ₹" + bill);
    }
}

// ============== Hotel =================
class Hotel {

    List<Room> rooms = new ArrayList<>();

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room findAvailableRoom(String type) throws RoomNotAvailableException {
        for (Room r : rooms) {
            if (!r.isBooked && r.getType().equals(type))
                return r;
        }
        throw new RoomNotAvailableException(type + " not available!");
    }

    public Reservation bookRoom(Guest guest, String type, int days, PricingStrategy pricing)
            throws RoomNotAvailableException {

        Room r = findAvailableRoom(type);
        r.isBooked = true;

        double total = pricing.calculatePrice(r.basePrice, days);

        return new Reservation(guest, r, days, total);
    }

    public void checkOut(Reservation res) {
        res.room.isBooked = false;
        System.out.println("\n" + res.guest.name + " checked out from room " + res.room.roomNo);
    }
}

// ============== Main =================
public class HotelReservationSystem {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        hotel.addRoom(new StandardRoom(101));
        hotel.addRoom(new StandardRoom(102));
        hotel.addRoom(new DeluxeRoom(201));

        Guest g1 = new Guest("Abhay");
        Guest g2 = new Guest("Rahul");

        try {
            PricingStrategy normal = new NormalSeasonPricing();
            PricingStrategy festival = new FestivalSeasonPricing();

            Reservation r1 = hotel.bookRoom(g1, "Standard Room", 3, normal);
            r1.showInvoice();

            Reservation r2 = hotel.bookRoom(g2, "Deluxe Room", 2, festival);
            r2.showInvoice();

            hotel.checkOut(r1);

        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
