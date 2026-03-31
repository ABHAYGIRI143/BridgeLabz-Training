import java.util.Scanner;

public class VolumeOfCylinder {
 public static void main(String args[]){
    
    Scanner sc = new Scanner(System.in);
    int radius = sc.nextInt();
    int height = sc.nextInt();
    float PI = 3.14f;
    float  areaOfCylinder = PI*radius*radius*height;
    System.out.println("The radius, height, area of the cylinder are as follows "+radius+","+height+","+areaOfCylinder);
    sc.close();
}   
}
