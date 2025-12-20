import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int temperature = sc.nextInt(); //take temperature as input in celsius
        int convertInFahrenheit = ((temperature*9)/5)+32;
        System.out.println("The temperature in clesius is "+temperature+" and temperature in fahrenheit is "+convertInFahrenheit);
        sc.close();
    }
}
