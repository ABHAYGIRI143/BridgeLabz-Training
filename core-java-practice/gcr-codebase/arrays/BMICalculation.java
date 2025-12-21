import java.util.Scanner;

public class BMICalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       //create the scanner object
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        // Arrays to store details
        double[] weight = new double[n];   // weight in kg
        double[] height = new double[n];   // height in meters
        double[] bmi = new double[n];      // BMI values
        String[] status = new String[n];   // Weight status

        //rKW weight and height as inputs
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter weight (in kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (in meters): ");
            height[i] = sc.nextDouble();
        }

        // calculate BMI
        for (int i = 0; i < n; i++) {

            // BMI formula: weight / (height * height)
            bmi[i] = weight[i] / (height[i] * height[i]);

            // Determine weight status using BMI table
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        //print output
        System.out.println("\n=========== BMI REPORT ===========");

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height : " + height[i] + " meters");
            System.out.println("Weight : " + weight[i] + " kg");
            System.out.println("BMI    : " + String.format("%.2f", bmi[i]));
            System.out.println("Status : " + status[i]);
            System.out.println("");
        }

        //close the scanner object
        sc.close();
    }
}
