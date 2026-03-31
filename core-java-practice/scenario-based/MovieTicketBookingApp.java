import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {

    	//Create Scanner Object
        Scanner sc = new Scanner(System.in);
        char continueBooking  = 'n';

        do {
            int ticketPrice = 0;
            int snackPrice = 0;

            // Movie type input
            System.out.println("\nSelect Movie Type:");
            System.out.println("1. Action");
            System.out.println("2. Comedy");
            System.out.println("3. Drama");
            int movieType = sc.nextInt();

            // Seat type input
            System.out.print("Enter Seat Type (Gold/Silver): ");
            String seatType = sc.next();

            // Movie price using switch
            switch (movieType) {
                case 1:
                    ticketPrice = 200;
                    break;
                case 2:
                    ticketPrice = 180;
                    break;
                case 3:
                    ticketPrice = 160;
                    break;
                default:
                    System.out.println("Invalid movie type!");
                    continue;
            }

            // Seat price using if
            if (seatType.equalsIgnoreCase("Gold")) {
                ticketPrice += 100;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                ticketPrice += 50;
            } else {
                System.out.println("Invalid seat type!");
                continue;
            }

            // Snacks option
            System.out.print("Do you want snacks? (yes/no): ");
            String snacks = sc.next();

            if (snacks.equalsIgnoreCase("yes")) {
                snackPrice = 80;
            }

            int totalAmount = ticketPrice + snackPrice;

            // Bill
            System.out.println("\n----- Booking Summary -----");
            System.out.println("Seat Type: " + seatType);
            System.out.println("Ticket Price: ₹" + ticketPrice);
            System.out.println("Snack Price: ₹" + snackPrice);
            System.out.println("Total Amount: ₹" + totalAmount);

            // Continue for next customer
            System.out.print("\nBook ticket for another customer? (y/n): ");
            continueBooking = sc.next().charAt(0);

        } while (continueBooking == 'y' || continueBooking == 'Y');

        //Close Scanner Object
        sc.close();
        
    }
}
