import java.util.Scanner;

public class LibraryReminderApp {

    public static void main(String[] args) {

    	//Create Scanner Object
        Scanner sc = new Scanner(System.in);
        int finePerDay = 5;

        // Loop for 5 books
        for (int bookNumber = 1; bookNumber <= 5; bookNumber++) {

            System.out.println("\nBook " + bookNumber);

            System.out.print("Enter Due Date (day number): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter Return Date (day number): ");
            int returnDate = sc.nextInt();

            // Check late return
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fineAmount = lateDays * finePerDay;

                System.out.println("Returned Late by " + lateDays + " days");
                System.out.println("Fine Amount: ₹" + fineAmount);
            } else {
                System.out.println("Returned on time. No fine ");
            }
        }

        //Close Scanner Object
        sc.close();
        
    }
}
