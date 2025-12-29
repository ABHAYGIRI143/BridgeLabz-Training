import java.util.Scanner;

public class FitnessChallengeTracker {

    public static void main(String[] args) {

    	//Create Scanner Object
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter  the number of days for challenge");
    	int numOfDays = sc.nextInt();
    	
        // Push-ups done each day of the week
        // 0 indicates a rest day
    	int pushUps[]= new int[numOfDays];
    	
    	System.out.println("Enter the push ups for each day and 0 will signify as rest day");
    	
    	for(int i = 0 ; i<numOfDays ; i++) {
    		pushUps[i]  = sc.nextInt();
    	}
    	
        int totalPushUps = 0;
        int workoutDays = 0;

        // for-each loop
        for (int dailyCount : pushUps) {

            // Skip rest days
            if (dailyCount == 0) {
                continue;
            }

            totalPushUps += dailyCount;
            workoutDays++;
        }

        // Calculate average
        double averagePushUps = (double) totalPushUps / workoutDays;

        // Output
        System.out.println("Total Push-ups in the week: " + totalPushUps);
        System.out.println("Workout Days: " + workoutDays);
        System.out.println("Average Push-ups per workout day: " + averagePushUps);
        
        //Close Scanner Object
        sc.close();
    }
}
