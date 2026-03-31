class HotelBooking {
    String guestName;
    String roomType;
    int nights;

   
    HotelBooking() {
        this("Guest", "Standard", 1);
    }

  
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    void displayBooking() {
        System.out.println(guestName + " | " + roomType + " | " + nights + " nights");
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Abhay", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);

        b1.displayBooking();
        b2.displayBooking();
        b3.displayBooking();
    }
}
