import java.util.Scanner;

public class FIndDisatnce {
    public static void main(String args[]){
     
        //1 mile = 1760 yards and 1 yard is 3 feet
        Scanner sc = new Scanner(System.in);
        double distance = sc.nextInt();// input distance in feet
        double distanceInYards = distance / 3;
        double distanceInMiles = distanceInYards / 1760;
        System.out.println("The Distance in feet is "+distance+" and distance in yards is "+distanceInYards+" distance in miles is "+distanceInMiles);
        sc.close();
    }
}
