import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateCamparison {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Formatter for input
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Taking first date input
        System.out.print("Enter first date (dd-MM-yyyy): ");
        LocalDate date1 =
                LocalDate.parse(sc.nextLine(), formatter);

        // Taking second date input
        System.out.print("Enter second date (dd-MM-yyyy): ");
        LocalDate date2 =
                LocalDate.parse(sc.nextLine(), formatter);

        // Comparing dates
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the SAME.");
        }

        sc.close();
    }
}
