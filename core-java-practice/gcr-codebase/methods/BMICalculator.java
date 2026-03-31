import java.util.Scanner;

public class BMICalculator {
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            
            double heightMeters = heightCm / 100.0;
            double bmi = weight / (heightMeters * heightMeters);
            
            data[i][2] = bmi;
        }
    }
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi >= 18.5 && bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi >= 25.0 && bmi <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {

        //create Scanner objcet
        Scanner sc = new Scanner(System.in);

        //initialize an array that store weight and height and bmi 
        double[][] members = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for member " + (i + 1) + ": ");
            members[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) for member " + (i + 1) + ": ");
            members[i][1] = sc.nextDouble();
        }

        calculateBMI(members);

        String[] status = getBMIStatus(members);

        System.out.println("\nWeight\tHeight(cm)\tBMI\t\tStatus");
       

        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t%.2f\t\t%.2f\t%s\n",
                    members[i][0],
                    members[i][1],
                    members[i][2],
                    status[i]);
        }

        //Close Scanner object
        sc.close();
    }
}
