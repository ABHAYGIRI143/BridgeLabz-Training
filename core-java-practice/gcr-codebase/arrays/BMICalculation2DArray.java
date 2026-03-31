import java.util.Scanner;

public class BMICalculation2DArray {

    public static void main(String[] args) {

    	//create the scanner object
        Scanner sc = new Scanner(System.in);

        // input number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // 2D array to store Weight, Height, BMI
        double[][] personData = new double[number][3];

        // Array to store weight status
        String[] weightStatus = new String[number];

        //input weight and height
        for (int i = 0; i < number; i++) {

            System.out.println("\nEnter details for Person " + (i + 1));

            // Take weight input with validation
            while (true) {
                System.out.print("Enter weight (in kg): ");
                personData[i][0] = sc.nextDouble();

                if (personData[i][0] > 0) {
                    break;
                }
                System.out.println("Invalid input! Weight must be positive.");
            }

            // Take height input with validation
            while (true) {
                System.out.print("Enter height (in meters): ");
                personData[i][1] = sc.nextDouble();

                if (personData[i][1] > 0) {
                    break;
                }
                System.out.println("Invalid input! Height must be positive.");
            }
        }

        // calculate BMI
        for (int i = 0; i < number; i++) {

            double weight = personData[i][0];
            double height = personData[i][1];

            // BMI calculation
            personData[i][2] = weight / (height * height);

            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // print output
        System.out.println("\n=========== BMI REPORT (2D ARRAY) ===========");

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight : " + personData[i][0] + " kg");
            System.out.println("Height : " + personData[i][1] + " meters");
            System.out.println("BMI    : " + String.format("%.2f", personData[i][2]));
            System.out.println("Status : " + weightStatus[i]);
            System.out.println("-------------------------------------------");
        }

        //close the scanner object
        sc.close();
    }
}
