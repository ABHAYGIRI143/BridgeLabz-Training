

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    Ticket next;

    Ticket(int ticketId, String customerName, String movieName,
           String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}


class TicketSystem {

    private Ticket head = null;
    private Ticket tail = null;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head;   // circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;   // maintain circle
        }

        System.out.println("Ticket booked successfully");
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int id) {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;

        do {
            if (current.ticketId == id) {

                // Only one ticket
                if (head == tail) {
                    head = tail = null;
                }
                // Removing head
                else if (current == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Removing tail
                else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                }
                // Removing middle node
                else {
                    previous.next = current.next;
                }

                System.out.println("Ticket removed successfully");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Ticket not found");
    }

    // Display all tickets
    public void displayTickets() {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        System.out.println("\nBooked Tickets:");

        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);

            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by Customer or Movie
    public void search(String keyword) {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                temp.movieName.equalsIgnoreCase(keyword)) {

                System.out.println("Ticket ID: " + temp.ticketId +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber +
                        ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No matching ticket found");
    }

    // Count total tickets
    public void totalTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets Booked: " + count);
    }
}


public class OnlineTicketReservation {
    public static void main(String[] args) {

        TicketSystem ts = new TicketSystem();

        ts.addTicket(101, "Abhay", "Avengers", "A1", "10:00 AM");
        ts.addTicket(102, "Manas", "Inception", "B2", "12:00 PM");
        ts.addTicket(103, "Kapil", "Avengers", "C3", "02:00 PM");

        ts.displayTickets();

        ts.search("Avengers");

        ts.removeTicket(102);

        ts.displayTickets();

        ts.totalTickets();
    }
}
