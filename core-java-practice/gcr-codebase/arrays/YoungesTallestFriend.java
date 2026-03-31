import java.util.Scanner;

public class YoungesTallestFriend {

    public static void main(String[] args) {

    	//create scanner object
    	Scanner sc = new Scanner(System.in);

        // Array to store names of friends
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Arrays to store age and height of friends
        int[] age = new int[3];
        double[] height = new double[3];

      
        // run a loop to take inputs from user
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i]);

            System.out.print("Enter Age: ");
            age[i] = sc.nextInt();

            System.out.print("Enter Height (in cm): ");
            height[i] = sc.nextDouble();
        }

        //determine which one is youngest
        int youngestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }
        }

        //determine which one is youngest
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

      //display output
        System.out.println("\n========== RESULT ==========");
        System.out.println("Youngest Friend : " + names[youngestIndex] +
                " (Age: " + age[youngestIndex] + ")");

        System.out.println("Tallest Friend  : " + names[tallestIndex] +
                " (Height: " + height[tallestIndex] + " cm)");

        //close the scanner object
        sc.close();
    }
}
