import java.util.Scanner;

public class DistanceCoversion2 {
    public static void main(String args[]){
        // 1km is equals to 1.6miles
        Scanner sc=new Scanner(System.in);
        double distance=sc.nextDouble();// distance in km
       double result=distance*1.6;// distance in miles;
         System.out.println("The distance "+ distance+" km in miles is "+result);
        sc.close();
    }
}
