import java.util.Scanner;

public class PerimeterOfRectangle {
    public static void main(String args[]){
       
        //All the parameters are in cm
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        int area = 2*(length+breadth);
        System.out.println("The area of rectangle is "+area);
        sc.close();
    }
}
