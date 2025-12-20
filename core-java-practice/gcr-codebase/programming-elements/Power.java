import java.util.*;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int e = sc.nextInt();

        int pwr = (int) Math.pow(m, e);

        System.out.println(pwr);
        sc.close();
    }
}
