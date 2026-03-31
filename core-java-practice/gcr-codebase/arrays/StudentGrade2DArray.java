import java.util.Scanner;

public class StudentGrade2DArray {

    public static void main(String[] args) {

    	
    	//create the scanner object
        Scanner sc = new Scanner(System.in);

        //input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // 2D array to store marks
        // Column index: 0 → Physics, 1 → Chemistry, 2 → Maths
        int[][] marks = new int[n][3];

        // Arrays to store percentage and grade
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // input marks
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();

            // Validation: marks should not be negative
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid marks! Please enter positive values.");
                i--; // decrement index to re-enter marks
                continue;
            }
        }

        // calculate percentage and grades
        for (int i = 0; i < n; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total / 300.0) * 100;

            // Grade calculation
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        //display result
       
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics     : " + marks[i][0]);
            System.out.println("Chemistry   : " + marks[i][1]);
            System.out.println("Maths       : " + marks[i][2]);
            System.out.println("Percentage  : " + String.format("%.2f", percentage[i]) + "%");
            System.out.println("Grade       : " + grade[i]);
            System.out.println("");
        }

        
        //close the scanner object
        sc.close();
    }
}
