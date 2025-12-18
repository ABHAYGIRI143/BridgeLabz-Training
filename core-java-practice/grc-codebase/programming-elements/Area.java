import java.util.*;

public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double area = 3.14 * Math.pow(radius, 2);

        System.out.println(area);
    }
}
