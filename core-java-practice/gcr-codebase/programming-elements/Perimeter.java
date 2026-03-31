import java.util.*;

public class Perimeter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int perimeter= 2*(m+n);

        System.out.println(perimeter);
        
        sc.close();
    }
}