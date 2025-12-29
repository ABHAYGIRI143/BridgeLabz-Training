import java.util.Scanner;

public class DigitalWatch{

    public static void main(String[] args) {

    	//Create Scanner Object
        Scanner sc = new Scanner(System.in);

        // Take stop time input
        System.out.print("Enter stop hour (0-23): ");
        int stopHour = sc.nextInt();

        System.out.print("Enter stop minute (0-59): ");
        int stopMinute = sc.nextInt();

        // Outer loop for hours
        for (int hour = 0; hour < 24; hour++) {

            // Inner loop for minutes
            for (int minute = 0; minute < 60; minute++) {

                // Stop watch at user-defined time
                if (hour == stopHour && minute == stopMinute) {
                    System.out.println("Power cut! Watch stopped at "
                            + String.format("%02d:%02d", hour, minute) + " ⛔");
                    break;
                }

                // Print time
                System.out.printf("%02d:%02d\n", hour, minute);
            }
        }
        
        //Close Scanner Object
        sc.close();
    }
}
