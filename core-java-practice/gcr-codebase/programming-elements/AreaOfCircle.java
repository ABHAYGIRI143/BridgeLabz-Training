import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        float PI = 3.14f;
        float areaOfCircle = PI*radius*radius;
        System.out.println("The radius of circle is "+radius+" and the area of circle is "+areaOfCircle);
        sc.close();
    }
}
