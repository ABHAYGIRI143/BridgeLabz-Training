import java.util.Random;

public class EmployeeWagesComputation {
   
    static final int IS_ABSENT = 0;
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;

    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 8;

    static final int WORKING_DAYS_PER_MONTH = 20;
    static final int MAX_WORKING_HOURS = 100;
    static final int MAX_WORKING_DAYS = 20;

    static Random random = new Random();

    // ---------- Main ----------
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        // USE CASE 1, 3 & 4: Check Employee Type using RANDOM and Switch
        int empType = getEmployeeType();
        displayEmployeeType(empType);

        // USE CASE 2 & 3: Calculate Daily Wage
        int dailyWage = calculateDailyWage(empType);
        System.out.println("Daily Employee Wage: ₹" + dailyWage);

        // USE CASE 5: Calculate Monthly Wage (20 Working Days)
        int monthlyWage = calculateMonthlyWage();
        System.out.println("Monthly Employee Wage (20 days): ₹" + monthlyWage);

        // USE CASE 6: Calculate Monthly Wage with Max Hours / Days
        int conditionalMonthlyWage = calculateWageTillCondition();
        System.out.println("Monthly Wage (Max 100 hrs or 20 days): ₹" + conditionalMonthlyWage);
    }

    // ---------- USE CASE 1, 3 & 4 ----------
    static int getEmployeeType() {
        return random.nextInt(3); // 0-Absent, 1-Full Time, 2-Part Time
    }

    static void displayEmployeeType(int empType) {
        switch (empType) {
            case IS_FULL_TIME:
                System.out.println("Employee is Full Time");
                break;
            case IS_PART_TIME:
                System.out.println("Employee is Part Time");
                break;
            default:
                System.out.println("Employee is Absent");
        }
    }

    // ---------- USE CASE 2 & 3 ----------
    static int calculateDailyWage(int empType) {

        int hoursWorked;

        switch (empType) {
            case IS_FULL_TIME:
                hoursWorked = FULL_DAY_HOURS;
                break;
            case IS_PART_TIME:
                hoursWorked = PART_TIME_HOURS;
                break;
            default:
                hoursWorked = 0;
        }

        return hoursWorked * WAGE_PER_HOUR;
    }

    // ---------- USE CASE 5 ----------
    static int calculateMonthlyWage() {

        int totalWage = 0;

        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            int empType = getEmployeeType();
            totalWage += calculateDailyWage(empType);
        }

        return totalWage;
    }

    // ---------- USE CASE 6 ----------
    static int calculateWageTillCondition() {

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < MAX_WORKING_HOURS && totalDays < MAX_WORKING_DAYS) {

            totalDays++;
            int empType = getEmployeeType();

            int hoursWorked;
            switch (empType) {
                case IS_FULL_TIME:
                    hoursWorked = FULL_DAY_HOURS;
                    break;
                case IS_PART_TIME:
                    hoursWorked = PART_TIME_HOURS;
                    break;
                default:
                    hoursWorked = 0;
            }

            totalHours += hoursWorked;
            totalWage += hoursWorked * WAGE_PER_HOUR;
        }

        return totalWage;
    }
}