import java.util.Scanner;

public class PowerCalculation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exponent = sc.nextInt();
        int power =(int) Math.pow(base,exponent);
        System.out.println("The power for base "+base+"and exponent "+exponent+" is "+ power);
        sc.close();
    }
}
