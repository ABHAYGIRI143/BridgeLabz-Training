import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        
        //create the scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for 3 friends:");

        // Input for Amar
        System.out.print("\nEnter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        double amarHeight = sc.nextDouble();

        // Input for Akbar
        System.out.print("\nEnter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        double akbarHeight = sc.nextDouble();

        // Input for Anthony
        System.out.print("\nEnter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        double anthonyHeight = sc.nextDouble();

        // Find youngest
        String youngest;
        int youngestAge;

        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngest = "Amar";
            youngestAge = amarAge;
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            youngest = "Akbar";
            youngestAge = akbarAge;
        } else {
            youngest = "Anthony";
            youngestAge = anthonyAge;
        }

        // Find tallest
        String tallest;
        double tallestHeight;

        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallest = "Amar";
            tallestHeight = amarHeight;
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallest = "Akbar";
            tallestHeight = akbarHeight;
        } else {
            tallest = "Anthony";
            tallestHeight = anthonyHeight;
        }

        // Display results
        System.out.println("Youngest friend: " + youngest + " (Age: " + youngestAge + ")");
        System.out.println("Tallest friend: " + tallest + " (Height: " + tallestHeight + " cm)");

    //close the scanner object
    sc.close();
    }
}