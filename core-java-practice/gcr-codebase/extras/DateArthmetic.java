import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArthmetic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Formatter for input and output
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Taking date input
        System.out.print("Enter a date (dd-MM-yyyy): ");
        String inputDate = sc.nextLine();

        // Parsing string to LocalDate
        LocalDate date = LocalDate.parse(inputDate, formatter);

        System.out.println("Original Date: " + date.format(formatter));

      
        LocalDate updatedDate = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2);

        System.out.println("After adding 7 days, 1 month, and 2 years: "
                + updatedDate.format(formatter));

        // Subtracting 3 weeks
        LocalDate finalDate = updatedDate.minusWeeks(3);

        System.out.println("After subtracting 3 weeks: "
                + finalDate.format(formatter));

        sc.close();
    }
}
